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


@XmlRootElement(name="dataPool")
@XmlAccessorType(XmlAccessType.NONE)
public class DataPool {

	@XmlTransient
	private String poolID;
	
	@XmlTransient
	private String name;
	
	@XmlTransient
	private String description;
	
	@XmlTransient
	private List<? extends CaptureData> data = new ArrayList<CaptureData>();
	
	@XmlTransient
	private List<String> keywords = new ArrayList<String>();
	
	@XmlTransient
	private String lang;

	public String getPoolID() {
		return poolID;
	}

	@XmlElement(name="poolID")
	public void setPoolID(String poolID) {
		this.poolID = poolID;
	}

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<? extends CaptureData> getData() {
		return data;
	}

	public void setData(List<? extends CaptureData> data) {
		this.data = data;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	@XmlElement(name="keyword")
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getLang() {
		return lang;
	}
	@XmlElement(name="lang")
	public void setLang(String lang) {
		this.lang = lang;
	}
		
}
