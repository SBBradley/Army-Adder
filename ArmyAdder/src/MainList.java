import java.io.*;
import java.util.*;


/*
* Army list creator for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class MainList {

//Scanner for user input.
   static Scanner scan = new Scanner(System.in);
   
   //Array list to hold all created units throughout program.
   static ArrayList<String> createdUnits = new ArrayList<String>();
   
   //All objects for the different types of units.
   static HqChoice hq = new HqChoice("", "", 0, 0);   
   static TroopsChoice troops = new TroopsChoice("", "", 0, 0);
   static ElitesChoice elites = new ElitesChoice("", "", 0, 0);
   static FlyerChoice flyer = new FlyerChoice("", "", 0, 0);
   static FastAttackChoice fastAttack = new FastAttackChoice("", "", 0, 0);
   static HeavySupportChoice heavySupport = new HeavySupportChoice("", "", 0, 0);
   static TransportChoice transport = new TransportChoice("", "", 0, 0);
   
   //All point values are ints.
   static int hqTotalPointVal;
   static int troopsTotalPointVal;
   static int elitesTotalPointVal;
   static int flyerTotalPointVal;
   static int fastAttackTotalPointVal;
   static int heavySupportTotalPointVal;
   static int transportTotalPointVal;     
   
   //Strings for user input and replies.
   static String race = "";
   static String battleRole = "";
   static String reply = "";

//Main method for class MainList
   public static void main(String[] args) {
      //Asks the user for the alien race of the army.
      System.out.println("Choose an army race:");
      //User inputs the alien race of the army.
      race = scan.nextLine();
      System.out.println();
      
      //Calls unitCreate method and cycles through creation questions.
      unitCreate();
      
      System.out.println();
      System.out.println("Are you finished creating your army?");
      //User either finishes creating list or adds more input.
      String reply2 = scan.nextLine();
      System.out.println();
      
      if(reply2.equalsIgnoreCase("Yes")) {
         System.out.println("Please wait for your army list to generate...");
         /*Calls createList method that exports to a 
         *text document with a summary of all created units and stats.*/

         createList(); 
      }
      else {
          //Calls unitCreate method and cycles through creation questions.
         unitCreate();
      }
   }
   
   //Method that exports to a text document with a summary of all created units and stats.
   static void createList() {
      StringBuilder completedList = new StringBuilder();
      
      for (String value : createdUnits) {
         completedList.append(value + "\n" + "\n");
      }
      
      String done = completedList.toString();
   
      try {
         FileWriter file = new FileWriter("New Army List.txt");
         file.write(race.toUpperCase() + " Army List" + "\n" + "\n"
            + "Total Unit Count: " + UnitBuilder.getTotalUnitCount() + "\n"
            + "Total Army Points: " + getTotalArmyPoints() + "\n" + "\n"
            + "-----------------------------------------------------------"
            + "\n" + done);
            
         file.close();
         
         /* ***********************************************
          * Add the filepath appended to this line BELOW. 
          * ***********************************************
          */
         System.out.println("Successfully generated file in:");
         /* ***********************************************
          * Add the filepath appended to this line ABOVE. 
          * ***********************************************
          */
      }
      catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }
   
    /*
    * Method for getting total army points.
    * @return returns TotalArmyPoints.
    */
   public static int getTotalArmyPoints() {
      int TotalArmyPoints = hqTotalPointVal + troopsTotalPointVal
         + elitesTotalPointVal + flyerTotalPointVal + fastAttackTotalPointVal 
         + heavySupportTotalPointVal + transportTotalPointVal;
      return TotalArmyPoints;
   }
   
   //Method for creating units.
   static void unitCreate() {
    //Making next unit type selections.
      System.out.println("Do you want to choose a battlefield role?");
      reply = scan.nextLine();
         
        /*While loop for getting multiple unit creations. 
         * ********************************************
         * NEED TO COME UP WITH A BETTER SOLUTION FOR THIS BELOW.
         * Will terminate if user inputs "no".
         * NEED TO COME UP WITH A BETTER SOLUTION FOR THIS ABOVE.
         * ********************************************
         */
      while(reply.equalsIgnoreCase("Yes")) {
         System.out.println();
         System.out.println("Options:" + "\n" +  "HQ, Troops, Elites, Flyer," 
            + "\n" + "Fast Attack, Heavy Support, Transport"); 
      
      //Choose a specific battelfield role from options list.
         System.out.println();
         System.out.println("Choose battlefield role.");
         battleRole = scan.nextLine();
         System.out.println();
      
         if(battleRole.equalsIgnoreCase("HQ")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
            
            System.out.println("Make a HQ choice: ");
            hq.UnitName = scan.nextLine();
            hq.BattleRole = "HQ";
            System.out.println();
            
            System.out.println("Enter number of models in the unit.");
            hq.NumInUnit = scan.nextInt();
            System.out.println();
            
            System.out.println("Enter number of points per model.");
            hq.PointVal = scan.nextInt();
            createdUnits.add(hq.toString());
            hqTotalPointVal = hq.NumInUnit * hq.PointVal;
            System.out.println();
         }
         
         else if (battleRole.equalsIgnoreCase("TROOPS")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
         
            System.out.println("Make a troops choice:");
            troops.UnitName = scan.nextLine();
            troops.BattleRole = "Troops";
            System.out.println();
            
            System.out.println("Enter number of models in the unit.");
            troops.NumInUnit = scan.nextInt();
            System.out.println();
            
            System.out.println("Enter number of points per model.");
            troops.PointVal = scan.nextInt();
            createdUnits.add(troops.toString());
            troopsTotalPointVal = troops.NumInUnit * troops.PointVal;
            System.out.println();
         }
         
         else if (battleRole.equalsIgnoreCase("ELITES")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
         
            System.out.println("Make an elites choice:");
            elites.UnitName = scan.nextLine();
            elites.BattleRole = "Elites";
            System.out.println();
         
            System.out.println("Enter number of models in the unit.");
            elites.NumInUnit = scan.nextInt();
            System.out.println();
         
            System.out.println("Enter number of points per model.");
            elites.PointVal = scan.nextInt();
            
            createdUnits.add(elites.toString());
            
            elitesTotalPointVal = elites.NumInUnit * elites.PointVal;
            
            System.out.println();
         }
         
         else if (battleRole.equalsIgnoreCase("FLYER")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
         
            System.out.println("Make a flyer choice:");
            flyer.UnitName = scan.nextLine();
            flyer.BattleRole = "Flyer";
            System.out.println();
         
            System.out.println("Enter number of models in the unit.");
            flyer.NumInUnit = scan.nextInt();
            System.out.println();
         
            System.out.println("Enter number of points per model.");
            flyer.PointVal = scan.nextInt();
            
            createdUnits.add(flyer.toString());
            
            flyerTotalPointVal = flyer.NumInUnit * flyer.PointVal;
            
            System.out.println();
         }
         
         else if (battleRole.equalsIgnoreCase("FAST ATTACK")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
          
            System.out.println("Make a fast attack choice:");
            fastAttack.UnitName = scan.nextLine();
            fastAttack.BattleRole = "Fast Attack";
            System.out.println();
         
            System.out.println("Enter number of models in the unit.");
            fastAttack.NumInUnit = scan.nextInt();
            System.out.println();
         
            System.out.println("Enter number of points per model.");
            fastAttack.PointVal = scan.nextInt();
            
            createdUnits.add(fastAttack.toString());
            
            fastAttackTotalPointVal = fastAttack.NumInUnit * fastAttack.PointVal;
            
            System.out.println();
         }
         
         else if (battleRole.equalsIgnoreCase("HEAVY SUPPORT")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
         
            System.out.println("Make a heavy support choice:");
            heavySupport.UnitName = scan.nextLine();
            heavySupport.BattleRole = "Heavy Support";
            System.out.println();
         
            System.out.println("Enter number of models in the unit.");
            heavySupport.NumInUnit = scan.nextInt();
            System.out.println();
         
            System.out.println("Enter number of points per model.");
            heavySupport.PointVal = scan.nextInt();
            
            createdUnits.add(heavySupport.toString());
            
            heavySupportTotalPointVal = heavySupport.NumInUnit * heavySupport.PointVal;
            
            System.out.println();
         }
         
         else if (battleRole.equalsIgnoreCase("TRANSPORT")) {
        	 /*Total unit count will only increase
             by 1 if this type of unit is created.*/
            UnitBuilder.increaseTotalUnitCount();
         
            System.out.println("Make a transport choice:");
            transport.UnitName = scan.nextLine();
            transport.BattleRole = "Transport";
            System.out.println();
         
            System.out.println("Enter number of models in the unit.");
            transport.NumInUnit = scan.nextInt();
            System.out.println();
         
            System.out.println("Enter number of points per model.");
            transport.PointVal = scan.nextInt();
            
            createdUnits.add(transport.toString());
            
            transportTotalPointVal = transport.NumInUnit * transport.PointVal;
            
            System.out.println();
         }
         
         /*Repeats question to reenter or exit while loop.
          * If user enters "no" will jump out of loop and 
          * back into main method to create the finalized list.*/
         scan.nextLine();
         System.out.println("Do you want to choose another battlefield role?");
         reply = scan.nextLine();
      }
   } 
}