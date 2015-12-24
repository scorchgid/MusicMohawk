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
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Scorchgid
 */
public class Main  {

    //Stage mainWindow;
    //Scene scene;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (!alphaFX(args)) {
            OmegaConsole.omegaConsole();
        }
    }

    public static boolean alphaFX(String[] args) {
        try {
            MainView.launch();
        } catch (Exception e) {
            System.err.println("GUI Failed Switching to command line\n"
                    + e.toString());
            return false;
        }
        return true;
    }
/*
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(5));
    }

*/
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
