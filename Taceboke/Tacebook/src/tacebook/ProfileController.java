/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * controlador
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileController {

    private Profile sessionProfile;
    private ProfileView view;

    public Profile getSessionProfile() {
        return sessionProfile;
    }

    public void setSessionProfile(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
    }

    public ProfileView getView() {
        return view;
    }

    public void setView(ProfileView view) {
        this.view = view;
    }
    

    public ProfileController(Profile sessionProfile, ProfileView view) {
        this.sessionProfile = sessionProfile;
        this.view = view;
    }


    //actualiza los datos que se muestran
    public void updateProfileStatus(String newStatus){}

    public int getPostsShown() {
        return 0;
    }
    public void reloadProfile(){}
    public void openSession(Profile sessionProfile){}
    
    

}
