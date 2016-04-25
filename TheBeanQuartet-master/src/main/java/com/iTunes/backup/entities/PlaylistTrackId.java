package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlaylistTrackId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Column(name="playlist_id")Integer playlist_id; 
	@Column(name="track_id")Integer track_id;
	public Integer getPlaylist_id() {
		return playlist_id;
	}
	public void setPlaylist_id(Integer playlist_id) {
		this.playlist_id = playlist_id;
	}
	public Integer getTrack_id() {
		return track_id;
	}
	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
	} 

	@Override
	public int hashCode() {
		return Objects.hashCode(playlist_id+track_id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PlaylistTrackId))
			return false;
		PlaylistTrackId other = (PlaylistTrackId)obj;
		return (other.playlist_id.equals(this.playlist_id) 
				&& other.track_id.equals(this.track_id));
	}
	
}
