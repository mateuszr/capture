package atos.knowledgelab.capture.example.producer;

import java.util.Date;
import java.util.Properties;

import kafka.producer.ProducerConfig;
import atos.knowledgelab.capture.bean.stream.StreamItem;
import atos.knowledgelab.capture.bean.stream.Tweet;
import atos.knowledgelab.capture.stream.config.ConsumerClientConfig;
import atos.knowledgelab.capture.stream.config.StreamProducerConfig;
import atos.knowledgelab.capture.stream.consumer.ConsumerClient;
import atos.knowledgelab.capture.stream.producer.StreamProducer;

public class ExampleProducer {

	public static void main(String[] args) throws InterruptedException {
		
		//Configuration of the producer
		StreamProducerConfig conf = new StreamProducerConfig();
		
		// TODO: load configuration from file?
		// props.load(this.getClass().getClassLoader().getResourceAsStream("kafka.properties"));

		//Here it is important to specify the broker (kafka node or nodes)
		//more details here: http://kafka.apache.org/08/configuration.html
		conf.put("metadata.broker.list", "localhost:9092");
		conf.put("zookeeper.connect", "localhost:2181");
		conf.put("serializer.class", "kafka.serializer.StringEncoder");
		conf.put("request.required.acks", "1");
		conf.put("kafka.topic", "test");
		// props.put("partitioner.class", props.getProperty("partitioner.class"));

		
		try {
			StreamProducer sp = new StreamProducer(conf);
			
			for (int i=0; i<100; i++) {
				StreamItem si = new StreamItem();
				Tweet t = new Tweet();
				t.setText("Tweet number " + i);
				t.setCreatedAt(new Date());
				t.setUserScreenName("User1");
				si.setTweet(t);
				sp.send(si);				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
