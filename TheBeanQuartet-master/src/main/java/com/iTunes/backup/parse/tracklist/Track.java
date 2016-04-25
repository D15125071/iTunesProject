package com.iTunes.backup.parse.tracklist;


import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Element;

//path = /plist/dict/dict/dict
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dict")
public class Track {
	
	
	
	@XmlAnyElement
	private List<Element> others;
	
	
	public List<Element> getOthers() {
		return others;
	}

	public void setOthers(List<Element> others) {
		this.others = others;
	}	
	
	
	
}
