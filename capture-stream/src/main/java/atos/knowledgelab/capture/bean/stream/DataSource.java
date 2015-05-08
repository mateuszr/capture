package atos.knowledgelab.capture.bean.stream;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.NONE)
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
