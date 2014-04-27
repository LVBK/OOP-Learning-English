/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package englishlearning.presenter;

import englishlearning.model.UsersList;
import englishlearning.util.DataInDisk;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Clicia
 */
public class Login extends Presenter {
    @FXML TextField username;
    
    //<editor-fold defaultstate="collapsed" desc="Property isLoged">
    private final BooleanProperty isLoged = new SimpleBooleanProperty(this, "isLoged", false);;
    public final Boolean getIsLoged() { return isLoged.get(); }
    public final void setIsLoged(Boolean value) { isLoged.set(value); }
    public final BooleanProperty isLogedProperty() { return isLoged; }
//</editor-fold>
    
    private final UsersList users;
    
    public Login() {
        loadFXML();
        
        users = DataInDisk.getUsersList();
        TextFields.bindAutoCompletion(username, users);
        
        isLogedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            users.add(getUsername());
            DataInDisk.saveUsersList(users);
        });
    }
    
    public final void onLogin(ActionEvent event) {
        if (!getUsername().equals("")) setIsLoged(true);
    }
    
    public final String getUsername() {
        return username.getText();
    }
}