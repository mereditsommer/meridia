package meridia.views;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

import static meridia.filesystem.FilesystemAccess.downloadImage;
import static meridia.filesystem.FilesystemAccess.readFile;

public class DownloadView extends HBox implements ViewMixin {

    private PresentationModel model;
    private Stage primaryStage;
    private Button downloadButton;

    public DownloadView(PresentationModel model) {
        this.model = model;
        init();
    }
    public DownloadView(PresentationModel model, Stage primaryStage) {
        this.model = model;
        this.primaryStage = primaryStage;
        init();
    }

    @Override
    public void initializeControls() {
        downloadButton = new Button();
        this.getChildren().add(downloadButton);
    }

    @Override
    public void layoutControls() {
        getStyleClass().add("header-view");
        downloadButton.setText("download the image");
    }

    /* Hilfe/Ideen zu ValueChangedListeners von Samuel Lupica */
    @Override
    public void setupValueChangedListeners() {
    }

    @Override
    public void setupEventHandlers() {
        downloadButton.setOnMouseClicked(e -> downloadImage(this.primaryStage, model));
    }
}
