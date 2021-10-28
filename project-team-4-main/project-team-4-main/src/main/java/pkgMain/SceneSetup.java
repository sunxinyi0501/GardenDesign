package pkgMain;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Second Page View
 * Let user choose to setup their garden
 * 
 * @author 　Weitong Sun
 * @version final
 */

public class SceneSetup implements ViewMaker{
	private Stage theStage;
	View view;
	
	
	//constant
	int imgW = 400;
	int imgH = 300;
	int imgX = 690;
	int imgY = 110;
	
	int titleFontSize = 50;
	
	int nameX = 100;
	int nameY = 200;
	
	int inputX = 200;
	int inputY = 190;
	
	int titleX = 50;
	int titleY = 100;
	
	int setupButtonSize = 100;
	int setupButtonX = 430;
	int setupButtonY = 350;
	
	int mainButtonSize = 100;
	
	///////////////////////
	
	/** Must inject a stage */
	
	/**
	 * 
	 * @param theStage
	 * @param view
	 */
	public SceneSetup(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	@Override
	public Scene getScene() {
		
		//Page 2 stage & scene
		theStage.setTitle("Garden Designer");
		
		Group root = new Group();
	
		Scene theScene = new Scene(root,view.canvasWidth,view.canvasHeight);
		theScene.setFill(Color.LAVENDERBLUSH); 
		theStage.setScene(theScene);
		
		//add background sticker image
		Image img = null;
		img = new Image(getClass().getClassLoader().getResourceAsStream("img/gardenDesign.PNG"));
        ImageView gd = new ImageView(img);

        gd.setFitWidth(imgW);
        gd.setFitHeight(imgH);
        gd.relocate(imgX, imgY);
        
        root.getChildren().addAll(gd);
        ////////////////////////////////////////
				
		//Add Text "Setup your Garden"
		Text text = new Text();
		text.setFont(new Font(titleFontSize));
		text.setX(titleX); 
		text.setY(titleY);
		text.setText("Setup your Garden");
		root.getChildren().addAll(text);
		text.setStrokeWidth(1);
		text.setStroke(Color.WHITE);
		
		//add label "Name"
		Label name = new Label("Garden Name: ");
		name.setLayoutX(nameX);
		name.setLayoutY(nameY);
		root.getChildren().addAll(name);
		
		//add label "width"
		Label width = new Label("Width(in ft): ");
		width.setLayoutX(nameX);
		width.setLayoutY(nameY + 100);
		root.getChildren().addAll(width);	
					
		//add label "height"
		Label height = new Label("Height(in ft): ");
		height.setLayoutX(nameX);
		height.setLayoutY(nameY + 200);
		root.getChildren().addAll(height);
	
		/////////////////////////////////
		
		//input name 
		root.getChildren().addAll(view.nameIn);
		view.nameIn.setLayoutX(inputX);
		view.nameIn.setLayoutY(inputY);
				
		//input Width  
		root.getChildren().addAll(view.widthIn);
		view.widthIn.setLayoutX(inputX);
		view.widthIn.setLayoutY(inputY+100);
		
		//input Height 
		root.getChildren().addAll(view.heightIn);
		view.heightIn.setLayoutX(inputX);
		view.heightIn.setLayoutY(inputY+200);
			
		
		//Add setup button to go to next scene
		root.getChildren().addAll(view.setUp);
		view.setUp.setStyle("-fx-font-size: 40px");
		view.setUp.setStyle("-fx-background-color: #FFFFF0");
		view.setUp.setWrapText(true);
		view.setUp.setPrefSize(setupButtonSize, setupButtonSize);
		view.setUp.relocate(setupButtonX,setupButtonY);
		
		//Add main button to go to next scene
		root.getChildren().addAll(view.main);
		view.main.setStyle("-fx-font-size: 40px");
		view.main.setStyle("-fx-background-color: #FFFFF0");
		view.main.setWrapText(true);
		view.main.setPrefSize(mainButtonSize, mainButtonSize);
		view.main.relocate(setupButtonX + mainButtonSize + 10,setupButtonY);
		
		//root.getChildren().addAll(view.alert);
		return theScene;
	}
	

}
