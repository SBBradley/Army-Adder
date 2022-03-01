import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/*
*Test case file for ArmyAdder.java
*February 28, 2022
*/
public class ArmyAdderTest {
   
//Fixture initialization
@Before 
public void setUp() {
}

//CONSTRUCTOR: unitBuilder(String unitNameIn, String unitCompositionIn, String remarksIn, int upgradePointsIn, int numInUnitIn, int pointValIn)

@Test
public void dedicatedTransportTest() {
dedicatedTransport dedicatedTransportChoice = new dedicatedTransport("Tank", "3 tanks with mega cannon", "Special abilities: ignore terrain", 500, 3, 100);
dedicatedTransportChoice.setDedicatedTransportTotalPointVal(800);
assertEquals("Tank", dedicatedTransportChoice.getUnitName());
assertEquals("3 tanks with mega cannon", dedicatedTransportChoice.getUnitComposition());
assertEquals("Special abilities: ignore terrain", dedicatedTransportChoice.getRemarks());
assertEquals(500, dedicatedTransportChoice.getUpgradePoints());
assertEquals(3, dedicatedTransportChoice.getNumInUnit());
assertEquals(100, dedicatedTransportChoice.getPointVal());
assertEquals(800, dedicatedTransport.getDedicatedTransportTotalPointVal());
}

@Test
public void elitesTest() {

}

@Test
public void fastAttackTest() {
    
}

@Test
public void flyerTest() {
    
}

@Test
public void fortificationTest() {
    
}

@Test
public void heavySupportTest() {
    
}

@Test
public void HQTest() {
HQ hqChoice = new HQ("Captain", "1 captain with chainsword", "Special abilities: thunder stomp", 50, 1, 100);
hqChoice.setHqTotalPointVal(150);
assertEquals("Captain", hqChoice.getUnitName());
assertEquals("1 captain with chainsword", hqChoice.getUnitComposition());
assertEquals("Special abilities: thunder stomp", hqChoice.getRemarks());
assertEquals(50, hqChoice.getUpgradePoints());
assertEquals(1, hqChoice.getNumInUnit());
assertEquals(100, hqChoice.getPointVal());
assertEquals(150, HQ.getHqTotalPointVal());
}

@Test
public void lordOfWarTest() {
    
}

@Test
public void troopsTest() {
    
}

@Test
public void unitBuilderTest() {
    
}

}
