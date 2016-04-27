package com.iTunes.backup.dao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.iTunes.backup.entities.Library;
import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.Track;



//@Default
@Stateless
@Local
//@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class Main_JPA implements Main_DAO{
	
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Collection<Playlist> GetPlaylists(int playlist_id) {
		Query query = em.createQuery("from Playlist");
		List<Playlist> data = query.getResultList();
		System.out.println("number of rows acquired: "+data.size());
		return data;
	}

	@Override
	public Collection<Playlist_Track_Link> getPlaylistTrackLink() {
		Query query = em.createQuery("from Playlist_Track_Link");
		List<Playlist_Track_Link> data = query.getResultList();
		System.out.println("number of rows acquired: "+data.size());
		return data;
	}

	@Override
	public Collection<Track> getTrackList() {
		Query query = em.createQuery("from Track");
		List<Track> data = query.getResultList();
		System.out.println("number of rows acquired: "+data.size());
		return data;
	}

	@Override
	public Collection<Playlist_Track_Link> getPlaylistTracks(int id) {
		Query query = em.createQuery("select d.track from Playlist_Track_Link d where d.playlist_id = :id");
		query.setParameter("id", id);
		//Query query = em.createQuery("from Playlist_Track_Link");
		List<Playlist_Track_Link> data = query.getResultList();
		System.out.println("number of rows acquired: "+data.size());
		return data;
	}

	@Override
	public String setPlaylistName(int id, String name) {
		Query query = em.createQuery("update Playlist_Track_Link set playlist.playlist_name = :name where playlist_id = :id");
		query.setParameter("name", name);
		query.setParameter("id", id);
		Playlist playlist = em.find(Playlist.class, id);
		playlist.setPlaylist_name(name); 
		em.merge(playlist); 
		return "Name Changed";
	}

	@Override
	public String deleteTrack(int playlist_id, int track_id) {
		String id = track_id +""+playlist_id+"";
		Playlist_Track_Link p = em.find(Playlist_Track_Link.class, id); 
		em.remove(p); 
		return "Track Deleted";
	}

	@Override
	public String deletePlaylist(int playlist_id) {
		Playlist p = em.find(Playlist.class, playlist_id); 
		em.remove(p);
		return "Playlist Deleted";
	}

	@Override
	public String moveTrack(int from_playlist_id, int track_id, int to_playlist_id) {
		//remove playList track link
		String id = track_id +""+from_playlist_id+"";
		Playlist_Track_Link pt = em.find(Playlist_Track_Link.class, id); 
		em.remove(pt); 
		
		//create new playList track link
		Playlist p = em.find(Playlist.class, to_playlist_id);
		Track t = em.find(Track.class, track_id);
		Playlist_Track_Link playlist_track = new Playlist_Track_Link(p,t);
		em.persist(playlist_track);
		
		return "Track moved";
	}

	@Override
	public void addLibrary(Library lib) {
		em.persist(lib);
	}


}
