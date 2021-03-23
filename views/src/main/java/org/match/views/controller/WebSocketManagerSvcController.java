package org.match.views.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.match.services.interfaces.WebSocketServices;

@RequestMapping("/ws/svc")
@RestController
public class WebSocketManagerSvcController extends AbstractConstroller {

    @Autowired
    private WebSocketServices webSocketServices;

    @Override
    protected String namedModelName() {
        return "webSocket 服务模块";
    }

    @GetMapping("/registry")
    public Object doRespGenricSid(){
        return  webSocketServices.sid();
    }
}
