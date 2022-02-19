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
   
   //Objects created by other classes in file to hold each unit's info.
   static HQ hqChoice = new HQ("", "", "", "", "", 0, 0);   
   static troops troopsChoice = new troops("", "", "", "", "", 0, 0);
   static elites elitesChoice = new elites("", "", "", "", "", 0, 0);
   static fastAttack fastAttackChoice = new fastAttack("", "", "", "", "", 0, 0);
   static heavySupport heavySupportChoice = new heavySupport("", "", "", "", "", 0, 0);
   static dedicatedTransport dedicatedTransportChoice = new dedicatedTransport("", "", "", "", "", 0, 0);
   static flyer flyerChoice = new flyer("", "", "", "", "", 0, 0);
   static fortification fortificationChoice = new fortification("", "", "", "", "", 0, 0);
   static lordOfWar lordOfWarChoice = new lordOfWar("", "", "", "", "", 0, 0);
   
   static int hqTotalPointVal;
   static int troopsTotalPointVal;
   static int elitesTotalPointVal;
   static int fastAttackTotalPointVal;
   static int heavySupportTotalPointVal;
   static int dedicatedTransportTotalPointVal;  
   static int flyerTotalPointVal;
   static int fortificationTotalPointVal;
   static int lordOfWarTotalPointVal;
   
   static String race = "";
   static String battleRole = "";
   static String reply = "";
   static String reply2 = ""; 
   static String response = "";

//Main method for class listBuilder
   public static void main(String[] args) {

      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("Choose an army race:");

      race = scan.nextLine();
      System.out.println();
      
      //Calls unitCreate method and cycles through creation questions.
      unitCreate();
      
      System.out.println();
      System.out.println("Are you finished creating your army? (yes/no)");

      //User either finishes creating list or adds more input.
      reply2 = scan.nextLine();
      System.out.println();
      
      if(reply2.equalsIgnoreCase("yes")) {

         /*Calls createList method that exports to a 
         *text document with a summary of all created units and stats.*/
         createList(); 
      }
      else {

          //Calls unitCreate method and cycles through creation questions.
         unitCreate();
      }
   }

       /*
    * Method for getting total army points.
    * @return returns totalArmyPoints.
    */
    public static int getTotalArmyPoints() {

      //This int holds all combined points from each unit.
      int totalArmyPoints = hqTotalPointVal 
         + troopsTotalPointVal
         + elitesTotalPointVal 
         + fastAttackTotalPointVal 
         + heavySupportTotalPointVal
         + dedicatedTransportTotalPointVal 
         + flyerTotalPointVal 
         + fortificationTotalPointVal 
         + lordOfWarTotalPointVal;
      return totalArmyPoints;
   }
   
   //Method for creating units.
   static void unitCreate() {
      try {
        System.out.println("Do you want to choose a battlefield role? (yes/no)");
        reply = scan.nextLine();
           
          //While loop for getting multiple unit creations, will terminate if user inputs "no".
       while(reply.equalsIgnoreCase("yes")) {
           System.out.println();
           System.out.println("Options:" + "\n" 
            + "HQ" + "\n" 
            + "Troops" + "\n"
            + "Elites" + "\n"
            + "Fast Attack" + "\n"
            + "Heavy Support" + "\n"
            + "Dedicated Transport" + "\n"
            + "Flyer" + "\n" 
            + "Fortification" + "\n"
            + "Lord of War" );

           System.out.println();
           System.out.println("Choose a battlefield role from the options above.");
           battleRole = scan.nextLine();
           System.out.println();
        
           //This if-else-if statement will call each appropriate method for selected battleRole.
           if(battleRole.equalsIgnoreCase("HQ")) {
              pickedHq();   
            }
           else if (battleRole.equalsIgnoreCase("Troops")) {
              pickedTroops();
           }
           else if (battleRole.equalsIgnoreCase("Elites")) {
              pickedElites();
           }
           else if (battleRole.equalsIgnoreCase("Fast Attack")) {
              pickedFastAttack();
           }
           else if (battleRole.equalsIgnoreCase("Heavy Support")) {
              pickedHeavySupport();
           }
           else if (battleRole.equalsIgnoreCase("Dedicated Transport")) {
              pickedDedicatedTransport();
           }
           else if (battleRole.equalsIgnoreCase("Flyer")) {
              pickedFlyer();
           }
           else if (battleRole.equalsIgnoreCase("Fortification")) {
              pickedFortification();
           }
           else if (battleRole.equalsIgnoreCase("Lord of War")) {
              pickedLordOfWar();
        }
         
           /*Repeats question to reenter or exit while loop.
            * If user enters "no" will jump out of loop and 
            * back into main method to create the finalized list.*/
           scan.nextLine();
           System.out.println("Do you want to choose another battlefield role? (yes/no)");
           reply = scan.nextLine();
         }
      }
      catch (Exception ex) {
         System.out.println("An error occurred. Please only enter (yes/no)");
         ex.printStackTrace();
      }
     } 
   
        //Method that exports to a text document with a summary of all created units and stats.
        static void createList() {
           StringBuilder completedList = new StringBuilder();
           
           //For loop that appends each units created string to be added to txt file.
           for (String value : createdUnits) {
              completedList.append(value + "\n" + "\n");
           }
           
           String finalCompletedList = completedList.toString();
        
           //Adds a filewriter and writes all entered info from the user to a txt file to used.
           try {
              File file = new File("New " + race + " Army List.txt");
              FileWriter fw = new FileWriter(file);
              fw.write(race + " Army List" + "\n" + "\n"
                 + "Total unit count: " + unitBuilder.getTotalUnitCount() + "\n"
                 + "Total army points: " + getTotalArmyPoints() + "\n" + "\n"
                 + "-----------------------------------------------------------"
                 + "\n" + finalCompletedList);
              fw.close();
              System.out.println("Successfully generated file in:" + "\n"
              + file.getAbsolutePath());
           }
           //Exception in case the filewriter cannot write to file or other error occurs.
           catch (IOException ex) {
              System.out.println("An error occurred.");
              ex.printStackTrace();
           }
         }
 
   //Method that gathers all necessary HQ info.
   static void pickedHq() {

        	    /*Total unit count will only increase
             by 1 if this type of unit is created.*/
             unitBuilder.increaseTotalUnitCount();

             System.out.println("Make a HQ choice: ");
             hqChoice.unitName = scan.nextLine();
             hqChoice.battleRole = "HQ";
             System.out.println();
             System.out.println("Enter number of models in the unit.");
             hqChoice.numInUnit = scan.nextInt();

             System.out.println();
             System.out.println("Enter number of points per model.");
             hqChoice.pointVal = scan.nextInt();

             System.out.println();
             scan.nextLine();
             System.out.println("Any special weapons? (yes/no)");
             response = scan.nextLine();

             if (response.equalsIgnoreCase("yes")) {
                System.out.println("Enter special weapons:");
                hqChoice.specialWeapons = scan.nextLine();
             }

             System.out.println();
             System.out.println("Any upgrades? (yes/no)");
             response = scan.nextLine();

             if (response.equalsIgnoreCase("yes")) {
               System.out.println("Enter upgrades:");
               hqChoice.upgrades = scan.nextLine();
            }

             System.out.println();
             System.out.println("Any remarks? (yes/no)");
             response = scan.nextLine();

             if (response.equalsIgnoreCase("yes")) {
               System.out.println("Enter remarks:");
               hqChoice.remarks = scan.nextLine();
            }

             createdUnits.add(hqChoice.toString());
             hqTotalPointVal = hqChoice.numInUnit * hqChoice.pointVal;
             System.out.println();
   }

   //Method that gathers all necessary Troops info.
   static void pickedTroops() {

               /*Total unit count will only increase
               by 1 if this type of unit is created.*/
               unitBuilder.increaseTotalUnitCount();
           
               System.out.println("Make a troops choice:");
               troopsChoice.unitName = scan.nextLine();
               troopsChoice.battleRole = "Troops";
               System.out.println();
               System.out.println("Enter number of models in the unit.");
               troopsChoice.numInUnit = scan.nextInt();
               System.out.println();
               System.out.println("Enter number of points per model.");
               troopsChoice.pointVal = scan.nextInt();
               createdUnits.add(troopsChoice.toString());
               troopsTotalPointVal = troopsChoice.numInUnit * troopsChoice.pointVal;
               System.out.println();
   }

   //Method that gathers all necessary Elites info.
   static void pickedElites() {

               /*Total unit count will only increase
               by 1 if this type of unit is created.*/
               unitBuilder.increaseTotalUnitCount();

               System.out.println("Make an elites choice:");
               elitesChoice.unitName = scan.nextLine();
               elitesChoice.battleRole = "Elites";
               System.out.println();
               System.out.println("Enter number of models in the unit.");
               elitesChoice.numInUnit = scan.nextInt();
               System.out.println();
               System.out.println("Enter number of points per model.");
               elitesChoice.pointVal = scan.nextInt();
               createdUnits.add(elitesChoice.toString());
               elitesTotalPointVal = elitesChoice.numInUnit * elitesChoice.pointVal;
               System.out.println();
   }


   //Method that gathers all necessary Fast Attack info.
   static void pickedFastAttack() {

               /*Total unit count will only increase
               by 1 if this type of unit is created.*/
               unitBuilder.increaseTotalUnitCount();

               System.out.println("Make a fast attack choice:");
               fastAttackChoice.unitName = scan.nextLine();
               fastAttackChoice.battleRole = "Fast Attack";
               System.out.println();
               System.out.println("Enter number of models in the unit.");
               fastAttackChoice.numInUnit = scan.nextInt();
               System.out.println();
               System.out.println("Enter number of points per model.");
               fastAttackChoice.pointVal = scan.nextInt();
               createdUnits.add(fastAttackChoice.toString());
               fastAttackTotalPointVal = fastAttackChoice.numInUnit * fastAttackChoice.pointVal;
               System.out.println();
   }

   //Method that gathers all necessary Heavy Support info.
   static void pickedHeavySupport() {

                /*Total unit count will only increase
               by 1 if this type of unit is created.*/
               unitBuilder.increaseTotalUnitCount();

               System.out.println("Make a heavy support choice:");
               heavySupportChoice.unitName = scan.nextLine();
               heavySupportChoice.battleRole = "Heavy Support";
               System.out.println();
               System.out.println("Enter number of models in the unit.");
               heavySupportChoice.numInUnit = scan.nextInt();
               System.out.println();
               System.out.println("Enter number of points per model.");
               heavySupportChoice.pointVal = scan.nextInt();
               createdUnits.add(heavySupportChoice.toString());
               heavySupportTotalPointVal = heavySupportChoice.numInUnit * heavySupportChoice.pointVal;
               System.out.println();
   }

    //Method that gathers all necessary Transport info.
   static void pickedDedicatedTransport() {

      /*Total unit count will only increase
      by 1 if this type of unit is created.*/
      unitBuilder.increaseTotalUnitCount();

      System.out.println("Make a dedicated transport choice:");
      dedicatedTransportChoice.unitName = scan.nextLine();
      dedicatedTransportChoice.battleRole = "Dedicated Transport";
      System.out.println();
      System.out.println("Enter number of models in the unit.");
      dedicatedTransportChoice.numInUnit = scan.nextInt();
      System.out.println();
      System.out.println("Enter number of points per model.");
      dedicatedTransportChoice.pointVal = scan.nextInt();
      createdUnits.add(dedicatedTransportChoice.toString());  
      dedicatedTransportTotalPointVal = dedicatedTransportChoice.numInUnit * dedicatedTransportChoice.pointVal;   
      System.out.println();
}

   //Method that gathers all necessary Flyer info.
   static void pickedFlyer() {

      /*Total unit count will only increase
       by 1 if this type of unit is created.*/
       unitBuilder.increaseTotalUnitCount();

       System.out.println("Make a flyer choice:");
       flyerChoice.unitName = scan.nextLine();
       flyerChoice.battleRole = "Flyer";
       System.out.println();
       System.out.println("Enter number of models in the unit.");
       flyerChoice.numInUnit = scan.nextInt();
       System.out.println();
       System.out.println("Enter number of points per model.");
       flyerChoice.pointVal = scan.nextInt();
       createdUnits.add(flyerChoice.toString());
       flyerTotalPointVal = flyerChoice.numInUnit * flyerChoice.pointVal;
       System.out.println();
}

   //Method that gathers all necessary fortification info.
   static void pickedFortification() {

      /*Total unit count will only increase
      by 1 if this type of unit is created.*/
      unitBuilder.increaseTotalUnitCount();

      System.out.println("Make a fortification choice:");
      fortificationChoice.unitName = scan.nextLine();
      fortificationChoice.battleRole = "Fortification";
      System.out.println();
      System.out.println("Enter number of models in the unit.");
      fortificationChoice.numInUnit = scan.nextInt();
      System.out.println();
      System.out.println("Enter number of points per model.");
      fortificationChoice.pointVal = scan.nextInt();
      createdUnits.add(fortificationChoice.toString());  
      fortificationTotalPointVal = fortificationChoice.numInUnit * fortificationChoice.pointVal;   
      System.out.println();
}

   //Method that gathers all necessary Lord of War info.
   static void pickedLordOfWar() {

      /*Total unit count will only increase
      by 1 if this type of unit is created.*/
      unitBuilder.increaseTotalUnitCount();

      System.out.println("Make a lord of war choice:");
      lordOfWarChoice.unitName = scan.nextLine();
      lordOfWarChoice.battleRole = "Lord of War";
      System.out.println();
      System.out.println("Enter number of models in the unit.");
      lordOfWarChoice.numInUnit = scan.nextInt();
      System.out.println();
      System.out.println("Enter number of points per model.");
      lordOfWarChoice.pointVal = scan.nextInt();
      createdUnits.add(lordOfWarChoice.toString());  
      lordOfWarTotalPointVal = lordOfWarChoice.numInUnit * lordOfWarChoice.pointVal;   
      System.out.println();
}
}
