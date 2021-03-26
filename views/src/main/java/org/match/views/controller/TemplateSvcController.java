package org.match.views.controller;

import org.match.domains.bo.MatchTemplateBO;
import org.match.domains.dto.EventDTO;
import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.AbstractStage;
import org.match.services.interfaces.StageServices;
import org.match.services.interfaces.TeamAllocatedGroupServices;
import org.match.views.utils.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    private TeamAllocatedGroupServices teamAllocatedGroupServices;

    @Autowired
    private StageServices stageServices;


    @RequestMapping("/page/create/data")
    public Object doRespGetCreatePageData(){
        return templateServices.dataOfCreatePage();
    }

    @RequestMapping("/as/model")
    public Object doRespAsModel(@RequestBody EventDTO eventDTO){
        templateServices.saveConfig(eventDTO);
        return WebResponse.getSingleton().successResp("success",null);
    }

    @Async
    public void createFrom(MatchTemplateBO bo){
        AbstractGroup group = teamAllocatedGroupServices.group(bo);
        AbstractStage stage = stageServices.create(group);
        stageServices.schedule(bo,stage,group);
    }



    @RequestMapping("/create")
    public Object doRespCreate(@RequestBody MatchTempDTO matchTempDTO){
        MatchTemplateBO bo = (MatchTemplateBO) templateServices.create(matchTempDTO.eventDTO());
        createFrom(bo);
        return WebResponse.getSingleton().successResp("success",null);
    }
}
