package com.app.vehicleservice.socketclient;

import com.app.vehicleservice.constants.CommonConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public enum StompClientSession {
  INSTANCE;
  StompSession stompSession;

  public StompSession getStompSession() throws ExecutionException, InterruptedException {
    List<Transport> transports = new ArrayList<Transport>(2);
    transports.add(new WebSocketTransport(new StandardWebSocketClient()));
    transports.add(new RestTemplateXhrTransport());
    SockJsClient sockJsClient = new SockJsClient(transports);
    WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);

    stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    CustomStompSessionHandler sessionHandler = new CustomStompSessionHandler();

    stompSession = stompClient.connect(CommonConstants.SOCKJS_URL, sessionHandler)
        .get();

    return stompSession;
  }

  public void setStompSession(StompSession stompSession) {
    this.stompSession = stompSession;
  }
}