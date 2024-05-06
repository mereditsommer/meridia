package meridia.views;
import meridia.filesystem.FilesystemAccess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;
import meridia.utils.Filter;

import java.io.File;

import static jdk.jfr.consumer.EventStream.openFile;
import static meridia.filesystem.FilesystemAccess.readFile;

public class FiltersView extends VBox implements ViewMixin {
    private final PresentationModel model;
    private Button blackWhiteButton;
    private Button grayButton;
    private Button pixelButton;
    private Stage primaryStage;
    final FileChooser fileChooser = new FileChooser();

    public FiltersView(PresentationModel model) {
        this.model = model;
        init();
    }
    public FiltersView(PresentationModel model, Stage primaryStage) {
        this.model = model;
        this.primaryStage = primaryStage;
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
        grayButton.setText("Grayscale");
        pixelButton.setDisable(true);
        pixelButton.setText("Pixelated");

        this.setSpacing(32);
        this.getChildren().addAll(blackWhiteButton, grayButton, pixelButton);
    }

    @Override
    public void setupEventHandlers() {
        blackWhiteButton.setOnMouseClicked(e -> model.setFilter(Filter.BW));
        grayButton.setOnMouseClicked(e -> model.setFilter(Filter.GRAY));
        pixelButton.setOnMouseClicked(e -> model.setFilter(Filter.PIXEL));
        blackWhiteButton.setOnMouseClicked( e -> model.setFile(readFile(this.primaryStage)));
//        blackWhiteButton.setOnMouseClicked(e -> model.setFilter());
//        blackWhiteButton.setOnMouseClicked(e -> model.setFilter());
    }
}
