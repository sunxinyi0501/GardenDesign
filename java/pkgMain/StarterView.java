package pkgMain;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Starter Page View
 * Let user choose to whether start a new garden or choose a garden from template
 * 
 * @author 　Weitong Sun
 * @version final
 */

public class StarterView implements ViewMaker{
	
	private Stage theStage;
	View view;
	
	//constants//
	String title = "Garden Designer";
	String template = "Garden Templates";
	
	
	
	
	/** Must inject a stage */
	
	/**
	 * 
	 * @param theStage
	 * @param view
	 */
	public StarterView(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	
	
	@Override
	public Scene getScene() {
		
		//Page 1 stage & scene
		theStage.setTitle("Garden Designer");
		
		Group root = new Group();
		//System.out.println("11111");
	
		Scene theScene = new Scene(root,view.canvasWidth,view.canvasHeight);
		//System.out.println("22222");
		theScene.setFill(Color.LAVENDERBLUSH); 
		theStage.setScene(theScene);
		
		
		//Add Text "garden designer"
		Text text = new Text();
		text.setFont(new Font(50));
		text.setX((view.canvasWidth/2) - title.length()*12); 
		text.setY(100);
		text.setText(title);
		Line line = new Line(view.canvasWidth/4, 120, (view.canvasWidth/4)*3, 120);
		root.getChildren().addAll(text,line);
		text.setStrokeWidth(1);
		text.setStroke(Color.WHITE);
				
		//Add Text "Templates"
		Text text1 = new Text();
		text1.setFont(new Font(30));
		text1.setX(view.canvasWidth/2 - template.length()*8); 
		text1.setY(view.canvasHeight/2 + 50);	
		text1.setText(template);
		root.getChildren().addAll(text1);
				
		////////////////Button/////////////////
		
		//add newGarden Button
		root.getChildren().addAll(view.newGarden);
		// CSS design for newGarden Button
		view.newGarden.setStyle("-fx-font-size: 40px");
		view.newGarden.setStyle("-fx-background-color: #FFFFF0");
		view.newGarden.setWrapText(true);
		view.newGarden.setPrefSize(275, 175);
		view.newGarden.relocate(view.canvasWidth/4,150);
		
		
		//add loadGarden Button
		root.getChildren().addAll(view.loadGarden);
		// CSS design for newGarden1 Button
		view.loadGarden.setStyle("-fx-font-size: 40px");
		view.loadGarden.setStyle("-fx-background-color: #FFFFF0");
		view.loadGarden.setWrapText(true);
		view.loadGarden.setPrefSize(275, 175);
		view.loadGarden.relocate((view.canvasWidth/4)*2,150);

	///////////////////////////////////////////////////////////////////////////////
		
		
		
		//add template Button
		root.getChildren().addAll(view.template);
		// CSS design for template Button
		view.template.setStyle("-fx-font-size: 40px");
		view.template.setStyle("-fx-background-color: #FFFFF0");
		view.template.setWrapText(true);
		view.template.setPrefSize(230, 150);
		view.template.relocate((view.canvasWidth/2) - title.length()*8,500);
		
		return theScene;
	}

}
