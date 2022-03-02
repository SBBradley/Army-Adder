/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class dedicatedTransport extends unitBuilder {

  //Class object created to hold each unit's info. 
  static dedicatedTransport dedicatedTransportChoice = new dedicatedTransport("", "", "", 0, 0, 0);
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
 * Method for getting the dedicatedTransport unit point val.
 * @return returns dedicatedTransportUnitPointVal
 */
 public int getDedicatedTransportUnitPointVal() {
  return dedicatedTransportUnitPointVal;
 }

 /**
 * Method for setting dedicatedTransport unit point val.
 * @param dedicatedTransportUnitPointValIn inputs dedicatedTransportUnitPointVal.
 */
 public void setDedicatedTransportUnitPointVal(int dedicatedTransportUnitPointValIn) {
  dedicatedTransportUnitPointVal = dedicatedTransportUnitPointValIn;
 }
 
  /**
 * Method for getting the dedicatedTransport total point val.
 * @return returns dedicatedTransport Total Point Val
 */
 public static int getDedicatedTransportTotalPointVal() {
  return dedicatedTransportTotalPointVal;
 }

 /**
 * Method for setting dedicatedTransport total point val.
 * @param dedicatedTransportTotalPointValIn inputs dedicatedTransportTotalPointVal.
 */
 public void setDedicatedTransportTotalPointVal(int dedicatedTransportTotalPointValIn) {
  dedicatedTransportTotalPointVal = dedicatedTransportTotalPointValIn;
 }

  //Method that gathers all necessary dedicatedTransport info.
   public void pickedDedicatedTransport() {
  try {

   /*Total unit count will only increase
   by 1 if this type of unit is created.*/
   unitBuilder.increaseTotalUnitCount();
  
   System.out.println();
   System.out.println("Make a dedicatedTransport choice.");
   dedicatedTransportChoice.setUnitName(listBuilder.scan.nextLine());
  
   System.out.println();

   /*Makes the scanner read a tab-enter before continuing to scan, 
   * this allows multi-line input from user */
   listBuilder.scan.useDelimiter("\\t");
   System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
   dedicatedTransportChoice.setUnitComposition(listBuilder.scan.next());
   listBuilder.scan.reset();

  dedicatedTransportPointCalculator();

   System.out.println();
   listBuilder.scan.useDelimiter("\\t");
   System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
   dedicatedTransportChoice.setRemarks(listBuilder.scan.next());
   listBuilder.scan.reset();

   listBuilder.createdUnits.add(dedicatedTransportChoice.toString());

   System.out.println();
   listBuilder.scan.nextLine();
   System.out.println("Pick another dedicated transport? (yes/no)");
   String dedicatedTransportAnswer = listBuilder.scan.nextLine();

  //Call the method again of there are additional inputs.
  if (dedicatedTransportAnswer.equalsIgnoreCase("yes")) {
    pickedDedicatedTransport(); //call to own method.
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
public void dedicatedTransportPointCalculator() {
 try {
 System.out.println();
 System.out.println("Enter # of models in the unit.");
 dedicatedTransportChoice.setNumInUnit(listBuilder.scan.nextInt());

 System.out.println();
 System.out.println("Enter # of points per model.");
 dedicatedTransportChoice.setPointVal(listBuilder.scan.nextInt());

 System.out.println();
 System.out.println("Enter total upgrade pts.");
 dedicatedTransportChoice.setUpgradePoints(listBuilder.scan.nextInt());

 //Adds each unit pts value separately.
 dedicatedTransportUnitPointVal = (dedicatedTransportChoice.getNumInUnit() * dedicatedTransportChoice.getPointVal()) + dedicatedTransportChoice.getUpgradePoints();
 
 //Holds a running total of how many pts the dedicatedTransport units cost in total.
 dedicatedTransportTotalPointVal += dedicatedTransportUnitPointVal;
 }
 catch (Exception ex) {
  System.out.println("\n" + "An error occurred." + "\n" 
  + "Please only enter numbers." + "\n");
  ex.printStackTrace();
 }
}
}