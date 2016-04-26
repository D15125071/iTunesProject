package com.iTunes.backup.rs;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.iTunes.backup.entities.Options;
import com.iTunes.backup.entities.Playlist;
import com.iTunes.backup.entities.Playlist_Track_Link;
import com.iTunes.backup.entities.Track;
import com.iTunes.backup.parse.playlist.Playlist_plist;
import com.iTunes.backup.parse.tracklist.MusicLibraryTracks;
import com.iTunes.backup.parse.utilities.JAXBXMLHandler;
import com.iTunes.backup.serviceEJB.Service;




@Path("/upload")
public class XmlParseRestService {

	@Inject
	private Service service;
	
	
	List<Playlist> playlistList = new ArrayList<Playlist>();
	List<Track> trackList = new ArrayList<Track>();
	List<Playlist_Track_Link> playlist_track_link = new ArrayList<Playlist_Track_Link>();
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/xml")
	public String parseXML(Options opt){
		System.out.println(opt.getOption1());
		System.out.println(opt.getOption2());
		System.out.println("**************** parsing xml");
		System.out.println("Try version 1: time: 13.15");
		
		String filePath = opt.getOption1();
		
		try {
			compileXMLtoTrackList(filePath);
			compileXMLtoPlaylist(filePath);
		} catch (FileNotFoundException | SAXException e) {
			e.printStackTrace();
		}
		Create_Playlist_Track_Link();
		
		
		return "xml parse complete";
	}
	public void compileXMLtoTrackList(String filePath) throws FileNotFoundException, SAXException{

		MusicLibraryTracks tracks = new MusicLibraryTracks();
		
		
		try {
			tracks = JAXBXMLHandler.unmarshalTracks(new File("C:/Users/Ivan/Desktop/iTunes_Music_Library3.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		int numberTracks = tracks.getTracksPlaylist().getRoot().getTrackList().size();
		System.out.println("number of tracks: "+numberTracks);

		for(int i=0; i<numberTracks; i++){
			
			int numberTrackElements = tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().size();

			Track newTrack = new Track();
			newTrack.setTrack_name("unknown");
			newTrack.setTrack_artist("unknown");
			newTrack.setTrack_album("unknown");
			for(int x=0; x<numberTrackElements; x++){
				if(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x).getTextContent().equals("Track ID")){
					newTrack.setTrack_id(Integer.parseInt(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x+1).getTextContent()));
				}
				if(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x).getTextContent().equals("Name")){
					newTrack.setTrack_name(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x+1).getTextContent());
				}
				if(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x).getTextContent().equals("Artist")){
					newTrack.setTrack_artist(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x+1).getTextContent());
				}
				if(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x).getTextContent().equals("Album")){
					newTrack.setTrack_album(tracks.getTracksPlaylist().getRoot().getTrackList().get(i).getOthers().get(x+1).getTextContent());
				}
			}
			trackList.add(newTrack);
		}
		System.out.println(service.addTracks(trackList));
	}	
	
	public void compileXMLtoPlaylist(String filePath) throws FileNotFoundException, SAXException{

		Playlist_plist playlists = new Playlist_plist();
		
		try {
			playlists = JAXBXMLHandler.unmarshalPlaylist(new File("C:/Users/Ivan/Desktop/iTunes_Music_Library3.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		int numberPlaylist = playlists.getRoot().getArray().getDicts().size();
		System.out.println("number of playlists: "+numberPlaylist);
		
		for(int i=0; i<numberPlaylist; i++){
			Playlist newPlaylist = new Playlist();
			newPlaylist.setPlaylist_name("unknown");
			
			int numberOtherElements = playlists.getRoot().getArray().getDicts().get(i).getOthers().size();
			for(int x=0; x<numberOtherElements; x++){
				if(playlists.getRoot().getArray().getDicts().get(i).getOthers().get(x).getTextContent().equals("Playlist ID")){
					newPlaylist.setPlaylist_id(Integer.parseInt(playlists.getRoot().getArray().getDicts().get(i).getOthers().get(x+1).getTextContent()));
				}
				if(playlists.getRoot().getArray().getDicts().get(i).getOthers().get(x).getTextContent().equals("Name")){
					newPlaylist.setPlaylist_name(playlists.getRoot().getArray().getDicts().get(i).getOthers().get(x+1).getTextContent());
				}
			}
			int numberTracks = playlists.getRoot().getArray().getDicts().get(i).getArray().getDicts().size();
			for(int x=0; x<numberTracks; x++){
				if(!newPlaylist.getTrack_id_list().contains(Integer.parseInt(playlists.getRoot().getArray().getDicts().get(i).getArray().getDicts().get(x).getOthers().get(1).getTextContent())))
					newPlaylist.getTrack_id_list().add(Integer.parseInt(playlists.getRoot().getArray().getDicts().get(i).getArray().getDicts().get(x).getOthers().get(1).getTextContent()));
			
			}
			playlistList.add(newPlaylist);
		}
		System.out.println(service.addPlaylist(playlistList));
	}
	public void Create_Playlist_Track_Link(){
		
		Playlist_Track_Link playlist_track;
		
		System.out.println("All tracks....");
		for(int x=0; x < trackList.size(); x++){
			System.out.println(trackList.get(x).getTrack_id());
		}
		
		for(int i=0; i < playlistList.size(); i++){
			System.out.println("**********************"+i);
			System.out.println("Playlist id: "+playlistList.get(i).getPlaylist_id());
			int numberTracks = playlistList.get(i).getTrack_id_list().size();
			for(int y=0; y<numberTracks; y++){
				
				System.out.println("    track id: "+playlistList.get(i).getTrack_id_list().get(y));
				for(int x=0; x < trackList.size(); x++){

					if(trackList.get(x).getTrack_id().equals(playlistList.get(i).getTrack_id_list().get(y))){
						playlist_track = new Playlist_Track_Link(playlistList.get(i),trackList.get(x));
						playlist_track_link.add(playlist_track);
						System.out.println("added track id: "+trackList.get(x).getTrack_id());
					}
				}
			}
		}
		System.out.println(service.addPlaylist_Track_link(playlist_track_link));
	}
	
	
		

}
	
	

