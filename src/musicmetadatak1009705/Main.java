/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Code useage
 https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG - This tutorial was used.
 */
package musicmetadatak1009705;

import Testing.TestMain;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Scorchgid
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MainView.launch(args);
        } catch (Exception e) {
            System.err.println("GUI Failed Switching to command line\n"
                    + e.toString());
            omegaConsole();
        }
    }

    /**
     * When all else fails..
     */
    public static void omegaConsole() {
        int x = 0;
        Scanner scan = new Scanner(System.in);
        String shownline;
        System.out.println("Welcome to Media Mohawk - Ω Command Line Mode (Ω_CLM)\nThe following drive are avliable");
        File[] drives = File.listRoots();
        for (File file : drives) {
            System.out.println(file.toString());
        }
        System.out.println("Which Drive should I search? ");
        shownline = scan.nextLine();
        aVAJAVAFileMp3Scan(new File(shownline));

        while (x == 0) {
            System.out.println("Please enter the full File path of the MP3 File you wish to edit");
            shownline = scan.nextLine();
            {
                try {
                    MusicDataModel reader = new MusicDataModel(shownline);
                    System.out.println("The following is a list of metadata for this file: \n"
                            + "Track: " + reader.getTrack()
                            + "\nTitle: " + reader.getTitle()
                            + "\nLength " + reader.getLength()
                            + "\nArtist " + reader.getArtist()
                            + "\nAlbum " + reader.getAlbum()
                            + "\nGenre " + reader.getGenre()
                            + "\nYear " + reader.getYear()
                            + "\nComment " + reader.getComment()
                    );
                } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
                    System.err.println("The file you have entered could not be found, exception thrown, please run this file again.");
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public static void aVAJAVAFileMp3Scan(File dir) {
        try {
            String[] extensions = new String[]{"mp3"};
            System.out.println("Getting all .mp3 files in " + dir.getCanonicalPath()
                    + " including those in subdirectories");
            List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
            for (File file : files) {
                System.out.println("file: " + file.getCanonicalPath());
            }
        } catch (IOException ex) {
        }
    }
}
