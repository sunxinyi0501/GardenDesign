package pkgMain;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller for {@link ViewTwo}.
 * Ruoxi Jin

 */
public class ViewDragFlowersController {

    private Stage stage;

    /** Must inject a stage */
    public ViewDragFlowersController(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        this.stage = stage;
        
    }


    public void drag(MouseEvent event, Pane container) {
        MyImageView n = (MyImageView) event.getSource();
        Bounds boundsInLocal = n.getBoundsInParent();
        Bounds curParentBoundsInLocal = n.getParent().getBoundsInParent();
        double curNodeMinX = boundsInLocal.getMinX();
        double curNodeMinY = boundsInLocal.getMinY();
        //drag flower
        if (SceneDesignGarden.dragImageViewList.indexOf(n) < 0) {
        	 n.setOriginMinX(curNodeMinX);
             n.setOriginMinY(curNodeMinY);
             SceneDesignGarden.dragImageViewList.add(n);
             if (n.getExpandHeight() != 0 && n.getExpandHeight() != 0) {
                 n.setFitWidth(n.getExpandHeight());
                 n.setFitHeight(n.getExpandHeight());
             }
        }
        Bounds boundsInParent = container.getBoundsInParent();
        double minX = boundsInParent.getMinX();
        double mixY = boundsInParent.getMinY();
        n.setOffsetX(curNodeMinX - (minX - curParentBoundsInLocal.getMinX()) + 20);
        n.setOffsetY(curNodeMinY - (mixY - curParentBoundsInLocal.getMinY()) + 20);
        n.setTranslateX(n.getTranslateX() + event.getX());
        n.setTranslateY(n.getTranslateY() + event.getY());
    }
  // remove plants
    public void setHandlerForDrag(MyImageView iv1, Pane container) {
    	iv1.setOnMouseDragged(event -> drag(event, container));
    	iv1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
        {
            
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
}
