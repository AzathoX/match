package org.match.views.controller;



import org.match.views.utils.WebResponse;
import org.nrocn.lib.baserqnp.IMicroResponsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.match.domains.dto.PhontomDTO;
import org.match.domains.dto.PhontomReviewDTO;
import org.match.services.interfaces.PhontomManagerServices;
import org.match.services.interfaces.WebSocketServices;
import org.match.services.interfaces.impl.WebSockerImpl;

import java.util.List;

@RequestMapping("/phontom/svc")
@RestController
public class PhontomSvcController  extends  AbstractConstroller{


    @Autowired
    private PhontomManagerServices phontomManagerServices;

    @Autowired
    private WebSocketServices webSocketServices;

    @Override
    protected String namedModelName() {
        return "魅影圈模块(原魅美影像)";
    }


    //魅影圈说说上线
    @Async
    @PostMapping("/public/online")
    public IMicroResponsable online(@RequestBody PhontomDTO phontomDTO){
        phontomManagerServices.save(phontomDTO);
        WebSockerImpl.sendAllMessage(phontomManagerServices.list(0));
        return WebResponse.getSingleton().successResp("发布成功",null);
    }

    @GetMapping("/list")
    public Object doRespList(@RequestParam(required = false) Integer state){
        return phontomManagerServices.list(state);
    }

    @PostMapping("/list/review")
    public Object doRespReview(@RequestBody PhontomReviewDTO dto){
        phontomManagerServices.review(dto.getName(),dto.getState());
        WebSockerImpl.sendAllMessage(phontomManagerServices.list(0));
        return dto;
    }

    @GetMapping("/list/polling")
    public Object doRespListByLongPolling(@RequestParam(required = false) Integer state){
        return phontomManagerServices.listWithLongPolling( state);
    }




}
