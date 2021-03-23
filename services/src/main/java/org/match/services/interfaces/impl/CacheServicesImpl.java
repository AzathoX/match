package org.match.services.interfaces.impl;

import org.match.services.interfaces.CacheServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CacheServicesImpl implements CacheServices {

    private static AtomicInteger NUM = new AtomicInteger();

    private static void addOnlineCount(){
        NUM.incrementAndGet();
    }

    @Override
    public void addNo(){
        addOnlineCount();
    }

    @Override
    public  String getNo(){
        return  NUM.toString();
    }


    private  static Map<String,Object>  CACHE_POOL = new HashMap<>();

    @Override
    public void addCache(String name, Object value){
        CACHE_POOL.put(name,value);
    }

    @Override
    public void rmCache(String name){
        CACHE_POOL.remove(name);
    }


    @Override
    public Object getCache(String name){
        return CACHE_POOL.get(name);
    }


    public void clearCache(){
        CACHE_POOL.clear();
    }


}
