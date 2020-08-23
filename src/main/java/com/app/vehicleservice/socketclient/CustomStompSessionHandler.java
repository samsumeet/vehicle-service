package com.app.vehicleservice.socketclient;

import com.app.vehicleservice.model.BroadcastLocationEvent;
import java.lang.reflect.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

/**
 * This class is an implementation for StompSessionHandlerAdapter. Once a connection is established,
 * We subscribe to /topic/messages and send a sample message to server.
 */
public class CustomStompSessionHandler extends StompSessionHandlerAdapter {

  private Logger logger = LogManager.getLogger(CustomStompSessionHandler.class);

  @Override
  public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    logger.info("New session established : " + session.getSessionId());
    session.subscribe("/topic/public", this);
    logger.info("Subscribed to /topic/public");
  }

  @Override
  public void handleException(StompSession session, StompCommand command, StompHeaders headers,
      byte[] payload, Throwable exception) {
    logger.error("Got an exception", exception);
  }

  @Override
  public Type getPayloadType(StompHeaders headers) {
    return BroadcastLocationEvent.class;
  }

  @Override
  public void handleFrame(StompHeaders headers, Object payload) {
    BroadcastLocationEvent msg = (BroadcastLocationEvent) payload;
    logger.info("Received : " + msg.getId() + " from : " + msg.getLocation().getLat());
  }

}