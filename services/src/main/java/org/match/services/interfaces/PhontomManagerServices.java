package org.match.services.interfaces;

import org.match.domains.dto.DataTranslateObject;
import org.match.domains.vo.ViewObject;

import java.util.List;

public interface PhontomManagerServices {


    void save(DataTranslateObject dto);

    List<ViewObject> list(Integer state);

    void review(String[] uniname,int state);

    List<ViewObject> listWithLongPolling(Integer state);
}
