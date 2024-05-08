package meridia.views;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import meridia.presentationmodels.PresentationModel;
import meridia.utils.Filter;

public class FiltersView extends VBox implements ViewMixin {
    private final PresentationModel model;
    private Label label;
    private  Button originalButton;
    private Button blackWhiteButton;
    private Button grayButton;
    private Button pixelButton;

    public FiltersView(PresentationModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        originalButton = new Button("Original");
        blackWhiteButton = new Button("Black and White");
        grayButton = new Button("Grayscale");
        pixelButton = new Button("Pixelated");
        label = new Label("Choose a filter to apply");
    }

    @Override
    public void layoutControls() {
        getStyleClass().add("toolbar-view");
        originalButton.getStyleClass().add("main-button");
        originalButton.getStyleClass().add("filter-button");
        blackWhiteButton.getStyleClass().add("main-button");
        grayButton.getStyleClass().add("main-button");
        pixelButton.getStyleClass().add("main-button");
        blackWhiteButton.getStyleClass().add("filter-button");
        grayButton.getStyleClass().add("filter-button");
        pixelButton.getStyleClass().add("filter-button");

        this.setSpacing(18);
        this.getChildren().addAll(label, originalButton, blackWhiteButton, grayButton, pixelButton);
    }

    @Override
    public void setupEventHandlers() {
        blackWhiteButton.setOnMouseClicked(e -> model.setFilter(Filter.BW));
        grayButton.setOnMouseClicked(e -> model.setFilter(Filter.GRAY));
        pixelButton.setOnMouseClicked(e -> model.setFilter(Filter.PIXEL));
        originalButton.setOnMouseClicked(e -> model.setFilter(Filter.NONE));
    }
}
