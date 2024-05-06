package meridia.views;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

public class ApplicationUI extends BorderPane implements ViewMixin {

    private final PresentationModel model;

    private UploadView uploadView;
    private FiltersView filtersView;
    private DownloadView downloadView;
    private SplitPane splitPane;

    private Stage primaryStage;

    public ApplicationUI(PresentationModel model) {
        this.model = model;
        init();
    }
    public ApplicationUI(PresentationModel model, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.model = model;
        init();
    }

    public void initializeSelf() {
        String stylesheet = getClass().getResource("../style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    public void initializeControls() {
        uploadView = new UploadView(model);
        filtersView = new FiltersView(model, primaryStage);
        downloadView = new DownloadView(model);
        splitPane = initializeSplitPane();
    }

    public void layoutControls() {
        VBox.setVgrow(splitPane, Priority.ALWAYS);

        setCenter(splitPane);
    }

    private SplitPane initializeSplitPane() {
        SplitPane splitPane = new SplitPane();

        splitPane.getItems().addAll(uploadView, filtersView, downloadView);
        splitPane.setDividerPositions(0.5f);

        return splitPane;
    }
}
