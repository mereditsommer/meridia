package meridia.views;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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
