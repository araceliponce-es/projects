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

    private Profile model;
    private ProfileView view;

    public ProfileController(Profile model, ProfileView view) {
        this.model = model;
        this.view = view;
    }

    //no son los getters y setters predeterminados de netbeans
    public void setProfileName(String name) {
        model.setName(name);
    }

    public String getProfileName() {
        return model.getName();
    }

    public void setProfileStatus(String status) {
        model.setStatus(status);
    }

    public String getProfileStatus() {
        return model.getStatus();
    }
    //fin-----------

    //actualiza los datos que se muestran
    public void updateView() {
        view.printProfileDetails(model.getName(), model.getStatus());
    }

}
