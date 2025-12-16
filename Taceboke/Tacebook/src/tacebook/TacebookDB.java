/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1al10
 */
public class TacebookDB {

    public ArrayList<Message> messages = new ArrayList<>();
    public ArrayList<Profile> profiles = new ArrayList<>();

    public TacebookDB() {
        
            profiles.add(new Profile("a","a","a"));

    }

    
    
    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }
}
