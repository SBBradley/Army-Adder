/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class flyer extends unitBuilder {

  //Class object created to hold each unit's info. 
  static flyer flyerChoice = new flyer("", "", "", 0, 0, 0);
  private int flyerUnitPointVal;
  private static int flyerTotalPointVal;

//Constructor that takes the parameters of the unit.
 public flyer(String unitName, String unitComposition, String remarks, 
 int upgradePoints, int numInUnit, int pointVal) {
  super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
 }

//toString method returns the unit info in string form.
 public String toString() {
  String output = super.toString();

  //Appends all info from user input.
  output = 
  "* FLYER: " 
  + getUnitName().toUpperCase() + " / " 
  + "[" + flyerUnitPointVal + "pts] *" + "\n"
  + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
  + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
  return output;
 }

 /**
 * Method for getting the flyer unit point val.
 * @return returns flyerUnitPointVal
 */
 public int getFlyerUnitPointVal() {
  return flyerUnitPointVal;
 }

 /**
 * Method for setting flyer unit point val.
 * @param flyerUnitPointValIn inputs flyerUnitPointVal.
 */
 public void setFlyerUnitPointVal(int flyerUnitPointValIn) {
  flyerUnitPointVal = flyerUnitPointValIn;
 }
 
  /**
 * Method for getting the flyer total point val.
 * @return returns flyer Total Point Val
 */
 public static int getFlyerTotalPointVal() {
  return flyerTotalPointVal;
 }

 /**
 * Method for setting flyer total point val.
 * @param flyerTotalPointValIn inputs flyerTotalPointVal.
 */
 public void setFlyerTotalPointVal(int flyerTotalPointValIn) {
  flyerTotalPointVal = flyerTotalPointValIn;
 }

  //Method that gathers all necessary flyer info.
   public void pickedFlyer() {
  try {

   /*Total unit count will only increase
   by 1 if this type of unit is created.*/
   unitBuilder.increaseTotalUnitCount();
  
   System.out.println();
   System.out.println("Make a flyer choice.");
   flyerChoice.setUnitName(listBuilder.scan.nextLine());
  
   System.out.println();

   /*Makes the scanner read a tab-enter before continuing to scan, 
   * this allows multi-line input from user */
   listBuilder.scan.useDelimiter("\\t");
   System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
   flyerChoice.setUnitComposition(listBuilder.scan.next());
   listBuilder.scan.reset();

  flyerPointCalculator();

   System.out.println();
   listBuilder.scan.useDelimiter("\\t");
   System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
   flyerChoice.setRemarks(listBuilder.scan.next());
   listBuilder.scan.reset();

   listBuilder.createdUnits.add(flyerChoice.toString());

   System.out.println();
   listBuilder.scan.nextLine();
   System.out.println("Pick another flyer? (yes/no)");
   String flyerAnswer = listBuilder.scan.nextLine();

  //Call the method again of there are additional inputs.
  if (flyerAnswer.equalsIgnoreCase("yes")) {
    pickedFlyer(); //call to own method.
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
public void flyerPointCalculator() {
 try {
 System.out.println();
 System.out.println("Enter # of models in the unit.");
 flyerChoice.setNumInUnit(listBuilder.scan.nextInt());

 System.out.println();
 System.out.println("Enter # of points per model.");
 flyerChoice.setPointVal(listBuilder.scan.nextInt());

 System.out.println();
 System.out.println("Enter total upgrade pts.");
 flyerChoice.setUpgradePoints(listBuilder.scan.nextInt());

 //Adds each unit pts value separately.
 flyerUnitPointVal = (flyerChoice.getNumInUnit() * flyerChoice.getPointVal()) + flyerChoice.getUpgradePoints();
 
 //Holds a running total of how many pts the flyer units cost in total.
 flyerTotalPointVal += flyerUnitPointVal;
 }
 catch (Exception ex) {
  System.out.println("\n" + "An error occurred." + "\n" 
  + "Please only enter numbers." + "\n");
  ex.printStackTrace();
 }
}
}