package pkgMain;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * The custom JavaFX select component can support both the selection function and the input box function
 */
public class Select {

     double y_diff = 30;

     Pane selectPane;


     String[] datas;

     List<Pane> panes = new ArrayList<>();

    /**
     *
     * @param p
     * @param datas
     */
    public Select(Pane p, String[] datas) {
        this(p,datas,100,p.getLayoutX(),p.getLayoutY()+30);
    }

    /**
     *
     * @param p
     * @param datas
     * @param width
     * @param x
     * @param y
     */
    public Select(Pane p, String[] datas,double width,double x, double y) {
        selectPane = new Pane();
        selectPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        selectPane.setPrefWidth(width);
        selectPane.setLayoutX(x);
        selectPane.setLayoutY(y);
        this.datas = datas;
        init();
        p.getChildren().add(selectPane);
        selectPane.setVisible(false);
        selectPane.setManaged(false);
    }

    /**
     * Sets the width of a single selection box
     * @param width
     */
    public  void setW(double width){
        selectPane.setPrefWidth(width);
        for(Pane p:panes){
            p.setPrefWidth(width);
        }
    }


    /**
     * Sets the height of a single selection box
     * @param height
     */
    public  void setH(double height){
        selectPane.setPrefHeight(height);
    }

    /**
     * Set the coordinates of a single selection box
     * @param x
     * @param y
     */
   public void setPos(double x,double y){
          selectPane.setLayoutX(x);
          selectPane.setLayoutY(y);
   }

    /**
     * Set the mouse to move into the display input box
     * @param p
     */
    public  void setShowEle(Node p){
        p.setOnMouseClicked(e->{
            show();
        });
//        p.setOnMouseExited(e->{
//            hide();
//        });
    }

    /**
     * display input box components
     */
    public  void show(){
        selectPane.setVisible(true);
        selectPane.setManaged(true);
    }

    /**
     * hide input box components
     */
    public  void hide(){
        selectPane.setVisible(false);
        selectPane.setManaged(false);
    }

    /**
     * Initialize all tag data
     */
    public  void init(){
        setClick((e)->{
            Label l = (Label) e.getSource();
            System.out.println(l.getText());
        });
    }


    /**
     * Set click callback event
     * @param clickEh
     */
    public void setClick(EventHandler clickEh){
         double init_y = 0;
         int len = datas.length;
         double width = selectPane.getPrefWidth();
         selectPane.setPrefHeight(y_diff*(datas.length)+10);
         for(int i=0;i<len;i++){
             Pane p = new Pane();
             panes.add(p);
             p.setPrefWidth(selectPane.getPrefWidth());
             Label label = new Label(datas[i]);
             p.setPrefHeight(y_diff);
             p.setLayoutY(init_y+y_diff*i);
             p.setCursor(Cursor.HAND);
             label.setLayoutY(p.getPrefHeight()/3);
             label.setLayoutX((width-50)/2);
             label.setOnMouseEntered((e)->{
                 Label l = (Label) e.getSource();
                 Pane pa = (Pane) l.getParent();
                 l.setStyle("-fx-color: white");
                 pa.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE,null,null)));
             });
             label.setOnMouseExited((e)->{
                 Label l = (Label) e.getSource();
                 Pane pa = (Pane) l.getParent();
                 l.setStyle("-fx-color: black");
                 pa.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
             });
             label.setOnMouseClicked((e)->{
                  clickEh.handle(e);
                   hide();
             });
             p.getChildren().add(label);
             selectPane.getChildren().add(p);
         }
     }



















}
