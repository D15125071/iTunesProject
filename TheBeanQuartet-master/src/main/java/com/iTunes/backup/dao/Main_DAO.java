package com.iTunes.backup.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.iTunes.backup.entities.Library;
import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.Track;




@Local
public interface Main_DAO {

	Collection<Playlist> GetPlaylists(String user_name);

	Collection<Playlist_Track_Link> getPlaylistTrackLink();

	Collection<Track> getTrackList();

	Collection<Playlist_Track_Link> getPlaylistTracks(int id, String user_name);

	String setPlaylistName(int id, int id2, String name);

	String deleteTrack(int user_id, int playlist_id, int track_id);

	String deletePlaylist(int user_name, int playlist_id);

	String moveTrack(int from_playlist_id, int track_id, int to_playlist_id, int to_playlist_id2);

	void addLibrary(Library lib);

	int getUserId(String user_name);
}
