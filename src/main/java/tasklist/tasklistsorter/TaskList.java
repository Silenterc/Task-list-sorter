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
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
public class TaskList {
    private ArrayList<Task>list;
    
    
    public TaskList(){
        this.list = new ArrayList<>();
        
    }
    public void add(Task task){
        this.list.add(task);
        
    }
    public void remove(int index){
        int i = 1;
        for(Task t : this.list ){
            if(i == index){
                this.list.remove(t);
                
                break;
            }
            i++;
            
        }
    }
    public int getSize(){
        return this.list.size();
    }
    //Sorts the list chronologically(task added first is first etc.)
    public void sortbyTimeAdded(){
        Collections.sort(this.list, new Comparator<Task>(){
            //ascending sort
            public int compare(Task first, Task second){
                return Integer.valueOf(first.count).compareTo(second.count);
            }
            
        });
    }
    //Prints the chronologically sorted list
    public void printSortedByTimeAdded(){
        int i = 1;
        this.sortbyTimeAdded();
        for(Task t : this.list){
            System.out.println(i + ", " + t);
        }
    }
    //Prints the list sorted by the duration of the tasks(tasks without a disclosed duration are put last)
    public void printSortedByDuration(){
        Collections.sort(this.list, new Comparator<Task>(){
            //ascending sort
            public int compare(Task first, Task second){
                return Integer.valueOf(first.timeToComplete).compareTo(second.timeToComplete);
            }
            
        });
        this.printList();
       
        
    }
    //Prints the list in an alphabetical order
    public void printAlphabetically(){
        Collections.sort(this.list, new Comparator<Task>(){
            //ascending sort
            public int compare(Task first, Task second){
                return first.getName().compareTo(second.getName());
            }
            
        });
        this.printList();
       
    }
    
    //Prints the list sorted by the urgency of the tasks(tasks without a disclosed urgency are put last)
    public void printSortedByUrgency(){
        Collections.sort(this.list, new Comparator<Task>(){
            //ascending sort
            public int compare(Task first, Task second){
                return Integer.valueOf(first.urgency).compareTo(second.urgency);
            }
            
        });
        this.printList();
       
        
    }
    
    // Checks whether the list is empty
    public boolean isEmpty(){
        if(this.list.isEmpty()){
            return true;
        }
        return false;
    }
    // Prints the list with the appropriate numbering starting from 1
    public void printList(){
        int i = 1;
        for(Task t : this.list){
            System.out.println( i + ", " + t);
            i++;
                    
           
        }
    }
    
}

