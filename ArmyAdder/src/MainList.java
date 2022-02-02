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
      System.out.println("Are you finished creating your army? (Yes/No)");

      //User either finishes creating list or adds more input.
      String reply2 = scan.nextLine();
      System.out.println();
      
      if(reply2.equalsIgnoreCase("Yes")) {

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
    * @return returns TotalArmyPoints.
    */
    public static int getTotalArmyPoints() {

      //This int holds all combined points from each unit.
      int TotalArmyPoints = hqTotalPointVal + troopsTotalPointVal
         + elitesTotalPointVal + flyerTotalPointVal + fastAttackTotalPointVal 
         + heavySupportTotalPointVal + transportTotalPointVal;
      return TotalArmyPoints;
   }
   
   //Method for creating units.
   static void unitCreate() {
      try {

      //Making next unit type selections.
        System.out.println("Do you want to choose a battlefield role? (Yes/No)");
        reply = scan.nextLine();
           
          //While loop for getting multiple unit creations, will terminate if user inputs "no".
       while(reply.equalsIgnoreCase("Yes")) {
           System.out.println();
           System.out.println("Options:" + "\n" 
            +  "HQ" + "\n" 
            + "Troops" + "\n"
            + "Elites" + "\n"
            + "Flyer" + "\n" 
            + "Fast Attack" + "\n"
            + "Heavy Support" + "\n"
            + "Transport"); 
        
        //Choose a specific battelfield role from options list.
           System.out.println();
           System.out.println("Choose a battlefield role from the options above.");
           battleRole = scan.nextLine();
           System.out.println();
        
           //This if-else-if statement will call each appropriate method for selected battleRole.
           if(battleRole.equalsIgnoreCase("Hq")) {
              pickedHq();   
            }
           else if (battleRole.equalsIgnoreCase("Troops")) {
              pickedTroops();
           }
           else if (battleRole.equalsIgnoreCase("Elites")) {
              pickedElites();
           }
           else if (battleRole.equalsIgnoreCase("Flyer")) {
               pickedFlyer();
           }
           else if (battleRole.equalsIgnoreCase("Fast Attack")) {
               pickedFastAttack();
           }
           else if (battleRole.equalsIgnoreCase("Heavy Support")) {
               pickedHeavySupport();
           }
           else if (battleRole.equalsIgnoreCase("Transport")) {
               pickedTransport();
           }
         
           /*Repeats question to reenter or exit while loop.
            * If user enters "no" will jump out of loop and 
            * back into main method to create the finalized list.*/
           scan.nextLine();
           System.out.println("Do you want to choose another battlefield role? (Yes/No)");
           reply = scan.nextLine();
         }
      }
      catch (Exception ex) {
         System.out.println("An error occurred. Please only enter (Yes/No)");
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
           
           String done = completedList.toString();
        
           //Adds a filewriter and writes all entered info from the user to a txt file to used.
           try {
              File file = new File("NEW ARMY LIST.txt");
              FileWriter fw = new FileWriter(file);
              fw.write(race.toUpperCase() + " ARMY LIST" + "\n" + "\n"
                 + "Total Unit Count: " + UnitBuilder.getTotalUnitCount() + "\n"
                 + "Total Army Points: " + getTotalArmyPoints() + "\n" + "\n"
                 + "-----------------------------------------------------------"
                 + "\n" + done);
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

   //Method that gathers all necessary Troops info.
   static void pickedTroops() {

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

   //Method that gathers all necessary Elites info.
   static void pickedElites() {

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

   //Method that gathers all necessary Flyer info.
   static void pickedFlyer() {

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

   //Method that gathers all necessary Fast Attack info.
   static void pickedFastAttack() {

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

   //Method that gathers all necessary Heavy Support info.
   static void pickedHeavySupport() {

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

   //Method that gathers all necessary Transport info.
   static void pickedTransport() {

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
}
