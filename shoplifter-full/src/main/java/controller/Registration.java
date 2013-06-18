/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import TO.UserTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@SessionScoped
public class Registration {

    private String friendsSerachField;
    private List<UserTO> searchResult = new ArrayList<UserTO>();
    private RegistrationStep registrationStep;

    public Registration() {
        registrationStep = RegistrationStep.findFriends;
    }


    public String getFriendsSerachField() {
        return friendsSerachField;
    }

    public void setFriendsSerachField(String friendsSerachField) {
        this.friendsSerachField = friendsSerachField;
    }

    public List<UserTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<UserTO> searchResult) {
        this.searchResult = searchResult;
    }

    public int getRegistrationStep() {
        switch (registrationStep) {
            case addOrder:
                return 1;
            case findFriends:
                return 2;
            case promiseOrder:
                return 3;
            default:
                return 0;
        }
    }
    
    
}
