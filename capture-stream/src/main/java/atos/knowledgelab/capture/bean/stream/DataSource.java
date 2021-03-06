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

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@XmlAccessorType(XmlAccessType.NONE)
@JsonTypeInfo(use = Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "type")
@JsonSubTypes({
    @Type(value = TwitterDataSource.class, name = "twitter")
    })
public class DataSource {
	
	public DataSource(){
		//this.sourceID =  UUID.randomUUID().toString();
	}
	
	@XmlTransient
	private String sourceID;
	
	@XmlTransient
	private String dstype;
	

	@XmlElement(name="sourceID")
	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	@XmlElement(name="type")
	public String getDstype() {
		return dstype;
	}

	public void setDstype(String type) {
		this.dstype = type;
	}
		
	public List<? extends CaptureData> getData(){
		throw new RuntimeException("WARNING: DataSource is only instantiable due to datanucleus requirements. Every time you extend this class you MUST override this method");
	}
	
}
