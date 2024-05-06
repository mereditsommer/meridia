package meridia.views;

import javafx.scene.layout.GridPane;
import meridia.presentationmodels.PresentationModel;

public class UploadView extends GridPane implements ViewMixin {

    private final PresentationModel model;

    public UploadView(PresentationModel model) {
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

    /* Hilfe zu maxTopSpeed- & birdAmount-Bindings von Samuel Lupica */
    @Override
    public void setupBindings() {
    }

    @Override
    public void setupValueChangedListeners() {
    }
}
