package JSFWebSockets.bean;

import JSFWebSockets.websockets.NotificationEndPoint;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.websocket.Session;

/**
 * Managed Bean for output on display.
 */
@ManagedBean(name = "notificationManagedBean")
@ViewScoped
public class NotificationManagedBean implements Serializable {

  public NotificationManagedBean() {
  }
  
  String message;

  /**
   * Sets current message.
   *
   * @param message message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Outputs message on display.
   * template.xhtml -> javascript 'this_socket.on_message'
   */
  public void sendNotification()  {
    List<Session> list = NotificationEndPoint.getSessions();
    for (Session s : list) {
      if (s.isOpen()) {
        s.getAsyncRemote().sendText(message);
      }
    }
  }
  
}
