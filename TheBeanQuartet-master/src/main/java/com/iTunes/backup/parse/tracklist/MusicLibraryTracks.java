package com.iTunes.backup.parse.tracklist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//path = /plist

//full path = /plist/Root_dict/Tracks/Track/Key


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "plist")
public class MusicLibraryTracks {

	
	/*Contains the Directory that contains the tracks and playlist*/
	@XmlElement(name = "dict", type = Tracks_dict.class)
	private Tracks_dict root = new Tracks_dict();

	
	public Tracks_dict getTracksPlaylist() {
		return root;
	}

	public void setTracksPlaylist(Tracks_dict root) {
		this.root = root;
	}
	
}
