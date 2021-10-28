package pkgMain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.print.PrinterJob;
import javafx.embed.swing.SwingFXUtils;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SceneReview implements ViewMaker{
	
	private Stage theStage;
	View view;
	private Shop[] shops = { new Shop("DeWayne's","4585  Turkey Pen Lane","334-464-9750",3),
			new Shop("Countryside Flower Shop Nursery and Garden Center","4008  Hemlock Lane","956-387-6785",5),
			new Shop("Gullo's Garden Center","272  Desert Broom Court","201-694-5845",4),
			new Shop("Yard'n Garden Land","3281  Granville Lane","973-458-2010",5),
			new Shop("Smith's Gardentown","4030  Fire Access Road","336-859-0903",4),
			new Shop("Stauffers of Kissel Hill","305  Platinum Drive","724-812-0350",5),
			new Shop("English Gardens","762  Glenwood Avenue","216-364-5194",3),
			new Shop("Homestead Gardens","108  Jerome Avenue","956-384-1165",5),
			new Shop("Molbak's Garden + Home","1041  Pursglove Court","937-299-4800",3),
			new Shop("American Plant","2374  Marcus Street","256-587-9731",5),
			new Shop("Portland Nursery","2856  New York Avenue","817-979-6345",4),
			new Shop("Hilermann Nursery & Florist","2208  Everette Alley","954-772-6804",5),
			new Shop("Stein's Garden & Home","3780  Devils Hill Road","769-237-3783",5),
			new Shop("Sheridan Nurseries","2053  Luke Lane","580-237-7057",4),
			new Shop("Roger's Gardens","3871  Ventura Drive","831-464-0095",5),
			new Shop("Sam Bridge Nursery & Greenhouses","2015  Red Maple Drive","323-419-0073",5),
			new Shop("Nunan Florist & Greenhouses","4258  Jim Rosa Lane","415-793-0197",5),
			new Shop("Amstrong Garden Centers & Pike Nuerseries","3047  Argonne Street","302-261-4746",4),
			new Shop("Oakland Nurseries","788  Sampson Street","303-607-3338",5),
			new Shop("Alsip Home & Nursery","2942  Burton Avenue","901-674-6155",3),
			new Shop("Ruibal's Plants of Texas","3648  Sycamore Circle","682-214-2348",4),
			new Shop("Sloat Garden Center","696  Metz Lane","857-559-3404",5),
			new Shop("Esposito Garden Center","2806  Chandler Drive","417-741-3629",3),
			new Shop("Gethsemane Garden Center","3537  Stiles Street","412-572-2217",5),
			new Shop("Calloway's Nursery","1502  Rinehart Road","786-364-6408",5),
			new Shop("Sawyer Home & Garden Center","4221  Nash Street","312-956-1900",4),
			new Shop("Petitti Garden Centers","4223  Twin House Lane","417-505-3881",3),
			new Shop("Weston Nurseries","179  Whiteman Street","609-970-3146",5),
			new Shop("Condursos Garden Center","4315  Cheshire Road","203-346-0966",4),
			new Shop("Mulhall's","994  Felosa Drive","325-244-9938",4),
			new Shop("Wannemakers's Home and Garden","4820  New Creek Road","256-855-2502",5),
			new Shop("Ray Wiegand's Nursery","4112  Mudlick Road","509-543-1934",4),
			new Shop("Hillermann Nursery & Florist","1631  Emma Street","806-839-9328",4),
			new Shop("Lukas Nursery & Garden Shop","1475  Whispering Pines Circle","972-416-0573",5)};
	
	/** Must inject a stage */
	public SceneReview(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	@Override
	public Scene getScene() {
		Stage stage = new Stage();
    	
    	GridPane gird = new GridPane();
    	gird.setHgap(20);
        gird.setVgap(20);
    	
    	
    	Label re = new Label("Review");
    	re.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30)); 
    	gird.add(re, 2, 2);
    	
    	/*Image em1 = null;
		em1 = new Image(getClass().getClassLoader().getResourceAsStream("img/images.jpg"));
        ImageView emp0 = new ImageView(em1);

        emp0.setFitWidth(400);
        emp0.setFitHeight(400);
        gird.add(emp0, 2, 3);
    	*/
    	
    	//make sure that the review page's frame is same as sceneDesgin garden, if it template also need to reach same size with the review page(xinyi)
    	GridPane box = new GridPane();
    	if (SceneDesignGarden.rightCenter != null && SceneDesignGarden.rightCenter.getWidth() > 0) {
			box.setMinSize(SceneDesignGarden.rightCenter.getWidth(), SceneDesignGarden.rightCenter.getWidth());
		} else if (SceneTemplate.rightCenter != null && SceneTemplate.rightCenter.getWidth() > 0) {
			box.setMinSize(SceneTemplate.rightCenter.getWidth(), SceneTemplate.rightCenter.getWidth());
		}
    	
    	//box.setMinSize(view.gardenWidth, view.gardenHeight);
    	
    	box.setStyle("-fx-background-color: white;");
    	List<String> plantName = new ArrayList<>();
    	for (MyImageView myImageView : SceneDesignGarden.dragImageViewList) {
    		myImageView.setTranslateX(myImageView.getOffsetX());
    		myImageView.setTranslateY(myImageView.getOffsetY());
    		box.add(myImageView,0,0);
    		//adding plant name to last page
    		if (myImageView.getPlant() != null) {
                plantName.add(myImageView.getPlant().name);
            }
    	}
    	gird.add(box, 2, 3);  
        
        Button save = new Button("Save");
        save.setWrapText(false);
        save.setPrefSize(100, 70);
        save.setFont(Font.font("Times New Roman", FontWeight.BOLD, 12));
        gird.add(save, 5, 1);
        
        save.setOnMousePressed(e -> this.savePage(stage, gird));
        
        VBox v = new VBox();
        Label l1 = new Label("List Of Plants in Gardens");
        l1.setFont(Font.font("Times New Roman", FontWeight.BLACK, 15));
        l1.setAlignment(Pos.TOP_CENTER);
        v.getChildren().addAll(l1);
        
        //ruoxijin
        ObservableList<String> strList = FXCollections.observableList(plantName);
        ListView<String> listView = new ListView<>(strList);
        listView.setItems(strList);
        //listView.setPrefSize(400, 200);
        v.getChildren().addAll(listView);
        
        GridPane g1 = new GridPane();
        g1.setHgap(20);
        g1.setVgap(20);
        int plantSize = SceneDesignGarden.scenePlants.size();
        int plantIdSum = 0;
        for(int i=0;i<plantSize;i++) {
        	v.getChildren().addAll(new Label("Name: "+SceneDesignGarden.scenePlants.get(i).getName()));
        	System.out.println(SceneDesignGarden.scenePlants.get(i).getName());
        	plantIdSum++;
        }
        
        int randomStore = 0;
        try {
        	randomStore = plantIdSum/plantSize;
        	if(randomStore > plantSize) {
        		Random random = new Random(System.currentTimeMillis());
            	randomStore = random.nextInt(10);
        	}
        }catch(ArithmeticException ex) {
        	Random random = new Random(System.currentTimeMillis());
        	randomStore = random.nextInt(10);        
    	}
        
//        Label l2 = new Label("Name_____________");
//        v.getChildren().addAll(l2);
//          
//        Label l3 = new Label("Name_____________");
//        v.getChildren().addAll(l3);
//        
//        Label l4 = new Label("Name_____________");
//        v.getChildren().addAll(l4);
//        
//        Label l5 = new Label("Name_____________");
//        v.getChildren().addAll(l5);
//        
//        VBox v1 = new VBox();
//        
//        Label r = new Label(" ");
//        v1.getChildren().addAll(r);
//        
//        Label l6 = new Label("Name_____________");
//        v1.getChildren().addAll(l6);
//          
//        Label l7 = new Label("Name_____________");
//        v1.getChildren().addAll(l7);
//        
//        Label l8 = new Label("Name_____________");
//        v1.getChildren().addAll(l8);
//        
//        Label l9 = new Label("Name_____________");
//        v1.getChildren().addAll(l9);
//        
//        g1.add(v1, 2, 1);
        
        g1.add(v, 1, 1);
        
        gird.add(g1, 6, 3);
        
        int randomImageMap = 1;
        Random random = new Random(System.currentTimeMillis());
    	
    	
    	ImageView [] imageViewMap = new ImageView[2];
    	
    	for(int i = 0;i<2;i++) {
    		randomStore = random.nextInt(10);
    		randomImageMap = random.nextInt(5)+1;
    		
    		VBox b = new VBox();
            
			if(i == 0) {
				Label sh = new Label("Suggest Shop to Buy");
	            sh.setFont(Font.font("Times New Roman", FontWeight.BLACK, 15));
	            sh.setAlignment(Pos.TOP_CENTER);
	            b.getChildren().addAll(sh);	
    		}
    		
            
            Label a = new Label("Name:"+shops[randomStore].name);
            b.getChildren().addAll(a);
            Label a1 = new Label("Phone:"+shops[randomStore].phone);
            b.getChildren().addAll(a1);
            Label a2= new Label("Address:"+shops[randomStore].address);
            b.getChildren().addAll(a2);
            Label a3 = new Label("Rate:"+shops[randomStore].rateToStars());
            b.getChildren().addAll(a3);
           
            g1.add(b, 1, 2+i);
    		
    		VBox bv = new VBox();
    		Image mapImage = new Image(getClass().getClassLoader().getResourceAsStream("img/"+randomImageMap+".png"));
    		imageViewMap[i] = new ImageView(mapImage);
    		imageViewMap[i].setFitHeight(120);
            imageViewMap[i].setFitWidth(120);
            imageViewMap[i].setPreserveRatio(true);
            
            Label map1 = new Label();
            Label map2 = new Label(" ");
            Label map3 = new Label(" ");
            Label map = new Label("Map");
            map.setFont(Font.font("Times New Roman", FontWeight.BLACK, 25));
            map.setAlignment(Pos.TOP_CENTER);
            bv.getChildren().addAll(map2,map1,map,imageViewMap[i],map3);
            g1.add(bv, 2, 2+i);
    	}

        
//        VBox xv = new VBox();
//        
//        Label d = new Label("Name:__________");
//        xv.getChildren().addAll(d);
//        Label d1 = new Label("Phone:__________");
//        xv.getChildren().addAll(d1);
//        Label d2= new Label("Address:__________");
//        xv.getChildren().addAll(d2);
//        Label d3 = new Label("Rate:*****");
//        xv.getChildren().addAll(d3);
//       
//       g1.add(xv, 1, 3);
//        
//        VBox x = new VBox();
//        
//        Label q = new Label(" ");
//        Label q1 = new Label(" ");
//        Label q2 = new Label(" ");
//        Label q3 = new Label("Map");
//        q3.setFont(Font.font("Times New Roman", FontWeight.BLACK, 25));
//        q3.setAlignment(Pos.TOP_CENTER);
//        
//        x.getChildren().addAll(q1,q3,q2,q);
//        
//        g1.add(x, 2, 3);
        
    	Button print = new Button("Print");
    	print.setWrapText(true);
    	print.setPrefSize(150, 70);
        print.setFont(Font.font("Times New Roman", FontWeight.BLACK, 15));
        print.setAlignment(Pos.TOP_CENTER);
        gird.add(print, 4, 1);
        print.setOnMousePressed(e -> this.printPage(stage));
        
        try {
        	Button backToMainButton = view.mainReview;
        	Controller.backButton = view.mainReview;
            print.setFont(Font.font("Times New Roman", FontWeight.BLACK, 25));
            print.setAlignment(Pos.TOP_CENTER);
            gird.add(backToMainButton, 6, 1);
        }catch(NullPointerException ex) {
        	Button backToMainButton = Controller.backButton;
            print.setFont(Font.font("Times New Roman", FontWeight.BLACK, 25));
            print.setAlignment(Pos.TOP_CENTER);
            gird.add(backToMainButton, 6, 1);
        }
        
        
        
        Scene sc1 = new Scene(gird,1250,900);
        return sc1;
	}

	public void printPage(Stage stage) {
		PrinterJob pJ = PrinterJob.createPrinterJob();

		if ( pJ != null && pJ.showPrintDialog(null)) {
			System.out.println(pJ+"");
		    boolean success = pJ.showPrintDialog(stage);
		    if (success) {
		    	showInformationDialog("Print Successful","Info",AlertType.INFORMATION);
		        pJ.endJob();
		    }else {
		    	showInformationDialog("Error on print","Info",AlertType.ERROR);
		    }
		}else{
			showInformationDialog("There no are available printers","Info",AlertType.WARNING);
		}
	}
	

	public void savePage(Stage stage, GridPane grid) {
	
		WritableImage image = grid.snapshot(new SnapshotParameters(), null);
		
		try {
			
		
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save Garden");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("PNG image",".png"));
			File file = fileChooser.showSaveDialog(stage);
		
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
			showInformationDialog("Garden saved!","Info",AlertType.INFORMATION);
			}catch (IOException e) {
			  
				e.printStackTrace();
				showInformationDialog("Can't save file, make you sure you have permission to save in this directory","Error",AlertType.ERROR);
			}
	
	}
	

	public void showInformationDialog(String message, String title ,AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		
		alert.showAndWait();
	}

}