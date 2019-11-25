package JSFWebSockets.messaging;

import javax.jms.JMSException;
import JSFWebSockets.bean.NotificationManagedBean;
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	/**
	 * Active MQ message receiver.
	 */

	private static final Logger log = Logger.getLogger(MessageReceiver.class);

	/**
	 * Queue name.
	 */
	private static final String ORDER_RESPONSE_QUEUE = "order-queue";

	private NotificationManagedBean notificationManagedBean = new NotificationManagedBean();

	/**
	 * Receives message from the main app.
	 * Redirects in to Notification Managed Bean to output on display.
	 *
	 * @param message message
	 */
	@JmsListener(destination = ORDER_RESPONSE_QUEUE)
	public void receiveMessage(final Message<String> message) throws JMSException {
		String response = message.getPayload();
		notificationManagedBean.setMessage(response);
		notificationManagedBean.sendNotification();
		log.info("message received: " + response);
	}
}
