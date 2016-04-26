package com.iTunes.backup.serviceEJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.iTunes.backup.dao.Main_DAO;
import com.iTunes.backup.dao.SysUserDAO;
import com.iTunes.backup.dao.XML_DAO;
import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.SysUser;
import com.iTunes.backup.entities.Track;


@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class ServiceEJB implements Service{
	
	@Inject
	@EJB 
	private SysUserDAO dao;
	@Inject
	@EJB 
	private XML_DAO xmlDao;
	@Inject
	@EJB 
	private Main_DAO mainDao;

	public void setDao(SysUserDAO dao) {
		this.dao = dao;
	}
	public String addUser(SysUser user) {		
			return dao.addUser(user);
	}
	public Collection<SysUser> getUsers() {
		return dao.getAllUsers();
	}
	public String verifyUser(SysUser user) {
		return dao.verify_user(user);
	}
	@Override
	public String addTracks(List<Track> trackList) {
		return xmlDao.addTracks(trackList);
		
	}
	@Override
	public String addPlaylist(List<Playlist> playlistList) {
		return xmlDao.addPlaylist(playlistList);
	}
	@Override
	public String addPlaylist_Track_link(List<Playlist_Track_Link> playlist_track_link) {
		return xmlDao.addPlaylist_Track_link(playlist_track_link);
	}
	@Override
	public Collection<Playlist> GetPlaylists(int playlist_id) {
		// TODO Auto-generated method stub
		return mainDao.GetPlaylists(playlist_id);
	}
	@Override
	public Collection<Playlist_Track_Link> getPlaylistTrackLink() {
		return mainDao.getPlaylistTrackLink();
	}
	@Override
	public Collection<Track> getTrackList() {
		return mainDao.getTrackList();
	}
	@Override
	public Collection<Playlist_Track_Link> getPlaylistTracks(int id) {
		return mainDao.getPlaylistTracks(id);
	}
	@Override
	public String setPlaylistName(int id, String name) {
		// TODO Auto-generated method stub
		return mainDao.setPlaylistName(id, name);
	}
	@Override
	public String deleteTrack(int playlist_id, int track_id) {
		// TODO Auto-generated method stub
		return mainDao.deleteTrack(playlist_id, track_id);
	}
	@Override
	public String deletePlaylist(int playlist_id) {
		// TODO Auto-generated method stub
		return mainDao.deletePlaylist(playlist_id);
	}
	@Override
	public String moveTrack(int from_playlist_id, int track_id, int to_playlist_id) {
		return mainDao.moveTrack(from_playlist_id, track_id, to_playlist_id);
	}
}
