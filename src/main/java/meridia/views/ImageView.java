package meridia.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

import java.awt.Image;

import static meridia.filesystem.FilesystemAccess.readFile;

public class ImageView extends GridPane implements ViewMixin {

    private final PresentationModel model;
    private VBox col;
    private Label mainTitle;
    private Label subTitle;
    private ImageView imageBox;
    private Button uploadButton;
    private Stage primaryStage;
    final FileChooser fileChooser = new FileChooser();

    public ImageView(PresentationModel model) {
        this.model = model;
        init();
    }

    public ImageView(PresentationModel model, Stage primaryStage) {
        this.model = model;
        this.primaryStage = primaryStage;
        init();
    }

    @Override
    public void initializeControls() {
        mainTitle = new Label("Image Processor");
        subTitle = new Label("Start by adding an image for processing.");
       // imageBox = new ImageView();
        uploadButton = new Button();
    }

    @Override
    public void layoutControls() {
        col = new VBox(mainTitle,subTitle,uploadButton);
        getStyleClass().add("image-view");
        uploadButton.setText("Upload your Image");
        getChildren().add(col);
    }

    @Override
    public void setupEventHandlers() {
        uploadButton.setOnMouseClicked(e -> model.setFile(readFile(this.primaryStage)));
    }
}
