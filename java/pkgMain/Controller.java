package pkgMain;


import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * @version final version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is Controller class. 
 * The controller processes and responds to events, 
 * typically user actions, and may invoke changes on the model
 */

public class Controller extends Application implements ViewMaker{
	//data fields hold Model and View
	public View view;
	private Model model;
	private SceneDragFlowers sceneDragFlowers;
	
	int gW;
	int gH;
	
	Garden garden;
	FileHelper fh;

///////////////////////////////
	
	public static Button backButton;
	
	/** Holds the various scenes to switch between */
	public static Map<SceneName, Scene> scenes = new HashMap<>();

    
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
    }
	
	//handle to change scene when pressed
	
		/**
		 * handler for newGarden button on main page to go to setup page
		 * 
		 * @param event
		 * @param theStage
		 */
		public void handleOnPressNewGarden(MouseEvent event, Stage theStage) {
			theStage.setScene(scenes.get(SceneName.SETUP));
		}

		/**
		 * handler for template button on main page to go to template page
		 * 
		 * @param event
		 * @param theStage
		 */
		public void handleOnPressTemplate(MouseEvent event, Stage theStage) {
			theStage.setScene(new SceneTemplate(theStage,view).getScene());
		}
		
		
		//SceneSetup page button handle
		/**
		 * handler for Setup button on setup garden page to to go garden design page
		 * 
		 * @param event
		 * @param theStage
		 */
		public void handleOnPressSetup(MouseEvent event, Stage theStage) {
			
			view.adjust(view.gW, view.gH);//adjust user typed in width and height to show on screen
			
			//System.out.println("view gardenW gardenH:"+view.gardenWidth + "," + view.gardenHeight);
			
			gW = view.gardenWidth;
			gH = view.gardenHeight;
			theStage.setScene(scenes.get(SceneName.DESIGN_GARDEN));
			System.out.println("c.gW: " + gW + ", c.gH: " + gH);
		}
		/**
		 * handler for Main button on setup garden page to go back to main page
		 * 
		 * @param event
		 * @param theStage
		 */
		public void handleOnPressMain(MouseEvent event, Stage theStage) {
			
	
			theStage.setScene(scenes.get(SceneName.MAIN));
		}
		
		
		//Load Garden function
		/**
		 * handler for using Serializable to read in Garden properties
		 * 
		 * @param event
		 * @param theStage
		 * @throws IOException
		 */
		public void handleOnPressSave(MouseEvent event, Stage theStage) throws IOException {
			garden = new Garden(gW, gH, View.gardenName);
				
			fh = new FileHelper("garden_data");
			System.out.println("save: "+gW + "," + gH);
			garden.updateGarden(gW, gH,View.gardenName);
			fh.saveObjToFile(garden);
		
//			String dataFile = "garden_data";
//			try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(dataFile))) {
//				Model model = new Model();
//				output.writeObject(model);
//				output.close();
//				output.flush();
//			}
		}
		/**
		 * handler for using Serializable to load Garden function
		 * 
		 * @param event
		 * @param theStage
		 * @throws IOException
		 */
		public void handleOnPressLoad(MouseEvent event, Stage theStage) throws IOException{
			if(view.gW == 0 && view.gH == 0) {
				view.alert1.setTitle("invalid input");
				view.alert1.setContentText("You have not setup your garden width and height yet");
				view.alert1.show();	
			}else {
				fh = new FileHelper("garden_data");
				garden = fh.getObjFromFile();

				System.out.println("inside Load: garden object -> w: " +garden.getLength() + "h: " + garden.getWidth());

				theStage.setScene(scenes.get(SceneName.DESIGN_GARDEN));
			}
			
		}

        ////////////////////////////////////////////////////////////////////
		
		/**
		 * handler for Go to plant character limit page
		 * 
		 * @param event
		 * @param theStage
		 */
		public  void goFour(MouseEvent event, Stage theStage){
			theStage.setScene(scenes.get(SceneName.CharacteristicsLimit));
		}
		/**
		 * handler for Go to plant detail page
		 * 
		 * @param event
		 * @param theStage
		 */
		public   void goFive(MouseEvent event, Stage theStage){
			theStage.setScene(scenes.get(SceneName.PLANTS_DETAIL));
		}
		
		/**
		 * handler for Go to plant drag and drop page
		 * 
		 * @param event
		 * @param theStage
		 * @param view1
		 */
		public void handleOnPressNextSix(MouseEvent event, Stage theStage,View view1) {
			theStage.setScene(new SceneDragFlowers(theStage,view1).getScene());
		}
		/**
		 * handler for Go to seasons page
		 * 
		 * @param event
		 * @param theStage
		 */
		public void handleOnPressSceneSeven(MouseEvent event, Stage theStage) {
			theStage.setScene(scenes.get(SceneName.SEASONS));
		}
		/**
		 * handler for Go to Review page
		 * 
		 * @param event
		 * @param theStage
		 */
		public void handleOnPressSceneEight(MouseEvent event, Stage theStage) {
            theStage.setScene(new SceneReview(theStage,view).getScene());
        }
		
		/**
		 * To test if a user input garden name start with a character or not
		 * 
		 * @param strNum
		 * @return
		 */
		public boolean isNumeric(String strNum) {
            if (strNum == null) {
                return false;
            }
            try {
                double d = Integer.parseInt(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }

		//////////////////////////////////////////////////////////////////////////

	    @Override
		public void start(Stage theStage) {
	        view = new View(theStage);
			//model = new Model(view.getWidth(), view.getHeight());
			//view.setModel(model);
	        
			//add listener to textField
			view.nameIn.textProperty().addListener((observable, oldValue, newValue) -> {
				if(newValue.length() > oldValue.length()) {
					if(newValue.length() != 0) {
						char t = newValue.charAt(0);
						String s =String.valueOf(t);  
						if(isNumeric(s)) {
							view.alert.setTitle("invalid input");
							view.alert.setContentText("Please input Sting name");
							view.alert.show();
						}else {
							View.gardenName = newValue;
						}
					}
				}else {
					char t = newValue.charAt(0);
					String s =String.valueOf(t);  
					if(!isNumeric(s)) {
						View.gardenName = newValue;
					}
				}
			    
			});
			
			view.heightIn.textProperty().addListener((observable, oldValue, newValue) -> {
			    view.gH = Integer.parseInt(newValue);    
			});
			
			view.widthIn.textProperty().addListener((observable, oldValue, newValue) -> {
				  view.gW = Integer.parseInt(newValue);
			});
		
			
			//handle scene to manage their functions 
			sceneDragFlowers = new SceneDragFlowers(theStage,view);
			
			// Create and store all scenes up front
			scenes.put(SceneName.MAIN, new StarterView(theStage,view).getScene());
			scenes.put(SceneName.SETUP, new SceneSetup(theStage,view).getScene());
			scenes.put(SceneName.TEMPLATE, new SceneTemplate(theStage,view).getScene());
			scenes.put(SceneName.DESIGN_GARDEN, new SceneDesignGarden(theStage,view).getScene());
			scenes.put(SceneName.CharacteristicsLimit, new CharacteristicsLimit(theStage,view).getScene());
			scenes.put(SceneName.PLANTS_DETAIL, new PlantsDetail(theStage,view).getScene());
			scenes.put(SceneName.SEASONS, new SceneDifferentSeasonsView(theStage,view).getScene());
			scenes.put(SceneName.REVIEW, new SceneReview(theStage,view).getScene());
			
			
			//set start Scene
			theStage.setScene(scenes.get(SceneName.MAIN));
			/////////////////////////////////////////////////////////////////////////

			//change to SCENE1 when press New Garden
			view.newGarden.setOnMousePressed(e -> handleOnPressNewGarden(e, theStage));

			//change to SCENE3 when press template
			view.template.setOnMousePressed(e -> handleOnPressTemplate(e, theStage));
			
			//change to MAIN when press main ('back to main')
			view.main.setOnMousePressed(e -> handleOnPressMain(e, theStage));
			view.mainReview.setOnMousePressed(e -> handleOnPressMain(e, theStage));
			
			//change to SCENE3 when press next
			view.setUp.setOnMousePressed(e -> {
				handleOnPressSetup(e, theStage);
				
				scenes.put(SceneName.DESIGN_GARDEN, new SceneDesignGarden(theStage,view).getScene());
				theStage.setScene(scenes.get(SceneName.DESIGN_GARDEN));
			});
			
			
			view.loadGarden.setOnMousePressed(e -> {
				try {
					handleOnPressLoad(e, theStage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			});
		
	        theStage.show();
	    }
	    
	    
	   

		@Override
		public Scene getScene() {
			// TODO Auto-generated method stub
			return null;
		}

}
