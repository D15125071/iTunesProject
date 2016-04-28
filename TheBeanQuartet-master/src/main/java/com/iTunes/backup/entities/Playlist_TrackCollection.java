package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Playlist_TrackCollection implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Playlist_Track_Link> wrapper;
	
	public Collection<Playlist_Track_Link> getCollection() {
		return wrapper;
	}
	public void setCollection(Collection<Playlist_Track_Link> tracks) {
		this.wrapper = tracks;
	}
}
