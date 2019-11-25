package JSFWebSockets.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import java.util.Arrays;

@Configuration
@EnableJms
public class MessagingListenerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;

    /**
     * Active MQ localhost.
     */
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    /**
     * Connection factory.
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("JSFWebSockets"));
        return connectionFactory;
    }

    /**
     * Jms listener.
     */
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-1");
        return factory;
    }

}
