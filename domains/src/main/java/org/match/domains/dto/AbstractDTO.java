package org.match.domains.dto;

import lombok.Getter;

public abstract class AbstractDTO<T> implements  DataTranslateObject{


    private String message;

    private boolean  pass = true;

    @Override
    public boolean isPass(){
        return  pass;
    }

    @Override
    public  String getMessage(){
        return this.message;
    }


    protected  void setMessage(String message){
         this.message = message;
    }

    protected  void addMessage(String message){
         this.message += message;
    }



    @Override
    public boolean check() {
        return pass = doCheck();
    }

    protected  boolean doCheck(){
        return true;
    }


    @Override
    public T bo() {
        return null;
    }


}
