import java.io.*;
import java.util.*;

/*
* A program that generates an army list for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class listBuilder {

   static Scanner scan = new Scanner(System.in);
   
   //Array list to hold all created units throughout program.
   static ArrayList<String> createdUnits = new ArrayList<String>();

   //Strings for user inputs.
   static String race = "";
   static String battleRole = "";
   static String reply = "";
   static String reply2 = ""; 

//Main method for class listBuilder
   public static void main(String[] args) {
      
      System.out.println();
      System.out.println();
      System.out.println("Choose an army race:");
      race = scan.nextLine();
      
      //Calls unitCreate method and cycles through creation questions.
      unitCreate();

      try {
      System.out.println();
      System.out.println("Are you finished creating your army? (yes/no)");

      //User either finishes creating list or adds more input.
      reply2 = scan.nextLine();
      
      if(reply2.equalsIgnoreCase("yes")) {

         /*Calls createList method that exports to a 
         *text document with a summary of all created units and stats.*/
         createList(); 
         scan.close();
         System.exit(0);
      }
      else {

          //Calls unitCreate method and cycles through creation questions.
         unitCreate();
      }
   }
   catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n");
      ex.printStackTrace();
      System.exit(0);
   }
   }

   //Method to manually capitalize first letter in a string.
   public static String capitalizeString(String input) {
   String firstLetter = input.substring(0, 1);
   String firstLetterCapitalized = firstLetter.toUpperCase();
   String remainingString = input.substring(1);
   String finalString = firstLetterCapitalized + remainingString;
      return finalString;
   }

    /*
    * Method for getting total army points.
    * @return returns totalArmyPoints.
    */
    public static int getTotalArmyPoints() {

      //This int holds all combined points from each unit.
      int totalArmyPoints = HQ.getHqTotalPointVal() + troops.getTroopsTotalPointVal() + elites.getElitesTotalPointVal() 
                          + fastAttack.getFastAttackTotalPointVal() + heavySupport.getHeavySupportTotalPointVal() 
                          + dedicatedTransport.getDedicatedTransportTotalPointVal() + flyer.getFlyerTotalPointVal() 
                          + fortification.getFortificationTotalPointVal() + lordOfWar.getLordOfWarTotalPointVal();
      return totalArmyPoints;
   }

       //Method that exports to a text document with a summary of all created units and stats.
       public static void createList() {
         StringBuilder temporaryList = new StringBuilder();
         
         //For loop that appends each units created string to be added to txt file.
         for (String value : createdUnits) {
            temporaryList.append(value);
         }
         
         String completedList = temporaryList.toString();
      
         //Adds a filewriter and writes all entered info from the user to a txt file to used.
         try {
            File file = new File("New " + capitalizeString(race) + " Army List.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("** " + capitalizeString(race) + " Army List **" + "\n"
               + "   Unit count / Total pts: " + unitBuilder.getTotalUnitCount() + " / "
               + "[" + getTotalArmyPoints() + "pts]" + "\n"
               + "-----------------------------------------------------------"
               + "\n" + "\n" + completedList);
            fw.close();
            System.out.println("Successfully generated file in:" + "\n"
            + file.getAbsolutePath() + "\n" + "\n");
         }

         //Exception in case the filewriter cannot write to file or other error occurs.
         catch (IOException ex) {
            System.out.println("\n" + "An error occurred." + "\n");
            ex.printStackTrace();
            System.exit(0);
         }
       }

   //Method for creating units.
   public static void unitCreate() {
      try {
        System.out.println();
        System.out.println("Choose a battlefield role? (yes/no)");
        reply = scan.nextLine();
           
        if (reply.equalsIgnoreCase("no")) {
         try {
            System.out.println();
            System.out.println("Are you finished creating your army? (yes/no)");
      
            //User either finishes creating list or adds more input.
            reply2 = scan.nextLine();
            System.out.println();
            
            if(reply2.equalsIgnoreCase("yes")) {
      
               /*Calls createList method that exports to a 
               *text document with a summary of all created units and stats.*/
               createList(); 
               scan.close();
               System.exit(0);
            }
            else {
      
                //Calls unitCreate method and cycles through creation questions.
               unitCreate();
            }
         }
         catch (Exception ex) {
            System.out.println("\n" + "An error occurred." + "\n");
            ex.printStackTrace();
            System.exit(0);
         }
      }
      
      //While loop for getting multiple unit creations, will terminate if user inputs "no".
       while(reply.equalsIgnoreCase("yes")) {

           System.out.println();
           System.out.println("Options: HQ, Troops, Elites, Fast Attack," + "\n"
                                     + "         Heavy Support, Dedicated Transport," +"\n"
                                     + "         Flyer, Fortification, Lord of War");
           System.out.println();
           System.out.println("Choose from options above.");
           battleRole = scan.nextLine();
        
           //This if-else-if statement will call each appropriate method for selected battleRole.
           if(battleRole.equalsIgnoreCase("HQ")) {
              HQ.hqChoice.pickedHq();   
            }
           else if (battleRole.equalsIgnoreCase("Troops")) {
              troops.troopsChoice.pickedTroops();
           }
           else if (battleRole.equalsIgnoreCase("Elites")) {
              elites.elitesChoice.pickedElites();
           }
           else if (battleRole.equalsIgnoreCase("Fast Attack")) {
              fastAttack.fastAttackChoice.pickedFastAttack();
           }
           else if (battleRole.equalsIgnoreCase("Heavy Support")) {
              heavySupport.heavySupportChoice.pickedHeavySupport();
           }
           else if (battleRole.equalsIgnoreCase("Dedicated Transport")) {
              dedicatedTransport.dedicatedTransportChoice.pickedDedicatedTransport();
           }
           else if (battleRole.equalsIgnoreCase("Flyer")) {
              flyer.flyerChoice.pickedFlyer();
           }
           else if (battleRole.equalsIgnoreCase("Fortification")) {
              fortification.fortificationChoice.pickedFortification();
           }
           else if (battleRole.equalsIgnoreCase("Lord of War")) {
              lordOfWar.lordOfWarChoice.pickedLordOfWar();
        }
      
           /*Repeats question to reenter or exit while loop.
            * If user enters "no" will jump out of loop and 
            * back into main method to create the finalized list.*/
           System.out.println();
           System.out.println("Choose another battlefield role? (yes/no)");
           reply = scan.nextLine(); 
      }
   }
   catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n");
      ex.printStackTrace();
      System.exit(0);
   }
     } 
}