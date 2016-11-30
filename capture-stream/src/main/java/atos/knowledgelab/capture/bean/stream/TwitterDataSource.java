/*******************************************************************************
 * Copyright (C) 2016  ATOS Spain S.A.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *      Mateusz Radzimski (ATOS, ARI, Knowledge Lab)
 *      Iván Martínez Rodriguez (ATOS, ARI, Knowledge Lab)
 *      María Angeles Sanguino Gonzalez (ATOS, ARI, Knowledge Lab)
 *      Jose María Fuentes López (ATOS, ARI, Knowledge Lab)
 *      Jorge Montero Gómez (ATOS, ARI, Knowledge Lab)
 *      Ana Luiza Pontual Costa E Silva (ATOS, ARI, Knowledge Lab)
 *      Miguel Angel Tinte García (ATOS, ARI, Knowledge Lab)
 *      
 *******************************************************************************/
package atos.knowledgelab.capture.bean.stream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private boolean chronologicalOrder;

	@XmlTransient
	private Long historicalLimit;

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
	
	@JsonIgnore
	@Override
	public List <? extends CaptureData> getData() {
		return tweets;
	}

	public void setChronologicalOrder(boolean chronologicalOrder) {
		this.chronologicalOrder = chronologicalOrder;
	}	
	
	@XmlElement(name="chronologicalOrder")
	public boolean getChronologicalOrder () {
		return this.chronologicalOrder;
	}
	
	@XmlElement(name="historicalLimit")
	public Long getHistoricalLimit() {
		return historicalLimit;
	}

	public void setHistoricalLimit(Long historicalLimit) {
		this.historicalLimit = historicalLimit;
	}
}
