Capture Consumer Client
=======================

Purpose
-------

The purpose of this module is to provide a simple API
for fast and easy implementation of kafka data stream consumers.



Quick Start
-----------

Here is the instruction for quickly setup a running kafka client:

1) Download the source code if you haven't already

2) Build the "capture-stream" module with maven

```bash
cd capture/capture-stream
mvn clean install
```

3) Setup kafka message broker (if you haven't already)

See kafka documentation for details here: http://kafka.apache.org/documentation.html#quickstart 

Basically you need to start zookeeper and kafka server. This example will use "test" topic, that is created by default. Should you need to use another topic, first you need to create it. Refer to the kafka documentation for details.

4) Run examples bundled with this project:

This project contains 2 example applications: Consumer and Producer.
See `atos.knowledgelab.capture.example` packages for the source code.
The `capture-stream` build will create a jar file in `target` folder with packaged dependencies and examples. You can use them to test your kafka setup.

Running example consumer:

```bash
cd target
java -cp capture-stream-0.0.1-SNAPSHOT-jar-with-dependencies.jar atos.knowledgelab.capture.example.consumer.ExampleConsumer
```

Running example producer (preferably in other terminal):

```bash
cd target
java -cp capture-stream-0.0.1-SNAPSHOT-jar-with-dependencies.jar atos.knowledgelab.capture.example.producer.ExampleProducer
```

After starting both examples, the consumer application should start receiving messages. 
Consumer will run for about 30 seconds and will exit.
Producer will send 100 tweets and will exit as well.


Using this module
-----------------

In order to use this module in your application, edit the pom.xml file of your project put the following dependency:

```xml
<dependency>
	<groupId>atos.knowledgelab.capture</groupId>
	<artifactId>capture-stream</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

API overview
------------

Here is an example of the kafka consumer client.
It consists of 2 classes: the first one is an observer that will receivve messages and print them to the console. The second shows the API
of the `ConsumerClient`: client configuration, registration of the 
`MessageReceiver` and starting the client for 10 seconds.
 

```java
import java.util.Observable;
import java.util.Observer;

import atos.knowledgelab.capture.api.stream.StreamItem;

public class MessageReceiver implements Observer {

	public void update(Observable o, Object arg) {
		//The object we receive here is of class StreamItem 
		StreamItem si = (StreamItem) arg;

		//print the text of the tweet
		System.out.println(si.getTweet().getText());
		
		
	}

}
```

6) create class "ExampleApp"

```java
import atos.knowledgelab.capture.client.manager.ConsumerClient;
import atos.knowledgelab.capture.client.manager.ConsumerClientConfig;

public class ExampleApp {

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

```

7) Now you can run the ExampleApp class and you are now ready to receive messages from the "test" topic. 


Message format
--------------

All messages are the serialized `Twitter` classes. You may either use JAXB unmarshaller for deserialization, or use custom JSON parsing.

The JSON format resembles the Twitter.java class, and looks similar to the following example:
 
```JSON
{
    "queryData": {
        "captureEndDate": "2015-10-18T22:34:59Z",
        "captureStartDate": "2015-10-06T14:34:59Z",
        "composedID": "828db5b9-354b8ada-0b6e-4c53-b0df-182781db1d5d",
        "dcID": "828db5b9",
        "dsID": "354b8ada-0b6e-4c53-b0df-182781db1d5d",
        "fromLastID": "false",
        "lastID": "0",
        "positioninQueue": "0",
        "query": "obama;;;",
        "type": "stream"
    },
    "tweet": {
        "createdAt": "2015-10-09T20:41:29+01:00",
        "dataID": "Tweet652569592057860096",
        "dataPools": null,
        "dataSources": null,
        "favouriteCount": "0",
        "hashTags": "",
        "inReplyToId": "-1",
        "originalTweetId": "652563634569109504",
        "retweetCount": "0",
        "rawJson": "{}",
        "source": "<a href=\"http://twitter.com/download/iphone\" rel=\"nofollow\">Twitter for iPhone</a>",
        "sourceUrls": "https://t.co/O0dsB1JQRa",
        "text": "RT @baseballcrank: You think you've seen a new low in political spin, then you read \"pro-Massacre activists\" https://t.co/O0dsB1JQRa",
        "tweetID": "652569592057860096",
        "userDescription": "success through persistence (blood/sweat/tears) In the City of Angels, my horns blend in rather well\nKick. Flip. Twist.",
        "userFollowers": "1466",
        "userFollowes": "1998",
        "userID": "2160070393",
        "userScreenName": "bmenyhert"
    }
}
        

```

Please note that there might be few more fields, depending on the current version, but in principle it should be always consistent with the Twitter.java file.

We also provide "rawJson" field, to get the raw result as it comes from the Twitter API. This can be useful for retrieving other fields (such as user information). You might use it to speed up paring, by retrieving only "<rawJson>" field from the XML, and use JSON parser, which should be faster. 



