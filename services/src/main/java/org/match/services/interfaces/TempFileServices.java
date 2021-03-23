package org.match.services.interfaces;

import org.springframework.web.multipart.MultipartFile;
import org.match.domains.vo.CloudFileVO;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;

public interface TempFileServices {

    /**
     * 存储临时文件
     *
     * @param origin 传进来的源文件
     * @param parentFile 需要存储的文件夹
     * @return
     */
    CloudFileVO tempSave(MultipartFile origin, File parentFile);


    File tempFile(String shortName);

    void tempToPersistent(String[] shortNames);
}
