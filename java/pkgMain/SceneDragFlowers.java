package pkgMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SceneDragFlowers implements ViewMaker{
	
	private Stage theStage;
	View view;
	private ImageView iv1;
    public static List<ImageData> imageDataList = new ArrayList<>();
    public static List<MyImageView> dragImageViewList = new ArrayList<>();
    private ViewDragFlowersController imc;
    private Stage stage;
    private GridPane pane;
    private GridPane rightCenter;


    Stage s;
    LimitMouseShowController limitMouseShowController;
	/** Must inject a stage */
	public SceneDragFlowers(Stage theStage, View view) {
		this.stage = theStage;
		this.theStage = theStage;
		this.view = view;
		iv1 = new ImageView();
        imc = new ViewDragFlowersController(this.theStage);
        imc = new ViewDragFlowersController(this.stage);

//        iv1 = new ImageView();
//        imc = new ViewDragFlowersController(this.theStage);
//        imc = new ViewDragFlowersController(this.stage);
        imageDataList.clear();
        s = new Stage();
        //selection of plants after screening
        FXMLLoader loader = FxUtils.getLoader("/fxml/s4_1.fxml");
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        limitMouseShowController = loader.getController();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.setAlwaysOnTop(true);
        for(Integer index:Data.plants_select){
            Plant p = Data.filters.get(index);
            ImageData imageData = new ImageData(p.getTemplateImg(),index,p.getGardenWidth(),p.getGardenHeight(),p);
            imageDataList.add(imageData);
        }


        
	}
	
	
	@Override
	public Scene getScene() {
		
		Pane pane = new Pane();
		//left flower part
        Pane left = new Pane();
        left.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 6;" + "-fx-border-color: black;");
        left.setPrefWidth(100);
        left.setLayoutX(0);
        left.setLayoutY(0);
        //top label part
        Pane rightTop = new Pane();
        rightTop.setPrefWidth(500);
        rightTop.setPrefHeight(50);
        rightTop.setLayoutX(120);
        rightTop.setLayoutY(0);
        rightTop.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        rightTop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Label title = new Label(view.gardenName+"(Right click to delete added plant.)");
        rightTop.getChildren().addAll(title);



        //main part: where flowers can be dropped.
        Pane rightCenter = new Pane();
        rightCenter.setPrefWidth(view.gardenWidth);
        rightCenter.setPrefHeight(view.gardenHeight);
        rightCenter.setLayoutX(SceneDesignGarden.RIGHT_CENTER_X);
        rightCenter.setLayoutY(SceneDesignGarden.RIGHT_CENTER_Y);
        rightCenter.setMouseTransparent(true);
        rightCenter.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
        //dragging part
        if (SceneDesignGarden.dragImageViewList.size() == 0 && SceneTemplate.dragImageViewList.size() > 0) {
            SceneDesignGarden.dragImageViewList.addAll(SceneTemplate.dragImageViewList);
        }
        for (MyImageView myImageView : SceneDesignGarden.dragImageViewList) {
            myImageView.setTranslateX(myImageView.getOffsetX());
            myImageView.setTranslateY(myImageView.getOffsetY());
            myImageView.setLayoutX(0);
            myImageView.setLayoutY(0);
            rightCenter.getChildren().add(myImageView);
        }
        //adding left flower to the main part
        int colIndex = 0;// for the dragged flower size
        int i=0;// for the number of the flower that has been dragged
        left.setOnMouseExited(event -> {
             s.hide();
             //System.out.println("great teamwork!");
             //TODO add plant
             
        });
        for (ImageData imageData : imageDataList) {
//            for (int j = 0; j < imageData.getNum(); j++) {
                Image im1 = new Image(getClass().getResourceAsStream(imageData.getPath()));
                MyImageView iv1 = new MyImageView(imageData.getExpandWidth(),imageData.getExpandHeight(),imageData.getPlant());
                iv1.setUserData(imageData.getNum());
                iv1.setOnMouseMoved(e->{
                    Data.clickId = (Integer) iv1.getUserData();
                    //System.out.println("move"+ Data.clickId);
                    s.setX(stage.getX()+iv1.getX()+stage.getWidth()/2);
                    s.setY(stage.getY()+left.getLayoutY());
                    limitMouseShowController.init();

                    s.show();
                });
                iv1.setImage(im1);
                iv1.setPreserveRatio(true);
                iv1.setFitWidth(50);
                iv1.setFitHeight(50);

                imc.setHandlerForDrag(iv1, rightCenter);
                iv1.setLayoutX(colIndex * 50);//for plant choose box size
                iv1.setLayoutY(i * 50);//for plant choose box size
                left.getChildren().add(iv1);

            if (colIndex == 0) {
            	colIndex = 1;
			} else {
            	colIndex = 0;
            	i++;
			}// let the choosed flower list themselves, not stuck together.
        }
        pane.getChildren().add(left);
        pane.getChildren().add(rightTop);
        pane.getChildren().add(rightCenter);
        HBox rightBottom = new HBox();
        rightBottom.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
        rightBottom.setLayoutX(120);
        rightBottom.setLayoutY(60 + view.gardenHeight + 10);
        rightBottom.setPrefWidth(500);
        rightBottom.setPrefHeight(60);
        pane.getChildren().add(rightBottom);
        

        
        //change scene buttons
        Button button = new Button("next page");
        Button button1 = new Button("Back to choose plants");
        Button button2 = new Button("Main page");
        Label gdName = new Label("Garden Name: " + view.gardenName);
        // change scene events
        Controller controller = new Controller();
        button.setOnMousePressed(e -> controller.handleOnPressSceneEight(e, this.stage));
        button1.setOnMousePressed(e -> controller.goFour(e, this.stage));
        button2.setOnMousePressed(e -> controller.handleOnPressMain(e, this.stage));
        view.save.setOnMousePressed(e -> {
			try {
				controller.handleOnPressSave(e, this.stage);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        
        rightBottom.getChildren().addAll(button,button1,button2,view.save);
		
        rightBottom.setSpacing(20);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        scrollPane.setPannable(false);
        return new Scene(scrollPane, view.canvasWidth, view.canvasHeight);
    }

}