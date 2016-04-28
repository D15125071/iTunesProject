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
import com.iTunes.backup.entities.SysUser;
import com.iTunes.backup.entities.Track;



//@Default
@Stateless
@Local
//@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class Main_JPA implements Main_DAO{
	
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Collection<Playlist> GetPlaylists(String user_name) {
		Query query = em.createQuery("from Playlist d where d.user_name = :name");
		query.setParameter("name", user_name);
		//Query query = em.createQuery("from Playlist_Track_Link");
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
	public Collection<Playlist_Track_Link> getPlaylistTracks(int id,String user_name) {
		Query query = em.createQuery("select d.track from Playlist_Track_Link d where d.playlist_id = :id "
				+ "and d.user_name = :name");
		query.setParameter("id", id);
		query.setParameter("name", user_name);
		//Query query = em.createQuery("from Playlist_Track_Link");
		List<Playlist_Track_Link> data = query.getResultList();
		System.out.println("number of rows acquired: "+data.size());
		return data;
	}

	@Override
	public String setPlaylistName(int user_id,int playlist_id, String name) {
//		Query query = em.createQuery("update Playlist_Track_Link set playlist.playlist_name = :name "
//				+ "where playlist_id = :id"
//				+ "and user_id = :u_id");
//		query.setParameter("name", name);
//		query.setParameter("id", id);
//		query.setParameter("u_id", user_id);
		String id = user_id+""+playlist_id;
		
		Playlist playlist = em.find(Playlist.class, id);
		playlist.setPlaylist_name(name); 
		em.merge(playlist); 
		return "Name Changed";
	}

	@Override
	public String deleteTrack(int user_id, int playlist_id, int track_id) {
		String id = user_id +""+track_id +""+playlist_id+"";
		Playlist_Track_Link p = em.find(Playlist_Track_Link.class, id); 
		em.remove(p); 
		return "Track Deleted";
	}

	@Override
	public String deletePlaylist(int user_id,int playlist_id) {
		String id = user_id+""+playlist_id;
		System.out.println(id);
		Playlist p = em.find(Playlist.class, id); 
		System.out.println(p.getPlaylist_name());
		em.remove(p);
		return "Playlist Deleted";
	}

	@Override
	public String moveTrack(int user_id, int from_playlist_id, int track_id, int to_playlist_id) {
	

		//remove playList track link
		String id = user_id+""+track_id +""+from_playlist_id+"";
		Playlist_Track_Link pt = em.find(Playlist_Track_Link.class, id); 
		em.remove(pt); 
		
		//create new playList track link
		Playlist p = em.find(Playlist.class, user_id+""+to_playlist_id);
		Track t = em.find(Track.class, user_id+""+track_id);
		SysUser u = em.find(SysUser.class, user_id);
		Playlist_Track_Link playlist_track = new Playlist_Track_Link(user_id,u.getUser_name(),p,t);
		em.persist(playlist_track);
	
		return "Track moved";
	}
	

	@Override
	public void addLibrary(Library lib) {
		em.persist(lib);
	}

	@Override
	public int getUserId(String user_name) {
		Query query = em.createQuery("select s.user_id from SysUser s where s.user_name = :name");
		query.setParameter("name", user_name);
		List<Integer> users =  query.getResultList();
		System.out.println("user id acquired from db: "+users.get(0));
		int id = users.get(0);
		//System.out.println("user id found: "+id);
		return id;
	}


}
