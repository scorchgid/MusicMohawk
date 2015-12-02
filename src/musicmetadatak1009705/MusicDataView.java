/*
 * Package to managed the music metadata
 */
package musicmetadatak1009705;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author Scorchgid
 */
public class MusicDataView {

    private TextField mp3FileNameTF, trackNoTF, titleTF, artistsTF, lengthTF, albumTF, yearTF, genreTF;
    private TextArea commentsTF;
    private Button saveButton, resetButton, webAutoFillButton, exitButton, openButton;

    private MainView mainView;
    private MusicDataModel musicDataModel;

    public MusicDataView(MusicDataModel musicDataModel, MainView m) {
        this.musicDataModel = musicDataModel;
        this.mainView = m;
    }

    public TextField getMp3FileNameTF() {
        return mp3FileNameTF;
    }

    public void setMp3FileNameTF(TextField mp3FileNameTF) {
        this.mp3FileNameTF = mp3FileNameTF;
    }

    public void setMp3FileNameTF(TextField mp3FileNameTF, String text) {
        mp3FileNameTF.setText(text);
        this.mp3FileNameTF = mp3FileNameTF;
    }

    public TextField getTrackNoTF() {
        return trackNoTF;
    }

    public void setTrackNoTF(TextField trackNoTF) {
        this.trackNoTF = trackNoTF;
    }

    public void setTrackNoTF(TextField trackNoTF, String text) {
        trackNoTF.setText(text);
        this.trackNoTF = trackNoTF;
    }

    public TextField getTitleTF() {
        return titleTF;
    }

    public void setTitleTF(TextField titleTF) {
        this.titleTF = titleTF;
    }

    public void setTitleTF(TextField titleTF, String text) {
        titleTF.setText(text);
        this.titleTF = titleTF;
    }

    public TextField getArtistsTF() {
        return artistsTF;
    }

    public void setArtistsTF(TextField artistsTF) {
        this.artistsTF = artistsTF;
    }

    public void setArtistsTF(TextField artistsTF, String text) {
        artistsTF.setText(text);
        this.artistsTF = artistsTF;
    }

    public TextField getLengthTF() {
        return lengthTF;
    }

    public void setLengthTF(TextField lengthTF) {
        this.lengthTF = lengthTF;
    }

    public void setLengthTF(TextField lengthTF, String text) {
        lengthTF.setText(text);
        this.lengthTF = lengthTF;
    }

    public TextField getAlbumTF() {
        return albumTF;
    }

    public void setAlbumTF(TextField albumTF) {
        this.albumTF = albumTF;
    }

    public void setAlbumTF(TextField albumTF, String text) {
        albumTF.setText(text);
        this.albumTF = albumTF;
    }

    public TextField getYearTF() {
        return yearTF;
    }

    public void setYearTF(TextField yearTF) {
        this.yearTF = yearTF;
    }

    public void setYearTF(TextField yearTF, String text) {
        yearTF.setText(text);
        this.yearTF = yearTF;
    }

    public TextField getGenreTF() {
        return genreTF;
    }

    public void setGenreTF(TextField genreTF) {
        this.genreTF = genreTF;
    }

    public void setGenreTF(TextField genreTF, String text) {
        genreTF.setText(text);
        this.genreTF = genreTF;
    }

    public TextArea getCommentsTF() {
        return commentsTF;
    }

    public void setCommentsTF(TextArea commentsTF) {
        this.commentsTF = commentsTF;
    }

    public void setCommentsTF(TextArea commentsTF, String text) {
        commentsTF.setText(text);
        this.commentsTF = commentsTF;
    }

    public Scene grid() {
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

        mp3FileNameTF = new TextField(musicDataModel.getmP3FileName());
        trackNoTF = new TextField(musicDataModel.getTrack());
        titleTF = new TextField(musicDataModel.getTitle());
        artistsTF = new TextField(musicDataModel.getArtist());
        lengthTF = new TextField(String.valueOf(musicDataModel.getLength()));
        albumTF = new TextField(musicDataModel.getAlbum());
        yearTF = new TextField(musicDataModel.getYear());
        genreTF = new TextField(musicDataModel.getGenre());
        commentsTF = new TextArea(musicDataModel.getComment());

        saveButton = new Button("Save");
        resetButton = new Button("Reset");
        webAutoFillButton = new Button("Web Autofill");
        exitButton = new Button("Exit");
        saveButton.setPadding(new Insets(8));
        resetButton.setPadding(new Insets(8));
        webAutoFillButton.setPadding(new Insets(8));
        exitButton.setPadding(new Insets(8));
        saveButton.setPrefWidth(100);
        resetButton.setPrefWidth(100);
        webAutoFillButton.setPrefWidth(100);
        exitButton.setPrefWidth(100);
        openButton = new Button("Open");

        openButton.setOnMouseClicked(e -> {

            System.out.println("View 1");
            String dummyFile = "D:\\K3NoteBackup\\SD Card\\Music\\Gaming\\Ace Attorney\\Phoenix Wright - Ace Attorney\\17 Reminiscence ~ True Evening of Grief.mp3";
            try {
                System.out.println("View 2");
                musicDataModel.load(dummyFile);
                setMp3FileNameTF(mp3FileNameTF, musicDataModel.getmP3FileName());
                setTrackNoTF(trackNoTF, musicDataModel.getTrack());
                setTitleTF(titleTF, musicDataModel.getTitle());
                setArtistsTF(artistsTF, musicDataModel.getArtist());
                setLengthTF(lengthTF, Long.toString(musicDataModel.getLength()));
                setYearTF(yearTF, musicDataModel.getYear());
                setGenreTF(genreTF, musicDataModel.getGenre());
                setCommentsTF(commentsTF, musicDataModel.getComment());
                System.out.println("View 3");
            } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
                System.out.println("View 4 Exception");
                Logger.getLogger(MusicDataView.class.getName()).log(Level.SEVERE, null, ex);
            }
            //mainView.
        });

        //Using a lambda to set 
        mp3FileNameTF.setOnKeyTyped(e -> {
            musicDataModel.setmP3FileName(mp3FileNameTF.getText());
        });

        trackNoTF.setOnKeyTyped(e -> {
            musicDataModel.setTrack(mp3FileNameTF.getText());
        });

        titleTF.setOnKeyTyped(e -> {
            musicDataModel.setTitle(titleTF.getText());
        });

        artistsTF.setOnKeyTyped(e -> {
            musicDataModel.setArtist(artistsTF.getText());
        });

        lengthTF.setOnKeyTyped(e -> {
            long longLength = Long.parseLong(lengthTF.getText());
            musicDataModel.setLength(longLength);
        });

        albumTF.setOnKeyTyped(e -> {
            musicDataModel.setAlbum(albumTF.getText());
        });

        yearTF.setOnKeyTyped(e -> {
            musicDataModel.setYear(yearTF.getText());
        });

        genreTF.setOnKeyTyped(e -> {
            musicDataModel.setGenre(genreTF.getText());
        });

        commentsTF.setOnKeyTyped(e -> {
            musicDataModel.setComment(commentsTF.getText());
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(2));
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().addAll(saveButton, resetButton, webAutoFillButton, openButton);
        grid.addColumn(0, mp3FileNameT, trackNoT, titleT, artistsT, lengthT, albumT, yearT, genreT, commentsT);
        grid.addColumn(1, mp3FileNameTF, trackNoTF, titleTF, artistsTF, lengthTF, albumTF, yearTF, genreTF, commentsTF, hbox);
        grid.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(grid, 500, 500);
        return scene;
    }
}
