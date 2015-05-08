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

	@Override
	public List <? extends CaptureData> getData() {
		return tweets;
	}	
}
