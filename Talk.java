import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Talk implements Comparable <Talk> {
 //Instance variables associated with a talk object are declared
     private String speaker = " ";
     private int startTime = 0;
     private int endTime = 0;

      
 public Talk (String s, int t, int e){
   //Talk object is made with the instance variables in the constructor  
     speaker = s;
     startTime = t;
     endTime = e;
 }
     
 //Compare to method is made 
 public int compareTo(Talk y){
     //End times are compared
     if(this.endTime < y.endTime)
     {
         return -1;
     }
     
     else if(this.endTime > y.endTime)
     {
         return 1;
     } 
     //If end times are the same, then the start times are compared
     else if(this.endTime == y.endTime)
     {
         if(this.startTime > y.startTime)
         {
             return 1;
         }   
         else if(this.startTime < y.startTime)
         {
             return -1;
         }
     }
          return 0;
         
 }
    //Returns the speaker, startTime, and endTime in the form of a string
    public String toString(){
       return speaker + " "+ startTime + " " + endTime;
    }
    //Returns the start time
    public int getStartTime(){
        return startTime;
    }
    //Returns the end time
    public int getEndTime(){
        return endTime;
    }
  }
