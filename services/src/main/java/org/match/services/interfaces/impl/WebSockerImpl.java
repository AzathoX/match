package org.match.services.interfaces.impl;


import com.alibaba.fastjson.JSON;
import org.match.services.interfaces.IWebSocketServices;
import org.nrocn.lib.basesocket.AbstractWebSocket;
import org.nrocn.lib.basesocket.WebSocketContext;
import org.nrocn.lib.model.socket.SocketDomain;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint("/ws/{sid}")
public class WebSockerImpl extends AbstractWebSocket implements IWebSocketServices {


    private Session session;

    @Override
    protected SocketDomain parseJSON(String message) {
        final SocketDomain socketDomain = new SocketDomain();
        socketDomain.setMessage(message);
        return socketDomain;
    }

    @Override
    protected String getId() {
        return session.getId();
    }


    public static void sendAllMessage(Object object){
        final SocketDomain socketDomain = new SocketDomain();
        Map<String, Object> data = new HashMap<>();
        data.put("data",object);
        socketDomain.setData(data);
        socketDomain.setMessage(JSON.toJSONString(socketDomain));
        WebSocketContext.sendMsgAll(socketDomain);
    }

    @Override
    public void onOpen(Session session) {

    }
}
