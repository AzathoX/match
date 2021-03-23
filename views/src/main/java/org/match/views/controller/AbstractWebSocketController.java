package org.match.views.controller;


import org.springframework.web.socket.client.WebSocketClient;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.nrocn.lib.basesocket.WebSocketContext.subOnlineCount;

//webService 入口
public abstract class AbstractWebSocketController {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();


    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }


    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String userName){
        sessionPools.put(userName, session);
        addOnlineCount();
        try {
            sendMessage(session, "连接成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(@PathParam(value = "sid") String userName){
        sessionPools.remove(userName);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        for (Session session: sessionPools.values()) {
            try {
                sendMessage(session, message);
            } catch(Exception e){
                e.printStackTrace();
                continue;
            }
        }
    }


    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }


    //发送消息
    public static void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
    //给指定用户发送信息
    public void sendInfo(String userName, String message){
        Session session = sessionPools.get(userName);
        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //给全部用户发送信息
    public static void sendAll(String message){
        for (Session session : sessionPools.values()) {
            try {
                sendMessage(session,message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}
