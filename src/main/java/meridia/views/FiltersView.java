package meridia.views;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import meridia.presentationmodels.PresentationModel;

public class FiltersView extends VBox implements ViewMixin {
    private final PresentationModel model;
    private Button blackWhiteButton;
    private Button grayButton;
    private Button pixelButton;

    public FiltersView(PresentationModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        blackWhiteButton = new Button();
        grayButton = new Button();
        pixelButton = new Button();
    }

    @Override
    public void layoutControls() {
        getStyleClass().add("toolbar-view");
        blackWhiteButton.setDisable(true);
        blackWhiteButton.setText("Black and White");
        grayButton.setDisable(true);
        pixelButton.setDisable(true);

        this.setSpacing(32);
        this.getChildren().addAll(blackWhiteButton, grayButton, pixelButton);
    }

    @Override
    public void setupEventHandlers() {
        blackWhiteButton.setOnMouseClicked(e -> model.setFilter());
        blackWhiteButton.setOnMouseClicked(e -> model.setFilter());
        blackWhiteButton.setOnMouseClicked(e -> model.setFilter());
    }
}
