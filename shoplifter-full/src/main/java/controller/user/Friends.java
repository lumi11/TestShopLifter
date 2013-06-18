/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import TO.ProfileTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@ViewScoped
public class Friends implements Serializable {

    private List<ProfileTO> userFriends = new ArrayList<ProfileTO>();
    private List<ProfileTO> friendRequests = new ArrayList<ProfileTO>();
    private List<ProfileTO> friendsSuggest = new ArrayList<ProfileTO>();

    /*@ManagedProperty(value = "#{user.searching}")
     private String serarching;*/
    @PostConstruct
    public void init() {

        userFriends.add(new ProfileTO());
        userFriends.add(new ProfileTO());
        userFriends.add(new ProfileTO());
        friendRequests.add(new ProfileTO());
        friendRequests.add(new ProfileTO());
        friendRequests.add(new ProfileTO());
        friendRequests.add(new ProfileTO());
        friendsSuggest.add(new ProfileTO());
    }

    public List<ProfileTO> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(List<ProfileTO> userFriends) {
        this.userFriends = userFriends;
    }

    public List<ProfileTO> getFriendRequests() {
        return friendRequests;
    }

    public void setFriendRequests(List<ProfileTO> friendRequests) {
        this.friendRequests = friendRequests;
    }

    public List<ProfileTO> getFriendsSuggest() {
        return friendsSuggest;
    }

    public void setFriendsSuggest(List<ProfileTO> friendsSuggest) {
        this.friendsSuggest = friendsSuggest;
    }

    public String reqestFriendship(Long userId) {
        return "searchFriends";
    }
}
