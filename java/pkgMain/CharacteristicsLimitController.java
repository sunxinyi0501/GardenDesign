package pkgMain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.*;

/**
 * Plant list controller, which controls the dynamic behavior of the plant list
 * Query data, image rendering
 */
public class CharacteristicsLimitController {
    @FXML
    Pane imgPane;

    @FXML
    Pane leftPane;

    public Stage stage;

    Stage s;

    LimitMouseShowController limitMouseShowController;

    @FXML
    TextField light;

    @FXML
    TextField water;

    @FXML
    TextField bloomTime;

//    @FXML
//    TextField hight;

    @FXML
    TextField bloomColor;

    @FXML
    TextField soilMoisture;

    @FXML
    TextField caCO3Tolerance;

    @FXML
    TextField droughtTolerance;

    View view;

    Controller controller = new Controller();

    /**
     * Initialize all picture data
     * Initialize all event actions
     */
    public void init() {
        Data.plants_select.clear();
        Set<Node> panes = leftPane.lookupAll("Pane");
        Iterator<Node> iterator = panes.iterator();
        int i = 1;
        boolean frist = true;
        s = new Stage();
        FXMLLoader loader = FxUtils.getLoader("/fxml/s4_1.fxml");
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Scene scene = new Scene(root,500,500);
        Scene scene = new Scene(root);
        limitMouseShowController = loader.getController();

//        scene.getStylesheets().add("-fx-scale-x:0.1;-fx-scale-y: 0.1;");
        // setting the X-y factors for the scale
        s.setScene(scene);
//        s.setX(stage.getX()+300);
       imgPane.setOnMouseExited(event -> {
            s.hide();
       });
        while (iterator.hasNext()) {
            Pane pane = (Pane) iterator.next();
            if (frist) {
                frist = false;
                continue;
            }
            TextField textField = (TextField) pane.lookup("TextField");
            Label label = (Label) pane.lookup("Label");
            ImageView imageView = (ImageView) pane.lookup("ImageView");
            Map<String, String[]> selectMap = Data.getSelectMap();
            Select select = new Select(leftPane, selectMap.get(label.getText()), 158, textField.getLayoutX() + 30, i * pane.getPrefHeight() + 6);
            select.hide();
            select.setShowEle(imageView);
            //set select
            select.setClick((e) -> {
                Label l = (Label) e.getSource();
                textField.setText(l.getText());
                queryData();
            });
            i++;
        }
        queryData();
    }


    /**
     * Query data method through this method according
     * to the selected data in the text box to render the picture dynamically
     */
    public  void queryData(){
        List<Plant> plants = Data.plants;
        String lightText = light.getText();
        String waterText = water.getText();
        String bloomTimeText = bloomTime.getText();
//        String hightText = hight.getText();
        String bloomColorText = bloomColor.getText();
        String soilMoistureText = soilMoisture.getText();
        String caCO3ToleranceText = caCO3Tolerance.getText();
        String droughtToleranceText = droughtTolerance.getText();

        List<Plant> filters = new ArrayList<>();
        int size = plants.size();
        for(int  i =0;i<size;i++){
             Plant p = plants.get(i);
            if(!droughtToleranceText.trim().equals("")){
                if(!p.getDroughtTolerance().trim().contains(droughtToleranceText)){
                    continue;
                }
            }

            if(!caCO3ToleranceText.trim().equals("")){
                if(!p.getCaCO3Tolerance().trim().contains(caCO3ToleranceText)){
                    continue;
                }
            }

            if(!soilMoistureText.trim().equals("")){
                if(!p.getSoilMoisture().trim().contains(soilMoistureText)){
                    continue;
                }
            }

            if(!bloomColorText.trim().equals("")){
                if(!p.getBloomColor().trim().contains(bloomColorText)){
                    continue;
                }
            }

//            if(!hightText.trim().equals("")){
//                if(!p.getHight().trim().contains(hightText)){
//                    continue;
//                }
//            }

             if(!lightText.trim().equals("")){
                 if(!p.getLight().trim().contains(lightText)){
                     continue;
                 }
             }

             if(!waterText.trim().equals("")){
                 if(!p.getWater().trim().contains(waterText)){
                     continue;
                 }
             }

            if(!bloomTimeText.trim().equals("")){
                if(!p.getBloomTime().trim().contains(bloomTimeText)){
                    continue;
                }
            }

            filters.add(p);
        }

        Data.filters = filters;
        int start = (Data.curPage-1)*Data.size;
        int end =Data.curPage*Data.size;
        if(end> filters.size()){
             end = filters.size();
        }
        Set<Node> imageViews = imgPane.lookupAll("ImageView");
        Iterator<Node> iterator = imageViews.iterator();




        for(int j = start;j<end;j++){
            Plant p = filters.get(j);
            if (iterator.hasNext()) {
                ImageView imageView = (ImageView) iterator.next();
                Pane pane = (Pane) imageView.getParent();
                if(Data.plants_select.contains(j)){
                    pane.setStyle("-fx-background-color: black");
                }else {
                    pane.setStyle("");
                }

                show(pane);
                imageView.setImage(p.getImageView().getImage());
                imageView.setUserData(j);

//                pane.setStyle("-fx-background-color: black");
                s.setAlwaysOnTop(true);
                imageView.setOnMouseMoved(e->{
                    Data.clickId = (Integer) imageView.getUserData();
                    System.out.println("move"+ Data.clickId);
                    limitMouseShowController.init();
                    Pane pa = (Pane) imageView.getParent();
                    s.setX(stage.getX()+imgPane.getLayoutX()+pa.getLayoutX()+pa.getPrefWidth());
                    s.setY(stage.getY()+imgPane.getLayoutY()+pa.getLayoutY()+pa.getPrefHeight());
                    s.show();
                });

//                imageView.setOnMouseExited(e->{
//                });

                imageView.setOnMouseClicked(e -> {
                    Integer index = (Integer) imageView.getUserData();
                    Data.clickId = index;
//                    if(e.isControlDown()){
                        Pane pa = (Pane) imageView.getParent();
                        if(!Data.plants_select.contains(index)){
                            pa.setStyle("-fx-background-color: black");
                            Data.plants_select.add(index);
                        }else {
                            pa.setStyle("");
                            Data.plants_select.remove(index);
                        }
//                    }
//                    else {
//                        PlantsDetail plantsDetail = new PlantsDetail(stage,view);
//                         stage.setScene(plantsDetail.getScene());
//                         s.hide();
//                    }
                });

            }
        }

        while (iterator.hasNext()) {
            ImageView imageView = (ImageView) iterator.next();
            Pane pane = (Pane) imageView.getParent();
            hide(pane);
        }

    }


    /**
     * Jump to the next page, you can modify the current page and total number in the data class
     * @return
     */
    public  boolean judgeNextPage(){
        return  Data.curPage*Data.size<Data.plants.size();
    }


    /**
     * Determine if there is a previous page
     * @return
     */
    public  boolean judgePrevPage(){
        return  Data.curPage-1>0;
    }

    /**
     * Reset all input box data and query data
     * @param e
     */
    public void reset(MouseEvent e) {
        light.setText("");
        water.setText("");
        bloomTime.setText("");
//        hight.setText("");
        bloomColor.setText("");
        soilMoisture.setText("");
        caCO3Tolerance.setText("");
        droughtTolerance.setText("");
        Data.curPage = 1;
        queryData();
    }


    /**
     * Jump to the next page
     * @param e
     */
    public void next(MouseEvent e) {
        boolean judge = judgeNextPage();
        if(!judge){
            FxUtils.showMsg("no next page");
            return;
        }
        Data.curPage += 1;
        queryData();
    }

    /**
     * Jump to the previous page, you can modify the current page and total number in the data class
     * @param e
     */
    public void prev(MouseEvent e) {
        boolean judge = judgePrevPage();
        if(!judge){
            FxUtils.showMsg("no prev page");
            return;
        }
        Data.curPage -= 1;
        queryData();
    }


    /**
     * Go to the plant drag page
     * @param e
     */
    public void goToSeasonView(MouseEvent e) {
        s.hide();
        controller.handleOnPressNextSix(e, stage, view);
    }

    /**
     * hide containers
     * @param p
     */
    public void hide(Pane p) {
        p.setVisible(false);
        p.setManaged(false);
    }

    /**
     * show containers
     * @param p
     */
    public void show(Pane p) {
        p.setVisible(true);
        p.setManaged(true);
    }

}

