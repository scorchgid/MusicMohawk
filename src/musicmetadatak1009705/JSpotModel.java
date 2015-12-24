/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;


import com.google.code.jspot.*;
import java.io.IOException;

/**
 *
 * @author Scorchgid
 */
public class JSpotModel {

    
    public JSpotModel(MusicDataModel model) throws IOException {
        Spotify spotify = new Spotify();
        spotify.searchAlbum(model.getAlbum());
        
        
        
//Album = new Album();
    }
    
    
    
}
