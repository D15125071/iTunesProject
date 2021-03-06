package com.iTunes.backup.rs;


import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.iTunes.backup.entities.Options;
import com.iTunes.backup.entities.PlaylistCollection;
import com.iTunes.backup.entities.Playlist_TrackCollection;
import com.iTunes.backup.entities.SysUser;
import com.iTunes.backup.entities.SysUserList;
import com.iTunes.backup.entities.TrackCollection;
import com.iTunes.backup.serviceEJB.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;



@Path("/lib")
public class MainRestService {

	@Inject
	private Service service;
	
	/////////////////////////////////////////////////////////////////////// User Services
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/get/users")
    public SysUserList getUsers(){ 
		System.out.println("GET Request");
		SysUserList users = new SysUserList();
		users.setSysUserCollection(service.getUsers());
        return users;
    }
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/user/verify")
	public String verifyUser(SysUser user){
		System.out.println("**************** verfiying User");
		return service.verifyUser(user);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/user/register")
	public String addUser(SysUser user){
		System.out.println("**************** registering User");
		
		String username = user.getUser_name();
		String userpassword = user.getUser_password();
		String rule="";
		
		rule=verifyUsernameRule(username);
		if(!rule.equals("valid")){
			return rule;
		}
		rule=verifyPasswordRule(userpassword);
		if(!rule.equals("valid")){
			return rule;
		}
		return service.addUser(user);
	}
	private String verifyUsernameRule(String name){
		if(name.isEmpty()){
			return "No username entered";
		}
		if(containSpecialCharacter(name)){
			return "Special Characters not allowed";
		}
		if(name.length()<4){
			return "Username must be greater than 3 characters";
		}
		if(Character.isDigit(name.charAt(0))){
			return "Username must not start with a number";
		}
		return "valid";
	}

	private boolean containSpecialCharacter(String name) {
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(name);

		boolean b = m.find();
		if (b == true)
			return true;
		else
			return false;
	}
	private String verifyPasswordRule(String pwd){
		if(pwd.isEmpty()){
			return "No username entered";
		}
		if(containSpecialCharacter(pwd)){
			return "Special Characters not allowed";
		}
		if(pwd.length()<4){
			return "Password must be greater than 3 characters";
		}
		return "valid";
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/playlist/tracks")
	public Playlist_TrackCollection GetPlaylistTracks(Options opt){
		int id = Integer.parseInt(opt.getOption1());
		String user_name = opt.getOption2();
		Playlist_TrackCollection data = new Playlist_TrackCollection();
		data.setCollection(service.getPlaylistTracks(id,user_name));
		return data;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/playlist/list")
	public PlaylistCollection GetPlaylistList(Options opt){
		String user_name = opt.getOption1();//
		PlaylistCollection playlists = new PlaylistCollection();
		playlists.setPlaylistCollection(service.GetPlaylists(user_name));
		return playlists;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/track/list")
	public TrackCollection GetTrackList(){
		TrackCollection data = new TrackCollection();
		data.setTrackCollection(service.getTrackList());
		return data;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/playlist_track_link/list")
	public Playlist_TrackCollection GetPlaylist_Track_Link(Options opt){
		Playlist_TrackCollection data = new Playlist_TrackCollection();
		data.setCollection(service.getPlaylistTrackLink());
		return data;
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/playlist/rename")
	public String setPlaylistName(Options opt){
		String name = opt.getOption2();
		int playlist_id = Integer.parseInt(opt.getOption1());
		String user_name = opt.getOption3();
		int user_id = service.getUserId(user_name);
		return service.setPlaylistName(user_id,playlist_id, name);
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/track/delete")
	public String deleteTrack(Options opt){
		int track_id = Integer.parseInt(opt.getOption2());
		int playlist_id = Integer.parseInt(opt.getOption1());
		String user_name = opt.getOption3();
		int user_id = service.getUserId(user_name);
		System.out.println("track_id: "+track_id+" "+"playlist_id: "+playlist_id);
		return service.deleteTrack(user_id, playlist_id, track_id);
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/playlist/delete")
	public String deletePlaylist(Options opt){
		System.out.println("deleting playlist");
		int playlist_id = Integer.parseInt(opt.getOption1());
		String user_name = opt.getOption2();
		int user_id = service.getUserId(user_name);
		System.out.println("user_name: "+user_name);
		System.out.println("user_id: "+user_id);
		System.out.println("playlist_id: "+playlist_id);
		return service.deletePlaylist(user_id, playlist_id);
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/track/move")
	public String moveTrack(Options opt){
		int from_playlist_id = Integer.parseInt(opt.getOption1());
		int track_id = Integer.parseInt(opt.getOption2());
		int to_playlist_id = Integer.parseInt(opt.getOption3());
		String user_name = opt.getOption4();
		int user_id = service.getUserId(user_name);
		return service.moveTrack(user_id,from_playlist_id, track_id, to_playlist_id);
	}
	

}
	
	

