package pkgMain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *  Class of Plant List
 *  This class allows you to use the JavaFX view of the plant list
 */
public class CharacteristicsLimit implements ViewMaker {
    private Stage stage;
    View view;

    /**
     * @param stage Controller class stage
     * @param view  main view
     */
    public CharacteristicsLimit(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
    }

    /**
     * The main method to get the view, which uses the resources in fxml to create the view,
     * View editing changes can be created using the scenebuilder plug-in
     * @return
     */
    @Override
    public Scene getScene() {
        FXMLLoader loader = FxUtils.getLoader("/fxml/s4.fxml");
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root,view.canvasWidth,view.canvasHeight);
            CharacteristicsLimitController characteristicsLimitController = loader.getController();
            characteristicsLimitController.stage = this.stage;
            characteristicsLimitController.view = view;
            characteristicsLimitController.init();
            return  scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
