/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class heavySupport extends unitBuilder {

   //Class object created to hold each unit's info. 
   static heavySupport heavySupportChoice = new heavySupport("", "", "", 0, 0, 0);
   private String heavySupportAnswer;
   private int heavySupportUnitPointVal;
   private static int heavySupportTotalPointVal;

//Constructor that takes the parameters of the unit.
  public heavySupport(String unitName, String unitComposition, String remarks, 
  int upgradePoints, int numInUnit, int pointVal) {
   super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

//toString method returns the unit info in string form.
  public String toString() {
   String output = super.toString();

   //Appends all info from user input.
   output = 
   "* HEAVY SUPPORT: " 
   + getUnitName().toUpperCase() + " / " 
   + "[" + heavySupportUnitPointVal + "pts] *" + "\n"
   + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
   + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
   return output;
  }

  /**
  * Method for getting the heavy Support Answer.
  * @return returns heavySupportAnswer
  */
  public String getHeavySupportAnswer() {
   return heavySupportAnswer;
  }

  /**
  * Method for setting heavy Support Answer.
  * @param heavySupportAnswerIn inputs heavySupportAnswer.
  */
  public void setHeavySupportAnswer(String heavySupportAnswerIn) {
   heavySupportAnswer = heavySupportAnswerIn;
  }

  /**
  * Method for getting the heavy Support Unit Point Val.
  * @return returns heavySupportUnitPointVal
  */
  public int getHeavySupportUnitPointVal() {
   return heavySupportUnitPointVal;
  }

  /**
  * Method for setting heavy Support Unit Point Val.
  * @param heavySupportUnitPointValIn inputs heavySupportUnitPointVal.
  */
  public void setHeavySupportUnitPointVal(int heavySupportUnitPointValIn) {
   heavySupportUnitPointVal = heavySupportUnitPointValIn;
  }
  
   /**
  * Method for getting the heavy Support Total Point Val.
  * @return returns heavySupport Total Point Val
  */
  public static int getHeavySupportTotalPointVal() {
   return heavySupportTotalPointVal;
  }

  /**
  * Method for setting heavy Support Total Point Val.
  * @param heavySupportTotalPointValIn inputs heavySupportTotalPointVal.
  */
  public void setheavySupportTotalPointVal(int heavySupportTotalPointValIn) {
   heavySupportTotalPointVal = heavySupportTotalPointValIn;
  }

   //Method that gathers all necessary heavy Support info.
    public void pickedHeavySupport() {
   try {

    /*Total unit count will only increase
    by 1 if this type of unit is created.*/
    unitBuilder.increaseTotalUnitCount();
   
    System.out.println();
    System.out.println("Make a heavy support choice.");
    heavySupportChoice.setUnitName(listBuilder.scan.nextLine());
   
    System.out.println();
    System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");

    /*Makes the scanner read a tab-enter before continuing to scan, 
    * this allows multi-line input from user */
    listBuilder.scan.useDelimiter("\\t");
    heavySupportChoice.setUnitComposition(listBuilder.scan.next());

   heavySupportPointCalculator();

    System.out.println();
    listBuilder.scan.nextLine();
    System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");

    //listBuilder.scan.useDelimiter("\\t");
    heavySupportChoice.setRemarks(listBuilder.scan.next());

    System.out.println();
    listBuilder.scan.nextLine();
    
    listBuilder.createdUnits.add(heavySupportChoice.toString());

    System.out.println("Pick another heavy support? (yes/no) " + "\n" + "Use tab-enter to end.");
    heavySupportAnswer = listBuilder.scan.nextLine();

   //Call the method again of there are additional inputs.
   while (heavySupportAnswer.equalsIgnoreCase("yes")) {
     pickedHeavySupport(); //recursive call to own method.
     listBuilder.scan.nextLine();
   }
   }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n");
   ex.printStackTrace();
   pickedHeavySupport(); //recursive call to own method.
  }
}

//This method takes point values from user and calculates total point value.
public void heavySupportPointCalculator() {
  try {
  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of models in the unit." + "\n" + "Use tab-enter to end.");
  heavySupportChoice.setNumInUnit(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of points per model." + "\n" + "Use tab-enter to end.");
  heavySupportChoice.setPointVal(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter total upgrade pts." + "\n" + "Use tab-enter to end.");
  heavySupportChoice.setUpgradePoints(listBuilder.scan.nextInt());

  //Adds each unit pts value separately.
  heavySupportUnitPointVal = (heavySupportChoice.getNumInUnit() * heavySupportChoice.getPointVal()) + heavySupportChoice.getUpgradePoints();
  
  //Holds a running total of how many pts the heavySupport units cost in total.
  heavySupportTotalPointVal += heavySupportUnitPointVal;
  }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n" 
   + "Please only enter numbers and use tab-enter to end." + "\n");
   ex.printStackTrace();
   heavySupportPointCalculator(); //recursive call to own method.
  }
}
}
