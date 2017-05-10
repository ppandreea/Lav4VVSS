

import java.io.IOException;
import java.text.ParseException;

import ui.LaboratoriesUI;

public class App {

    public static void main(String[] args) {
    	LaboratoriesUI view  = new LaboratoriesUI();

        try {
            view.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}