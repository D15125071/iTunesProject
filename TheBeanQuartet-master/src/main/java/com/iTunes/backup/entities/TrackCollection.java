package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TrackCollection implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Track> wrapper;
	
	public Collection<Track> getTrackCollection() {
		return wrapper;
	}
	
	public void setTrackCollection(Collection<Track> tracks) {
		this.wrapper = tracks;
	}
}
