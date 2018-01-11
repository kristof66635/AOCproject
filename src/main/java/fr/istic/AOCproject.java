package fr.istic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *The FX Apllication class
 * @author chak
 */
public class AOCproject extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(AOCproject.class.getResource("bootstrap3.css").toExternalForm());
        stage.setTitle("Project AOC");
        stage.setScene(scene);
        stage.show();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void stop(){
        System.out.println("Stage is closing");
        System.exit(0);
    }
}

