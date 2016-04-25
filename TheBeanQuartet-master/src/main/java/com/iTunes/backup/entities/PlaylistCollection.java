package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaylistCollection implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Playlist> wrapper;
	
	public Collection<Playlist> getPlaylistCollection() {
		return wrapper;
	}
	
	public void setPlaylistCollection(Collection<Playlist> playlists) {
		this.wrapper = playlists;
	}
}
