package meridia.views;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import meridia.presentationmodels.PresentationModel;

public class UploadView extends GridPane implements ViewMixin {

    private final PresentationModel model;
    private Button uploadButton;

    public UploadView(PresentationModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        uploadButton = new Button();
        this.getChildren().add(uploadButton);
    }

    @Override
    public void layoutControls() {
        getStyleClass().add("header-view");
        uploadButton.setText("Upload your Image");
    }

    @Override
    public void setupEventHandlers() {
        uploadButton.setOnMouseClicked(e -> model.upload());
    }
}
