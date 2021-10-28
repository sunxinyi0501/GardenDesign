package pkgMain;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

/**
 * Creates and returns the scene for the first view.
 *
 * @author Weitong Sun, Xinyi Sun
 * @version final
 */
public class SceneDesignGarden implements ViewMaker {
    private ViewDesignGardenController imc;
    private ImageView iv1;
    public static List<ImageData> imageDataList  = new ArrayList<>();
    public static List<MyImageView> dragImageViewList  = new ArrayList<>();
    public static ArrayList <Plant> scenePlants = new ArrayList<>();
	public static GridPane  rightCenter;
	public static final int RIGHT_CENTER_X = 120;
	public static final int RIGHT_CENTER_Y = 60;
	private List<ImageData> rightTopList;
	
    private Stage stage;
    View view;
 
    
        public SceneDesignGarden(Stage theStage, View view) {
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
       // pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
       // pane.setHgap(5.5);
        //pane.setVgap(5.5);
        pane.setStyle("-fx-background-color: lightblue;");


        GridPane left = new GridPane();
        left.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
       // pane.add(left, 0, 0,20,100);
       // left.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        left.setPrefWidth(150);
        left.setLayoutX(0);
        left.setLayoutY(0);
        pane.getChildren().add(left);
       
        GridPane rightTop = new GridPane();
        rightTop.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        //pane.add(rightTop, 25, 0,90,10);
        //rightTop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        rightTop.setPrefHeight(100);
        rightTop.setLayoutX(170);
        rightTop.setLayoutY(0);
        pane.getChildren().add(rightTop);

        
        rightCenter = new GridPane();
        rightCenter.setMouseTransparent(true);
        rightCenter.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        
        //pass in user typed height and width after adjustment
        rightCenter.setPrefWidth(view.gardenWidth);
        rightCenter.setPrefHeight(view.gardenHeight);
        System.out.println("v.w " + view.gardenWidth + "v.h " + view.gardenHeight);
        rightCenter.setLayoutX(170);
        rightCenter.setLayoutY(120);
        pane.getChildren().add(rightCenter);

        //pane.add(rightCenter, RIGHT_CENTER_X, RIGHT_CENTER_Y, view.gardenWidth, view.gardenHeight);
        //pane.add(rightCenter, RIGHT_CENTER_X, RIGHT_CENTER_Y,view.gardenWidth,view.gardenHeight);
       // rightCenter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        
        
       
        for (int i = 0; i <  rightTopList.size(); i++) {
            ImageData imageData =  rightTopList.get(i);
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
               // System.out.println("img/" + imageData.getPath());
            	Image im1 = new Image(imageData.getPath());
                MyImageView iv1 = new MyImageView();
                iv1.setStyle("-fx-background-color: black;");
                iv1.setImage(im1);
                iv1.setPreserveRatio(true);
                iv1.setFitWidth(150);
                iv1.setFitHeight(150);         
                imc.setHandlerForDrag(iv1, rightCenter);
                			imc.setHandlerForReleased(iv1, rightCenter);
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
        //pane.add(rightBottom, 25, view.gardenHeight + 10, view.gardenWidth + view.gardenName.length(), 5);
        rightBottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       
        Label gdName = new Label("Garden Name: " + view.gardenName);
        Label gdW = new Label("Garden Width: " + view.gW + "ft");
        Label gdH = new Label("Garden Height: " + view.gH + "ft");
        //TextField location = new TextField();
       
    
        Button button = new Button("Next page");
        Button button1 = new Button("Back to Main");
        button.setFocusTraversable(false);
        button1.setFocusTraversable(false);
		 Controller controller = new Controller();
//		 button.setOnMousePressed(e -> controller.handleOnPressNextSix(e, this.stage,view));
		 button.setOnMousePressed(e -> controller.goFour(e, this.stage));
		 button1.setOnMousePressed(e -> controller.handleOnPressMain(e, this.stage));

        rightBottom.getChildren().addAll(gdName,gdW, gdH,button,button1);
        rightBottom.setSpacing(20);
        ScrollPane sp = new ScrollPane();
        sp.setPrefSize(view.canvasWidth, view.canvasHeight);
        sp.setContent(pane);
        
        return new Scene(sp, view.canvasWidth, view.canvasHeight);
    }
}
