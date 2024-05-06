package meridia;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;
import meridia.views.ApplicationUI;

import java.io.IOException;

public class AppStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		PresentationModel pm = new PresentationModel();
		Parent rootPanel = new ApplicationUI(pm);

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("ImageService");

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
