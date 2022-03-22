/*
* Army list class used by class listBuilder for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class lordOfWar extends unitBuilder {

  // Class object created to hold each unit's info.
  static lordOfWar lordOfWarChoice = new lordOfWar("", "", "", 0, 0, 0);
  private int lordOfWarUnitPointVal;
  private static int lordOfWarTotalPointVal;

  // Constructor that takes the parameters of the unit.
  public lordOfWar(String unitName, String unitComposition, String remarks,
      int upgradePoints, int numInUnit, int pointVal) {
    super(unitName, unitComposition, remarks, upgradePoints, numInUnit, pointVal);
  }

  // toString method returns the unit info in string form.
  public String toString() {
    String output = super.toString();

    // Appends all info from user input.
    output = "* LORD OF WAR: "
        + getUnitName().toUpperCase() + " / "
        + "[" + lordOfWarUnitPointVal + "pts] *" + "\n"
        + "+ UNIT COMP:" + "\n" + getUnitComposition() + "\n"
        + "+ RMKS: " + "\n" + getRemarks() + "\n" + "\n" + "\n";
    return output;
  }

  /**
   * Method for getting the lordOfWar unit point val.
   * 
   * @return returns lordOfWarUnitPointVal
   */
  public int getLordOfWarUnitPointVal() {
    return lordOfWarUnitPointVal;
  }

  /**
   * Method for setting lordOfWar unit point val.
   * 
   * @param lordOfWarUnitPointValIn inputs lordOfWarUnitPointVal.
   */
  public void setLordOfWarUnitPointVal(int lordOfWarUnitPointValIn) {
    lordOfWarUnitPointVal = lordOfWarUnitPointValIn;
  }

  /**
   * Method for getting the lordOfWar total point val.
   * 
   * @return returns lordOfWar Total Point Val
   */
  public static int getLordOfWarTotalPointVal() {
    return lordOfWarTotalPointVal;
  }

  /**
   * Method for setting lordOfWar total point val.
   * 
   * @param lordOfWarTotalPointValIn inputs lordOfWarTotalPointVal.
   */
  public void setLordOfWarTotalPointVal(int lordOfWarTotalPointValIn) {
    lordOfWarTotalPointVal = lordOfWarTotalPointValIn;
  }

  // Method that gathers all necessary lordOfWar info.
  public void pickedLordOfWar() {
    try {

      /*
       * Total unit count will only increase
       * by 1 if this type of unit is created.
       */
      unitBuilder.increaseTotalUnitCount();

      System.out.println();
      System.out.println("Make a lordOfWar choice.");
      lordOfWarChoice.setUnitName(listBuilder.scan.nextLine());

      System.out.println();

      /*
       * Makes the scanner read a tab-enter before continuing to scan,
       * this allows multi-line input from user
       */
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter unit composition." + "\n" + "Use tab-enter to end.");
      lordOfWarChoice.setUnitComposition(listBuilder.scan.next());
      listBuilder.scan.reset();

      lordOfWarPointCalculator();

      System.out.println();
      listBuilder.scan.useDelimiter("\\t");
      System.out.println("Enter remarks." + "\n" + "Use tab-enter to end.");
      lordOfWarChoice.setRemarks(listBuilder.scan.next());
      listBuilder.scan.reset();

      listBuilder.createdUnits.add(lordOfWarChoice.toString());

      System.out.println();
      listBuilder.scan.nextLine();
      System.out.println("Pick another lord of war? (yes/no)");
      String lordOfWarAnswer = listBuilder.scan.nextLine();

      // Call the method again of there are additional inputs.
      if (lordOfWarAnswer.equalsIgnoreCase("yes")) {
        pickedLordOfWar(); // call to own method.
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
  public void lordOfWarPointCalculator() {
    try {
      System.out.println();
      System.out.println("Enter # of models in the unit.");
      lordOfWarChoice.setNumInUnit(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter # of points per model.");
      lordOfWarChoice.setPointVal(listBuilder.scan.nextInt());

      System.out.println();
      System.out.println("Enter total upgrade pts.");
      lordOfWarChoice.setUpgradePoints(listBuilder.scan.nextInt());

      // Adds each unit pts value separately.
      lordOfWarUnitPointVal = (lordOfWarChoice.getNumInUnit() * lordOfWarChoice.getPointVal())
          + lordOfWarChoice.getUpgradePoints();

      // Holds a running total of how many pts the lordOfWar units cost in total.
      lordOfWarTotalPointVal += lordOfWarUnitPointVal;
    } catch (Exception ex) {
      System.out.println("\n" + "An error occurred." + "\n"
          + "Please only enter numbers." + "\n");
      ex.printStackTrace();
    }
  }
}