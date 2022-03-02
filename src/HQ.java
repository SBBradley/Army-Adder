/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class HQ extends unitBuilder {

   //Class object created to hold each unit's info. 
   static HQ hqChoice = new HQ("", "", "", 0, 0, 0);
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
  * Method for getting the hq unit point val.
  * @return returns hqUnitPointVal
  */
  public int getHqUnitPointVal() {
   return hqUnitPointVal;
  }

  /**
  * Method for setting hq unit point val.
  * @param hqUnitPointValIn inputs hqUnitPointVal.
  */
  public void setHqUnitPointVal(int hqUnitPointValIn) {
   hqUnitPointVal = hqUnitPointValIn;
  }
  
   /**
  * Method for getting the hq total point val.
  * @return returns hq Total Point Val
  */
  public static int getHqTotalPointVal() {
   return hqTotalPointVal;
  }

  /**
  * Method for setting hq total point val.
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

    /*Makes the scanner read a tab-enter before continuing to scan, 
    * this allows multi-line input from user */
    listBuilder.scan.useDelimiter("\\t");
    System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
    hqChoice.setUnitComposition(listBuilder.scan.next());
    listBuilder.scan.reset();

   hqPointCalculator();

    System.out.println();
    listBuilder.scan.useDelimiter("\\t");
    System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
    hqChoice.setRemarks(listBuilder.scan.next());
    listBuilder.scan.reset();

    listBuilder.createdUnits.add(hqChoice.toString());

    System.out.println();
    listBuilder.scan.nextLine();
    System.out.println("Pick another HQ? (yes/no)");
    String hqAnswer = listBuilder.scan.nextLine();

   //Call the method again of there are additional inputs.
   if (hqAnswer.equalsIgnoreCase("yes")) {
     pickedHq(); //call to own method.
     listBuilder.scan.nextLine();
     System.out.println();
   }
   else { 
     listBuilder.unitCreate();
     System.out.println();
   }
   }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n");
   ex.printStackTrace();
  }
}

//This method takes point values from user and calculates total point value.
public void hqPointCalculator() {
  try {
  System.out.println();
  System.out.println("Enter # of models in the unit.");
  hqChoice.setNumInUnit(listBuilder.scan.nextInt());

  System.out.println();
  System.out.println("Enter # of points per model.");
  hqChoice.setPointVal(listBuilder.scan.nextInt());

  System.out.println();
  System.out.println("Enter total upgrade pts.");
  hqChoice.setUpgradePoints(listBuilder.scan.nextInt());

  //Adds each unit pts value separately.
  hqUnitPointVal = (hqChoice.getNumInUnit() * hqChoice.getPointVal()) + hqChoice.getUpgradePoints();
  
  //Holds a running total of how many pts the HQ units cost in total.
  hqTotalPointVal += hqUnitPointVal;
  }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n" 
   + "Please only enter numbers." + "\n");
   ex.printStackTrace();
  }
}
}