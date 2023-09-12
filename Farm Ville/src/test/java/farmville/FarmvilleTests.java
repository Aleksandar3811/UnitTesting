package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    Animal animal;
    Farm farm;

    @Before
    public void setUp() {
        animal = new Animal("Alek", 50);
        farm = new Farm("Belene", 1);
        farm.add(animal);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testGetAnimalName() {
        Assert.assertEquals("Alek", animal.getType());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(1, farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalAtFullCapacityShouldThrow() {
        Animal animal1 = new Animal("Emo", 45.4);
        farm.add(animal1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAnimalShouldThrow() {
        farm.add(animal);
    }

    @Test
    public void testAddAnimal() {
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveAnimal() {
        farm.remove("Alek");
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityBelowZeroShouldThrow() {
        Farm farm1 = new Farm("Pleven", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow() {
        Farm farm1 = new Farm(null, 50);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyNameShouldThrow() {
        Farm farm1 = new Farm("  ", 40);
    }

    @Test
    public void testGetFarmName() {
        Assert.assertEquals("Belene",farm.getName());
    }
    @Test
    public void testGetAnimalEnergy(){
        double expected=50.0;
        Assert.assertEquals(expected,animal.getEnergy(),0.0f);
    }
}
