package org.nrocn.lib.basesocket;

import org.nrocn.lib.model.socket.SocketDomain;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Objects;

public abstract class AbstractWebSocket implements IWebSocket {

    protected Session session;



    protected  abstract SocketDomain parseJSON(String message);

    protected  abstract String getId();

    protected  abstract  void onOpen(Session session);


    @OnOpen
    public void onOpen(@PathParam("sid") String userId, Session session) {
        this.session = session;
        if(Objects.nonNull(userId)){
            WebSocketContext.push(userId,this);
        }
        else{
            WebSocketContext.push(session.getId(),this);
        }
        SocketDomain socketDomain = parseJSON("连接成功！");
        this.sendMsg(socketDomain);
        this.onOpen(session);
    }

    @OnClose
    public void onClose(CloseReason closeReason) {
        IWebSocket pop = WebSocketContext.pop(getId());
        if(pop != null){
            return ;
        }
    }


    @OnMessage
    public String onMessage(String message) {
        SocketDomain socketDomain = parseJSON(message);
        if(socketDomain.isAtAll()){
            WebSocketContext.sendMsgAll(socketDomain);
            return "全部发送完成";
        }
        WebSocketContext.sendMsgByAtList(socketDomain);
        return null;
    }

    public void receiveMessage(SocketDomain socketDomain) {
        SocketDomain receive = new SocketDomain();
        receive.setAtUsers(new String[]{socketDomain.getTicky()});
        receive.setMessage(socketDomain.getMessage());
        receive.setAtAll(false);
        WebSocketContext.sendMsgByAtList(receive);
    }


    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void sendMsg(SocketDomain socketDomain) {
        try {
            synchronized (this.session) {
                this.session.getBasicRemote().sendText(socketDomain.getMessage());
            }
        }catch (Exception exception){
            socketDomain.setMessage("发送异常消息为:"+exception.getMessage());
            this.receiveMessage(socketDomain);
        }
    }
}
