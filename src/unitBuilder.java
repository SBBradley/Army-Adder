/*
* Army list class for a tabletop wargame.
* Date: Jan. 16, 2022
*/
public abstract class unitBuilder {

 private String unitName;
 private String unitComposition;
 private String remarks;
 private int upgradePoints;
 private int numInUnit;
 private int pointVal;
 private static int totalUnitCount;
 
//Constructor for class unitBuilder.
 public unitBuilder(String unitNameIn, String unitCompositionIn, String remarksIn,
 int upgradePointsIn, int numInUnitIn, int pointValIn) {
  
  unitName = unitNameIn;
  unitComposition = unitCompositionIn;
  remarks = remarksIn;
  upgradePoints = upgradePointsIn;
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
 * Method for getting unit composition.
 * @return returns unitComposition.
 */
 public String getUnitComposition() {
  return unitComposition;
 }

 /**
 * Method for setting unit composition.
 * @param unitCompositionIn inputs unitComposition.
 */
 public void setUnitComposition(String unitCompositionIn) {
  unitComposition = unitCompositionIn;
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
 * Method for getting upgrade points.
 * @return returns upgradePoints.
 */
 public int getUpgradePoints() {
  return upgradePoints;
 }

 /**
 * Method for setting upgrade points.
 * @param upgradePointsIn inputs upgradePoints.
 */
 public void setUpgradePoints(int upgradePointsIn) {
  upgradePoints = upgradePointsIn;
 }

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