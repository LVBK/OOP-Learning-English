/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package englishlearning.presenter;

import englishlearning.model.UserInfo;
import englishlearning.model.wrapper.UserWrapper;
import englishlearning.model.wrapper.WrapperProperty;
import englishlearning.util.DataInDisk;

/**
 *
 * @author Clicia
 */
public class MainContent extends Controller {    
    //<editor-fold defaultstate="collapsed" desc="Property User">
    private WrapperProperty<UserWrapper<UserInfo>> user;
    public final UserWrapper<UserInfo> getUser() { return userProperty().get(); }
    protected final void setUser(UserWrapper<UserInfo> value) { userProperty().set(value); }
    public final WrapperProperty<UserWrapper<UserInfo>> userProperty() { 
        if (user == null) user = new WrapperProperty(this, "user");
        return user; 
    }
    public void raiseUserPropertyChange() {
        userProperty().fireValueChangedEvent();
    }
//</editor-fold>    
    
    public void setUser(String username) {
        UserWrapper<UserInfo> userwrapper = new UserWrapper(DataInDisk.getUserInfo(username));
        setUser(userwrapper);
        
        if (userwrapper.getRawData().playState == null) {
        
        } else {
        //TODO: resume play state
        }
    }
}
