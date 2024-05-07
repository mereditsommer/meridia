package meridia.views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import meridia.presentationmodels.PresentationModel;

import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class Header extends HBox implements ViewMixin {
    private ImageView imgView;

    public Header() {
        init();
    }

    @Override
    public void initializeSelf(){
        getStyleClass().add("header");
    }

    @Override
    public void initializeControls() {
        imgView = new ImageView(new Image(String.valueOf(getClass().getResource("../../img/MeridiaImages.png"))));
    }

    @Override
    public void layoutControls() {
        setPadding(new Insets(24));
        getChildren().addAll(imgView);
    }
}
