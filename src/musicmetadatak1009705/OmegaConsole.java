/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scorchgid
 */
public class OmegaConsole {

    /**
     * When all else fails..
     */
    public static void omegaConsole() {
        int x = 0;
        Scanner scan = new Scanner(System.in);
        String shownline;
        System.out.println("Welcome to Media Mohawk - \u03a9 Command Line Mode (\u03a9_CLM)\nThe following drive are avliable");
        File[] drives = File.listRoots();
        for (File file : drives) {
            System.out.println(file.toString());
        }
        System.out.println("Which Drive should I search? ");
        shownline = scan.nextLine();
        Main.aVAJAVAFileMp3Scan(new File(shownline));
        while (x == 0) {
            System.out.println("Please enter the full File path of the MP3 File you wish to edit");
            shownline = scan.nextLine();
            {
                try {
                    MusicDataModel reader = new MusicDataModel(shownline);
                    System.out.println("The following is a list of metadata for this file: \n" + "Track: " + reader.getTrack() + "\nTitle: " + reader.getTitle() + "\nLength " + reader.getLength() + "\nArtist " + reader.getArtist() + "\nAlbum " + reader.getAlbum() + "\nGenre " + reader.getGenre() + "\nYear " + reader.getYear() + "\nComment " + reader.getComment());
                } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
                    System.err.println("The file you have entered could not be found, exception thrown, please run this file again.");
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
