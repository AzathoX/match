package org.match.services.ddd;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.match.services.utils.AbstractMD5Utils;
import org.nrocn.lib.utils.BaseFileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.match.dataassert.datadomain.FileDomain;
import org.match.domains.bo.BusinessObject;
import org.match.domains.bo.CloudFileBO;
import org.match.domains.vo.CloudFileVO;
import org.match.domains.vo.ViewObject;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@NoArgsConstructor
public class CloudFile implements DriverDomainDesignedable<CloudFile> {

    public static CloudFile createByFile(MultipartFile origin, File parent){
        String orginName = origin.getOriginalFilename();
        //算文件名 32位
        String fileName = AbstractMD5Utils.md532ByteRandom(orginName);
        //写入文件
        try {
            if(!parent.exists()){
                parent.mkdir();
            }
            File file = new File(parent,fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            origin.transferTo(file);
            final CloudFile cloudFile = new CloudFile();
            cloudFile.file = file;
            cloudFile.originName = orginName;
            cloudFile.initFromFile();
            return cloudFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CloudFileBO bo(CloudFile cloudFile){
        CloudFileBO cloudFileBO = CloudFileBO.builder().fFileName(cloudFile.fileDomain.getFFileName())
                .fAbsoluteSrc(cloudFile.fileDomain.getFAbsoluteSrc())
                .fWebSrc(cloudFile.fileDomain.getFWebSrc())
                .fPositionPath(cloudFile.fileDomain.getFPositionPath())
                .fShortName(cloudFile.fileDomain.getFShortName())
                .fOriginalName(cloudFile.fileDomain.getFOriginalName())
                .fSubfix(cloudFile.fileDomain.getFSubfix())
                .fFiletreeId(cloudFile.fileDomain.getFFiletreeId())
                .fFiletreeVirtual(cloudFile.fileDomain.getFFiletreeVirtual())
                .fSize(cloudFile.fileDomain.getFSize())
                .build();
        return cloudFileBO;
    }


    public static CloudFile cloudFile(CloudFileBO bo){
        final FileDomain build = FileDomain.builder().fOriginalName(bo.getFOriginalName())
                .fFileName(bo.getFFileName())
                .fPositionPath(bo.getFPositionPath())
                .fShortName(bo.getFShortName())
                .fWebSrc(bo.getFWebSrc())
                .fSubfix(bo.getFSubfix())
                .fFiletreeId(bo.getFFiletreeId())
                .fFiletreeVirtual(bo.getFFiletreeVirtual())
                .fSize(bo.getFSize())
                .build();
        CloudFile cloudFile = new CloudFile();
        cloudFile.fileDomain = build;
        return cloudFile;
    }

    private String originName;

    @Getter
    private File file;

    @Getter
    private FileDomain fileDomain;

    private boolean isDel = false;

    private void initFromFile(){

        //算出 加密文件名 16 位;
        String shortName = AbstractMD5Utils.md516Byte(file.getName());
        fileDomain = FileDomain.builder()
                         .fAbsoluteSrc(file.getAbsolutePath())
                         .fPositionPath("/")
                         .fSize(file.length())
                         .fSubfix(BaseFileUtils.getFileSuffix(originName,false))
                         .isTemp(true)
                         .fOriginalName(originName)
                         .fFileName(file.getName())
                         .fShortName(shortName)
                         .build();
        fileDomain.setFWebSrc("/" + fileDomain.getFSubfix() + "/" + shortName);

    }

    public  CloudFile(FileDomain fileDomain){
        this.fileDomain = fileDomain;
        this.file = new File(this.fileDomain.getFAbsoluteSrc());
    }

    public void rm(){
       //删除文件 线程化
//        this.file.delete();
    }





    @Override
    public ViewObject vo(){
        return new CloudFileVO(CloudFile.bo(this));
    }

    @Override
    public BusinessObject bo() {
        return CloudFile.bo(this);
    }


}
