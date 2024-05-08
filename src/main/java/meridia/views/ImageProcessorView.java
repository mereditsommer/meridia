package meridia.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import meridia.filesystem.FilesystemAccess;
import meridia.presentationmodels.PresentationModel;

import java.io.File;
import java.net.URL;

import static meridia.filesystem.FilesystemAccess.downloadImage;
import static meridia.filesystem.FilesystemAccess.readFile;

public class ImageProcessorView extends GridPane implements ViewMixin {

    private final PresentationModel model;
    private VBox col;
    private Label mainTitle;
    private Label subTitle;
    private Image placeholder ;
    private ImageView imageView;
    private Button uploadButton;
    private Button clearButton;
    private Button downloadButton;
    private HBox tools;
    private StackPane imageArea;
    private Stage primaryStage;

    public ImageProcessorView(PresentationModel model, Stage primaryStage) {
        this.model = model;
        model.setImageProcessorView(this);
        this.primaryStage = primaryStage;
        init();
    }

    @Override
    public void initializeControls() {
        mainTitle = new Label("Image Processor");
        mainTitle.getStyleClass().add("h1-style");
        subTitle = new Label("Select your image, choose a filter and download the processed image.");
        subTitle.getStyleClass().add("h2-style");
        uploadButton = new Button();
        clearButton = new Button();
        downloadButton = new Button();

        placeholder = new Image("img/placeholder.jpg");
        imageView = new ImageView(placeholder);
        imageView.getStyleClass().add("imageStyle");
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(350);

        imageArea = new StackPane();
        imageArea.getChildren().addAll(imageView, uploadButton);
        StackPane.setAlignment(uploadButton, Pos.CENTER);
        imageArea.setAlignment(Pos.CENTER);

        tools = new HBox(clearButton, downloadButton);
        tools.setAlignment(Pos.CENTER);
        tools.setSpacing(40);
        col = new VBox(mainTitle, subTitle, imageArea, tools);
        col.setSpacing(10);
    }

    @Override
    public void layoutControls() {
        uploadButton.getStyleClass().add("main-button");
        clearButton.getStyleClass().add("main-button");
        downloadButton.getStyleClass().add("main-button");
        downloadButton.getStyleClass().add("pink-button");
        getStyleClass().add("image-view");

        uploadButton.setText("Select Image");
        clearButton.setText("Clear Image");
        downloadButton.setText("Download Image");
        getChildren().add(col);
    }

    @Override
    public void setupEventHandlers() {
        uploadButton.setOnMouseClicked(e -> {
            File file = readFile(this.primaryStage);
            if (file != null) {
                model.setFile(file);
                imageView.setImage(new Image(String.valueOf(model.getFile().toURI())));
            }
            imageArea.getChildren().remove(uploadButton);
        });
        downloadButton.setOnMouseClicked(e -> downloadImage(this.primaryStage, model));
        clearButton.setOnMouseClicked(e -> {
            imageArea.getChildren().add(uploadButton);
            imageView.setImage(placeholder);
        });
    }

    public void setImageWithFilter() {
        String format = model.getFile().getName().split("\\.")[1];
        URL imageURL = FilesystemAccess.class.getResource("/meridia." + format);
        imageView.setImage(new Image(String.valueOf(imageURL)));
    }

    public void resetImage() {
        imageView.setImage(new Image(String.valueOf(model.getFile().toURI())));
    }
}
