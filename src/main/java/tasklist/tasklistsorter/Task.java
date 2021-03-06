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

public class Task   {
    public String name;
    public int timeToComplete;
    public int urgency;
    public int count;
    public Task(String name){
        this.name = name;
        this.timeToComplete = 999999999;
        this.urgency = 6;
        this.count = 0;
    }
    public String getName(){
        return this.name;
    }

    
    public void setName(String name) {
        this.name = name;
    }


    public int getTimeToComplete() {
        return this.timeToComplete;
    }


    public void setTimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }


    public int getUrgency() {
        return urgency;
    }

    
    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }
    public void setCount(int count){
        this.count = count; 
    }
    public int getCount(){
        return this.count;
    }
    // A tool to get the right grammatical form of "minute" 
    public static String getMinutes(int time){
        if(time == 1){
            return String.valueOf(time) + " minute";
        } else{
            return String.valueOf(time) + " minutes";
        }
    
    }
    
    
    
    @Override
    public String toString(){
        if(this.urgency >= 0 && this.urgency <= 5 && this.timeToComplete >= 0 && !(this.timeToComplete == 999999999)){
            return this.name + ", which takes " + getMinutes(this.timeToComplete) + " and is at urgency " + this.urgency;
        } else if(this.urgency>= 0 && this.urgency<=5 && (this.timeToComplete<0 || this.timeToComplete == 999999999)){
            return this.name + " which is at urgency " + this.urgency;
        } else if(this.timeToComplete>= 0 && !(this.timeToComplete == 999999999) && (this.urgency<0 || this.urgency > 5)){
            return this.name + ", which takes " + getMinutes(this.timeToComplete);
        } else{
            return this.name;
        }
        
    }
    
    
   
  
   
    
    
            
            
            
    
    
    
    
}
