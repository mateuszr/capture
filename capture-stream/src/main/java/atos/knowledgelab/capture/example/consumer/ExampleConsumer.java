package atos.knowledgelab.capture.example.consumer;

import atos.knowledgelab.capture.stream.config.ConsumerClientConfig;
import atos.knowledgelab.capture.stream.consumer.ConsumerClient;

public class ExampleConsumer {

	public static void main(String[] args) throws InterruptedException {
		
		//Configuration of the client
		ConsumerClientConfig config = new ConsumerClientConfig();
		config.setZooKeeperEndPoint("localhost:2181");
		config.setGroupId("myGroup");
		config.setTopicName("test");
		
		ConsumerClient client = new ConsumerClient(config);
		
		//instantiate the message receiver class (Observer)
		MessageReceiver mr = new MessageReceiver();
		
		//register observer to receive all messages from kafka
		client.subscribeObserver(mr);
		
		//connect clients to the kafka broker and start receiving messages
		client.start();
		
		//wait for 10 seconds while we receive messages
		Thread.sleep(10000);
		
		//disconnect from broker and remove the client(s)
		client.stop();
		
		//unsubscribe from observer
		client.unsubscribeObserver(mr);

	}

}
