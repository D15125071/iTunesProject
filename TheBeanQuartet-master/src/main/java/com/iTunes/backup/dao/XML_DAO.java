package com.iTunes.backup.dao;


import java.util.List;
import javax.ejb.Local;

import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.Track;



@Local
public interface XML_DAO {

	String addTracks(List<Track> trackList);

	String addPlaylist(List<Playlist> playlistList);

	String addPlaylist_Track_link(List<Playlist_Track_Link> playlist_track_link);
}
