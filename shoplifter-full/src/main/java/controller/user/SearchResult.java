/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import TO.ProfileTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@ViewScoped
public class SearchResult {

    private List<ProfileTO> friendsReqest = new ArrayList<ProfileTO>();
    private List<ProfileTO> friendsSuggest = new ArrayList<ProfileTO>();
    private List<ProfileTO> foundPeople = new ArrayList<ProfileTO>();

    public SearchResult() {
        friendsReqest.add(new ProfileTO());
        friendsReqest.add(new ProfileTO());
        friendsReqest.add(new ProfileTO());

        friendsSuggest.add(new ProfileTO());

        foundPeople.add(new ProfileTO());
        foundPeople.add(new ProfileTO());
        foundPeople.add(new ProfileTO());
        foundPeople.add(new ProfileTO());
        foundPeople.add(new ProfileTO());
        foundPeople.add(new ProfileTO());
    }

    public List<ProfileTO> getFriendsReqest() {
        return friendsReqest;
    }

    public void setFriendsReqest(List<ProfileTO> friendsReqest) {
        this.friendsReqest = friendsReqest;
    }

    public List<ProfileTO> getFriendsSuggest() {
        return friendsSuggest;
    }

    public void setFriendsSuggest(List<ProfileTO> friendsSuggest) {
        this.friendsSuggest = friendsSuggest;
    }

    public List<ProfileTO> getFoundPeople() {
        return foundPeople;
    }

    public void setFoundPeople(List<ProfileTO> foundPeople) {
        this.foundPeople = foundPeople;
    }
    
}
