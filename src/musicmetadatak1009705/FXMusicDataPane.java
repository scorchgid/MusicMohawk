/*
 * Package to managed the music metadata
 */
package musicmetadatak1009705;

import javafx.beans.property.StringProperty;
import javafx.beans.binding.Bindings;
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
public class FXMusicDataPane {
//properties go here

    private Button saveButton, resetButton, webAutoFillButton, exitButton;
    private String mP3FileName, track, title, artist, album, year, genre, comment;
    //Start of messy area, I did of course have these like the butttons above and declared them as new in the Scene grid function.
    
    
    
    TextField mp3FileNameTF = new TextField("");
    TextField trackNoTF = new TextField("");
    TextField titleTF = new TextField("");
    TextField artistsTF = new TextField("");
    TextField lengthTF = new TextField("");
    TextField albumTF = new TextField("");
    TextField yearTF = new TextField("");
    TextField genreTF = new TextField("");
    TextArea commentsTF = new TextArea("");
    
    
    
    
    /*private StringProperty mp3FileNameProp = new SimpleStringProperty(this, mp3FileNameTF.getText(), "");
    public StringProperty mp3FileNameProperty() {
    }

    public StringProperty getMp3FileNameProp() {
        return mp3FileNameProp;
    }

    public void setMp3FileNameProp(StringProperty mp3FileNameProp) {
        this.mp3FileNameProp = mp3FileNameProp;
    }

    End of messy area */
    
    
    public TextField getMp3FileNameTF() {
        return mp3FileNameTF;
    }

    public void setMp3FileNameTF(TextField mp3FileNameTF) {
        this.mp3FileNameTF = mp3FileNameTF;
    }

    public TextField getTrackNoTF() {
        return trackNoTF;
    }

    public void setTrackNoTF(TextField trackNoTF) {
        this.trackNoTF = trackNoTF;
    }

    public TextField getTitleTF() {
        return titleTF;
    }

    public void setTitleTF(TextField titleTF) {
        this.titleTF = titleTF;
    }

    public TextField getArtistsTF() {
        return artistsTF;
    }

    public void setArtistsTF(TextField artistsTF) {
        this.artistsTF = artistsTF;
    }

    public TextField getLengthTF() {
        return lengthTF;
    }

    public void setLengthTF(TextField lengthTF) {
        this.lengthTF = lengthTF;
    }

    public TextField getAlbumTF() {
        return albumTF;
    }

    public void setAlbumTF(TextField albumTF) {
        this.albumTF = albumTF;
    }

    public TextField getYearTF() {
        return yearTF;
    }

    public void setYearTF(TextField yearTF) {
        this.yearTF = yearTF;
    }

    public TextField getGenreTF() {
        return genreTF;
    }

    public void setGenreTF(TextField genreTF) {
        this.genreTF = genreTF;
    }

    public TextArea getCommentsTF() {
        return commentsTF;
    }

    public void setCommentsTF(TextArea commentsTF) {
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

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(2));
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().addAll(saveButton, resetButton, webAutoFillButton);
        grid.addColumn(0, mp3FileNameT, trackNoT, titleT, artistsT, lengthT, albumT, yearT, genreT, commentsT);
        grid.addColumn(1, mp3FileNameTF, trackNoTF, titleTF, artistsTF, lengthTF, albumTF, yearTF, genreTF, commentsTF, hbox);
        grid.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(grid, 500, 500);
        return scene;
    }
}
