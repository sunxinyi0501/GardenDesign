package pkgMain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 *The act of controlling details in a plant detail control class
 */
public class PlantsDetailController {

    public Stage stage;

    public  View view;

    Controller controller = new Controller();

    @FXML
    ImageView imgV;

    @FXML
    Label name;

    @FXML
    Label light;


    @FXML
    Label water;

    @FXML
    Label bloomTime;


    @FXML
    Label hight;

    @FXML
    Label bloomColor;

    @FXML
    Label soilMoisture;

    @FXML
    Label caCO3Tolerance;

    @FXML
    Label droughtTolerance;

    @FXML
    Label fontLabel;

    /**
     * Initializing plant detail data
     */
    public void  init(){
        List<Plant> plants = Data.plants;
        Integer id = Data.clickId;
        Plant plant = plants.get(id);
        imgV.setImage(plant.getImageView().getImage());
        name.setText("name:"+plant.getName());
        light.setText("light:"+plant.getLight());
        water.setText("water:"+plant.getWater());
        bloomTime.setText("bloomTime:"+plant.getBloomTime());
        hight.setText("hight:"+plant.getHight());
        bloomColor.setText("bloomColor:"+plant.getBloomColor());
        soilMoisture.setText("soilMoisture:"+plant.getSoilMoisture());
        caCO3Tolerance.setText("caCO3Tolerance:"+plant.getCaCO3Tolerance());
        droughtTolerance.setText("droughtTolerance:"+plant.getDroughtTolerance());
    }


    /**
     * Return to previous page
     * @param mouseEvent
     */
    public void back(MouseEvent mouseEvent) {
        FXMLLoader loader = FxUtils.getLoader("/fxml/s4.fxml");
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            CharacteristicsLimitController characteristicsLimitController = loader.getController();
            characteristicsLimitController.stage = stage;
            characteristicsLimitController.view = view;
            characteristicsLimitController.init();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  hideFront(){
        fontLabel.setVisible(false);
    }

}
