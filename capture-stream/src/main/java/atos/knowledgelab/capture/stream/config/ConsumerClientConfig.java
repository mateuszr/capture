package atos.knowledgelab.capture.stream.config;

public class ConsumerClientConfig {

	//set up some default values
	
	String zooKeeperEndPoint = "localhost:2181";
	String groupId = "group1";
	String topicName = "test";
	Integer threadNum = 4;
	
	
	public Integer getThreadNum() {
		return threadNum;
	}
	public void setThreadNum(Integer threadNum) {
		this.threadNum = threadNum;
	}
	public String getZooKeeperEndPoint() {
		return zooKeeperEndPoint;
	}
	public void setZooKeeperEndPoint(String zooKeeperEndPoint) {
		this.zooKeeperEndPoint = zooKeeperEndPoint;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Zookeeper: " + this.getZooKeeperEndPoint() + "\n");
		sb.append("Group Id: " + this.getGroupId() + "\n");
		sb.append("Topic Name: " + this.getTopicName() + "\n");
		sb.append("Number of parallel threads (consumers): " + this.getThreadNum() + "\n");
		
		return sb.toString();
	}
	
}
