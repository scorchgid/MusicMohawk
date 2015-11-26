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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Displays the main window and hold all nodes
 *
 * @author Scorchgid
 */
public final class FXMainWindow extends Application implements EventHandler<ActionEvent> {

    Stage mainWindow;
    Scene scene;

    public FXMainWindow() {
        try {
            start(mainWindow);
        } catch (Exception ex) {
            System.err.println(ex.toString());
            //Logger.getLogger(FXMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setTitle("Music Mohawk");
        FXMusicDataPane musicDataPane = new FXMusicDataPane();
        mainWindow.setMinHeight(550);
        mainWindow.setMinWidth(530);
        mainWindow.setScene(musicDataPane.grid());
        mainWindow.show();
    }
/*
    public void Close() {
        mainWindow.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

    }
    public void closeProgram() {
        mainWindow.close();
    }
*/
    @Override
    public void handle(ActionEvent event) {
        

    }

    private void handleMP3Passing() {

        try {
            MP3Reader mp3Reader = new MP3Reader("D:\\K3NoteBackup\\SD Card\\Music\\Gaming\\Ace Attorney\\Phoenix Wright - Ace Attorney\\17 Reminiscence ~ True Evening of Grief.mp3");

            FXMusicDataPane fxMusic = new FXMusicDataPane();
        } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
            Logger.getLogger(FXMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
