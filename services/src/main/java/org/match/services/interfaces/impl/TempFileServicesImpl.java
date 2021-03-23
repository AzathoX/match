package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.services.interfaces.TempFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.match.dataassert.datadomain.FileDomain;
import org.match.dataassert.mapper.FileDomainMapper;
import org.match.domains.bo.CloudFileBO;
import org.match.domains.vo.CloudFileVO;
import org.match.services.ddd.CloudFile;

import java.io.File;

@Service
public class TempFileServicesImpl implements TempFileServices {


    @Autowired
    private FileDomainMapper fileDomainMapper;



    private String save(FileDomain fileDomain){
        fileDomainMapper.insertSelective(fileDomain);
        return fileDomain.getFFileName();
    }

    @Override
    public CloudFileVO tempSave(MultipartFile origin, File parentFile) {
        //上传临时文件
        final CloudFile file = CloudFile.createByFile(origin, parentFile);
        this.save(file.getFileDomain());
        //拿到临时文件路径
        final CloudFileVO vo = (CloudFileVO) file.vo();
        return vo;
    }

    @Override
    public File tempFile(String shortName) {
        final CloudFileBO bo = CloudFileBO.builder().fShortName(shortName).build();
        FileDomain fileDomain = fileDomainMapper.selectList(new QueryWrapper<FileDomain>().select(FileDomain.SQL_SELECT)
                .eq(FileDomain.F_SHORT_NAME, bo.getFShortName())
                .eq(FileDomain.IS_DEL,false)).get(0);
        final CloudFile cloudFile = new CloudFile(fileDomain);
        return cloudFile.getFile();
    }

    @Override
    public void tempToPersistent(String[] shortNames) {
        final FileDomain fileDomain = new FileDomain();
        fileDomain.setIsTemp(false);
        fileDomainMapper.update(fileDomain,new QueryWrapper<FileDomain>().in(FileDomain.F_SHORT_NAME,shortNames));
    }


}
