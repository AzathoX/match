package org.match.views.log;

import org.match.views.controller.AbstractConstroller;
import org.slf4j.LoggerFactory;

public class Logger {
    public static org.slf4j.Logger log = LoggerFactory.getLogger(AbstractConstroller.class);

    public static void write(String message){
        Logger.log.info(message);
        System.out.println(message);
    }

    public static void err(String error){
        Logger.log.error(error);
        System.out.println(error);
    }
}
