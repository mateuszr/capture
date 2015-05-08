package atos.knowledgelab.capture.example.consumer;

import java.util.Observable;
import java.util.Observer;

import atos.knowledgelab.capture.bean.stream.StreamItem;

public class MessageReceiver implements Observer {

	public void update(Observable o, Object arg) {
		//The object we receive here is of class StreamItem 
		StreamItem si = (StreamItem) arg;

		//print the text of the tweet
		System.out.println(si.getTweet().getText());
		
		
	}

}
