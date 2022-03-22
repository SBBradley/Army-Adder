/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class fortification extends unitBuilder {

  // Class object created to hold each unit's info.
  static fortification fortificationChoice = new fortification("", "", "", 0, 0, 0);
  private int fortificationUnitPointVal;
  private static int fortificationTotalPointVal;

  // Constructor that takes the parameters of the unit.
  public fortification(String unitName, String unitComposition, String remarks,
      int upgradePoints, int numInUnit, int pointVal) {
    super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

  // toString method returns the unit info in string form.
  public String toString() {
    String output = super.toString();

    // Appends all info from user input.
    output = "* FORTIFICATION: "
        + getUnitName().toUpperCase() + " / "
        + "[" + fortificationUnitPointVal + "pts] *" + "\n"
        + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
        + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
    return output;
  }

  /**
   * Method for getting the fortification unit point val.
   * 
   * @return returns fortificationUnitPointVal
   */
  public int getFortificationUnitPointVal() {
    return fortificationUnitPointVal;
  }

  /**
   * Method for setting fortification unit point val.
   * 
   * @param fortificationUnitPointValIn inputs fortificationUnitPointVal.
   */
  public void setFortificationUnitPointVal(int fortificationUnitPointValIn) {
    fortificationUnitPointVal = fortificationUnitPointValIn;
  }

  /**
   * Method for getting the fortification total point val.
   * 
   * @return returns fortification Total Point Val
   */
  public static int getFortificationTotalPointVal() {
    return fortificationTotalPointVal;
  }

  /**
   * Method for setting fortification total point val.
   * 
   * @param fortificationTotalPointValIn inputs fortificationTotalPointVal.
   */
  public void setFortificationTotalPointVal(int fortificationTotalPointValIn) {
    fortificationTotalPointVal = fortificationTotalPointValIn;
  }

  // Method that gathers all necessary fortification info.
  public void pickedFortification() {
    try {

      /*
       * Total unit count will only increase
       * by 1 if this type of unit is created.
       */
      unitBuilder.increaseTotalUnitCount();

      System.out.println();
      System.out.println("Make a fortification choice.");
      fortificationChoice.setUnitName(listBuilder.scan.nextLine());

      System.out.println();

      /*
       * Makes the scanner read a tab-enter before continuing to scan,
       * this allows multi-line input from user
       */
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
      fortificationChoice.setUnitComposition(listBuilder.scan.next());
      listBuilder.scan.reset();

      fortificationPointCalculator();

      System.out.println();
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
      fortificationChoice.setRemarks(listBuilder.scan.next());
      listBuilder.scan.reset();

      listBuilder.createdUnits.add(fortificationChoice.toString());

      System.out.println();
      listBuilder.scan.nextLine();
      System.out.println("Pick another fortification? (yes/no)");
      String fortificationAnswer = listBuilder.scan.nextLine();

      // Call the method again of there are additional inputs.
      if (fortificationAnswer.equalsIgnoreCase("yes")) {
        pickedFortification(); // call to own method.
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
  public void fortificationPointCalculator() {
    try {
      System.out.println();
      System.out.println("Enter # of models in the unit.");
      fortificationChoice.setNumInUnit(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter # of points per model.");
      fortificationChoice.setPointVal(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter total upgrade pts.");
      fortificationChoice.setUpgradePoints(listBuilder.scan.nextInt());

      // Adds each unit pts value separately.
      fortificationUnitPointVal = (fortificationChoice.getNumInUnit() * fortificationChoice.getPointVal())
          + fortificationChoice.getUpgradePoints();

      // Holds a running total of how many pts the fortification units cost in total.
      fortificationTotalPointVal += fortificationUnitPointVal;
    } catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n"
          + "Please only enter numbers." + "\n");
      ex.printStackTrace();
    }
  }
}