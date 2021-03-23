package org.match.views.controller;

import org.match.views.utils.WebResponse;
import org.nrocn.lib.basecontroller.BaseWebController;
import org.nrocn.lib.baserqnp.IMicroResponsable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.match.views.log.Logger;


public abstract class AbstractConstroller extends BaseWebController {


    protected static org.slf4j.Logger log = Logger.log;


    @Override
    @RequestMapping("/model/info")
    protected IMicroResponsable modelInfo() {
        log.info(this.namedModelName());
        return WebResponse.getPrototype().successResp(namedModelName(),null);
    }
}
