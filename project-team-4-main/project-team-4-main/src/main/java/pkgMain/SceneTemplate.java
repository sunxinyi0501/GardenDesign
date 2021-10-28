package pkgMain;

import java.util.ArrayList;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


/**
 * The Template Page View
 * Let user use a template garden
 * 
 * @author 　Weitong Sun
 * @version beta
 */

public class SceneTemplate implements ViewMaker {
	//constant
		int imgW = 800;
		int imgH = 450;
		int imgX = 25;
		int imgY = 10;
		
		int titleX = 50;
		int titleY = 100;
	
	private ViewDesignGardenController imc;
    private ImageView iv1;
    public static List<ImageData> imageDataList  = new ArrayList<>();
    public static List<MyImageView> dragImageViewList  = new ArrayList<>();
	public static GridPane  rightCenter;
    private Stage stage;
    View view;
    
    private List<ImageData> rightTopList; //sxy line46 , get the image from the csv
    /**
     * Must inject a stage
     */
    public SceneTemplate(Stage theStage, View view) {
        this.stage = theStage;
        this.view = view;
        iv1 = new ImageView();
        imc = new ViewDesignGardenController(this.stage);
        try {
            imageDataList = Data.readImageDatafromCsv("s3_left_data.csv");
            rightTopList = Data.readImageDatafromCsv("s3_right_top_data.csv");
        } catch (Exception e) {

        }
        
    }

    @Override
    public Scene getScene() {
        Pane pane = new Pane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setStyle("-fx-background-color: lightblue;");


        GridPane left = new GridPane();
        left.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
        left.setPrefWidth(150);
        left.setLayoutX(0);
        left.setLayoutY(0);
        pane.getChildren().add(left);

        GridPane rightTop = new GridPane();
        rightTop.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        rightTop.setPrefHeight(100);
        rightTop.setLayoutX(170);
        rightTop.setLayoutY(0);
        pane.getChildren().add(rightTop);

        
        
        //add template img
        Image img = null;
		img = new Image(getClass().getClassLoader().getResourceAsStream("img/Template.png"));
        ImageView tl = new ImageView(img);

        tl.setFitWidth(imgW);
        tl.setFitHeight(imgH);
        tl.relocate(imgX, imgY);
        
        rightCenter = new GridPane();
        rightCenter.setMouseTransparent(true);
        rightCenter.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        
        
        List<ImageData> list1 = new ArrayList<>();
        list1.add(new ImageData("/img/Tree.png", 50,30));
        list1.add(new ImageData("/img/Tree.png", 90,30));
        list1.add(new ImageData("/img/Home.png", 60,60));
        list1.add(new ImageData("/img/Chair.png", 30,150));
        list1.add(new ImageData("/img/Fence.png", 30,250));
        list1.add(new ImageData("/img/Fence.png", 150,320));
        list1.add(new ImageData("/img/pool.png", 230,150));
        list1.add(new ImageData("/img/Fence.png", 300,40));
        list1.add(new ImageData("/img/Fence.png", 420,110));
        list1.add(new ImageData("/img/Fence_reset.png", 280,320));
        list1.add(new ImageData("/img/Fence_reset.png", 420,230));
        for (int i = 0; i < list1.size(); i++) {
            ImageData imageData = list1.get(i);
            Image im1 = new Image(getClass().getResourceAsStream(imageData.getPath()));
            MyImageView iv = new MyImageView();
            iv.setImage(im1);
            iv.setPreserveRatio(true);
            iv.setFitHeight(150);
            iv.setFitWidth(150);
            iv.setTranslateX(imageData.getTranslateX());
            iv.setTranslateY(imageData.getTranslateY());
            iv.setOffsetX(imageData.getTranslateX());
            iv.setOffsetY(imageData.getTranslateY());
            rightCenter.add(iv, 0, 0);
            dragImageViewList.add(iv);
        }
        
        rightCenter.setPrefWidth(view.gardenWidth);
        rightCenter.setPrefHeight(view.gardenWidth);
        rightCenter.setLayoutX(170);
        rightCenter.setLayoutY(120);
        pane.getChildren().add(rightCenter);//xinyi line137-line141
        
        for (int i = 0; i < rightTopList.size(); i++) {
            ImageData imageData = rightTopList.get(i);
            Image im1 = new Image(getClass().getResourceAsStream(imageData.getPath()));
            for (int j = 0; j < imageData.getNum(); j++) {
                MyImageView iv = new MyImageView();
                iv.setImage(im1);
                iv.setPreserveRatio(true);
                iv.setFitHeight(100);
                iv.setFitWidth(150);
                iv.setPreserveRatio(true);
                imc.setHandlerForDrag(iv, rightCenter);
                rightTop.add(iv, i, 0);
            }
        }


        int imageSize = imageDataList.size();
        for (int i = 0; i < imageSize; i++) {
            ImageData imageData = imageDataList.get(i);
            for (int j = 0; j < imageData.getNum(); j++) {
                //System.out.println("img/" + imageData.getPath());
            	Image im1 = new Image(imageData.getPath());
                MyImageView iv1 = new MyImageView();
                iv1.setImage(im1);
                iv1.setPreserveRatio(true);
                iv1.setFitWidth(150);
                iv1.setFitHeight(150);
                imc.setHandlerForDrag(iv1, rightCenter);
                left.add(iv1, 0, i);
            }
        }




        HBox rightBottom = new HBox();
        rightBottom.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
        rightBottom.setLayoutX(170);
        rightBottom.setLayoutY(120 + view.gardenHeight + 10);
        rightBottom.setPrefWidth(700);
        rightBottom.setPrefHeight(60);
        pane.getChildren().add(rightBottom);
        rightBottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       
        Label gdName = new Label("Garden Name: Template Garden");
        Label gdW = new Label("Garden Width: " + "60ft");
        Label gdH = new Label("Garden Height: " + "60ft");
        
        Button button = new Button("next page");
        Button button1 = new Button("back to main");
        
		 Controller controller = new Controller();
//		 button.setOnMousePressed(e -> controller.handleOnPressNextSix(e, this.stage,view));
		 button.setOnMousePressed(e -> controller.goFour(e, this.stage));
		 button1.setOnMousePressed(e -> controller.handleOnPressMain(e, this.stage));

        rightBottom.getChildren().addAll(gdName,gdW, gdH,button,button1);
        rightBottom.setSpacing(20);
        
     


        
        
        
        return new Scene(pane, view.canvasWidth, view.canvasHeight);
    }

}
