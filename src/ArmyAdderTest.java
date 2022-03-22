import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/*
*Test case file for ArmyAdder.java
*February 28, 2022
*/
public class ArmyAdderTest {

    // Fixture initialization
    @Before
    public void setUp() {
    }

    // CONSTRUCTOR: unitBuilder(String unitNameIn, String unitCompositionIn, String
    // remarksIn, int upgradePointsIn, int numInUnitIn, int pointValIn)

    @Test
    public void dedicatedTransportTest() {
        dedicatedTransport dedicatedTransportChoice = new dedicatedTransport("Transport Truck", "3 transport trucks",
                "Special abilities: ignore terrain Transport capacity: 10", 500, 3, 100);
        dedicatedTransportChoice.setDedicatedTransportTotalPointVal(800);
        assertEquals("Transport Truck", dedicatedTransportChoice.getUnitName());
        assertEquals("3 transport trucks", dedicatedTransportChoice.getUnitComposition());
        assertEquals("Special abilities: ignore terrain Transport capacity: 10", dedicatedTransportChoice.getRemarks());
        assertEquals(500, dedicatedTransportChoice.getUpgradePoints());
        assertEquals(3, dedicatedTransportChoice.getNumInUnit());
        assertEquals(100, dedicatedTransportChoice.getPointVal());
        assertEquals(800, dedicatedTransport.getDedicatedTransportTotalPointVal());
    }

    @Test
    public void elitesTest() {
        elites elitesChoice = new elites("Commando Squad", "5 commandos with pistols and grenades",
                "Special abilities: stealth, infiltrate", 1000, 5, 250);
        elitesChoice.setElitesTotalPointVal(2250);
        assertEquals("Commando Squad", elitesChoice.getUnitName());
        assertEquals("5 commandos with pistols and grenades", elitesChoice.getUnitComposition());
        assertEquals("Special abilities: stealth, infiltrate", elitesChoice.getRemarks());
        assertEquals(1000, elitesChoice.getUpgradePoints());
        assertEquals(5, elitesChoice.getNumInUnit());
        assertEquals(250, elitesChoice.getPointVal());
        assertEquals(2250, elites.getElitesTotalPointVal());
    }

    @Test
    public void fastAttackTest() {
        fastAttack fastAttackChoice = new fastAttack("Warbikers", "10 warbikers with chains",
                "Special abilities: burnout, turbo", 200, 10, 100);
        fastAttackChoice.setFastAttackTotalPointVal(1200);
        assertEquals("Warbikers", fastAttackChoice.getUnitName());
        assertEquals("10 warbikers with chains", fastAttackChoice.getUnitComposition());
        assertEquals("Special abilities: burnout, turbo", fastAttackChoice.getRemarks());
        assertEquals(200, fastAttackChoice.getUpgradePoints());
        assertEquals(10, fastAttackChoice.getNumInUnit());
        assertEquals(100, fastAttackChoice.getPointVal());
        assertEquals(1200, fastAttack.getFastAttackTotalPointVal());
    }

    @Test
    public void flyerTest() {
        flyer flyerChoice = new flyer("Warplane Squadron", "9 warplanes with bombs and missiles",
                "Special abilities: strafe run, bombardment", 500, 9, 650);
        flyerChoice.setFlyerTotalPointVal(6350);
        assertEquals("Warplane Squadron", flyerChoice.getUnitName());
        assertEquals("9 warplanes with bombs and missiles", flyerChoice.getUnitComposition());
        assertEquals("Special abilities: strafe run, bombardment", flyerChoice.getRemarks());
        assertEquals(500, flyerChoice.getUpgradePoints());
        assertEquals(9, flyerChoice.getNumInUnit());
        assertEquals(650, flyerChoice.getPointVal());
        assertEquals(6350, flyer.getFlyerTotalPointVal());
    }

    @Test
    public void fortificationTest() {
        fortification fortificationChoice = new fortification("Bunker", "1 bunker with machine gun turrets",
                "Special abilities: fortress, rally point", 70, 1, 700);
        fortificationChoice.setFortificationTotalPointVal(770);
        assertEquals("Bunker", fortificationChoice.getUnitName());
        assertEquals("1 bunker with machine gun turrets", fortificationChoice.getUnitComposition());
        assertEquals("Special abilities: fortress, rally point", fortificationChoice.getRemarks());
        assertEquals(70, fortificationChoice.getUpgradePoints());
        assertEquals(1, fortificationChoice.getNumInUnit());
        assertEquals(700, fortificationChoice.getPointVal());
        assertEquals(770, fortification.getFortificationTotalPointVal());
    }

    @Test
    public void heavySupportTest() {
        heavySupport heavySupportChoice = new heavySupport("Armored Tank", "2 armored tanks with mega cannons",
                "Special abilities: ignore terrain, death roller, armorclad", 300, 2, 300);
        heavySupportChoice.setHeavySupportTotalPointVal(900);
        assertEquals("Armored Tank", heavySupportChoice.getUnitName());
        assertEquals("2 armored tanks with mega cannons", heavySupportChoice.getUnitComposition());
        assertEquals("Special abilities: ignore terrain, death roller, armorclad", heavySupportChoice.getRemarks());
        assertEquals(300, heavySupportChoice.getUpgradePoints());
        assertEquals(2, heavySupportChoice.getNumInUnit());
        assertEquals(300, heavySupportChoice.getPointVal());
        assertEquals(900, heavySupport.getHeavySupportTotalPointVal());
    }

    @Test
    public void HQTest() {
        HQ hqChoice = new HQ("Captain", "1 captain with chainsword", "Special abilities: thunder smash", 50, 1, 100);
        hqChoice.setHqTotalPointVal(150);
        assertEquals("Captain", hqChoice.getUnitName());
        assertEquals("1 captain with chainsword", hqChoice.getUnitComposition());
        assertEquals("Special abilities: thunder smash", hqChoice.getRemarks());
        assertEquals(50, hqChoice.getUpgradePoints());
        assertEquals(1, hqChoice.getNumInUnit());
        assertEquals(100, hqChoice.getPointVal());
        assertEquals(150, HQ.getHqTotalPointVal());
    }

    @Test
    public void lordOfWarTest() {
        lordOfWar lordOfWarChoice = new lordOfWar("Berserker", "1 berserker with twin axes",
                "Special abilities: feel no pain, wrath", 100, 1, 200);
        lordOfWarChoice.setLordOfWarTotalPointVal(300);
        assertEquals("Berserker", lordOfWarChoice.getUnitName());
        assertEquals("1 berserker with twin axes", lordOfWarChoice.getUnitComposition());
        assertEquals("Special abilities: feel no pain, wrath", lordOfWarChoice.getRemarks());
        assertEquals(100, lordOfWarChoice.getUpgradePoints());
        assertEquals(1, lordOfWarChoice.getNumInUnit());
        assertEquals(200, lordOfWarChoice.getPointVal());
        assertEquals(300, lordOfWar.getLordOfWarTotalPointVal());
    }

    @Test
    public void troopsTest() {
        troops troopsChoice = new troops("Assualt Squad 1",
                "1 squad leader with rocket launcher, 9 infantrymen with rifles", "", 50, 10, 10);
        troopsChoice.setTroopsTotalPointVal(150);
        assertEquals("Assualt Squad 1", troopsChoice.getUnitName());
        assertEquals("1 squad leader with rocket launcher, 9 infantrymen with rifles",
                troopsChoice.getUnitComposition());
        assertEquals("", troopsChoice.getRemarks());
        assertEquals(50, troopsChoice.getUpgradePoints());
        assertEquals(10, troopsChoice.getNumInUnit());
        assertEquals(10, troopsChoice.getPointVal());
        assertEquals(150, troops.getTroopsTotalPointVal());
    }

    @Test
    public void capitalizeStringTest() {
        assertEquals("Hulk", listBuilder.capitalizeString("hulk"));
        assertEquals("Hogan", listBuilder.capitalizeString("hogan"));
    }
}