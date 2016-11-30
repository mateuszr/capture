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
