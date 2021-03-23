package org.match.views.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.match.views.utils.WebResponse;
import org.nrocn.lib.basecontroller.BaseWebController;
import org.nrocn.lib.baserqnp.IMicroResponsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.match.dataassert.datadomain.SysDictDomain;
import org.match.services.interfaces.SysDictDomainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/dict/svc")
@RestController
public class SysDictController extends BaseWebController {


    @Autowired
    private SysDictDomainService sysDictDomainService;

    @Override
    protected String namedModelName() {
        return null;
    }

    @Override
    @RequestMapping("/model/info")
    protected IMicroResponsable modelInfo() {
        return WebResponse.getPrototype().successResp(namedModelName(),null);
    }


    @Cacheable
    @ModelAttribute("dictList")
    public List getDict(){
        List<SysDictDomain> list = sysDictDomainService
                .list(new QueryWrapper<SysDictDomain>()
                        .select(SysDictDomain.COL_ID
                                ,SysDictDomain.COL_CAT
                                ,SysDictDomain.COL_NAME
                                ,SysDictDomain.COL_TYPE
                                ,SysDictDomain.COL_CODE
                                ,SysDictDomain.COL_TYPE
                                ,SysDictDomain.COL_AGE_LIMIT
                                ,SysDictDomain.COL_DOUBLE_AGE_LIMIT
                                ,SysDictDomain.COL_MAN_COUNT)
                        .eq(SysDictDomain.COL_TYPE,1));
        return list;
    }


    @GetMapping("/all")
    public Object doRespDictAll(@ModelAttribute("dictList") List<SysDictDomain> dictList){
        Map<String, ArrayList<SysDictDomain>> result = new HashMap<>();
        dictList.forEach(action->{
            String cat = action.getCat();
            if(ObjectUtils.isEmpty(result.get(cat))){
                result.put(cat,new ArrayList<>());
            }
            result.get(cat).add(action);
        });
        return result;
    }

    @GetMapping("/type/{type}")
    public Object doRespDictByType(@PathVariable String type,@ModelAttribute("dictList") List<SysDictDomain> dictList){
        List<SysDictDomain> list = dictList.stream().filter(predicate -> predicate.getCat().equals(type))
                .collect(Collectors.toList());
        return list;
    }
}
