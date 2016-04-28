package com.iTunes.backup.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist_track_link")
public class Playlist_Track_Link implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "track_id")
	private Integer track_id;
	
	@Column(name = "playlist_id")
	private Integer playlist_id;
	
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "user_name")
	private String user_name;
	
	@ManyToOne
	@JoinColumn(name = "playlist_obj", referencedColumnName = "id")
	private Playlist playlist;

	@ManyToOne//name = java class
	@JoinColumn(name = "track_obj", referencedColumnName = "id")
	private Track track;



	public Playlist_Track_Link() {}

	public Playlist_Track_Link(int user_id,String user_name, Playlist playlist, Track track) {
		this.playlist = playlist;
		this.track = track;
		this.user_id = user_id;
		this.user_name = user_name;
		this.track_id = track.getTrack_id();
		this.playlist_id = playlist.getPlaylist_id();
		this.id = user_id+""+track.getTrack_id()+""+playlist.getPlaylist_id()+"";
	}
	

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTrack_id() {
		return track_id;
	}

	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
	}

	public Integer getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(Integer playlist_id) {
		this.playlist_id = playlist_id;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}


	
	
}
