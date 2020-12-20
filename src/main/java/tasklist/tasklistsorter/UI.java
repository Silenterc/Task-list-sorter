/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasklist.tasklistsorter;

/**
 *
 * @author silenter
 */
import java.util.Scanner;
public class UI {
    private Scanner scanner;
    private TaskList list;
    public UI(Scanner scanner, TaskList list){
        this.scanner = new Scanner (System.in);
        this.list = new TaskList();
    }
    //This starts the UI
    public void start(){
        int i = 1;
                
        System.out.println("Welcome to the task list");
        printCommands();
        while(true){
            System.out.println("What would you like to do?");
            String command = scanner.nextLine();
            if(command.equals("quit")|| command.equals("leave")){
                break;
            }
            if(command.equals("add")){
                //Setting the duration and urgency variables to an impossible value so 
                //if the user does not input their proper value the program will ignore them and
                //the sorting algorithm will put them last
                int dur = 999999999;
                int urg = 6;
                System.out.println("What is the name of the task?");
                String name = scanner.nextLine();
                System.out.println("What is the approximate time to complete the task in minutes?(insert a numerical value only)");
                String duration = scanner.nextLine();
                //Checks whether the input is a number above 0 and then sets the dur variable to the inputted value
                if(isInteger(duration)&& Integer.valueOf(duration)>= 0){
                    dur = Integer.valueOf(duration);
                    
                }
                System.out.println("How urgent is the task on scale of 1-5?" + "\n" + "1 is not very urgent, 5 is very urgent");
                String urgency = scanner.nextLine();
                //If the input is not a number it keeps the urg variable at an impossible value
                if(!(isInteger(urgency))){
                    urg = 6;
                // If the input is between 1 and 5, it sets the urg variable to the inputted value
                }else if(Integer.valueOf(urgency)>= 1 && Integer.valueOf(urgency)<=5){
                    urg = Integer.valueOf(urgency);
                } 
                //Creating a new task and then printing the task 
                Task task = new Task(name);
                task.setTimeToComplete(dur);
                task.setUrgency(urg);
                task.setCount(i);
                i++;
                this.list.add(task);
                System.out.println(task);
                
            }
            if(command.equals("remove")){
                if(this.list.isEmpty()){
                    System.out.println("There are no tasks on your list");
                } else{
                    System.out.println("Those tasks are on your list: ");
                    //Shows available tasks in the order they were added in
                    this.list.printSortedByTimeAdded();
                    System.out.println("Please enter the number of the task you would like to remove: ");
                    String removedNum = scanner.nextLine();
                    //Creating a variable and setting its value to an impossible value
                    int numToRemove = -1;
                   //Checks whether the input is a number, then sets the numToRemove variable to inputted value
                    if(isInteger(removedNum)){
                        numToRemove = Integer.valueOf(removedNum);
                    }
                    //If a task with the corresponding input as its number is on the list, it gets removed
                    if(numberIsOnTheList(numToRemove, this.list)){
                        this.list.remove(numToRemove);
                    }
                }
                
                
                
            }
            if(command.equals("help")){
                printCommands();
                
            }
            if(command.equals("list")||command.equals("sort")){
                if(this.list.isEmpty()){
                    System.out.println("There are no tasks available.");
                } else{
                    System.out.println(getSortOptions());
                
                    
                    String input = scanner.nextLine();
                    // Checks whether the input is a number and if not, it prints an error message
                    if(!(isInteger(input))){
                        System.out.println("Please input a number.");
                        continue;
                    }
                    if(Integer.valueOf(input) == 1){
                        this.list.printSortedByTimeAdded();
                    } else if(Integer.valueOf(input) == 2){
                        this.list.printSortedByDuration();
                    } else if(Integer.valueOf(input) == 3){
                        this.list.printSortedByUrgency();
                    } else if(Integer.valueOf(input) == 4){
                        this.list.printAlphabetically();
                       
                    } else{
                        //Incase the input is a different number than 1-4
                        System.out.println("Use a number between 1 and 4.");
                    }
                }
                
                
            }
            
        }
    }
    //To check if the input is an integer
    public static boolean isInteger(String input){
        try {
            int i = Integer.parseInt(input);
            return true;
            
        } catch(NumberFormatException e ){
            return false;
        }
        
    }
    //To check if the list contains the index of the number provided
    public static boolean numberIsOnTheList(int number, TaskList list){
        if(number<1){
            return false;
        }
        if(list.getSize()>=number){
            return true;
        } else{
            return false;
        }
    }
    public static void printCommands(){
        System.out.println("To add a task type: 'add'");
        System.out.println("To remove a task type: 'remove'");
        System.out.println("To see and sort the tasks type: 'sort' or 'list'");
        System.out.println("To leave this program type: 'quit' or 'leave'");
        System.out.println("To get help with these commands type:'help'");
    }
    public static void printSortingCommands(){
        System.out.println("To sort by time added type: '1'");
        System.out.println("To sort by the time to complete type: '2'");
        System.out.println("To sort by urgency type: '3' ");
        System.out.println("To sort alphabetically type: '4'");
        
    }
    public static String getSortOptions(){
        return "How would you like to sort your list?" + "\n" + "If by the time you have added the tasks to your list type : '1'"
               + "\n"+ "If by the time the tasks take to complete type: '2'" + "\n" + "If by the urgency of the tasks type: '3'" + "\n" + "If alphabetically type: '4'";
        
    }
   
    
}
