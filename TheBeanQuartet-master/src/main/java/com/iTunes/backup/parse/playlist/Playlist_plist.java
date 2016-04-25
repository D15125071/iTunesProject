package com.iTunes.backup.parse.playlist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//path = /plist

//full path = /plist/dict/array/dict/Key

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "plist")
public class Playlist_plist {

	@XmlElement(name = "dict", type = Playlist_plist_dict.class)
	private Playlist_plist_dict root = new Playlist_plist_dict();

	public Playlist_plist_dict getRoot() {
		return root;
	}

	public void setRoot(Playlist_plist_dict root) {
		this.root = root;
	}

	// lib.getRoot().getPlaylist_folder.getPlaylists().get(0)....
	
	//plist/dict/array/dict/key
	
}
