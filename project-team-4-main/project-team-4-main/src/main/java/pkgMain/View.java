package pkgMain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;


/**
 * @version beta version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is View class. 
 * The view is the visual representation of the data
 */

public class View implements Serializable{
	
	private Model model;
	
	// value of the height and width of screen
	final int canvasWidth = 1200;
	final int canvasHeight = 800;
	
	//Garden property
	static int inputWidth; 
	static int inputHeight; 
	
	static String gardenName;
	int gardenWidth = 600; //default Width
	int gardenHeight = 600; //default Height
	
	//adjust function will return these;
	int gW;
	int gH;
	
	
	// textField on page setup
	TextField nameIn = new TextField();   
	TextField heightIn = new TextField();  
	TextField widthIn = new TextField();
	
	//Alert
	Alert alert = new Alert(AlertType.WARNING);
	Alert alert1 = new Alert(AlertType.WARNING);
	
	// button 
	Button newGarden = new Button("Add New Garden");
	Button loadGarden = new Button ("Load Garden");
	Button template = new Button("Use Template");
	          //SceneSetup
	Button setUp = new Button("Setup");
	Button main = new Button("Back to Main");
	Button mainReview = new Button ("Back to Main");
	
	Button save = new Button ("Save");	////////////////////////////////////////////
	
	/** Holds the various scenes to switch between */
	private static Map<SceneName, Scene> scenes = new HashMap<>();
	
	/**
	 * adjust user input width and height to show on screen
	 * 
	 * @param width
	 * @param height
	 */
	public void adjust(int width, int height) {
		//System.out.println("adjust 111");
		if (height > width) {
			gardenHeight = 600;
			gardenWidth = width * gardenHeight /height;
		}else {
			gardenWidth = 600;
			gardenHeight = height * gardenWidth /width;
		}
		//System.out.println(gardenWidth + "," + gardenHeight);
	}
	

	public View(Stage theStage) {
		
		
	}
	
	
	//getter and setter
	public int getWidth() {
		return canvasWidth;
	}

	public int getHeight() {
		return canvasHeight;
	}
	
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
		

}
