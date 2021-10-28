package pkgMain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Plant details class
 */
public class PlantsDetail implements ViewMaker {
    private Stage stage;
    View view;

    /**
     *
     * @param stage
     * @param view
     */
    public PlantsDetail(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
    }

    /**
     * Get the plant details view from fxml
     * @return
     */
    @Override
    public Scene getScene() {
        FXMLLoader loader = FxUtils.getLoader("/fxml/s5.fxml");
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root,view.canvasWidth,view.canvasHeight);
            PlantsDetailController plantsDetailController = loader.getController();
            plantsDetailController.init();
            plantsDetailController.stage = stage;
            plantsDetailController.view = view;
            return  scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
