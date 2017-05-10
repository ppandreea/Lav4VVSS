package main.java;

import java.io.IOException;
import java.text.ParseException;

import main.java.ui.LaboratoriesUI;

public class App {

    public static void main(String[] args) {
    	LaboratoriesUI view  = new LaboratoriesUI();

        try {
            view.run();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}