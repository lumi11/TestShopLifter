/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import TO.SettingsTO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@ViewScoped
public class Settings implements Serializable {

    private SettingsTO data;

    public Settings() {
        data = new SettingsTO();
    }

    public SettingsTO getData() {
        return data;
    }

    public void setData(SettingsTO data) {
        this.data = data;
    }

    public void dataChanged() {
        return;
    }
}
