package com.iTunes.backup.dao;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.Track;



@Default
@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class XML_JPA implements XML_DAO{
	
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public String addTracks(List<Track> trackList) {
		for(int i=0; i<trackList.size();i++){
			em.persist(trackList.get(i));
		}
		return "complete";
	}

	@Override
	public String addPlaylist(List<Playlist> playlistList) {
		for(int i=0; i<playlistList.size();i++){
			em.persist(playlistList.get(i));
		}
		return "complete";
	}

	@Override
	public String addPlaylist_Track_link(List<Playlist_Track_Link> playlist_track_link) {
		for(int i=0; i<playlist_track_link.size();i++){
			em.persist(playlist_track_link.get(i));
		}
		return "complete";
	}
}
