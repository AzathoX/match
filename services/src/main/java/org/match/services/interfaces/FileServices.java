package org.match.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileServices {

    void delByShortName(List<String> shortName);

    void delById(int[] ids);
}
