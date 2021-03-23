package org.match.services.interfaces;

import org.nrocn.lib.basesocket.IWebSocket;
import org.nrocn.lib.model.socket.SocketDomain;

import javax.websocket.CloseReason;
import javax.websocket.Session;

public interface IWebSocketServices extends IWebSocket {
    void onOpen(Session session);

    void onClose(CloseReason closeReason);

    String onMessage(String message);

    void receiveMessage(SocketDomain socketDomain);

    void onError(Throwable t);

}
