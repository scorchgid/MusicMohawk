/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
 *
 * @author Scorchgid
 */
public class FileTreeView {

    private MainView mainView;
    public ObservableList<File> observableList; //= FXCollections.observableArrayList();
    private ListView<File> listView; // = new ListView(observableList);
    // public ObservableList<File> observableList;
    //public ObservableList<String> observableList;
    //private ListView<String> listView;
    private VBox vbox;

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public FileTreeView() {
        this.observableList = FXCollections.observableArrayList();
        this.listView = new ListView(this.observableList);

    }

    public void GetFilesFromFolder(String dirName) throws IOException{
        File dir = new File(dirName);
        File[] files = dir.listFiles((File dir1, String filename) -> filename.endsWith(".mp3"));
        observableList.clear();
        observableList.addAll(files);
    }

    public void SetFileTreeView(String dirName) throws IOException {
        observableList.clear();
        //listView.setItems(null);
        File dir = new File(dirName);
        File[] files = dir.listFiles((File dir1, String filename) -> filename.endsWith(".mp3"));
        //ObservableList<File> oListStavaka = FXCollections.observableArrayList(files);
        for (File file : files) {
            System.out.println(file.toString());
        }
        //List myList = Arrays.asList(files);          
        //observableList.addAll(new ArrayList<>(Arrays.asList(files)));
        System.out.println("Obvl to string\r\n" + observableList.toString());
        //listView.setItems(observableList);
        //System.out.println(listView.getItems().toString());
        System.out.println("Refersh");
        //listView.refresh();
    }

    public void SetFileTreeView() throws IOException {
        listView.setItems(null);
        //listView.refresh();

        /*observableList = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        listView = new ListView<>(observableList);
        System.out.println("Obvl to string" + observableList.toString());
         */
        //listView.setItems(observableList);
        //System.out.println(listView.getItems().toString());

        //System.out.println("Refersh");
        //listView.refresh();

    }

    //Files.walk(Paths.get(dir)).forEach((Path filePath) -> {
    //if (Files.isRegularFile(filePath)) {
    //System.out.println(filePath);
    public VBox listStack(String dirPath) throws IOException {
        vbox = new VBox();
        vbox.getChildren().add(listView);
        //obvl.add(new File("D:\\K3NoteBackup\\SD Card\\Music\\Singers\\The Arka Teks\\Evolver\\02  Mr. Jekyl Hyde.mp3"));
        GetFilesFromFolder(dirPath);
        //listView.getItems().addAll(observableList);
        listView.setItems(observableList);
        // Path path = null;
        // File file = new File(path.toString());
        // listView.setRoot;
        return vbox;
    }
}
