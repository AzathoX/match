package org.match.domains.dto;

import java.io.Serializable;

public interface DataTranslateObject<T> extends Serializable {

    //检查
    boolean check();

    //返回信息
    String getMessage();

    //是否通过
    boolean isPass();

    //转业务对象
    T bo();
}
