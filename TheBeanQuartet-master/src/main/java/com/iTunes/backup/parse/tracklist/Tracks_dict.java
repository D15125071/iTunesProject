package com.iTunes.backup.parse.tracklist;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//path = /plist/dict/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dict")
public class Tracks_dict {
	
	
	/*Object that contains the tracks*/
	@XmlElement(name = "dict", type = Tracks.class)
	private Tracks root = new Tracks();

	public Tracks getRoot() {
		return root;
	}

	public void setRoot(Tracks root) {
		this.root = root;
	}


	
	//@XmlElement(name = "array", type = PlayList.class)
	//private List<Playlist> books = new ArrayList<Book>();

}
