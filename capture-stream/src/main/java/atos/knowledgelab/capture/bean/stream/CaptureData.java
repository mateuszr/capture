package atos.knowledgelab.capture.bean.stream;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.NONE)
public class CaptureData {
		
	@XmlTransient
	private String dataID;
	
	@XmlTransient	
	private List<DataPool> dataPools = new ArrayList<DataPool>();	
	
	public List <? extends DataSource> getDataSources(){
		throw new RuntimeException("WARNING: CaptureData is only instantiable due to datanucleus requirements. Every time you extend this class you MUST override this method");
	}
			
	@XmlElementWrapper(name="dataPools")
	@XmlElements({
	     @XmlElement(name="poolID", type=DataPool.class)	     
	})
	public List<DataPool> getDataPools() {
		return dataPools;
	}

	public void setDataPools(List<DataPool> dataPools) {
		this.dataPools = dataPools;
	}

	@XmlElement(name="dataID")
	public String getDataID() {
		return dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}		
}
