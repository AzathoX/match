package org.match.services.interfaces.impl;

import org.match.services.interfaces.CacheServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.match.services.interfaces.ScoreServices;

import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class ScoreServicesImpl implements ScoreServices {


    @Autowired
    private CacheServices cacheServices;


    private final static String MATCH_RESULT = "match_result";

    private static int  LOCK_LIST = 0;


    private static CopyOnWriteArraySet<Thread> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    private static void notifyAllThread(){
        for (Thread thread : copyOnWriteArraySet) {
            thread.notifyAll();
        }
        copyOnWriteArraySet.clear();

    }

    private static void clearLock(){
        LOCK_LIST = 0;
    }
    //lock
    private static boolean lock(){
        while(true){
            //lock;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(LOCK_LIST == 0){

                break;
            }
        }
        return  true;
    }

    //clear
    private static  void unlock(){
        clearLock();
        notifyAllThread();
    }

    //++
    private static int addLockList(){
        copyOnWriteArraySet.add(Thread.currentThread());
        return ++LOCK_LIST;
    }




    @Override
    public void writeResult(List<String> result){
        cacheServices.addCache(MATCH_RESULT,result);
        if(LOCK_LIST > 0){
            unlock();
        }
    }




    @Override
    public void writeResult(Object obj){
        cacheServices.addCache(MATCH_RESULT,obj);
        if(LOCK_LIST > 0){
            unlock();
        }
    }


    @Override
    public Object resultPolling(){
        addLockList();
        if(lock()){
            final Object result = cacheServices.getCache(MATCH_RESULT);
            return result;
        }
        return  null;
    }


    @Override
    public Object result(){
        return cacheServices.getCache(MATCH_RESULT);
    }


}
