import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainScene extends Scene {



    static MediaPlayer mediaPlayer;
    Media[] medias = new Media[2];

    public MainScene(Parent root, double width, double height, Paint fill, Stage stage) {
        super(root, width, height, fill);
        makeMainScene(this, stage);
//        medias[0] = new Media(new File("music/02 Vay Behalesh.mp3").toURI().toString());
//        medias[1] = new Media(new File("music/Aamin - Shafa.mp3").toURI().toString());
//        mediaPlayer = new MediaPlayer(medias[0]);
//        mediaPlayer.play();
    }

    private void makeChangeMusicButton(Group root) {
        Button changeMusicButton = new Button("Change Music");
        changeMusicButton.relocate(30 * 32, 0);
        root.getChildren().add(changeMusicButton);
        changeMusicButton.setOnMouseClicked(event -> {
            if (mediaPlayer.getMedia() == medias[0]) {
                mediaPlayer.stop();
                mediaPlayer = new MediaPlayer(medias[1]);
                mediaPlayer.play();
            } else {
                mediaPlayer.stop();
                mediaPlayer = new MediaPlayer(medias[0]);
                mediaPlayer.play();
            }
        });
    }

    private void makeMainScene(Scene mainScene, Stage stage) {
        Group root = (Group) mainScene.getRoot();
        root.getChildren().clear();
        Button resetButton = new Button("Reset");

        Label mar = new Label("MAR : "+ Graphic.cpu.getDataPath().getRegs().get(0));
        try {
            ImageView background = new ImageView(new Image(new FileInputStream(new File("Untitled-2.jpg"))));
            root.getChildren().add(background);
        } catch (FileNotFoundException e) {
            System.out.println("what");
            e.printStackTrace();
        }
        makeChangeMusicButton(root);

    }
}
