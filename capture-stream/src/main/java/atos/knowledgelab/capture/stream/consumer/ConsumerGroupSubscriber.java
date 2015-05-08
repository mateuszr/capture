package atos.knowledgelab.capture.stream.consumer;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import atos.knowledgelab.capture.client.messages.MessageDispatcher;

public class ConsumerGroupSubscriber {
    private final ConsumerConnector consumer;
    private final String topic;
    private ExecutorService executor;
    private final MessageDispatcher dispatcher;
	private final static Logger LOGGER = Logger.getLogger(ConsumerGroupSubscriber.class.getName());

	
    public ConsumerGroupSubscriber(String a_zookeeper, String a_groupId, String a_topic, MessageDispatcher dispatcher) {
    	ConsumerConfig cc = createConsumerConfig(a_zookeeper, a_groupId);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(cc);
        
        this.topic = a_topic;
        this.dispatcher = dispatcher;
    }
 
    public void shutdown() {
        if (consumer != null) consumer.shutdown();
        if (executor != null) executor.shutdown();
    }
 
    public void run(int a_numThreads) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(a_numThreads));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
 
        // Launch all the threads within the threadpool executor service
        executor = Executors.newFixedThreadPool(a_numThreads);
 
        //for each kafka stream, assign a worker thread that will handle the messages 
        //all consumer threads will be in the same kafka consumer group
        int threadNumber = 0;
        try {
            for (final KafkaStream stream : streams) {
                executor.submit(new ConsumerThread(stream, threadNumber, dispatcher));
                threadNumber++;
            }
        	
        } catch (JAXBException e) {
        	LOGGER.info("Can't initialize consumer threads. JAXB Context initialisation error.");
        	e.printStackTrace();
        }
    }
 
    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
 
        return new ConsumerConfig(props);
    }


}
