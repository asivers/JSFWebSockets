package JSFWebSockets.websockets;

import JSFWebSockets.config.CustomSpringConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@Service
@Configurable
@ServerEndpoint(value = "/notification", configurator = CustomSpringConfigurator.class)
public class NotificationEndPoint implements Serializable {

  /**
   * EndPoint for session adding.
   */

  private static final Logger log = Logger.getLogger(NotificationEndPoint.class);

  static ArrayList<Session> sessions = new ArrayList<>();
  public static ArrayList<Session> getSessions() {
    return sessions;
  }
  public static void setSessions(ArrayList<Session> sessions) {
    NotificationEndPoint.sessions = sessions;
  }

  /**
   * Adds session when starting the application.
   *
   * @param session session
   */
  @OnOpen
  public void onOpen(Session session) {
    sessions.add(session);
    log.info("websocket opened");
  }

  @OnClose
  public void onClose(Session session) {
    sessions.remove(session);
  }

}
