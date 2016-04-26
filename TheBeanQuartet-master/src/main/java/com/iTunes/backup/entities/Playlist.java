package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "playlist")
public class Playlist implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "playlist_id")
	private Integer playlist_id;
	
	@Column(name = "playlist_name")
	private String playlist_name;
	
	
	@OneToMany(mappedBy = "playlist")//attribute
	private Collection<Playlist_Track_Link> playlist_track_link = new ArrayList<Playlist_Track_Link>();
	
	
	
	
//	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//		name = "playlist_track_link", 
//		joinColumns = { 
//				@JoinColumn(name = "playlist_id", nullable = false, updatable = false) 
//		}, 
//		inverseJoinColumns = { 
//				@JoinColumn(name = "track_id", nullable = false, updatable = false) 
//		}
//	)
//	private Collection<Track> tracks= new ArrayList<Track>();
//	
	
	
	
	
	
	
	@Transient
	List<Integer> track_id_list = new ArrayList<Integer>();//might use for database, remove @Transient

	public List<Integer> getTrack_id_list() {
		return track_id_list;
	}

	public void setTrack_id_list(List<Integer> track_id_list) {
		this.track_id_list = track_id_list;
	}

	public Integer getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(Integer playlist_id) {
		this.playlist_id = playlist_id;
	}

	public String getPlaylist_name() {
		return playlist_name;
	}

	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}

	public Playlist() {}

	public Playlist(Integer playlist_id, String playlist_name) {
		this.playlist_id = playlist_id;
		this.playlist_name = playlist_name;
	}

}
