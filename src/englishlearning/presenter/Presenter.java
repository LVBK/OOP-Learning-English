/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package englishlearning.presenter;

/**
 *
 * @author Clicia
 * @param <V>
 * @param <M>
 */
public abstract class Presenter<V, M> {
 
    private M model;
    private V view;
     
    protected V getView() {
        return this.view;
    }
 
    public void setView(V view) {
        if (view == null) {
            throw new NullPointerException("view cannot be null.");
        }
 
        if (this.view != null) {
            throw new IllegalStateException("View has already been set.");
        }
 
        this.view = view;
        
        this.initialize();
    }
 
    public final M getModel() {
        return this.model;
    }
 
    protected final void setModel(M model) {
        if (model == null) {
            throw new NullPointerException("model cannot be null.");
        }
        
        this.model = model;
    }
    
    protected abstract void initialize();
}
