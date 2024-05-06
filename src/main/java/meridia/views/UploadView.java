package meridia.views;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

import static meridia.filesystem.FilesystemAccess.readFile;

public class UploadView extends GridPane implements ViewMixin {

    private final PresentationModel model;
    private Button uploadButton;
    private Stage primaryStage;
    final FileChooser fileChooser = new FileChooser();

    public UploadView(PresentationModel model) {
        this.model = model;
        init();
    }

    public UploadView(PresentationModel model, Stage primaryStage) {
        this.model = model;
        this.primaryStage = primaryStage;
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
        uploadButton.setOnMouseClicked(e -> model.setFile(readFile(this.primaryStage)));
    }
}
