package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "track")
public class Track implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "track_id")
	private Integer track_id;
	
	@Column(name = "track_name")
	private String track_name;
	


	@Column(name = "track_artist")
	private String track_artist;
	
	@Column(name = "track_album")
	private String track_album;
	
	@OneToMany(mappedBy="track")
	@JsonIgnore
	private Collection<Playlist_Track_Link> playlist = new ArrayList<Playlist_Track_Link>();

	
	public Integer getTrack_id() {
		return track_id;
	}

	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
	}

	public String getTrack_name() {
		return track_name;
	}

	public void setTrack_name(String track_name) {
		this.track_name = track_name;
	}

	public String getTrack_artist() {
		return track_artist;
	}

	public void setTrack_artist(String track_artist) {
		this.track_artist = track_artist;
	}

	public String getTrack_album() {
		return track_album;
	}

	public void setTrack_album(String track_album) {
		this.track_album = track_album;
	}

	public Track() {}

	public Track(Integer track_id, String track_album, String track_artist, String track_name) {
		this.track_id = track_id;
		this.track_album = track_album;
		this.track_artist = track_artist;
		this.track_name = track_name;
	}

}
