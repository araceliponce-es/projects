/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import tacebook.persistence.ProfileDB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import tacebook.model.Post;
import tacebook.model.Profile;
import tacebook.controller.ProfileController;

/**
 * vista
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileView {

    private ProfileController myController;
    SimpleDateFormat formatter;

    private int postsShown = 10;

    /**
     *
     * @param myController
     */
    public ProfileView(ProfileController myController) {
        this.myController = myController;
    }

    /**
     * obtiene el numero de posts mostrados
     *
     * @return
     */
    public int getPostsShown() {
        return postsShown;
    }

    /**
     * establece el numero de posts mostrados
     *
     * @param postsShown
     */
    public void setPostsShown(int postsShown) {
        this.postsShown = postsShown;
    }

    /**
     * muestra la info del perfil, solo si es el perfil del mismo usuario
     * logueado
     *
     * @param ownProfile
     * @param profile
     */
    private void showProfileInfo(boolean ownProfile, Profile profile) {

        if (ownProfile = true) {

            System.out.println("Nombre: " + profile.getName());
            System.out.println();
            System.out.println("Estado: " + profile.getStatus());
            System.out.println();
            System.out.println("Publicaciones: " + profile.getPosts());
            System.out.println();
            //No hay un metodo en profile para recoger los mensajes y no encuentro donde lo pone en las partes del proyecto
            System.out.println("Comentarios: ");
            System.out.println();
            System.out.println("Solicitudes de amistad: " + profile.getFriendshipRequest());
            System.out.println();
            System.out.println("Amistades: " + profile.getFriends());
            System.out.println();
            System.out.println("");

        }

    }

    /**
     * cambia el status del perfil, solo si es el perfil del mismo usuario
     * logueado
     *
     * @param ownProfile
     * @param scanner
     * @param profile
     */
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

    /**
     * muestra el menu al usuario logueado, de cambiar de perfil o cerrar sesion
     *
     * @param profile
     */
    public void showProfileMenu(Profile profile) {
        showProfileInfo(true, profile);
        System.out.println("¿Cabiar el perfil(1) o cerrar sesión(2)?");
        Scanner scan = new Scanner(System.in);
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

    // FASE 2.6- METODOS
    /**
     * Este método utilizarase cando se pida ao usuario que introduza un número
     * para seleccionar un elemento dunha lista (de publicacións, de mensaxes,
     * de amizades, etc.). Encárgase de pedir un número ao usuario mostrando o
     * texto que recibe en "text", lelo usando o "scanner" e volvelo a pedir
     * repetidamente ata que o valor introducido estea entre 0 e "maxNumber-1".
     * Devolve o número introducido polo usuario. *
     */
    private int selectElement(String text, int maxNumber, Scanner scanner) {
        int numberUser = 0;

        do {

            //pregunta por consola un texto
            System.out.println(text);
            //recibe un numero
            numberUser = scanner.nextInt();
            scanner.nextLine();

        } while (numberUser > 0 && numberUser < maxNumber - 1);

        return numberUser;
    }

    /**
     * Pide o texto para crear unha nova publicación e chama ao controlador para
     * creala. *
     */
    private void writeNewPost(Scanner scanner, Profile profile) {
        // pide el texto?
        System.out.println("ingresa el texto para tu post:");

        //guarda el texto obtenido y crea nuevo post
        String postText = scanner.nextLine();
        myController.newPost(postText, profile);
    }

    /**
     * Pide ao usuario que seleccione unha publicación e que introduza un texto,
     * e chama ao controlador para crear un comentario con ese texto. *
     */
    private void commentPost(Scanner scanner, Profile profile) {

        //selecciona la publicacion del perfil usando el index
        System.out.println("selecciona una publicacion");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine();
        Post selectedPost = profile.getPosts().get(selectedIndex);

        System.out.println("cual es tu comentario?");
        String commentText = scanner.nextLine();

        myController.newComment(selectedPost, commentText);
    }

    /**
     * Pide ao usuario que seleccione unha publicación e chama ao controlador
     * para facer like sobre ela. *
     */
    private void addLike(Scanner scanner, Profile profile) {

        //selecciona la publicacion del perfil usando el index
        System.out.println("Selecciona una publicacion");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine();
        myController.newLike(myController.getShownProfile().getPosts().get(selectedIndex));
    }

    /**
     * Se estamos vendo o propio perfil, pide ao usuario seleccionar unha
     * amizade para establecer ese perfil como perfil a mostrar (chamando ao
     * controlador), e senón volve a poñer o perfil da sesión como perfil a
     * mostrar. O parámetro "ownProfile" é o que indica se estamos vendo o
     * propio perfil da sesión ou o perfil dunha amizade. *
     */
    private void showBiography(boolean ownProfile, Scanner scanner, Profile profile) {
        //si usuario esta en su propio perfil, le pide que eliga a uno de sus amigos para mostrar el perfil de est@

        if (ownProfile) {
            System.out.println("Elige el perfil de cual amigo quieres ver");
            String userText = scanner.nextLine();

            int frienIndex = 0;
            myController.setShownProfile(profile.getFriends().get(frienIndex));
        }

        //si no está en su perfil
        myController.setShownProfile(profile);
    }

    /**
     * Pide o nome dun perfil e chama ao controlador para enviarlle unha
     * solicitude de amizade. *
     */
    private void sendFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            System.out.println("Dime el nombre del perfil que quieres agregar : ");
            String userText = scanner.nextLine();
            myController.newFriendshipRequest(userText);
        }

    }

    /**
     * Pide o número dunha solicitude de amizade e chama ao controlador para
     * aceptala ou rexeitala, en función do que se indique no parámetro
     * "accept". *
     */
    private void proccessFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile, boolean accept) {
        if (ownProfile) {
            System.out.println("Que numero de solicitud quieres atender : ");
            int userInt = scanner.nextInt();

            if (accept) {
                myController.acceptFriendshipRequest(myController.getShownProfile().getFriendshipRequest().get(userInt));
            } else {
                myController.rejectFriendshipRequest(myController.getShownProfile().getFriendshipRequest().get(userInt));
            }

        }
    }

    /**
     * Se estamos vendo o propio perfil, pide ao usuario selecciona un amigo e o
     * texto da mensaxe e chama ao controlador para enviar unha mensaxe. Se
     * estamos vendo o perfil dunha amizade, pide o texto para enviarlle unha
     * mensaxe a ese perfil. *
     */
    private void sendPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            //Si estas en tu propio perfil obtiene el amigo con el index indicado
            System.out.println("Seleciona un amigo : ");
            int userIndex = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Escribe el mensaje para tu amigo : ");
            String msg = scanner.nextLine();
            Profile friend = myController.getShownProfile().getFriends().get(userIndex);
            myController.newMessage(friend, msg);
        } else {
            //Si ya estas sobre el perfil de un amigo entonces ya le mandas el mensaje
            System.out.println("Escribe el mensaje para tu amigo : ");
            String msg = scanner.nextLine();
            myController.newMessage(profile, msg);
        }
    }

    /**
     * Pide ao usuario que seleccione unha mensaxe e a mostra completa, dando as
     * opcións de respondela, eliminala ou simplemente volver á biografia
     * marcando a mensaxe como lida, chamando ao controlador para executar as
     * distintas accións. *
     */
    private void readPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            if (myController.getShownProfile().getMessages().isEmpty()) {
                System.out.println("No tienes mensajes");
            } else {
                System.out.println("Que mensaje quieres leer : ");
                int msgIndex = scanner.nextInt();
                System.out.println(myController.getShownProfile().getMessages().get(msgIndex));
                System.out.println("Que quieres hacer con el mensaje :");
                System.out.println("1.Responder :");
                System.out.println("2.Borrar mensaje :");
                System.out.println("3.Volver al perfil :");
                System.out.println("");
                int selector = scanner.nextInt();
                switch (selector) {
                    case 1 ->
                        sendPrivateMessage(ownProfile, scanner, myController.getShownProfile().getMessages().get(msgIndex).getSourceProfile());
                    case 2 ->
                        myController.deleteMessage(myController.getShownProfile().getMessages().get(msgIndex));
                    case 3 ->
                        myController.setShownProfile(profile);
                    default -> {
                        System.out.println("Mete un numero del menu");
                    }
                }
            }

        }
    }

    /**
     * Pide ao usuario que seleccione unha mensaxe e chama ao controlador para
     * borrala. *
     */
    private void deletePrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        System.out.println("Que mensaje quieres borrar : ");
        int msgIndex = scanner.nextInt();
        myController.deleteMessage(myController.getShownProfile().getMessages().get(msgIndex));
    }

    /**
     * Pide o número de publicacións que se queren visualizar e chamar ao
     * controlador para recargar o perfil. *
     */
    private void showOldPosts(Scanner scanner, Profile profile) {
        System.out.println("Cuantos post quieres mirar ???");
        int numeroPosts = scanner.nextInt();
        this.setPostsShown(numeroPosts);
        setPostsShown(numeroPosts);
        myController.reloadProfile();
    }

    /**
     * Os métodos que se inclúen a partir de aquí, simplemente mostran mensaxes
     * por pantalla e chámanse dende o controlador para informar ao usuario de
     * circunstancias que poden provocar que unha acción non se poida realizar.
     * Neste caso, que un perfil non se atopou (Úsase cando se quere enviar unha
     * solicitude de amizade). *
     */
    public void showProfileNotFoundMessage() {
        System.out.println("No se encontro el perfil");
    }

    /**
     * Informa de que non se pode facer like sobre unha publicación propia. *
     */
    public void showCannotLikeOwnPostMessage() {
        System.out.println("No te puedes dar like a ti mismo egolatra =)");
    }

    /**
     * Informa de que non se pode facer like sobre unha publicación sobre a que
     * xa se fixo like. *
     */
    public void showAlreadyLikedPostMessage() {
        System.out.println("No puedes dar like dos vezes");
    }

    /**
     * Informa de que xa tes amizade con ese perfil.
     *
     *
     * @param profileName
     */
    public void showIsAlreadyFriendMessage(String profileName) {
        System.out.println("Ya eres amigo de : "+profileName);
    }

    /**
     * Informa de que ese perfil xa ten unha solicitude de amizade contigo.
     *
     *
     * @param profileName
     */
    public void showExistsFrienshipRequestMessage(String profileName) {
        System.out.println("Ya le enviaste una solicitud a  : "+profileName);
    }

    /**
     * Informa de que xa tes unha solicitude de amizade con ese perfil.
     *
     *
     * @param profileName
     */
    public void showDuplicateFrienshipRequestMessage(String profileName) {
    }

}
