package atos.knowledgelab.capture.stream.producer;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import atos.knowledgelab.capture.bean.stream.StreamItem;
import atos.knowledgelab.capture.bean.stream.Tweet;
import atos.knowledgelab.capture.stream.config.StreamProducerConfig;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class StreamProducer {

	private Producer<String, String> kafkaProducer;
	private static Logger LOGGER = Logger.getLogger(StreamProducer.class.getName());
	private String kafkaTopic;
	private StreamProducerConfig configuration;
	private JAXBContext jc;
	private Marshaller marshaller;
	
	public StreamProducer(StreamProducerConfig config) throws JAXBException {

		/** Kafka producer properties **/
//		Properties props = new Properties();
//		// props.load(this.getClass().getClassLoader().getResourceAsStream("kafka.properties"));
//
//		props.put("metadata.broker.list", "localhost:9092");
//		props.put("serializer.class", "kafka.serializer.StringEncoder");
//		props.put("request.required.acks", "1");
		// props.put("partitioner.class", props.getProperty("partitioner.class"));

		ProducerConfig kafkaConfig = new ProducerConfig(config);
		kafkaProducer = new Producer<String, String>(kafkaConfig);

		kafkaTopic = config.getProperty("kafka.topic");
		//kafkaTopic = "test";

		//create JAXB context for stream item class
		//NOTE: Do not invoke this in a loop, to avoid classloader leak problem.
		this.jc = JAXBContext.newInstance(StreamItem.class);
		this.marshaller = jc.createMarshaller();
	}

	public void send(StreamItem item) {
		// The EventBuilder is used to build an event using the
		// the raw JSON of a tweet
		// LOGGER.info(status.getUser().getScreenName() + ": " +
		// status.getText());

		// create object to be send
		// StreamItem si = new StreamItem();
		// si.setDataChannelId(dataChannelId);
		// si.setDataSourceId(dataSourceId);
		// si.setQueryData(query);
		// si.setTweet(TweetUtils.getTweetFromStatus(status));

		Writer writer = new StringWriter();

		// serialize the java class to XML file
		try {
			//JAXBContext jc = JAXBContext.newInstance(StreamItem.class);
			//Marshaller marshaller = jc.createMarshaller();
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			JAXBElement<StreamItem> jaxbElement = new JAXBElement<StreamItem>(new QName("streamItem"), StreamItem.class, item);
			marshaller.marshal(jaxbElement, writer);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// KeyedMessage<String, String> data = new KeyedMessage<String,
		// String>(kafkaTopic, DataObjectFactory.getRawJSON(status));
		KeyedMessage<String, String> data = new KeyedMessage<String, String>(kafkaTopic, writer.toString());

		kafkaProducer.send(data);

	}

	public void send(Tweet tweet) {
		// The EventBuilder is used to build an event using the
		// the raw JSON of a tweet
		// LOGGER.info(status.getUser().getScreenName() + ": " +
		// status.getText());

		// create object to be send
		StreamItem si = new StreamItem();
		// si.setDataChannelId(dataChannelId);
		// si.setDataSourceId(dataSourceId);
		// si.setQueryData(query);
		si.setTweet(tweet);

		Writer writer = new StringWriter();

		// serialize the java class to XML file
		try {
			//JAXBContext jc = JAXBContext.newInstance(StreamItem.class);
			//Marshaller marshaller = jc.createMarshaller();
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			JAXBElement<StreamItem> jaxbElement = new JAXBElement<StreamItem>(new QName("streamItem"), StreamItem.class, si);
			marshaller.marshal(jaxbElement, writer);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// KeyedMessage<String, String> data = new KeyedMessage<String,
		// String>(kafkaTopic, DataObjectFactory.getRawJSON(status));
		KeyedMessage<String, String> data = new KeyedMessage<String, String>(kafkaTopic, writer.toString());

		kafkaProducer.send(data);

	}
}
