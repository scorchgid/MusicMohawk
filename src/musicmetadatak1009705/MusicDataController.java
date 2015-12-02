/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;

/**
 * Designed to control the FXMain window
 * http://www.tutorialspoint.com/design_pattern/mvc_pattern.htm
 *
 * @author Scorchgid
 */
public class MusicDataController {

    private MusicDataModel musicData;
    private MusicDataView musicView;
    String dummyFile = "D:\\K3NoteBackup\\SD Card\\Music\\Gaming\\Ace Attorney\\Phoenix Wright - Ace Attorney\\17 Reminiscence ~ True Evening of Grief.mp3";

    public MusicDataController(MusicDataModel musicData, MusicDataView musicView) throws NotSupportedException, UnsupportedTagException, InvalidDataException, IOException {

        //this.musicData = new MusicDataModel(dummyFile);
        this.musicData = musicData;
        this.musicView = musicView;
        
        
        
        //StringProperty track = new SimpleStringProperty
        

    }

    public MusicDataModel getMusicData() {
        return musicData;
    }

    public void setMusicData(MusicDataModel musicData) {
        this.musicData = musicData;
    }

    public MusicDataView getMusicView() {
        return musicView;
    }

    public void setMusicView(MusicDataView musicView) {
        this.musicView = musicView;
    }
    
}

/*
    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




Listners need to go here
 Questions?
 Should we create an object of mp3 player here
        
 Do we link our two classes together here
        
 What state are we currently at
        
 */
