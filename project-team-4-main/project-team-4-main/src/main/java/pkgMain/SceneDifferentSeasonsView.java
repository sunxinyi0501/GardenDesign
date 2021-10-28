package pkgMain;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SceneDifferentSeasonsView implements ViewMaker{
	
	private Stage theStage;
	View view;
	
	
	/** Must inject a stage */
	public SceneDifferentSeasonsView(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	public Image renderGarden() {
		File file = new File("nofilter.png");
		//System.out.println(file.getAbsolutePath());
		return new Image("file:"+file.getAbsolutePath());
	}
	
	/**
	 * Creates scene image with filters
	 */
	public ImageView createSceneImage(double contrast,double hue,double saturation,double light) {
    	
    	ColorAdjust colorAdjust = new ColorAdjust();
    	
    	colorAdjust.setContrast(contrast);
    	colorAdjust.setHue(hue);
    	colorAdjust.setSaturation(saturation);
    	colorAdjust.setBrightness(light);
    	
    	ImageView imageView = new ImageView(renderGarden());
    	imageView.setEffect(colorAdjust);
    	
		return imageView;
		
	}
	
	@Override
	public Scene getScene() {
		
		theStage.setTitle("Garden Designer");
		
		Group root = new Group();
		
		//Scene theScene = new Scene(root,view.canvasHeight,view.canvasWidth);
		
		//theScene.setFill(Color.INDIANRED); 
		
		
		GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(20);
        Label ib = new Label("View For Different Seasons");
       ib.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));           
        pane.add(ib, 0, 0);
        
        HBox hb = new HBox();
        
        Button btn = new Button("January");
        hb.getChildren().addAll(btn);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("January");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/winter.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	Image emp = null;
				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/snowfilter.png"));
            	ImageView emp1 = createSceneImage(0.1,-0.05,-0.5,0.1);
                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                na.getChildren().addAll(new ImageView(emp));
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn1 = new Button("Febuary");
        hb.getChildren().addAll(btn1);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("Febuary");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/winter.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	Image emp = null;
				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/snowfilter.png"));
            	ImageView emp1 = createSceneImage(0.1,-0.05,-0.5,0.1);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                na.getChildren().addAll(new ImageView(emp));
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn2 = new Button("March");
        hb.getChildren().addAll(btn2);
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("March");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/Spring.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0.5,0,0,0);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn3 = new Button("April");
        hb.getChildren().addAll(btn3);
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("April");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/Spring.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0.5,0,0,0);
                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn4 = new Button("May");
        hb.getChildren().addAll(btn4);
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("May");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/Spring.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0.5,0,0,0);
                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn5 = new Button("June");
        hb.getChildren().addAll(btn5);
        
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("June");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/summer.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0.3,0.2,0.8,0);
                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn6 = new Button("July");
        hb.getChildren().addAll(btn6);
        
        
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("July");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/summer.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0.3,0.2,0.8,0);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn7 = new Button("August");
        hb.getChildren().addAll(btn7);
        
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("August");
				/*
				 * Image emp = null; emp = new
				 * Image(getClass().getClassLoader().getResourceAsStream("img/summer.jpg"));
				 * ImageView emp1 = new ImageView(emp);
				 */
            	ImageView emp1 = createSceneImage(0.3,0.2,0.8,0);
                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        Button btn8 = new Button("September");
        hb.getChildren().addAll(btn8);
        
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("September");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/Fall.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0,0.2,0.3,0);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        Button btn9 = new Button("October");
        hb.getChildren().addAll(btn9);
        
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("October");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/Fall.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0,0.2,0.3,0);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn0 = new Button("November");
        hb.getChildren().addAll(btn0);
        
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("November");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/Fall.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	ImageView emp1 = createSceneImage(0,0.2,0.3,0);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        
        Button btn10 = new Button("December");
        hb.getChildren().addAll(btn10);
        
        
        
        
        btn10.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
            	
                	Stage stage = new Stage();
                	stage.setTitle("December");
//            	Image emp = null;
//				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/winter.jpg"));
//                ImageView emp1 = new ImageView(emp);
            	Image emp = null;
				emp = new Image(getClass().getClassLoader().getResourceAsStream("img/snowfilter.png"));
            	ImageView emp1 = createSceneImage(0.1,-0.05,-0.5,0.1);

                GridPane na = new GridPane();
                emp1.setFitWidth(500);
                emp1.setFitHeight(500);
                na.getChildren().addAll(emp1);
                na.getChildren().addAll(new ImageView(emp));
                
                Scene sc1 = new Scene(na,500,500);
                stage.setScene(sc1);
                stage.show();
            }
        }
        );
        
        pane.add(hb, 0, 1);
        
        //Image emp = null;
		//emp = new Image(getClass().getClassLoader().getResourceAsStream("img/winter.jpg"));
        //ImageView emp1 = new ImageView(emp);
        Image emp = null;
		emp = new Image(getClass().getClassLoader().getResourceAsStream("img/snowfilter.png"));
        ImageView emp1 = createSceneImage(0.1,-0.05,-0.5,0.1);

        emp1.setFitWidth(200);
        emp1.setFitHeight(200);

        HBox h1 = new HBox();
        h1.getChildren().addAll(emp1);
        h1.getChildren().addAll(new ImageView(emp));
        
        HBox hh = new HBox();
        HBox vh = new HBox();
        Label h = new Label("Winter            ");
        h.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        hh.getChildren().addAll(h);
        Label s = new Label("Summer");
        s.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        hh.getChildren().addAll(s);
        Label sp = new Label("Spring            ");
        sp.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        vh.getChildren().addAll(sp);
        
        Label f = new Label("Fall");
        f.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        vh.getChildren().addAll(f);
        
        pane.add(hh, 0, 4);
        pane.add(vh, 0, 6);
        
        
        
        //Image em1 = null;
		//em1 = new Image(getClass().getClassLoader().getResourceAsStream("img/Spring.jpg"));
        //ImageView emp0 = new ImageView(em1);
        ImageView emp0 = createSceneImage(0.5,0,0,0);

        emp0.setFitWidth(200);
        emp0.setFitHeight(200);
        
        h1.getChildren().addAll(emp0);
        
        pane.add(h1, 0, 3);
        
        HBox h2 = new HBox();
        
        //Image emp2 = null;
		//emp2 = new Image(getClass().getClassLoader().getResourceAsStream("img/summer.jpg"));
        //ImageView emp21 = new ImageView(emp2);
        ImageView emp21 = createSceneImage(0.3,0.2,0.8,0);

        emp21.setFitWidth(200);
        emp21.setFitHeight(200);
        
        h2.getChildren().addAll(emp21);
        
        //Image emp23 = null;
		//emp23 = new Image(getClass().getClassLoader().getResourceAsStream("img/summer.jpg"));
        //ImageView emp3 = new ImageView(emp23);
        ImageView emp3 = createSceneImage(0,0.2,0.3,0);

        emp3.setFitWidth(200);
        emp3.setFitHeight(200);
        
        h2.getChildren().addAll(emp3);
        pane.add(h2, 0, 5);
        
        Button next = new Button("Next Page");
        pane.add(next, 3, 4);
        
        Scene sc = new Scene(pane,view.canvasWidth,view.canvasHeight);
        
        
        next.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            	Controller controller = new Controller();
            	controller.handleOnPressSceneEight(event, theStage);
            }
		}
		);
				
		return sc;
	}

}