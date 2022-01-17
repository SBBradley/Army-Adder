import java.io.*;
import java.util.*;

/*
* Army list creator for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public abstract class UnitBuilder {

   protected String UnitName;
   protected String BattleRole;
   protected int NumInUnit;
   protected int PointVal;
   protected static int TotalUnitCount;
   
/**
* Constructor for class ArmyAdder
* @param BattleRole inputs the battlefield role of the unit.
* @param PointVal inputs the point value cost for the unit selected unit.
* @param TotalPointVal inputs the total point value cost for the unit selected unit.
* @param TotalUnitCount inputs the total amount of units in the created army list.
*/
   public UnitBuilder(String UnitNameIn, String BattleRoleIn, int NumInUnitIn, int PointValIn) {
      UnitName = UnitNameIn;
      BattleRole = BattleRoleIn;
      NumInUnit = NumInUnitIn;
      PointVal = PointValIn;
   }
   
    /**
    * Method for getting the unit's name.
    * @return returns UnitName.
    */
   public String getUnitName() {
      return UnitName;
   }

   /**
    * Method for setting unit's name.
    * @param UnitNameIn inputs UnitName.
    */
   public void setUnitName(String UnitNameIn) {
      UnitName = UnitNameIn;
   }
   
   /**
    * Method for getting battlefield role..
    * @return returns BattleRole .
    */
   public String getBattleRole() {
      return BattleRole;
   }

   /**
    * Method for setting battlefield role.
    * @param BattleRoleIn inputs BattleRole.
    */
   public void setBattleRole(String BattleRoleIn) {
      BattleRole = BattleRoleIn;
   }
   
   /**
    * Method for getting number of models in the unit.
    * @return returns NumInUnit.
    */
   public int getNumInUnit() {
      return NumInUnit;
   }

   /**
    * Method for setting number of models in the unit.
    * @param NumInUnitIn inputs NumInUnit.
    */
   public void setNumInUnit(int NumInUnitIn) {
      NumInUnit = NumInUnitIn;
   }

   /**
    * Method for getting the point cost for the unit.
    * @return returns PointValIn.
    */
   public int getPointVal() {
      return PointVal;
   }

   /**
    * Method for setting number of models in the unit.
    * @param PointValIn inputs PointVal.
    */
   public void setPointVal(int PointValInIn) {
      PointVal= PointValInIn;
   }

   /**
    * Method for getting total unit count.
    * @return returns TotalUnitCount.
    */
   public static int getTotalUnitCount() {
      return TotalUnitCount;
   }
   
   /**
    * Method for increasing total unit count.
    * @return returns TotalUnitCount++.
    */
   public static int increaseTotalUnitCount() {
      return TotalUnitCount++;
   }
}