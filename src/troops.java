/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class troops extends unitBuilder {

  // Class object created to hold each unit's info.
  static troops troopsChoice = new troops("", "", "", 0, 0, 0);
  private int troopsUnitPointVal;
  private static int troopsTotalPointVal;

  // Constructor that takes the parameters of the unit.
  public troops(String unitName, String unitComposition, String remarks,
      int upgradePoints, int numInUnit, int pointVal) {
    super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

  // toString method returns the unit info in string form.
  public String toString() {
    String output = super.toString();

    // Appends all info from user input.
    output = "* TROOPS: "
        + getUnitName().toUpperCase() + " / "
        + "[" + troopsUnitPointVal + "pts] *" + "\n"
        + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
        + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
    return output;
  }

  /**
   * Method for getting the troops unit point val.
   * 
   * @return returns troopsUnitPointVal
   */
  public int getTroopsUnitPointVal() {
    return troopsUnitPointVal;
  }

  /**
   * Method for setting troops unit point val.
   * 
   * @param troopsUnitPointValIn inputs troopsUnitPointVal.
   */
  public void setTroopsUnitPointVal(int troopsUnitPointValIn) {
    troopsUnitPointVal = troopsUnitPointValIn;
  }

  /**
   * Method for getting the troops total point val.
   * 
   * @return returns troops Total Point Val
   */
  public static int getTroopsTotalPointVal() {
    return troopsTotalPointVal;
  }

  /**
   * Method for setting troops total point val.
   * 
   * @param troopsTotalPointValIn inputs troopsTotalPointVal.
   */
  public void setTroopsTotalPointVal(int troopsTotalPointValIn) {
    troopsTotalPointVal = troopsTotalPointValIn;
  }

  // Method that gathers all necessary troops info.
  public void pickedTroops() {
    try {

      /*
       * Total unit count will only increase
       * by 1 if this type of unit is created.
       */
      unitBuilder.increaseTotalUnitCount();

      System.out.println();
      System.out.println("Make a troops choice.");
      troopsChoice.setUnitName(listBuilder.scan.nextLine());

      System.out.println();

      /*
       * Makes the scanner read a tab-enter before continuing to scan,
       * this allows multi-line input from user
       */
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
      troopsChoice.setUnitComposition(listBuilder.scan.next());
      listBuilder.scan.reset();

      troopsPointCalculator();

      System.out.println();
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
      troopsChoice.setRemarks(listBuilder.scan.next());
      listBuilder.scan.reset();

      listBuilder.createdUnits.add(troopsChoice.toString());

      System.out.println();
      listBuilder.scan.nextLine();
      System.out.println("Pick another troops? (yes/no)");
      String troopsAnswer = listBuilder.scan.nextLine();

      // Call the method again of there are additional inputs.
      if (troopsAnswer.equalsIgnoreCase("yes")) {
        pickedTroops(); // call to own method.
        listBuilder.scan.nextLine();
        System.out.println();
      } else {
        listBuilder.unitCreate();
        System.out.println();
      }
    } catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n");
      ex.printStackTrace();
    }
  }

  // This method takes point values from user and calculates total point value.
  public void troopsPointCalculator() {
    try {
      System.out.println();
      System.out.println("Enter # of models in the unit.");
      troopsChoice.setNumInUnit(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter # of points per model.");
      troopsChoice.setPointVal(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter total upgrade pts.");
      troopsChoice.setUpgradePoints(listBuilder.scan.nextInt());

      // Adds each unit pts value separately.
      troopsUnitPointVal = (troopsChoice.getNumInUnit() * troopsChoice.getPointVal()) + troopsChoice.getUpgradePoints();

      // Holds a running total of how many pts the troops units cost in total.
      troopsTotalPointVal += troopsUnitPointVal;
    } catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n"
          + "Please only enter numbers." + "\n");
      ex.printStackTrace();
    }
  }
}