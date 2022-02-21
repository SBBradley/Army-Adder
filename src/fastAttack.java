/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class fastAttack extends unitBuilder {

   //Class object created to hold each unit's info. 
   static fastAttack fastAttackChoice = new fastAttack("", "", "", 0, 0, 0);
   private String fastAttackAnswer;
   private int fastAttackUnitPointVal;
   private static int fastAttackTotalPointVal;

//Constructor that takes the parameters of the unit.
  public fastAttack(String unitName, String unitComposition, String remarks, 
  int upgradePoints, int numInUnit, int pointVal) {
   super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

//toString method returns the unit info in string form.
  public String toString() {
   String output = super.toString();

   //Appends all info from user input.
   output = 
   "* FAST ATTACK: " 
   + getUnitName().toUpperCase() + " / " 
   + "[" + fastAttackUnitPointVal + "pts] *" + "\n"
   + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
   + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
   return output;
  }

  /**
  * Method for getting the fast Attack Answer.
  * @return returns fastAttackAnswer
  */
  public String getFastAttackAnswer() {
   return fastAttackAnswer;
  }

  /**
  * Method for setting fast Attack Answer.
  * @param fastAttackAnswerIn inputs fastAttackAnswer.
  */
  public void setfastAttackAnswer(String fastAttackAnswerIn) {
   fastAttackAnswer = fastAttackAnswerIn;
  }

  /**
  * Method for getting the fast Attack Unit Point Val.
  * @return returns fastAttackUnitPointVal
  */
  public int getFastAttackUnitPointVal() {
   return fastAttackUnitPointVal;
  }

  /**
  * Method for setting fast Attack Unit Point Val.
  * @param fastAttackUnitPointValIn inputs fastAttackUnitPointVal.
  */
  public void setfastAttackUnitPointVal(int fastAttackUnitPointValIn) {
   fastAttackUnitPointVal = fastAttackUnitPointValIn;
  }
  
   /**
  * Method for getting the fast Attack Total Point Val.
  * @return returns fastAttack Total Point Val
  */
  public static int getFastAttackTotalPointVal() {
   return fastAttackTotalPointVal;
  }

  /**
  * Method for setting fast Attack Total Point Val.
  * @param fastAttackTotalPointValIn inputs fastAttackTotalPointVal.
  */
  public void setfastAttackTotalPointVal(int fastAttackTotalPointValIn) {
   fastAttackTotalPointVal = fastAttackTotalPointValIn;
  }

   //Method that gathers all necessary fast Attack info.
    public void pickedFastAttack() {
   try {

    /*Total unit count will only increase
    by 1 if this type of unit is created.*/
    unitBuilder.increaseTotalUnitCount();
   
    System.out.println();
    System.out.println("Make a fast Attack choice.");
    fastAttackChoice.setUnitName(listBuilder.scan.nextLine());
   
    System.out.println();
    System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");

    /*Makes the scanner read a tab-enter before continuing to scan, 
    * this allows multi-line input from user */
    listBuilder.scan.useDelimiter("\\t");
    fastAttackChoice.setUnitComposition(listBuilder.scan.next());

   fastAttackPointCalculator();

    System.out.println();
    listBuilder.scan.nextLine();
    System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");

    //listBuilder.scan.useDelimiter("\\t");
    fastAttackChoice.setRemarks(listBuilder.scan.next());

    System.out.println();
    listBuilder.scan.nextLine();
    
    listBuilder.createdUnits.add(fastAttackChoice.toString());

    System.out.println("Pick another fast attack? (yes/no) " + "\n" + "Use tab-enter to end.");
    fastAttackAnswer = listBuilder.scan.nextLine();

   //Call the method again of there are additional inputs.
   while (fastAttackAnswer.equalsIgnoreCase("yes")) {
     pickedFastAttack(); //recursive call to own method.
     listBuilder.scan.nextLine();
   }
   }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n");
   ex.printStackTrace();
   pickedFastAttack(); //recursive call to own method.
  }
}

//This method takes point values from user and calculates total point value.
public void fastAttackPointCalculator() {
  try {
  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of models in the unit." + "\n" + "Use tab-enter to end.");
  fastAttackChoice.setNumInUnit(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of points per model." + "\n" + "Use tab-enter to end.");
  fastAttackChoice.setPointVal(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter total upgrade pts." + "\n" + "Use tab-enter to end.");
  fastAttackChoice.setUpgradePoints(listBuilder.scan.nextInt());

  //Adds each unit pts value separately.
  fastAttackUnitPointVal = (fastAttackChoice.getNumInUnit() * fastAttackChoice.getPointVal()) + fastAttackChoice.getUpgradePoints();
  
  //Holds a running total of how many pts the fastAttack units cost in total.
  fastAttackTotalPointVal += fastAttackUnitPointVal;
  }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n" 
   + "Please only enter numbers and use tab-enter to end." + "\n");
   ex.printStackTrace();
   fastAttackPointCalculator(); //recursive call to own method.
  }
}
}
