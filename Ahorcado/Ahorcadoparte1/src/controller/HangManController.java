package controller;

import ahorcado.parte1.ui.MainWindow;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author daw1al10
 */
public class HangManController {

    private MainWindow myView;

    public HangManController() {
        myView = new MainWindow(this);
    }

    public void init() {
        myView.init();

    }

}
