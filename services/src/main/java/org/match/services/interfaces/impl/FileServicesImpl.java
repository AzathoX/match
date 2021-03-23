package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.services.interfaces.FileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.match.dataassert.datadomain.FileDomain;
import org.match.dataassert.mapper.FileDomainMapper;
import org.match.services.ddd.CloudFile;

import java.io.File;
import java.util.List;

@Service
public class FileServicesImpl implements FileServices {

    @Autowired
    private FileDomainMapper fileDomainMapper;

    @Override
    public void delByShortName(List<String> shortNames){
        final QueryWrapper<FileDomain> in = new QueryWrapper<FileDomain>()
                .select(FileDomain.SQL_SELECT)
                .in(FileDomain.F_SHORT_NAME, shortNames);
        final List<FileDomain> fileDomains = fileDomainMapper.selectList(in);
        //删除文件
        for (FileDomain fileDomain : fileDomains) {
            final CloudFile cloudFile = new CloudFile();
            cloudFile.rm();
        }
        //删除数据
        fileDomainMapper.delete(in);
    }

    @Override
    public void delById(int[] ids) {

    }
}
