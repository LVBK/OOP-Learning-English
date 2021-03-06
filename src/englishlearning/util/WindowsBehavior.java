/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package englishlearning.util;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Clicia
 */
public class WindowsBehavior {
    private static Double __initialX;
    private static Double __initialY;
    
    public static void setDragDrop(final Pane p, final Stage s) {        
        p.setOnMousePressed((MouseEvent me) -> {
            if (me.getButton() == MouseButton.PRIMARY && !s.isMaximized()) {                
                __initialX = me.getSceneX();
                __initialY = me.getSceneY();
            }
        });
        p.setOnMouseDragged((MouseEvent me) -> {
            if (me.getButton() == MouseButton.PRIMARY && !s.isMaximized()) {
                s.getScene().getWindow().setX(me.getScreenX() - __initialX);
                s.getScene().getWindow().setY(me.getScreenY() - __initialY);
            }
        });
    }
    
    public static void setWindowSize(Window window, Double width, Double height) {        
        window.setWidth(width);
        window.setHeight(height);
        
        window.centerOnScreen();
    }
}
