package com.iTunes.backup.parse.utilities;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.iTunes.backup.parse.playlist.Playlist_plist;
import com.iTunes.backup.parse.tracklist.MusicLibraryTracks;


public class JAXBXMLHandler {

	// Import
	public static MusicLibraryTracks unmarshalTracks(File importFile) throws JAXBException, SAXException, FileNotFoundException {
		MusicLibraryTracks mainRoot = new MusicLibraryTracks();

		JAXBContext context = JAXBContext.newInstance(MusicLibraryTracks.class);
		Unmarshaller um = context.createUnmarshaller();
		XMLReader xmlreader = XMLReaderFactory.createXMLReader();
		InputSource input = new InputSource(new FileReader(importFile));
		Source source = new SAXSource(xmlreader, input);
		mainRoot = (MusicLibraryTracks) um.unmarshal(source);

		return mainRoot;
	}
	public static Playlist_plist unmarshalPlaylist(File importFile) throws JAXBException, SAXException, FileNotFoundException {
		Playlist_plist mainRoot = new Playlist_plist();

		JAXBContext context = JAXBContext.newInstance(Playlist_plist.class);
		Unmarshaller um = context.createUnmarshaller();
		XMLReader xmlreader = XMLReaderFactory.createXMLReader();
		InputSource input = new InputSource(new FileReader(importFile));
		Source source = new SAXSource(xmlreader, input);
		mainRoot = (Playlist_plist) um.unmarshal(source);

		return mainRoot;
	}
}

/*
JAXBContext context = JAXBContext.newInstance(MusicLibrary.class);
Unmarshaller um = context.createUnmarshaller();
XMLReader xmlreader = XMLReaderFactory.createXMLReader();
InputSource input = new InputSource(new FileReader(importFile));
Source source = new SAXSource(xmlreader, input);
mainRoot = (MusicLibrary) um.unmarshal(source);
*/