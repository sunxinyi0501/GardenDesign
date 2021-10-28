package pkgMain;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class LimitMouseShowController {


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

    public void  init(){
        List<Plant> plants = Data.filters;
        Integer id = Data.clickId;
        Plant plant = plants.get(id);
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


}
