/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package englishlearning.controls;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 *
 * @author Clicia
 */
public class DataTemplate extends javafx.scene.layout.AnchorPane {

    private String dataType;
    public String getDataType() { return dataType; }
    public void setDataType(String className) {
        try {
            dataClass = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dataType = className;
    }
    
    private Class<?> dataClass;
    public Class<?> getDataClass() { return dataClass; }
    public void setDataClass(Class<?> dataClass) {
        this.dataClass = dataClass;
        this.dataType = dataClass.getCanonicalName();
    }
        
    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }
}