package pkgMain;

import javafx.event.Event;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

/**
 * Controller for {@link SceneDesignGarden}.
 *
 * @author Xinyi Sun
 * @version alpha
 */
public class ViewDesignGardenController {

    private Stage stage;

    /**
     * Must inject a stage
     */
    public ViewDesignGardenController(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        this.stage = stage;
    }
    
    /*public void released(MouseEvent event, GridPane container) {
    	MyImageView n = (MyImageView) event.getSource();

    	
    	double x0 = SceneDesignGarden.RIGHT_CENTER_X, y0 = SceneDesignGarden.RIGHT_CENTER_Y;
    	double x1 = x0 + container.getWidth(), y1 = y0 + container.getHeight();
    	
    	double x = n.getTranslateX(), y = n.getTranslateY();
    	
    	if (x < x0 || x > x1 || y < y0 || y > y1) {
    		n.setTranslateX(0);
    		n.setTranslateY(0);
    		return;
    	}
    	
    	// can add into plants list here
    	  	
    	
    		
    }*/


    public void drag(MouseEvent event, GridPane container) {
        
        MyImageView n = (MyImageView) event.getSource();
        Bounds boundsInLocal = n.getBoundsInParent();
        Bounds curParentBoundsInLocal = n.getParent().getBoundsInParent();
        double curNodeMinX = boundsInLocal.getMinX();
        double curNodeMinY = boundsInLocal.getMinY();
        if (SceneDesignGarden.dragImageViewList.indexOf(n) < 0) {
            n.setOriginMinX(curNodeMinX);
            n.setOriginMinY(curNodeMinY);
            SceneDesignGarden.dragImageViewList.add(n);
           
        }

       
        Bounds boundsInParent = container.getBoundsInParent();
        double minX = boundsInParent.getMinX();
        double mixY = boundsInParent.getMinY();
        n.setOffsetX(curNodeMinX - (minX - curParentBoundsInLocal.getMinX()));
        n.setOffsetY(curNodeMinY - (mixY - curParentBoundsInLocal.getMinY()));
        n.setTranslateX(n.getTranslateX() + event.getX());
        n.setTranslateY(n.getTranslateY() + event.getY());
     
    }
    

    public void setHandlerForDrag(MyImageView iv1, GridPane container) {
        iv1.setOnMouseDragged(event -> drag(event, container));
        iv1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                if (e.getButton() == MouseButton.SECONDARY)
                {
                    iv1.setVisible(false);
                    SceneDesignGarden.dragImageViewList.remove(iv1);
                }
                e.consume();
            }
        });
    }
    
    public void setHandlerForReleased(MyImageView iv1, GridPane container) {
        //iv1.setOnMouseReleased(event -> released(event, container));
    }
}
