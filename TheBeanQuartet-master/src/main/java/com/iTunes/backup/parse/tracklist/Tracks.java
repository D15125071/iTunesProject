package com.iTunes.backup.parse.tracklist;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//path = /plist/dict/dict
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dict")
public class Tracks {
	
	
	
	@XmlElement(name = "dict", type = Track.class)
	private List<Track> trackList = new ArrayList<Track>();

	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}
	


}