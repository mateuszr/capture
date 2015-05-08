package atos.knowledgelab.capture.bean.stream;

import org.apache.solr.client.solrj.beans.Field;

public class QueryData {
	
	@Field("id")
	private String composedID;
	
	@Field
	private String dcID;
	
	@Field
	private String dsID;
	
	@Field
	private String tweetID;
	
	@Field
	private String type;
		
	@Field("keywords")
	private String query;
	
	@Field
	private String captureStartDate;
	
	@Field
	private String captureEndDate;
	
	private int positioninQueue = 0; 
	
	public QueryData(){
		
	}
	
	public QueryData(String dcId, String dsId, String type, String keywords, String startDate, String endDate) {
		this.composedID = dcId + "-" + dsId;
		this.dcID = dcId;
		this.dsID = dsId;
		this.type = type;
		this.query = keywords;
		this.captureStartDate = startDate;
		this.captureEndDate = endDate;
	}
	public String getDsID() {
		return dsID;
	}
	public void setDsID(String dsID) {
		this.dsID = dsID;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}

	public String getComposedID() {
		return composedID;
	}

	public void setComposedID(String composedID) {
		this.composedID = composedID;
	}

	public String getDcID() {
		return dcID;
	}

	public void setDcID(String dcID) {
		this.dcID = dcID;
	}

	public String getTweetID() {
		return tweetID;
	}

	public void setTweetID(String tweetID) {
		this.tweetID = tweetID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCaptureStartDate() {
		return captureStartDate;
	}

	public void setCaptureStartDate(String captureStartDate) {
		this.captureStartDate = captureStartDate;
	}

	public String getCaptureEndDate() {
		return captureEndDate;
	}

	public void setCaptureEndDate(String captureEndDate) {
		this.captureEndDate = captureEndDate;
	}

	public int getPositioninQueue() {
		return positioninQueue;
	}

	public void setPositioninQueue(int positioninQueue) {
		this.positioninQueue = positioninQueue;
	}
	
}
