import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class Scheduler{
    
 public static ArrayList<Talk> makeTalks(String x) throws FileNotFoundException{
  //New array list is created
  ArrayList<Talk> talks = new ArrayList <Talk>();

 try{ 
     //A new file is created, and a scanner is made in order to read the file
        File inputFile = new File(x); 
        Scanner in = new Scanner(inputFile); 

     //Checks to see if there are more lines to go over
      while(in.hasNextLine())
      {
         //looks at the next line of the file
         String line = in.nextLine(); 
          // splits the line wherever there is whitespace and put it into array
         String [] stringSplit = line.split("\\s+");
          //we grab the first element which is the name
         String speaker = stringSplit[0]; 
             if(speaker.length() == 0)
              {
           //If there is no name that is provided, we throw a 
           //NoSuchElementException
                  throw new NoSuchElementException();    
              }
          //For loop goes through each of the characters of the name to make
          //sure that the name only has letters
             for(int i =0; i < speaker.length(); i++)
             {
                 char ch = speaker.charAt(i);
                 if(!(Character.isLetter(ch)))
                 {
          //If the name has anything aside from letters, an exception is thrown
                     throw new IllegalArgumentException();
                 }
             }
         //We grab the next element which is the start time
         String startTime = stringSplit[1];  
         //We convert it from a string to integer
         int convertStart = Integer.parseInt(startTime);
             //Checks to see that the time is not negative or beyond 24 hours
             //If so, an exception is thrown
              if(convertStart < 0 || convertStart >2400)
              {
                  throw new IllegalArgumentException();
              }
         //We grab the last element which is end time and convert it from 
         //a string into an integer
         String endTime = stringSplit[2]; 
         int convertEnd = Integer.parseInt(endTime); 
             if(convertEnd < 0|| convertEnd > 2400)
             {
             //We check to see if the end time is negative or beyond 24 hours.
             //If it is, we throw an exceptiom
             throw new IllegalArgumentException();
             }
         //Talk object is made with the speaker and start and end times
         Talk example = new Talk (speaker, convertStart,convertEnd);
         //Talk object is added to the array list
         talks.add(example);
      
      }
         if(talks.size() == 0)
         {
             //If there is nothing in the array list, then we throw an 
             //exception
             throw new IndexOutOfBoundsException();
         }
         //We close the scanner
           in.close();

 }
   //Exception catched when name is not entered
   catch(NoSuchElementException t){
       System.out.println("A name was not entered for a talk");
   }
   //Exception catched when there is a time that is not entered
   catch(IndexOutOfBoundsException q){
        System.out.println("There may not be a time to schedule");
    }
   //Exception catched when the times are not in the right format
   catch(NumberFormatException a){
        System.out.println("The times dont seem to be properly formatted.");
    }
   //Exception catched when either a name or time was not entered properly
    catch(IllegalArgumentException w){
        System.out.println("Either an invalid time or name was entered");
    }
   //General exception catched when there is no other exception that can be
   //catched, but something is wrong with the text file
    catch(Exception h){
        System.out.println("Something went wrong");
    }
     
    //The array list of the talks is returned
      return talks;
  }
 
    
 public static ArrayList<Talk> scheduleTalks (ArrayList<Talk> y)
 {
     //Array list is made that will hold the talks for the optimal schedule
     ArrayList <Talk> optimizedList = new ArrayList<Talk>();

     try{
        //List is first sorted through the compareTo method
         Collections.sort(y);
         //Add the first talk in the sorted list into the new array list
         optimizedList.add(y.get(0));
         //Go through each talk in the ArrayList Talks, and compare the start
         //time of that talk with the talk in the new list that will contain 
         //the optimal list
         for(int i = 1; i < y.size(); i++)
             {
         if(y.get(i).getStartTime() > optimizedList.get(optimizedList.size()-1)
            .getEndTime())
                {
             //If the talk fits the criteria, the talk is added to the array
             //list that will contain the optimal schedule
              optimizedList.add(y.get(i));  
                }
            }  
         }   
   //Catches a general exception and prints out a message
   catch(Exception e){
       System.out.println("An optimized list could not be made");
   }
   //Optimal schedule is returned
    return optimizedList;
 }
}
