package org.match.views.controller;

import cn.hutool.core.collection.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.match.services.interfaces.ScoreServices;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/score/svc")
public class ScoreSvcController  extends  AbstractConstroller{

    @Autowired
    private ScoreServices scoreServices;


    @Override
    protected String namedModelName() {
        return "成绩模块";
    }

    @PostMapping("/write/result")
    public void write(@RequestBody List<String> texts){
        this.scoreServices.writeResult(texts);
        System.out.println(texts);
    }

    @PostMapping("/write/str")
    public void writeStr(@RequestBody  String texts){
        final String[] split;
        try {
            split = URLDecoder.decode(texts,"UTF-8").replace("/n","").split(",|，");
            final List<String> strings = Arrays.asList(split);
            this.write(strings);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    @GetMapping("/result/polling")
    public Object doRespResultPolling(){
        return  scoreServices.resultPolling();
    }


    @GetMapping("/result")
    public Object doRespResult(){
        return  scoreServices.result();
    }
}
