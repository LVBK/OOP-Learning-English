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

/**
 *
 * @author Clicia
 */
public class WindowsBehavior {
    private static Double initialX;
    private static Double initialY;
    
    public static void setDragDrop(final Pane p, final Stage s) {        
        p.setOnMousePressed((MouseEvent me) -> {
            if (me.getButton() == MouseButton.PRIMARY) {
                initialX = me.getSceneX();
                initialY = me.getSceneY();
            }
        });
        p.setOnMouseDragged((MouseEvent me) -> {
           if (me.getButton() == MouseButton.PRIMARY) {
                s.getScene().getWindow().setX(me.getScreenX() - initialX);
                s.getScene().getWindow().setY(me.getScreenY() - initialY);
            } 
        });
    }
}
