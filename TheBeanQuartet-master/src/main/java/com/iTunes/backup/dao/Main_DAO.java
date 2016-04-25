package com.iTunes.backup.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.Track;




@Local
public interface Main_DAO {

	Collection<Playlist> GetPlaylists(int playlist_id);

	Collection<Playlist_Track_Link> getPlaylistTrackLink();

	Collection<Track> getTrackList();

	Collection<Playlist_Track_Link> getPlaylistTracks(int id);

	String setPlaylistName(int id, String name);

	String deleteTrack(int playlist_id, int track_id);

	String deletePlaylist(int playlist_id);
}
