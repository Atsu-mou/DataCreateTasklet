package com.dataCreate.SpringBootBatchTasklet.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PetTest {
    /**
     * Method under test: {@link Pet#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new Pet()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Pet#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        Pet pet = new Pet();
        assertTrue(pet.canEqual(new Pet()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Pet#Pet()}
     *   <li>{@link Pet#setAge(Integer)}
     *   <li>{@link Pet#setAnimal(String)}
     *   <li>{@link Pet#setGender(String)}
     *   <li>{@link Pet#setName(String)}
     *   <li>{@link Pet#toString()}
     *   <li>{@link Pet#getAge()}
     *   <li>{@link Pet#getAnimal()}
     *   <li>{@link Pet#getGender()}
     *   <li>{@link Pet#getName()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        Pet actualPet = new Pet();
        actualPet.setAge(1);
        actualPet.setAnimal("Animal");
        actualPet.setGender("Gender");
        actualPet.setName("Bella");
        String actualToStringResult = actualPet.toString();
        assertEquals(1, actualPet.getAge().intValue());
        assertEquals("Animal", actualPet.getAnimal());
        assertEquals("Gender", actualPet.getGender());
        assertEquals("Bella", actualPet.getName());
        assertEquals("Pet(name=Bella, gender=Gender, age=1, animal=Animal)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Pet#Pet(String, String, Integer, String)}
     *   <li>{@link Pet#setAge(Integer)}
     *   <li>{@link Pet#setAnimal(String)}
     *   <li>{@link Pet#setGender(String)}
     *   <li>{@link Pet#setName(String)}
     *   <li>{@link Pet#toString()}
     *   <li>{@link Pet#getAge()}
     *   <li>{@link Pet#getAnimal()}
     *   <li>{@link Pet#getGender()}
     *   <li>{@link Pet#getName()}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        Pet actualPet = new Pet("Bella", "Gender", 1, "Animal");
        actualPet.setAge(1);
        actualPet.setAnimal("Animal");
        actualPet.setGender("Gender");
        actualPet.setName("Bella");
        String actualToStringResult = actualPet.toString();
        assertEquals(1, actualPet.getAge().intValue());
        assertEquals("Animal", actualPet.getAnimal());
        assertEquals("Gender", actualPet.getGender());
        assertEquals("Bella", actualPet.getName());
        assertEquals("Pet(name=Bella, gender=Gender, age=1, animal=Animal)", actualToStringResult);
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new Pet(), null);
        assertNotEquals(new Pet(), "Different type to Pet");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Pet#equals(Object)}
     *   <li>{@link Pet#hashCode()}
     * </ul>
     */
    @Test
    public void testEquals2() {
        Pet pet = new Pet();
        assertEquals(pet, pet);
        int expectedHashCodeResult = pet.hashCode();
        assertEquals(expectedHashCodeResult, pet.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Pet#equals(Object)}
     *   <li>{@link Pet#hashCode()}
     * </ul>
     */
    @Test
    public void testEquals3() {
        Pet pet = new Pet();
        Pet pet1 = new Pet();
        assertEquals(pet, pet1);
        int expectedHashCodeResult = pet.hashCode();
        assertEquals(expectedHashCodeResult, pet1.hashCode());
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals4() {
        Pet pet = new Pet("Bella", "Gender", 1, "Animal");
        assertNotEquals(pet, new Pet());
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals5() {
        Pet pet = new Pet();
        assertNotEquals(pet, new Pet("Bella", "Gender", 1, "Animal"));
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals6() {
        Pet pet = new Pet();
        pet.setName("Bella");
        assertNotEquals(pet, new Pet());
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals7() {
        Pet pet = new Pet();
        pet.setGender("Gender");
        assertNotEquals(pet, new Pet());
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals8() {
        Pet pet = new Pet();
        pet.setAnimal("Animal");
        assertNotEquals(pet, new Pet());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Pet#equals(Object)}
     *   <li>{@link Pet#hashCode()}
     * </ul>
     */
    @Test
    public void testEquals9() {
        Pet pet = new Pet("Bella", "Gender", 1, "Animal");
        Pet pet1 = new Pet("Bella", "Gender", 1, "Animal");

        assertEquals(pet, pet1);
        int expectedHashCodeResult = pet.hashCode();
        assertEquals(expectedHashCodeResult, pet1.hashCode());
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals10() {
        Pet pet = new Pet();

        Pet pet1 = new Pet();
        pet1.setName("Bella");
        assertNotEquals(pet, pet1);
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals11() {
        Pet pet = new Pet();

        Pet pet1 = new Pet();
        pet1.setGender("Gender");
        assertNotEquals(pet, pet1);
    }

    /**
     * Method under test: {@link Pet#equals(Object)}
     */
    @Test
    public void testEquals12() {
        Pet pet = new Pet();

        Pet pet1 = new Pet();
        pet1.setAnimal("Animal");
        assertNotEquals(pet, pet1);
    }
}

