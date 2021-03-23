package org.match.views.controller;

import org.match.views.utils.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.match.domains.dto.EventDTO;
import org.match.domains.dto.MatchTempDTO;
import org.match.services.interfaces.TemplateServices;

//模板页面加载
@RequestMapping("/template/svc")
@RestController
public class TemplateSvcController extends AbstractConstroller{
    @Override
    protected String namedModelName() {
        return "模板模块";
    }

    @Autowired
    private TemplateServices templateServices;

    @RequestMapping("/page/create/data")
    public Object doRespGetCreatePageData(){
        return templateServices.dataOfCreatePage();
    }

    @RequestMapping("/as/model")
    public Object doRespAsModel(@RequestBody EventDTO eventDTO){
        templateServices.saveConfig(eventDTO);
        return WebResponse.getSingleton().successResp("success",null);
    }


    @RequestMapping("/create")
    public void doRespCreate(@RequestBody MatchTempDTO matchTempDTO){
        templateServices.create(matchTempDTO.eventDTO());
    }
}
