/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 * vista
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileView {

    private ProfileController myController;

    private int postsShown = 10;

    public int getPostsShown() {
        return postsShown;
    }

    public void setPostsShown(int postsShown) {
        this.postsShown = postsShown;
    }

    private void showProfileInfo(boolean ownProfile, Profile profile) {
        ownProfile = true;
        System.out.println("Nombre: " + profile.getName());
        System.out.println();
        System.out.println("Estado: " + profile.getStatus());

    }

    private void changeStatus(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            System.out.println("Ingresa un nuevo estado:");
            String newStatus = scanner.nextLine();
            myController.updateProfileStatus(newStatus);
        } else {
            System.out.println("Sólo puedes cambiar el estado de tu biografía");
            showProfileMenu(profile);
        }
    }

    public void showProfileMenu(Profile profile) {
        showProfileInfo(true, profile);
        System.out.println("¿Cabiar el perfil(1) o cerrar sesión(2)?");
        Scanner scan=new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1:
                changeStatus(true, scan, profile);
                break;
            case 2:
                break;
            default:
                System.out.println("Sólo hay dos opciones 1 o 2, no es tan difícil");
                break;
        }
    }

}
