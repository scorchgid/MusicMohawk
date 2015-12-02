/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;


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
public final class MainView extends Application implements EventHandler<ActionEvent> {

    Stage mainWindow;
    Scene scene;

    public MainView() {
        try {
            start(mainWindow);

        } catch (Exception ex) {
            System.err.println(ex.toString());
            //Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    MusicDataModel musicDataModel;
    MusicDataView musicDataView;

    /**
     * Set up and start the main GUI Window
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /* Main window setup */
        mainWindow = primaryStage;
        

        /* Music Metadata Pane */
        
        musicDataModel = new MusicDataModel("D:\\K3NoteBackup\\SD Card\\Music\\Singers\\The Arka Teks\\Evolver\\02  Mr. Jekyl Hyde.mp3");
        
        
        
        /// This line is causing the exception. Are the objects working together with each other as they should.
        musicDataView = new MusicDataView(musicDataModel, this);
        mainWindow.setScene(musicDataView.grid());
        mainWindow.setMinHeight(550);
        mainWindow.setMinWidth(530);

        /* Other Panes/ */
        /* Launch */
        mainWindow.setTitle("Music Mohawk");
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
}
