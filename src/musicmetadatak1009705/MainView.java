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
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Displays the main window and hold all nodes
 *
 * @author Scorchgid
 */
public final class MainView extends Application implements EventHandler<ActionEvent> {

    Stage mainWindow;
    Scene scene;
    MusicDataModel musicDataModel;
    MusicDataView musicDataView;
    FolderTreeView folderTreeView;
    FileTreeView fileTreeView;

    public Stage getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public boolean MainView() {
        try {
            start(mainWindow);
        } catch (Exception ex) {
            System.err.println("Main View Exeception\r\n" + ex.toString());
            return false;
        }
        return true;
    }

    private Scene mainView() {
        try {
            /* File Tree */
            this.fileTreeView = new FileTreeView();

            /* Folder Tree */
            folderTreeView = new FolderTreeView(fileTreeView);
            
            /* Music Metadata Pane */
            musicDataModel = new MusicDataModel("D:\\K3NoteBackup\\SD Card\\Music\\Singers\\The Arka Teks\\Evolver\\02  Mr. Jekyl Hyde.mp3");

            /// This line is causing the exception. Are the objects working together with each other as they should.
            musicDataView = new MusicDataView(musicDataModel, this);

            GridPane grid = new GridPane();
            grid.setHgap(8);
            grid.setVgap(8);
            grid.setPadding(new Insets(6));
            
            grid.addColumn(0, folderTreeView.treeStack());
            grid.addColumn(1, fileTreeView.listStack("D:\\K3NoteBackup\\SD Card\\Music\\Singers\\The Arka Teks\\Evolver\\"));
            grid.addColumn(2, musicDataView.grid());

            Platform.runLater(() -> {
                fileTreeView.getListView().refresh();
            });
            
            Scene sceneMainView = new Scene(grid);
            return sceneMainView;
        } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
            System.err.println("Excepion\r\n " + ex.toString());
        }
        return null;
    }

    /**
     * Set up and start the main GUI Window
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setScene(mainView());
        mainWindow.setMinHeight(550);
        mainWindow.setMinWidth(830);
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
     }*/
     

    @Override
    public void handle(ActionEvent event) {
        
    }
}
