/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class elites extends unitBuilder {

  // Class object created to hold each unit's info.
  static elites elitesChoice = new elites("", "", "", 0, 0, 0);
  private int elitesUnitPointVal;
  private static int elitesTotalPointVal;

  // Constructor that takes the parameters of the unit.
  public elites(String unitName, String unitComposition, String remarks,
      int upgradePoints, int numInUnit, int pointVal) {
    super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

  // toString method returns the unit info in string form.
  public String toString() {
    String output = super.toString();

    // Appends all info from user input.
    output = "* ELITES: "
        + getUnitName().toUpperCase() + " / "
        + "[" + elitesUnitPointVal + "pts] *" + "\n"
        + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
        + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
    return output;
  }

  /**
   * Method for getting the elites unit point val.
   * 
   * @return returns elitesUnitPointVal
   */
  public int getElitesUnitPointVal() {
    return elitesUnitPointVal;
  }

  /**
   * Method for setting elites unit point val.
   * 
   * @param elitesUnitPointValIn inputs elitesUnitPointVal.
   */
  public void setElitesUnitPointVal(int elitesUnitPointValIn) {
    elitesUnitPointVal = elitesUnitPointValIn;
  }

  /**
   * Method for getting the elites total point val.
   * 
   * @return returns elites Total Point Val
   */
  public static int getElitesTotalPointVal() {
    return elitesTotalPointVal;
  }

  /**
   * Method for setting elites total point val.
   * 
   * @param elitesTotalPointValIn inputs elitesTotalPointVal.
   */
  public void setElitesTotalPointVal(int elitesTotalPointValIn) {
    elitesTotalPointVal = elitesTotalPointValIn;
  }

  // Method that gathers all necessary elites info.
  public void pickedElites() {
    try {

      /*
       * Total unit count will only increase
       * by 1 if this type of unit is created.
       */
      unitBuilder.increaseTotalUnitCount();

      System.out.println();
      System.out.println("Make an elites choice.");
      elitesChoice.setUnitName(listBuilder.scan.nextLine());

      System.out.println();

      /*
       * Makes the scanner read a tab-enter before continuing to scan,
       * this allows multi-line input from user
       */
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
      elitesChoice.setUnitComposition(listBuilder.scan.next());
      listBuilder.scan.reset();

      elitesPointCalculator();

      System.out.println();
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
      elitesChoice.setRemarks(listBuilder.scan.next());
      listBuilder.scan.reset();

      listBuilder.createdUnits.add(elitesChoice.toString());

      System.out.println();
      listBuilder.scan.nextLine();
      System.out.println("Pick another elites? (yes/no)");
      String elitesAnswer = listBuilder.scan.nextLine();

      // Call the method again of there are additional inputs.
      if (elitesAnswer.equalsIgnoreCase("yes")) {
        pickedElites(); // call to own method.
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
  public void elitesPointCalculator() {
    try {
      System.out.println();
      System.out.println("Enter # of models in the unit.");
      elitesChoice.setNumInUnit(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter # of points per model.");
      elitesChoice.setPointVal(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter total upgrade pts.");
      elitesChoice.setUpgradePoints(listBuilder.scan.nextInt());

      // Adds each unit pts value separately.
      elitesUnitPointVal = (elitesChoice.getNumInUnit() * elitesChoice.getPointVal()) + elitesChoice.getUpgradePoints();

      // Holds a running total of how many pts the elites units cost in total.
      elitesTotalPointVal += elitesUnitPointVal;
    } catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n"
          + "Please only enter numbers." + "\n");
      ex.printStackTrace();
    }
  }
}