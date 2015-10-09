package atos.knowledgelab.capture.bean.stream;

public class StreamItem {
	Tweet tweet;
	String dataChannelId;
	String dataSourceId;
	QueryData queryData;
	Double sentiment; //-1 0 +1
	Double stress;
	Double dangerousness;
	
	//TODO: change to hashmap of features for the future?
		
	
	public QueryData getQueryData() {
		return queryData;
	}
	public Double getSentiment() {
		return sentiment;
	}
	public void setSentiment(Double sentiment) {
		this.sentiment = sentiment;
	}
	public Double getStress() {
		return stress;
	}
	public void setStress(Double stress) {
		this.stress = stress;
	}
	public Double getDangerousness() {
		return dangerousness;
	}
	public void setDangerousness(Double dangerousness) {
		this.dangerousness = dangerousness;
	}	
	public void setQueryData(QueryData queryData) {
		this.queryData = queryData;
	}
	public Tweet getTweet() {
		return tweet;
	}
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	public String getDataChannelId() {
		return dataChannelId;
	}
	public void setDataChannelId(String dataChannelId) {
		this.dataChannelId = dataChannelId;
	}
	public String getDataSourceId() {
		return dataSourceId;
	}
	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	
	
}
