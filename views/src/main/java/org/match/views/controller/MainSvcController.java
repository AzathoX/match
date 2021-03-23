package org.match.views.controller;

import org.match.views.utils.WebResponse;
import org.nrocn.lib.baserqnp.IMicroResponsable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/main/svc")
@RestController
public class MainSvcController  extends AbstractConstroller {



    @Override
    protected String namedModelName() {
        return "比赛辅助系统";
    }


    @Override
    protected IMicroResponsable modelInfo() {
        log.info("比赛辅助系统");
        return WebResponse.getPrototype().successResp(namedModelName(),null);
    }

}
