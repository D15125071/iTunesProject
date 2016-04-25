package com.iTunes.backup.parse.playlist;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//path = /plist/dict/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dict")
public class Playlist_plist_dict {

	@XmlElement(name = "array", type = Playlist_plist_dict_array.class)
	private Playlist_plist_dict_array array = new Playlist_plist_dict_array();

	public Playlist_plist_dict_array getArray() {
		return array;
	}

	public void setArray(Playlist_plist_dict_array array) {
		this.array = array;
	}



}
