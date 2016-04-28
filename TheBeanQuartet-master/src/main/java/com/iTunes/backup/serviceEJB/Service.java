package com.iTunes.backup.serviceEJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.iTunes.backup.entities.Library;
import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.SysUser;
import com.iTunes.backup.entities.Track;



@Local
public interface Service {

	public Collection<SysUser> getUsers();

	public String addUser(SysUser user);

	public String verifyUser(SysUser user);

	public String addTracks(List<Track> trackList);

	public String addPlaylist(List<Playlist> playlistList);

	public String addPlaylist_Track_link(List<Playlist_Track_Link> playlist_track_link);

	public Collection<Playlist> GetPlaylists(String user_username);

	public Collection<Playlist_Track_Link> getPlaylistTrackLink();

	public Collection<Track> getTrackList();

	public Collection<Playlist_Track_Link> getPlaylistTracks(int id, String user_name);

	public String setPlaylistName(int id, int playlist_id, String name);

	public String deleteTrack(int user_id, int playlist_id, int track_id);

	public String deletePlaylist(int user_id, int playlist_id);

	public String moveTrack(int from_playlist_id, int track_id, int to_playlist_id, int to_playlist_id2);

	public void addLibrary(Library lib);

	public int getUserId(String user_name);

}
