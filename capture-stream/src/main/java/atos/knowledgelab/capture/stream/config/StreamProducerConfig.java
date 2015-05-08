package atos.knowledgelab.capture.stream.config;

import java.util.Properties;

/*
 * 
 * Kafka producer will accept a standard Java property class,
 * for configuration parameters. 
 * In the future we can specify here:
 * - default options, 
 * - reading configuration from file here.
 * - etc... 
 * 
 */
public class StreamProducerConfig extends Properties {

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object k : this.keySet()) {
			sb.append((String) k + ": " + (String) this.getProperty((String) k) + "\n");
		}
		
		return sb.toString();
	}
	
}
