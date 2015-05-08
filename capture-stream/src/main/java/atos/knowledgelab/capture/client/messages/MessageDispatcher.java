package atos.knowledgelab.capture.client.messages;

import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

import atos.knowledgelab.capture.bean.stream.KafkaMessage;
import atos.knowledgelab.capture.bean.stream.StreamItem;



public class MessageDispatcher extends Observable {

	/*
	
	//experimental code
	ConcurrentLinkedQueue<KafkaMessage> queue = new ConcurrentLinkedQueue<KafkaMessage>();
	ConcurrentLinkedDeque<StreamItem> dequeue = new ConcurrentLinkedDeque<StreamItem>();
	Boolean batchMode = false;
	Integer batchSize = 10;
	*/
	
//	private () {
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * SingletonHolder is loaded on the first execution of
//	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
//	 * not before.
//	 */
//	private static class SingletonHolder {
//		public static final MessageDispatcher INSTANCE = new MessageDispatcher();
//	}
//
//	public static MessageDispatcher getInstance() {
//		return SingletonHolder.INSTANCE;
//	}

	public MessageDispatcher() {
		
	}
	
	//the method that receives all messages from kafka clients
	public void offer(StreamItem msg) {

		setChanged();
		notifyObservers(msg);
		
	}
	
	/*
	public StreamItem getLatest() throws InterruptedException {
		return this.dequeue.peekFirst();
	}
	
	public KafkaMessage poll() throws InterruptedException {
		return queue.poll();
	}
	*/
}
