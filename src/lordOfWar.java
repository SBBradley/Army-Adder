/*
* Army list creator for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public class lordOfWar extends unitBuilder {

    //Constructor that takes the parameters of the unit.
       public lordOfWar(String unitName, String battleRole, String specialWeapons, 
       String upgrades, String remarks, int numInUnit, int pointVal) {
          super(unitName, battleRole, specialWeapons, upgrades, remarks, numInUnit, pointVal);
       }
       
    //toString method returns the unit info in string form.
       public String toString() {
          String output = super.toString();
    
          //Appends all info from user input.
          output = "Lord of War: " + unitName.toUpperCase() + "\n" 
         + "- Battle role: " + battleRole + " / " + "# in unit: " +   numInUnit + " / " +"Pts: " + numInUnit * pointVal + "\n"
         + "- Special weapons: " + specialWeapons + "\n"
         + "- Upgrades: " + upgrades + "\n"
         + " -Remarks " + remarks;
          return output;
       }
    }

