package org.match.views.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/svc")
public class AccountSvcController extends AbstractConstroller {

    @Override
    protected String namedModelName() {
        return "账号分发模块";
    }



}
