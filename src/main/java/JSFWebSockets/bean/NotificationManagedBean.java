package JSFWebSockets.bean;

import JSFWebSockets.websockets.NotificationEndPoint;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.websocket.Session;

@ManagedBean(name = "notificationManagedBean")
@ViewScoped
public class NotificationManagedBean implements Serializable {

  public NotificationManagedBean() {
  }
  
  String message;
  
  public void sendNotification()  {
    List<Session> list = NotificationEndPoint.getSessions();
    for (Session s : list) {
      if (s.isOpen()) {
        s.getAsyncRemote().sendText(message);
      }
    }
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
}
