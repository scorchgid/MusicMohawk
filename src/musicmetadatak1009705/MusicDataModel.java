/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 The following websites were used for this class
 http://www.stackoverflow.com/questions/2980509/enumerate-external-drives

 */
package musicmetadatak1009705;

import java.io.IOException;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scorchgid
 */
public class MusicDataModel {

//I want to bind whatever is on this side to FXMusicDataPane, it changes when I add shit
    //so where are the properties going again
    Mp3File mp3file;
    private String mP3FileName, track, title, artist, album, year, genre, comment;
    private long length;

    public String getmP3FileName() {
        return mP3FileName;
    }

    public void setmP3FileName(String mP3FileName) {
        this.mP3FileName = mP3FileName;
    }

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

    public MusicDataModel() {
    }

    /**
     * Note that this class has code mostly taken from
     * https://github.com/mpatric/mp3agic-examples/blob/master/src/main/java/com/mpatric/mp3agic/example/Example.java
     * Note on IDTags, V1 is used as the information contained in 2 doesn't
     * really do much.
     *
     * @param fileName
     * @throws UnsupportedTagException
     * @throws InvalidDataException
     * @throws IOException
     * @throws NotSupportedException
     */
    public MusicDataModel(String fileName) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
        load(fileName);
    }

    public final void load(String fileName) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
        System.out.println("Load 1");
        mp3file = new Mp3File(fileName);
        mP3FileName = fileName;

        if (mp3file.hasId3v2Tag()) {
            System.out.println("Load 2 ID3v2Tag");
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            track = id3v2Tag.getTrack();
            title = id3v2Tag.getTitle();
            artist = id3v2Tag.getArtist();
            length = mp3file.getLength();
            album = id3v2Tag.getAlbum();
            year = id3v2Tag.getYear();
            genre = id3v2Tag.getGenreDescription();
            comment = id3v2Tag.getComment();
            System.out.println("Load 2 ID3v2Tag END");
            /*Fail safe*/
        } else if (mp3file.hasId3v1Tag()) {
            System.out.println("Load 2 IDv31Tag");
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            track = id3v1Tag.getTrack();
            title = id3v1Tag.getTitle();
            artist = id3v1Tag.getArtist();
            length = mp3file.getLength();
            album = id3v1Tag.getAlbum();
            year = id3v1Tag.getYear();
            genre = id3v1Tag.getGenreDescription();
            comment = id3v1Tag.getComment();
            System.out.println("Load 2 ID3v1Tag END");
        } else {
            System.err.println("Error: file did not contain a valid ID3V#Tag");
        }
    }

    /**
     * Saves the MP3 File
     *
     * @return False if file failed to save
     */
    public void MP3SaveFile() {
        try {
            System.out.println("Attemping Save");
            mp3file.save(mP3FileName);
            System.out.println("Save complete " + mp3file.getFilename());
        } catch (IOException | NotSupportedException ex) {
            Logger.getLogger(MusicDataModel.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Save Failed");
            //return false;
        }
        //return true;
    }
}
