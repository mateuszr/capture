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
		
}
