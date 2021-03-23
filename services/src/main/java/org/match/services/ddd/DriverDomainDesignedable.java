package org.match.services.ddd;


import org.match.domains.bo.BusinessObject;
import org.match.domains.vo.ViewObject;

//面向对象领域模型
public interface DriverDomainDesignedable<T> {
     //转试图对象
     ViewObject vo();

     //转业务对象
     BusinessObject bo();

}
