package meridia.views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import meridia.presentationmodels.PresentationModel;

import java.awt.Image;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class Header extends HBox implements ViewMixin {
    private final PresentationModel model;
    private Label title;
    private TextField logoSpace;

    public Header(PresentationModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeSelf(){getStyleClass().add("header");}

    @Override
    public void initializeControls() {
        title = new Label("MeridiaImages");
    }

    @Override
    public void layoutControls() {
        getChildren().add(title);

    }
}
