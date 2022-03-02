package ch.makery.adress;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.*;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		initRootLayout();
		showPersonOverview();
	}

	/** Inicializa el dise�o de la pantalla principal. */
	public void initRootLayout() {
		try {
			// Carga el XML con el dise�o principal
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			// Se a�ade el dise�o principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el dise�o de PersonOverview dentro de la pantalla principal
	 */
	public void showPersonOverview() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(personOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Returns the main stage. */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}