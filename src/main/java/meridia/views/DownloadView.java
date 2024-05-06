package meridia.views;

import javafx.scene.layout.HBox;
import meridia.presentationmodels.PresentationModel;

public class DownloadView extends HBox implements ViewMixin {

    private PresentationModel model;

    public DownloadView(PresentationModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {

    }

    @Override
    public void layoutControls() {
        getStyleClass().add("header-view");
    }

    /* Hilfe/Ideen zu ValueChangedListeners von Samuel Lupica */
    @Override
    public void setupValueChangedListeners() {
    }
}
