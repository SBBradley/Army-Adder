/*
* Army list creator for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class dedicatedTransport extends unitBuilder {

//Constructor that takes the parameters of the unit.
   public dedicatedTransport(String unitName, String battleRole, String specialWeapons, 
   String upgrades, String remarks, int numInUnit, int pointVal) {
      super(unitName, battleRole, specialWeapons, upgrades, remarks, numInUnit, pointVal);
   }
   
//toString method returns the unit info in string form.
   public String toString() {
      String output = super.toString();

      //Appends all info from user input.
      output = "Dedicated Transport: " + unitName.toUpperCase() + "\n" 
      + "- Battle role: " + battleRole + "\n"
      + "- # in unit: " +   numInUnit + "\n"
      + "- Point value: " + numInUnit * pointVal + "\n"
      + "- Special weapons: " + specialWeapons + "\n"
      + "- Upgrades: " + upgrades + "\n"
      + " -Remarks " + remarks;
      return output;
   }
}