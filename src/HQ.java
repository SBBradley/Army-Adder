/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class HQ extends unitBuilder {

   //Class object created to hold each unit's info. 
   static HQ hqChoice = new HQ("", "", "", 0, 0, 0);
   private String hqAnswer;
   private int hqUnitPointVal;
   private static int hqTotalPointVal;

//Constructor that takes the parameters of the unit.
  public HQ(String unitName, String unitComposition, String remarks, 
  int upgradePoints, int numInUnit, int pointVal) {
   super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

//toString method returns the unit info in string form.
  public String toString() {
   String output = super.toString();

   //Appends all info from user input.
   output = 
   "* HQ: " 
   + getUnitName().toUpperCase() + " / " 
   + "[" + hqUnitPointVal + "pts] *" + "\n"
   + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
   + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
   return output;
  }

  /**
  * Method for getting the hq Answer.
  * @return returns hqAnswer
  */
  public String getHqAnswer() {
   return hqAnswer;
  }

  /**
  * Method for setting hq Answer.
  * @param hqAnswerIn inputs hqAnswer.
  */
  public void setHqAnswer(String hqAnswerIn) {
   hqAnswer = hqAnswerIn;
  }

  /**
  * Method for getting the hq Unit Point Val.
  * @return returns hqUnitPointVal
  */
  public int getHqUnitPointVal() {
   return hqUnitPointVal;
  }

  /**
  * Method for setting hq Unit Point Val.
  * @param hqUnitPointValIn inputs hqUnitPointVal.
  */
  public void setHqUnitPointVal(int hqUnitPointValIn) {
   hqUnitPointVal = hqUnitPointValIn;
  }
  
   /**
  * Method for getting the hq Total Point Val.
  * @return returns hq Total Point Val
  */
  public static int getHqTotalPointVal() {
   return hqTotalPointVal;
  }

  /**
  * Method for setting hq Total Point Val.
  * @param hqTotalPointValIn inputs hqTotalPointVal.
  */
  public void setHqTotalPointVal(int hqTotalPointValIn) {
   hqTotalPointVal = hqTotalPointValIn;
  }

   //Method that gathers all necessary HQ info.
    public void pickedHq() {
   try {

    /*Total unit count will only increase
    by 1 if this type of unit is created.*/
    unitBuilder.increaseTotalUnitCount();
   
    System.out.println();
    System.out.println("Make a HQ choice.");
    hqChoice.setUnitName(listBuilder.scan.nextLine());
   
    System.out.println();
    System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");

    /*Makes the scanner read a tab-enter before continuing to scan, 
    * this allows multi-line input from user */
    listBuilder.scan.useDelimiter("\\t");
    hqChoice.setUnitComposition(listBuilder.scan.next());

   hqPointCalculator();

    System.out.println();
    listBuilder.scan.nextLine();
    System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");

    //listBuilder.scan.useDelimiter("\\t");
    hqChoice.setRemarks(listBuilder.scan.next());

    System.out.println();
    listBuilder.scan.nextLine();
    
    listBuilder.createdUnits.add(hqChoice.toString());

    System.out.println("Pick another HQ? (yes/no) " + "\n" + "Use tab-enter to end.");
    hqAnswer = listBuilder.scan.nextLine();

   //Call the method again of there are additional inputs.
   while (hqAnswer.equalsIgnoreCase("yes")) {
     pickedHq(); //recursive call to own method.
     listBuilder.scan.nextLine();
   }
   }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n");
   ex.printStackTrace();
   pickedHq(); //recursive call to own method.
  }
}

//This method takes point values from user and calculates total point value.
public void hqPointCalculator() {
  try {
  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of models in the unit." + "\n" + "Use tab-enter to end.");
  hqChoice.setNumInUnit(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of points per model." + "\n" + "Use tab-enter to end.");
  hqChoice.setPointVal(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter total upgrade pts." + "\n" + "Use tab-enter to end.");
  hqChoice.setUpgradePoints(listBuilder.scan.nextInt());

  //Adds each unit pts value separately.
  hqUnitPointVal = (hqChoice.getNumInUnit() * hqChoice.getPointVal()) + hqChoice.getUpgradePoints();
  
  //Holds a running total of how many pts the HQ units cost in total.
  hqTotalPointVal += hqUnitPointVal;
  }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n" 
   + "Please only enter numbers and use tab-enter to end." + "\n");
   ex.printStackTrace();
   hqPointCalculator(); //recursive call to own method.
  }
}
}
