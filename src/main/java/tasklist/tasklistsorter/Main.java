package tasklist.tasklistsorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author silenter
 */
import java.util.Scanner;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList list = new TaskList();
        UI ui = new UI(scanner,list);
        ui.start();
 
 }
    
}
