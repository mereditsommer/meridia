package meridia.views;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

public class ApplicationUI extends BorderPane implements ViewMixin {

    private final PresentationModel model;
    private Header header;
    private VBox mainView;
    private HBox splitView;
    private ImageProcessorView imageProcessorView;
    private FiltersView filtersView;
    private Stage primaryStage;

    public ApplicationUI(PresentationModel model, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.model = model;
        init();
    }

    public void initializeSelf() {
        String stylesheet = getClass().getResource("../stylemeridia.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    public void initializeControls() {
        header = new Header();
        imageProcessorView = new ImageProcessorView(model, primaryStage);
        filtersView = new FiltersView(model);
        splitView = new HBox(imageProcessorView, filtersView);
        mainView = new VBox(header, splitView);
    }

    public void layoutControls() {
        getChildren().add(mainView);
    }
}
