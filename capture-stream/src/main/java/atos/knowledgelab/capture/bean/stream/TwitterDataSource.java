package atos.knowledgelab.capture.bean.stream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="twitter")
@XmlAccessorType(XmlAccessType.NONE)
public class TwitterDataSource extends DataSource {
	
	@XmlTransient
	private String keywords;
	
	@XmlTransient
	private long lastTweetId;
	
	@XmlTransient
	private boolean fromLastTweetId;
	
	@XmlTransient
	private List<Tweet> tweets = new ArrayList<Tweet>();

	@XmlElement(name="keywords")
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {		
		this.keywords = keywords;
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	@XmlElement(name="lastTweetId")
	public long getLastTweetId() {
		return lastTweetId;
	}

	public void setLastTweetId(long lastTweetId) {
		this.lastTweetId = lastTweetId;
	}

	@XmlElement(name="fromLastTweetId")
	public boolean getFromLastTweetId() {
		return fromLastTweetId;
	}

	public void setFromLastTweetId(boolean fromLastTweetId) {
		this.fromLastTweetId = fromLastTweetId;
	}
	
	@Override
	public List <? extends CaptureData> getData() {
		return tweets;
	}	
}
