import org.junit.*;
import org.junit.runner.Runner;

import static org.junit.Assert.*;

/**
 * Unit tests for Project1 class.
 * 
 * @version Feb 03, 2025
 */
public class Project1Test 
{
    private Project1 runner;

    /**
     * setup() method, runs before each of your test methods.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() 
    {
        runner = new Project1(25);
    }

    /**
     * Tests retrieving the maximum value from the array.
     * Tests the correct functionality when the array is not empty.
     */
    @Test
    public void testGetMaximum() 
    {
        runner.addValue(10);
        runner.addValue(5);
        runner.addValue(20);
        assertEquals(20, runner.getMaximum()); 
    }

    /**
     * Tests the getRange() method.
     */
    @Test
    public void testGetRange() 
    {
        runner.addValue(10);
        runner.addValue(5);
        runner.addValue(20);
        assertEquals(15, runner.getRange()); 
    }

    /**
     * Tests calculating the average value of elements in the array.
     * Tests the correct functionality when the array is not empty.
     */
    @Test
    public void testGetAverage() 
    {
        runner.addValue(10);
        runner.addValue(20);
        runner.addValue(30);
        assertEquals(20.0, runner.getAverage(), 0.01); 
    }

    /**
     * Tests calculating the average value of elements in the array.
     * Tests the correct functionality when the array is not empty.
     */
    @Test
    public void testHasDuplicates() 
    {
        runner.addValue(10);
        runner.addValue(10); 
        assertTrue(runner.hasDuplicates()); 
    }

    /**
     * Tests the isEmpty() method.
     */
    @Test
    public void testIsEmpty() 
    {
        assertTrue(runner.isEmpty()); 
    }

    /**
     * Tests the isEmpty() method.
     */
    @Test
    public void testIsFull() 
    {
        for (int i = 0; i < 25; i++) 
        {
            runner.addValue(i);
        }
        assertTrue(runner.isFull()); 
    }

    /**
     * Tests the setValue() method.
     */
    @Test
    public void testSetValue() 
    {
        runner.addValue(10); 
        runner.setValue(0, 25); 

        assertEquals(25, runner.getValue(0)); 
    }

    /**
     * Tests that setValue() throws IndexOutOfBoundsException for an invalid index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueOutOfBounds() 
    {
        runner.setValue(30, 25); 
    }

    /**
     * Test method for {@link Runner#getCapacity()}.
     * 
     * This test verifies that the {@link Runner#getCapacity()} method returns the correct
     * capacity value. The expected capacity is set to 25 during the initialization of the
     * {@code runner} object. The test will assert that the actual returned capacity is
     * equal to the expected value of 25.
     * 
     */
    @Test
    public void testGetCapacity() 
    {
        assertEquals(25, runner.getCapacity()); 
    }
}
