package meridia.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

import java.awt.Image;
import java.io.File;

import static meridia.filesystem.FilesystemAccess.readFile;

public class ImageView extends GridPane implements ViewMixin {

    private final PresentationModel model;
    private VBox col;
    private Label mainTitle;
    private Label subTitle;
  //  private Image image = new Image(getClass().getResourceAsStream("placeholder.png"));
    private ImageView imageBox;
    private Button uploadButton;
    private Button clearButton;
    private Button downloadButton;
    private HBox tools;
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
        clearButton = new Button();
        downloadButton = new Button();

        tools = new HBox(clearButton,downloadButton);
        col = new VBox(mainTitle,subTitle,uploadButton,tools);
    }

    @Override
    public void layoutControls() {


        getStyleClass().add("image-view");
        uploadButton.setText("Upload your Image");
        clearButton.setText("Clear Image");
        downloadButton.setText("Download Image");
        getChildren().add(col);
    }

    @Override
    public void setupEventHandlers() {
        uploadButton.setOnMouseClicked(e -> model.setFile(readFile(this.primaryStage)));
    }
}
