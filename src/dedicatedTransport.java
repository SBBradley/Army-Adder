/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class dedicatedTransport extends unitBuilder {

   //Class object created to hold each unit's info. 
   static dedicatedTransport dedicatedTransportChoice = new dedicatedTransport("", "", "", 0, 0, 0);
   private String dedicatedTransportAnswer;
   private int dedicatedTransportUnitPointVal;
   private static int dedicatedTransportTotalPointVal;

//Constructor that takes the parameters of the unit.
  public dedicatedTransport(String unitName, String unitComposition, String remarks, 
  int upgradePoints, int numInUnit, int pointVal) {
   super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

//toString method returns the unit info in string form.
  public String toString() {
   String output = super.toString();

   //Appends all info from user input.
   output = 
   "* DEDICATED TRANSPORT: " 
   + getUnitName().toUpperCase() + " / " 
   + "[" + dedicatedTransportUnitPointVal + "pts] *" + "\n"
   + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
   + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
   return output;
  }

  /**
  * Method for getting the dedicated Transport Answer.
  * @return returns dedicatedTransportAnswer
  */
  public String getDedicatedTransportAnswer() {
   return dedicatedTransportAnswer;
  }

  /**
  * Method for setting dedicated Transport Answer.
  * @param dedicatedTransportAnswerIn inputs dedicatedTransportAnswer.
  */
  public void setdedicatedTransportAnswer(String dedicatedTransportAnswerIn) {
   dedicatedTransportAnswer = dedicatedTransportAnswerIn;
  }

  /**
  * Method for getting the dedicated Transport Unit Point Val.
  * @return returns dedicatedTransportUnitPointVal
  */
  public int getDedicatedTransportUnitPointVal() {
   return dedicatedTransportUnitPointVal;
  }

  /**
  * Method for setting dedicated Transport Unit Point Val.
  * @param dedicatedTransportUnitPointValIn inputs dedicatedTransportUnitPointVal.
  */
  public void setdedicatedTransportUnitPointVal(int dedicatedTransportUnitPointValIn) {
   dedicatedTransportUnitPointVal = dedicatedTransportUnitPointValIn;
  }
  
   /**
  * Method for getting the dedicated Transport Total Point Val.
  * @return returns dedicatedTransport Total Point Val
  */
  public static int getDedicatedTransportTotalPointVal() {
   return dedicatedTransportTotalPointVal;
  }

  /**
  * Method for setting dedicated Transport Total Point Val.
  * @param dedicatedTransportTotalPointValIn inputs dedicatedTransportTotalPointVal.
  */
  public void setdedicatedTransportTotalPointVal(int dedicatedTransportTotalPointValIn) {
   dedicatedTransportTotalPointVal = dedicatedTransportTotalPointValIn;
  }

   //Method that gathers all necessary dedicated Transport info.
    public void pickedDedicatedTransport() {
   try {

    /*Total unit count will only increase
    by 1 if this type of unit is created.*/
    unitBuilder.increaseTotalUnitCount();
   
    System.out.println();
    System.out.println("Make a dedicatedTransport choice.");
    dedicatedTransportChoice.setUnitName(listBuilder.scan.nextLine());
   
    System.out.println();
    System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");

    /*Makes the scanner read a tab-enter before continuing to scan, 
    * this allows multi-line input from user */
    listBuilder.scan.useDelimiter("\\t");
    dedicatedTransportChoice.setUnitComposition(listBuilder.scan.next());

   dedicatedTransportPointCalculator();

    System.out.println();
    listBuilder.scan.nextLine();
    System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");

    //listBuilder.scan.useDelimiter("\\t");
    dedicatedTransportChoice.setRemarks(listBuilder.scan.next());

    System.out.println();
    listBuilder.scan.nextLine();
    
    listBuilder.createdUnits.add(dedicatedTransportChoice.toString());

    System.out.println("Pick another dedicated transport? (yes/no) " + "\n" + "Use tab-enter to end.");
    dedicatedTransportAnswer = listBuilder.scan.nextLine();

   //Call the method again of there are additional inputs.
   while (dedicatedTransportAnswer.equalsIgnoreCase("yes")) {
     pickedDedicatedTransport(); //recursive call to own method.
     listBuilder.scan.nextLine();
   }
   }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n");
   ex.printStackTrace();
   pickedDedicatedTransport(); //recursive call to own method.
  }
}

//This method takes point values from user and calculates total point value.
public void dedicatedTransportPointCalculator() {
  try {
  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of models in the unit." + "\n" + "Use tab-enter to end.");
  dedicatedTransportChoice.setNumInUnit(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter # of points per model." + "\n" + "Use tab-enter to end.");
  dedicatedTransportChoice.setPointVal(listBuilder.scan.nextInt());

  System.out.println();
  listBuilder.scan.nextLine();
  System.out.println("Enter total upgrade pts." + "\n" + "Use tab-enter to end.");
  dedicatedTransportChoice.setUpgradePoints(listBuilder.scan.nextInt());

  //Adds each unit pts value separately.
  dedicatedTransportUnitPointVal = (dedicatedTransportChoice.getNumInUnit() * dedicatedTransportChoice.getPointVal()) + dedicatedTransportChoice.getUpgradePoints();
  
  //Holds a running total of how many pts the dedicatedTransport units cost in total.
  dedicatedTransportTotalPointVal += dedicatedTransportUnitPointVal;
  }
  catch (Exception ex) {
   System.out.println("\n" + "An error occurred." + "\n" 
   + "Please only enter numbers and use tab-enter to end." + "\n");
   ex.printStackTrace();
   dedicatedTransportPointCalculator(); //recursive call to own method.
  }
}
}
