/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class elites extends unitBuilder {

   //Class object created to hold each unit's info. 
   static elites elitesChoice = new elites("", "", "", 0, 0, 0);
   private String elitesAnswer;
   private int elitesUnitPointVal;
   private static int elitesTotalPointVal;

//Constructor that takes the parameters of the unit.
  public elites(String unitName, String unitComposition, String remarks, 
  int upgradePoints, int numInUnit, int pointVal) {
   super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

//toString method returns the unit info in string form.
  public String toString() {
   String output = super.toString();

   //Appends all info from user input.
   output = 
   "* ELITES: " 
   + getUnitName().toUpperCase() + " / " 
   + "[" + elitesUnitPointVal + "pts] *" + "\n"
   + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
   + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
   return output;
  }

  /**
  * Method for getting the elites Answer.
  * @return returns elitesAnswer
  */
  public String getElitesAnswer() {
   return elitesAnswer;
  }

  /**
  * Method for setting elites Answer.
  * @param elitesAnswerIn inputs elitesAnswer.
  */
  public void setelitesAnswer(String elitesAnswerIn) {
   elitesAnswer = elitesAnswerIn;
  }

  /**
  * Method for getting the elites Unit Point Val.
  * @return returns elitesUnitPointVal
  */
  public int getElitesUnitPointVal() {
   return elitesUnitPointVal;
  }

  /**
  * Method for setting elites Unit Point Val.
  * @param elitesUnitPointValIn inputs elitesUnitPointVal.
  */
  public void setelitesUnitPointVal(int elitesUnitPointValIn) {
   elitesUnitPointVal = elitesUnitPointValIn;
  }
  
   /**
  * Method for getting the elites Total Point Val.
  * @return returns elites Total Point Val
  */
  public static int getElitesTotalPointVal() {
   return elitesTotalPointVal;
  }

  /**
  * Method for setting elites Total Point Val.
  * @param elitesTotalPointValIn inputs elitesTotalPointVal.
  */
  public void setelitesTotalPointVal(int elitesTotalPointValIn) {
   elitesTotalPointVal = elitesTotalPointValIn;
  }

   //Method that gathers all necessary elites info.
    public void pickedElites() {
   try {

    /*Total unit count will only increase
    by 1 if this type of unit is created.*/
    unitBuilder.increaseTotalUnitCount();
   
    System.out.println();
    System.out.println("Make a elites choice.");
    elitesChoice.setUnitName(listBuilder.scan.nextLine());
   
    System.out.println();
    System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");

    /*Makes the scanner read a tab-enter before continuing to scan, 
    * this allows multi-line input from user */
    listBuilder.scan.useDelimiter("\\t");
    elitesChoice.setUnitComposition(listBuilder.scan.next());

   elitesPointCalculator();

    System.out.println();
    listBuilder.scan.nextLine();
    System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");

    //listBuilder.scan.useDelimiter("\\t");
    elitesChoice.setRemarks(listBuilder.scan.next());

    System.out.println();
    listBuilder.scan.nextLine();
    
    listBuilder.createdUnits.add(elitesChoice.toString());

    System.out.println("Pick another elites? (yes/no) " + "\n" + "Use tab-enter to end.");
    elitesAnswer = listBuilder.scan.nextLine();

   //Call the method again of there are additional inputs.
   while (elitesAnswer.equalsIgnoreCase("yes")) {
     pickedElites(); //recursive call to own method.
     listBuilder.scan.nextLine();
   }
   }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n");
   ex.printStackTrace();
   pickedElites(); //recursive call to own method.
  }
}

//This method takes point values from user and calculates total point value.
public void elitesPointCalculator() {
  try {
  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of models in the unit." + "\n" + "Use tab-enter to end.");
  elitesChoice.setNumInUnit(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of points per model." + "\n" + "Use tab-enter to end.");
  elitesChoice.setPointVal(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter total upgrade pts." + "\n" + "Use tab-enter to end.");
  elitesChoice.setUpgradePoints(listBuilder.scan.nextInt());

  //Adds each unit pts value separately.
  elitesUnitPointVal = (elitesChoice.getNumInUnit() * elitesChoice.getPointVal()) + elitesChoice.getUpgradePoints();
  
  //Holds a running total of how many pts the elites units cost in total.
  elitesTotalPointVal += elitesUnitPointVal;
  }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n" 
   + "Please only enter numbers and use tab-enter to end." + "\n");
   ex.printStackTrace();
   elitesPointCalculator(); //recursive call to own method.
  }
}
}
