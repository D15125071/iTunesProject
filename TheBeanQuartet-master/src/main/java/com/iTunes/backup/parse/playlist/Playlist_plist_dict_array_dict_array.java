package com.iTunes.backup.parse.playlist;


import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Element;

//path = /plist/dict/dict/dict
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "array")
public class Playlist_plist_dict_array_dict_array {
	
	
	
	@XmlAnyElement
	private List<Element> others;
	
	@XmlElement(name = "dict", type = Playlist_plist_dict_array_dict_array_dict.class)
	private List<Playlist_plist_dict_array_dict_array_dict> dicts = new ArrayList<Playlist_plist_dict_array_dict_array_dict>();

	public List<Playlist_plist_dict_array_dict_array_dict> getDicts() {
		return dicts;
	}

	public void setDicts(List<Playlist_plist_dict_array_dict_array_dict> dicts) {
		this.dicts = dicts;
	}
	
	
	
	
	
}
