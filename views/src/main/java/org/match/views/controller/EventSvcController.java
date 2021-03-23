package org.match.views.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.views.utils.WebResponse;
import org.nrocn.lib.basecontroller.BaseWebController;
import org.nrocn.lib.baserqnp.IMicroResponsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.match.dataassert.datadomain.EventDomain;
import org.match.dataassert.datadomain.SysDictDomain;
import org.match.services.interfaces.EventDomainService;
import org.match.services.interfaces.SysDictDomainService;

import java.util.List;


@RequestMapping("/event/svc")
@RestController
public class EventSvcController extends BaseWebController {

    @RequestMapping("/model/info")
    @Override
    protected String namedModelName() {
        return "赛事模块";
    }

    @Override
    protected IMicroResponsable modelInfo() {
        return WebResponse.getPrototype().successResp(namedModelName(),null);
    }


    @Autowired
    private SysDictDomainService sysDictDomainService;


    @Autowired
    private EventDomainService eventDomainService;


    @GetMapping("/like/{name}")
    public List doRespSelectByNameLike(@PathVariable String name){
        List<EventDomain> list = eventDomainService.list(new QueryWrapper<EventDomain>()
                .select(EventDomain.COL_ID,EventDomain.COL_NAME,EventDomain.COL_START_DATE)
                .like(SysDictDomain.COL_NAME,name));
        return list;
    }


    @GetMapping("/all")
    public Object doRespEventList(){
        List<EventDomain> list = eventDomainService.list(new QueryWrapper<EventDomain>()
                .select(EventDomain.COL_ID,EventDomain.COL_NAME,EventDomain.COL_START_DATE)
                 .orderByDesc(EventDomain.COL_CREATE_TIME));
        return list;
    }

    private static final String QR_CODE = "t_event.code";

    @GetMapping("/qrcode")
    public Object doRespQrCodeList(){
        return  sysDictDomainService.list(new QueryWrapper<SysDictDomain>().select(SysDictDomain.COL_NAME,EventDomain.COL_DESCRIPTION).eq(SysDictDomain.COL_CAT,QR_CODE));
    }


}
