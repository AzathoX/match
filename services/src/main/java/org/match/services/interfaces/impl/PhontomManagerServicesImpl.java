package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.services.ddd.VChatCloud;
import org.match.services.interfaces.PhontomManagerServices;
import org.match.services.interfaces.TempFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.match.dataassert.datadomain.PhontomDomain;
import org.match.dataassert.datadomain.PhontomFileDomain;
import org.match.dataassert.datadomain.PhontomText;
import org.match.dataassert.mapper.PhontomDomainMapper;
import org.match.dataassert.mapper.PhontomFileMapper;
import org.match.dataassert.mapper.PhontomTextMapper;
import org.match.domains.bo.PhontomBO;
import org.match.domains.dto.DataTranslateObject;
import org.match.domains.vo.CloudFileVO;
import org.match.domains.vo.VChatCloudVO;
import org.match.domains.vo.ViewObject;
import org.match.services.interfaces.FileServices;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class PhontomManagerServicesImpl implements PhontomManagerServices {

    @Autowired
    private PhontomDomainMapper phontomDomainMapper;

    @Autowired
    private PhontomTextMapper phontomTextMapper;

    @Autowired
    private PhontomFileMapper phontomFileMapper;


    @Autowired
    private TempFileServices tempFileServices;

    @Autowired
    private FileServices fileServices;

    private static int  LOCK_LIST = 0;


    private static CopyOnWriteArraySet<Thread> copyOnWriteArraySet = new CopyOnWriteArraySet<>();


    //++
    private static int addLockList(){
        copyOnWriteArraySet.add(Thread.currentThread());
        return ++LOCK_LIST;
    }

    private static void clearLock(){
        LOCK_LIST = 0;
    }

    //clear
    private static  void unlock(){
         clearLock();
         notifyAllThread();
    }


    private static void notifyAllThread(){
        for (Thread thread : copyOnWriteArraySet) {
            thread.notifyAll();
        }
        copyOnWriteArraySet.clear();

    }


    //lock
    private static boolean lock(){
        while(true){
            //lock;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(LOCK_LIST == 0){

                break;
            }
        }
        return  true;
    }


    private Map<String,List<CloudFileVO>> fileMap(){
        List<Map<String, Object>> map= phontomFileMapper.map();
        Map<String,List<CloudFileVO>> data = new HashMap<>();
        for (Map<String, Object> stringObjectMap : map) {
            List<CloudFileVO> list = null ;
            String key = null;
            if(Objects.nonNull(key = stringObjectMap.get(PhontomFileDomain.P_UNINAME).toString() ) && Objects.isNull(list = data.get(key))){
                 list = new ArrayList<>();
                 data.put(key,list);
            }
            String shortName = stringObjectMap.get(PhontomFileDomain.F_SHORT_NAME).toString();
            String subfix  = stringObjectMap.get(PhontomFileDomain.SUBFIX).toString();
            final CloudFileVO cloudFileVO = new CloudFileVO();
            cloudFileVO.setFSubfix(subfix);
            cloudFileVO.setFShortName(shortName);
            list.add(cloudFileVO);
        }
        return data;
    }



    @Transactional
    @Override
    public void save(DataTranslateObject dto) {
        final PhontomBO pbo = (PhontomBO) dto.bo();
        pbo.dataDesensitization();
        final VChatCloud vChatCloud = VChatCloud.vChatCloud(pbo);
        vChatCloud.genericUniqueName();
        vChatCloud.init();
        //插入基本信息
        this.phontomDomainMapper.insertSelective(vChatCloud.getPhontomDomain());
        //插入文字
        this.phontomTextMapper.insertSelective(vChatCloud.getPhontomText());
        //插入图像
        this.phontomFileMapper.batchInsert(vChatCloud.getPhontomFileDomain());
        //批量修改临时文件为永久文件 false->true
        this.tempFileServices.tempToPersistent(pbo.getShortNames());

    }


    @Override
    public List<ViewObject> list(Integer state) {
        List<ViewObject> vlist = new ArrayList<>();
        //1.连表查询 phontom表和text 表
        final List<PhontomDomain> list = this.phontomDomainMapper.list(state);
        //2.查询该列表下的所有图片 唯一id , 名字列表 Map<String,List<String>> map;
        final Map<String, List<CloudFileVO>> data = fileMap();
        //3.PhontomDomain转成VO
        for (PhontomDomain phontomDomain : list) {
            final VChatCloud vChatCloud = VChatCloud.vChatCloud(phontomDomain);
            final VChatCloudVO vo = (VChatCloudVO) vChatCloud.vo();
            final List<CloudFileVO> fileList = data.get(vChatCloud.getUniname());
            if(Objects.nonNull(fileList)){
                vo.setPrevimgs(fileList);
            }
            vlist.add(vo);
        }
        return vlist;
    }

    @Override
    public void review(String[] uniname, int state) {
        final PhontomBO bo = PhontomBO.builder().shortNames(uniname).pCheck((byte) state).build();
        final VChatCloud vChatCloud = VChatCloud.vChatCloud(bo);
        phontomDomainMapper.update(vChatCloud.getPhontomDomain(),new QueryWrapper<PhontomDomain>().in(PhontomDomain.P_UNINAME,uniname));
        if(LOCK_LIST > 0){
            unlock();
        }
    }


    @Override
    public List<ViewObject> listWithLongPolling(Integer state){
        //1.判断数据是否已经刷新，检查review接口是否有数据过来
        addLockList();
        if(lock()){
            //2.如果是则返回数据
            final List<ViewObject> list = this.list(state);
            //3.清空锁并返回数据
            return list;
        }
        //清空锁
        return null;

    }



    private void doRemoveData(List<PhontomDomain> phontomDomains){
        final Map<String, List<CloudFileVO>> imgData = this.fileMap();
        List<CloudFileVO> fileResource = new ArrayList<>();
        List<String> pResource = new ArrayList<>();
        for (PhontomDomain phontomDomain : phontomDomains) {
            final List<CloudFileVO> cloudFileVOS = imgData.get(phontomDomain.getPUniname());
            if(Objects.nonNull(cloudFileVOS)){
                pResource.add(phontomDomain.getPetName());
                fileResource.addAll(cloudFileVOS);
            }
        }
        //开始删除
        //删图片
        List<String> shortName = new ArrayList<>();
        for (CloudFileVO cloudFileVO : fileResource) {
            shortName.add(cloudFileVO.getFShortName());
        }
        fileServices.delByShortName(shortName);
        //删文字
        phontomTextMapper.delete(new QueryWrapper<PhontomText>().in(PhontomText.P_UNINAME,pResource));
        //删整块
        phontomDomainMapper.delete(new QueryWrapper<PhontomDomain>().in(PhontomDomain.P_UNINAME,pResource));
    }

    public void del(String[] uniname, boolean really){
        if(really){
            //真删
            doRemoveData(phontomDomainMapper.selectList(new QueryWrapper<PhontomDomain>().select(PhontomDomain.ID,PhontomDomain.P_UNINAME).in(PhontomDomain.P_UNINAME,uniname)));
        }
        else{
            final PhontomBO bo = PhontomBO.builder().isDel(true).build();
            final VChatCloud vChatCloud = VChatCloud.vChatCloud(bo);
            phontomDomainMapper.update(vChatCloud.getPhontomDomain(),new QueryWrapper<PhontomDomain>().in(PhontomDomain.P_UNINAME,uniname));
        }
    }

}
