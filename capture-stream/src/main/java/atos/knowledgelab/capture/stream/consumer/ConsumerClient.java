package atos.knowledgelab.capture.stream.consumer;

import java.util.Observer;
import java.util.logging.Logger;

import atos.knowledgelab.capture.client.messages.MessageDispatcher;
import atos.knowledgelab.capture.stream.config.ConsumerClientConfig;

public class ConsumerClient {
	private final static Logger LOGGER = Logger.getLogger(ConsumerClient.class.getName());
	
	private final MessageDispatcher dispatcher;
	private ConsumerGroupSubscriber consumerGroupSubscriber;
	
	private ConsumerClientConfig configuration;
	

	
	public ConsumerClient(ConsumerClientConfig config) {
		//store the configuration internally
		configuration = config;
		
		//setup storage manager classes
		LOGGER.info("Initializing consumer application.");
		//print current client configuration
		LOGGER.info("Consumer configuration: ");
		LOGGER.info(configuration.toString());
		
		//setup message dispatcher
		LOGGER.info("Setting up message dispatcher...");
		//dispatcher = MessageDispatcher.getInstance();
		dispatcher = new MessageDispatcher();
		
		//setting up kafka consumers, but don't start them yet.
		//allow user to setup the observers, etc.
		LOGGER.info("Setting up Kafka consumers...");
		//consumerGroupSubscriber = new ConsumerGroupSubscriber("localhost:2181", "group1", "test");
		consumerGroupSubscriber = new ConsumerGroupSubscriber(
				configuration.getZooKeeperEndPoint(), 
				configuration.getGroupId(), 
				configuration.getTopicName(),
				dispatcher);
        
	}
	
	public void start() {
		consumerGroupSubscriber.run(configuration.getThreadNum());
	}
	
	public void stop() {
		consumerGroupSubscriber.shutdown();
	}
	
	public MessageDispatcher getDispatcher() {
		return dispatcher;
	}
	
	public void subscribeObserver(Observer o) {
		dispatcher.addObserver(o);
	}
	
	public void unsubscribeObserver(Observer o) {
		dispatcher.deleteObserver(o);
	}
}
