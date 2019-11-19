package JSFWebSockets.websockets;

//import JSFWebSockets.messaging.MessageSender;
import JSFWebSockets.config.CustomSpringConfigurator;
import JSFWebSockets.messaging.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.server.standard.SpringConfigurator;
import JSFWebSockets.bean.NotificationManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@Service
@Configurable
@ServerEndpoint(value = "/notification", configurator = CustomSpringConfigurator.class)
public class NotificationEndPoint implements Serializable {

  @Autowired
  MessageSender messageSender;

  static ArrayList<Session> sessions = new ArrayList<>();

  @OnMessage
  public void messageReceiver(String message) {
    messageSender.sendMessage(message);
  }

  @OnOpen
  public void onOpen(Session session) {
    sessions.add(session);
  }

  @OnClose
  public void onClose(Session session) {
    sessions.remove(session);
  }

  public static ArrayList<Session> getSessions() {
    return sessions;
  }

  public static void setSessions(ArrayList<Session> sessions) {
    NotificationEndPoint.sessions = sessions;
  }

}
