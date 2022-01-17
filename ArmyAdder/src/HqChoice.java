import java.io.*;
import java.util.*;

/*
* Army list creator for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class HqChoice extends UnitBuilder {

//Constructor that takes the parameters of the unit.
   public HqChoice(String UnitName, String BattleRole, int NumInUnit, int PointVal) {
      super(UnitName, BattleRole,  NumInUnit, PointVal);
   }
   
//toString method returns the unit info in string form.
   public String toString() {
   
      String output = super.toString();
      output = "HQ choice: " + UnitName.toUpperCase() + "\n" +
         "Battle role: " + BattleRole + "\n" + 
         "# in unit: " +   NumInUnit + "\n" + 
         "Point value: " + NumInUnit * PointVal;
      return output;
   }
}