package JSFWebSockets.messaging;

import javax.jms.JMSException;

import JSFWebSockets.bean.NotificationManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	private static final String ORDER_RESPONSE_QUEUE = "order-queue";

	private NotificationManagedBean notificationManagedBean = new NotificationManagedBean();

	@JmsListener(destination = ORDER_RESPONSE_QUEUE)
	public void receiveMessage(final Message<String> message) throws JMSException {
		String response = message.getPayload();
		notificationManagedBean.setMessage(response);
		notificationManagedBean.sendNotification();
	}
}
