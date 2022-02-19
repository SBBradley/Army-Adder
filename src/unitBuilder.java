/*
* Army list creator for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public abstract class unitBuilder {

   String unitName;
   String battleRole;
   String specialWeapons;
   String upgrades;
   String remarks;
   int numInUnit;
   int pointVal;
   static int totalUnitCount;
   
/**
* Constructor for class unitBuilder.
* @param battleRole inputs the battlefield role of the unit.
* @param pointVal inputs the point value cost for the unit selected unit.
  @param specialWeapons inputs any special weapons added to the unit.
  @param upgrades inputs any upgrades added to the unit.
  @param remarks adds any remarks for the unit.
* @param totalPointVal inputs the total point value cost for the unit selected unit.
* @param totalUnitCount inputs the total amount of units in the created army list.
*/
   public unitBuilder(String unitNameIn, String battleRoleIn, String specialWeaponsIn,
    String upgradesIn, String remarksIn, int numInUnitIn, int pointValIn) {
      unitName = unitNameIn;
      battleRole = battleRoleIn;
      specialWeapons = specialWeaponsIn;
      upgrades = upgradesIn;
      remarks = remarksIn;
      numInUnit = numInUnitIn;
      pointVal = pointValIn;
   }
   
   //STRINGS:

    /**
    * Method for getting the unit's name.
    * @return returns unitName.
    */
   public String getUnitName() {
      return unitName;
   }

   /**
    * Method for setting unit's name.
    * @param unitNameIn inputs unitName.
    */
   public void setUnitName(String unitNameIn) {
      unitName = unitNameIn;
   }
   
   /**
    * Method for getting battlefield role..
    * @return returns battleRole .
    */
   public String getBattleRole() {
      return battleRole;
   }

   /**
    * Method for setting battlefield role.
    * @param battleRoleIn inputs battleRole.
    */
   public void setBattleRole(String battleRoleIn) {
      battleRole = battleRoleIn;
   }

   /**
    * Method for getting any special weapons for the unit.
    * @return  returns specialWeapons.
    */
    public String getSpecialWeapons() {
      return specialWeapons;
   }

   /**
    *  Method for setting any special weapons for the unit.
    * @param specialWeaponsIn inputs specialWeapons.
    */
   public void setSpecialWeapons(String specialWeaponsIn) {
      specialWeapons = specialWeaponsIn;
   }

   /**
    * Method for getting any upgrades for the unit.
    * @return returns upgrades.
    */
    public String getUpgrades() {
      return upgrades;
   }

   /**
    * Method for setting any upgrades for the unit.
    * @param upgradesIn inputs upgrades.
    */
   public void setUpgrades(String upgradesIn) {
      upgrades = upgradesIn;
   }

    /**
    * Method for getting any additional remarks for the unit.
    * @return returns remarks.
    */
    public String getRemarks() {
      return remarks;
   }

   /**
    * Method for setting any additional remarks for the unit.
    * @param remarksIn inputs remarks.
    */
   public void setRemarks(String remarksIn) {
      remarks = remarksIn;
   }

   

   //INTS:
   
   /**
    * Method for getting number of models in the unit.
    * @return returns numInUnit.
    */
   public int getNumInUnit() {
      return numInUnit;
   }

   /**
    * Method for setting number of models in the unit.
    * @param numInUnitIn inputs numInUnit.
    */
   public void setNumInUnit(int numInUnitIn) {
      numInUnit = numInUnitIn;
   }

   /**
    * Method for getting the point cost for the unit.
    * @return returns pointValIn.
    */
   public int getPointVal() {
      return pointVal;
   }

   /**
    * Method for setting number of models in the unit.
    * @param pointValIn inputs pointVal.
    */
   public void setPointVal(int pointValInIn) {
      pointVal= pointValInIn;
   }

   /**
    * Method for getting total unit count.
    * @return returns totalUnitCount.
    */
   public static int getTotalUnitCount() {
      return totalUnitCount;
   }
   
   /**
    * Method for increasing total unit count.
    * @return returns totalUnitCount++.
    */
   public static int increaseTotalUnitCount() {
      return totalUnitCount++;
   }
}