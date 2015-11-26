/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v24Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import org.apache.commons.io.FileUtils;

/**
 * This File is just for test scraps and can be ignored
 *
 * @author Scorchgid
 */
public class TestMain extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tests calls go here
        launch(args);
    }

    public static void testGetListOfMP3Files() {
        String[] files;
        files = getListOfMP3Files();
        for (String file : files) {
            System.out.println(file);
        }
    }

    public static String[] getListOfMP3Files() {
        //List<String> listOfFiles = new ArrayList<>();
        //1.
        File[] drives = File.listRoots();
        // C:\ D:\

        // none of this works
        // why does it fail??? it just crashes after one attempt
        // needs to run recursivly down each folder
        for (File rootDirectory : drives) {
            //recursive

            File directory = new File(rootDirectory.getPath());
            return directory.list(new FilenameFilter() {
                public boolean accept(File directory, String filename) {
                    return filename.endsWith(".mp3");
                }
            });

        }
        return null;
    }

    public static void readFromMP3FileTest() {
        try {
            readFromMP3File(new File("C:\\04. argrmwiztzihj!.mp3"));
        } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * https://github.com/mpatric/mp3agic-examples/blob/master/src/main/java/com/mpatric/mp3agic/example/Example.java
     *
     * @param mP3FileParm
     * @throws UnsupportedTagException
     * @throws InvalidDataException
     * @throws IOException
     * @throws NotSupportedException
     */
    public static void readFromMP3File(File mP3FileParm) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {

        Mp3File mp3file = new Mp3File(mP3FileParm);

        System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
        System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
        System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
        System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
        System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
        System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));

        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            System.out.println("Track: " + id3v1Tag.getTrack());
            System.out.println("Artist: " + id3v1Tag.getArtist());
            System.out.println("Title: " + id3v1Tag.getTitle());
            System.out.println("Album: " + id3v1Tag.getAlbum());
            System.out.println("Year: " + id3v1Tag.getYear());
            System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
            System.out.println("Comment: " + id3v1Tag.getComment());
        }

        ID3v1 id3v1Tag;
        if (mp3file.hasId3v1Tag()) {
            id3v1Tag = mp3file.getId3v1Tag();
        } else {
            id3v1Tag = new ID3v1Tag();
            mp3file.setId3v1Tag(id3v1Tag);
        }
        id3v1Tag.setTrack("5");
        id3v1Tag.setArtist("An Artist");
        id3v1Tag.setTitle("The Title");
        id3v1Tag.setAlbum("The Album");
        id3v1Tag.setYear("2001");
        id3v1Tag.setGenre(12);
        id3v1Tag.setComment("Some comment");
        mp3file.save("MyMp3File.mp3");

        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            System.out.println("Track: " + id3v2Tag.getTrack());
            System.out.println("Artist: " + id3v2Tag.getArtist());
            System.out.println("Title: " + id3v2Tag.getTitle());
            System.out.println("Album: " + id3v2Tag.getAlbum());
            System.out.println("Year: " + id3v2Tag.getYear());
            System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
            System.out.println("Comment: " + id3v2Tag.getComment());
            System.out.println("Composer: " + id3v2Tag.getComposer());
            System.out.println("Publisher: " + id3v2Tag.getPublisher());
            System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
            System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
            System.out.println("Copyright: " + id3v2Tag.getCopyright());
            System.out.println("URL: " + id3v2Tag.getUrl());
            System.out.println("Encoder: " + id3v2Tag.getEncoder());
        }

        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            byte[] imageData = id3v2Tag.getAlbumImage();
            if (imageData != null) {
                String mimeType = id3v2Tag.getAlbumImageMimeType();
                System.out.println("Mime type: " + mimeType);
                // Write image to file - can determine appropriate file extension from the mime type
                RandomAccessFile file = new RandomAccessFile("album-artwork", "rw");
                file.write(imageData);
                file.close();
            }
        }

        ID3v2 id3v2Tag;
        if (mp3file.hasId3v2Tag()) {
            id3v2Tag = mp3file.getId3v2Tag();
        } else {
            id3v2Tag = new ID3v24Tag();
            mp3file.setId3v2Tag(id3v2Tag);
        }
        id3v2Tag.setTrack("5");
        id3v2Tag.setArtist("An Artist");
        id3v2Tag.setTitle("The Title");
        id3v2Tag.setAlbum("The Album");
        id3v2Tag.setYear("2001");
        id3v2Tag.setGenre(12);
        id3v2Tag.setComment("Some comment");
        id3v2Tag.setComposer("The Composer");
        id3v2Tag.setPublisher("A Publisher");
        id3v2Tag.setOriginalArtist("Another Artist");
        id3v2Tag.setAlbumArtist("An Artist");
        id3v2Tag.setCopyright("Copyright");
        id3v2Tag.setUrl("http://foobar");
        id3v2Tag.setEncoder("The Encoder");
        mp3file.save("MyMp3File.mp3");
    }

    public static void grid(Stage stage) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(5));

        Text mp3FileNameT, trackNoT, titleT, artistsT, lengthT, albumT, yearT, genreT, commentsT;

        mp3FileNameT = new Text("Filename:");
        trackNoT = new Text("Track Number:");
        titleT = new Text("Title:");
        artistsT = new Text("Artists:");
        lengthT = new Text("Track Length:");
        albumT = new Text("Album:");
        yearT = new Text("Year:");
        genreT = new Text("Genere:");
        commentsT = new Text("Comments/Lyrics: ");

        TextField mp3FileNameTF, trackNoTF, titleTF, artistsTF, lengthTF, albumTF, yearTF, genreTF;
        TextArea commentsTF;

        mp3FileNameTF = new TextField("");
        trackNoTF = new TextField("");
        titleTF = new TextField("");
        artistsTF = new TextField("");
        lengthTF = new TextField("");
        albumTF = new TextField("");
        yearTF = new TextField("");
        genreTF = new TextField("");
        commentsTF = new TextArea("");

        grid.addColumn(0, mp3FileNameT, trackNoT, titleT, artistsT, lengthT, albumT, yearT, genreT, commentsT);
        grid.addColumn(1, mp3FileNameTF, trackNoTF, titleTF, artistsTF, lengthTF, albumTF, yearTF, genreTF, commentsTF);
        grid.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(grid, 500, 500);

        stage.setTitle("Grid Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void treeSample(Stage stage) {

        TreeItem<String> rootItem = new TreeItem<String>("Inbox");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<String>(rootItem);
        StackPane root = new StackPane();
        root.getChildren().add(tree);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //testVBox1Titles(primaryStage);
            //testVBox2Values(primaryStage);
            //grid(primaryStage);
            treeSample(primaryStage);

        } catch (UnsupportedOperationException e) {
            System.err.println(e.toString());
        }
        //To change body of generated methods, choose Tools | Templates.
    }
}
