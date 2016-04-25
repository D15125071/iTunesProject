package com.iTunes.backup.parse.playlist;


import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Element;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dict")
public class Playlist_plist_dict_array_dict {
	
	
	
	@XmlAnyElement
	private List<Element> others;
	
	@XmlElement(name = "array", type = Playlist_plist_dict_array_dict_array.class)
	private Playlist_plist_dict_array_dict_array array = new Playlist_plist_dict_array_dict_array();

	public List<Element> getOthers() {
		return others;
	}

	public void setOthers(List<Element> others) {
		this.others = others;
	}

	public Playlist_plist_dict_array_dict_array getArray() {
		return array;
	}

	public void setArray(Playlist_plist_dict_array_dict_array array) {
		this.array = array;
	}
	
	
	
	
	
}
