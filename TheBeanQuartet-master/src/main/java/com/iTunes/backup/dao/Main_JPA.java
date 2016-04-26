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

//		Query query2 = em.createQuery("select d.playlist from Playlist_Track_Link d where d.playlist_id = :id");
//		query2.setParameter("id", id);
//		List<Playlist> data = query2.getResultList();
//		System.out.println("Playlist Name: "+data.get(0).getPlaylist_name());
		
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
		/*
		Query query = em.createQuery(""
				+ "delete from Playlist_Track_Link p "
				+ "where p.playlist_id = :p_id "
				+ "AND p.track_id = :t_id");
		query.setParameter("p_id", playlist_id);
		query.setParameter("t_id", track_id);
		*/
		
		return "Track Deleted";
		


	}

	@Override
	public String deletePlaylist(int playlist_id) {
		/*
		System.out.println("time: 14.115252332323323");
		Playlist p = em.find(Playlist.class, playlist_id);
		System.out.println(p.getPlaylist_name());
		em.remove(p);
		*/

		
		Playlist p = em.find(Playlist.class, playlist_id); 
		em.remove(p);
		
		return "Playlist Deleted";
	}


}
