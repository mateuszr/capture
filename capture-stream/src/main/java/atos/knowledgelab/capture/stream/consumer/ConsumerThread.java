package atos.knowledgelab.capture.stream.consumer;

import java.io.StringReader;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import atos.knowledgelab.capture.bean.stream.StreamItem;
import atos.knowledgelab.capture.client.messages.MessageDispatcher;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerThread implements Runnable {
    private KafkaStream stream;
    private int threadNumber;
    private MessageDispatcher dispatcher;
	private final static Logger LOGGER = Logger.getLogger(ConsumerThread.class.getName());
	private JAXBContext jc;
	private Unmarshaller unmarshaller;
	
    public ConsumerThread(KafkaStream a_stream, int a_threadNumber, MessageDispatcher dispatcher) throws JAXBException {
        this.threadNumber = a_threadNumber;
        this.stream = a_stream;
        this.dispatcher = dispatcher;
        
        this.jc = JAXBContext.newInstance(StreamItem.class);
		this.unmarshaller = jc.createUnmarshaller();
    }
 
    
    public void run() {
        ConsumerIterator<byte[], byte[]> it = this.stream.iterator();
        
        //the main loop where we receive messages form the kafka broker
        while (it.hasNext()) {
        	String msg = new String(it.next().message());
        	//LOGGER.info("Thread " + threadNumber + ": " + msg);
            
            //unmarshall xml message:
            
			try {
				JAXBElement<StreamItem> streamItemElement = unmarshaller.unmarshal(new StreamSource(new StringReader(msg)), StreamItem.class);
				dispatcher.offer(streamItemElement.getValue());
				
			} catch (JAXBException e1) {
				// TODO check for parser exception, and in case of invalid character 
				// try to convert to 0xFFFD or drop. and repeat unmarshall
				// illegal chars: 0x8, 0x19, 0x10
				
				e1.printStackTrace();
			}
            
        }
        
        System.out.println("Shutting down Thread: " + this.threadNumber);
    }
}