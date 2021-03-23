package org.match.views.controller;

import org.nrocn.lib.utils.BaseIOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.match.domains.vo.CloudFileVO;
import org.match.services.interfaces.TempFileServices;
import org.match.views.value.MatchConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file/svc")
public class FileSvcController extends AbstractConstroller {

    private final File bindFile;


    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private TempFileServices tempFileServices;

    @Autowired
    public FileSvcController(MatchConfig matchConfig) throws IOException {
        this.bindFile = new File(matchConfig.getPath());
        if(!bindFile.exists()){
            bindFile.mkdir();
        }

    }

    @Override
    protected String namedModelName() {
        return "文件系统";
    }

    //上传临时文件
    @PostMapping("/temp/upload")
    public CloudFileVO tempUpload(MultipartFile origin){
        final CloudFileVO vo = tempFileServices.tempSave(origin, bindFile);
        return vo;
    }

    //查看临时文件
    @GetMapping("/temp/read/{shortName}")
    public void tempRead(@PathVariable("shortName") String shortName){
        try {
            BaseIOUtils.httpDownloadFileResponse(tempFileServices.tempFile(shortName),httpServletResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
