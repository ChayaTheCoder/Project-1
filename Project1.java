import java.util.Random;

import itsc2214.*;

/**
 * The Project1 class implements the ArrayInt interface.
 * This class provides various operations for managing an integer array, 
 * including adding values, retrieving statistical data such as min, max, 
 * average, and range, checking for duplicates, and handling array capacity.
 */
public class Project1 implements ArrayInt 
{
    private int[] array;
    private int size;

    /**
     * Constructs a new Project1 object with a specified capacity.
     * Initializes the array with the given capacity and sets the size to 0.
     *
     * @param capacity The maximum number of elements the array can hold.
     */
 public Project1(int capacity) 
    {
        this.array = new int[capacity];
        this.size = 0;
 }

    /**
     * Returns the minimum value in the array.
     * If the array is empty, Integer.MIN_VALUE is returned.
     *
     * @return the minimum value in the array, or Integer.MIN_VALUE if the array is empty.
     */
    public int getMinimum() 
    {
        if (size == 0) 
        {
            return Integer.MIN_VALUE;
        }

        int min = array[0];
        for (int i = 1; i < size; i++) 
        {
            if (array[i] < min) 
            {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Returns the maximum value in the array.
     * If the array is empty, Integer.MAX_VALUE is returned.
     *
     * @return the maximum value in the array, or Integer.MAX_VALUE if the array is empty.
     */
    public int getMaximum() 
    {
        if (size == 0) 
        {
            return Integer.MAX_VALUE;
        }

        int max = array[0];
        for (int i = 1; i < size; i++) 
        {
            if (array[i] > max) 
            {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Calculates the range of the array, which is the difference 
     * between the maximum and minimum values.
     *
     * @return The range of the array (max - min). If the array is empty, 
     *         it returns Integer.MAX_VALUE - Integer.MIN_VALUE.
     */
    public int getRange() 
    {
        int min = getMinimum();
        int max = getMaximum();
        return max - min;
    }

    /**
     * Calculates the average (mean) of the values in the array.
     *
     * @return The average of the array values.
     * @throws IllegalStateException If the array is empty.
     */
    public double getAverage() 
    {
        if (size == 0) 
        {
            throw new IllegalStateException("Cannot calculate average, array is empty");
        }

        int sum = 0;
        for (int i = 0; i < size; i++) 
        {
            sum += array[i];
        }
        return (double) sum / size;
    }

    /**
     * Gets the number of elements currently stored in the array.
     *
     * @return The current size of the array.
     */
    public int size() 
    {
        return size;
    }

    /**
     * Returns the current capacity of the array.
     * The capacity is the length of the internal array.
     *
     * @return the capacity of the array (i.e., the length of the array).
     */
    public int getCapacity() 
    {
        return array.length;
    }

    /**
     * Adds a new value to the array at the next available index.
     * If the array is full, an IllegalStateException is thrown.
     *
     * @param value the value to add to the array
     * @throws IllegalStateException if the array is full 
     * and cannot accommodate more values
     */
    public void addValue(int value) throws IllegalStateException 
    {
        if (size >= getCapacity()) 
        {
            throw new IllegalStateException("Array is full, cannot add more values");
        }
        array[size] = value;
        size++;
    }

    /**
     * Retrieves the value stored at the specified index in the array.
     * Throws an exception if the index is out of bounds.
     *
     * @param index the index of the value to retrieve
     * @return the value at the specified index
     * @throws IndexOutOfBoundsException if the index is less than 
     * 0 or greater than or equal to the current size of the array
     */
    public int getValue(int index) throws IndexOutOfBoundsException 
    {
        if (index < 0 || index >= size) 
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return array[index];
    }

    /**
     * Sets the value at the specified index in the array.
     * Throws an exception if the index is out of bounds.
     *
     * @param index the index where the value will be set
     * @param value the value to set at the specified index
     * @return the previous value at the specified index
     * @throws IndexOutOfBoundsException if the index is less than 
     * 0 or greater than or equal to the current size of the array
     */
    public int setValue(int index, int value) throws IndexOutOfBoundsException 
    {
        if (index < 0 || index >= size) 
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        int previousValue = array[index];
        array[index] = value;
        return previousValue;
    }

    /**
     * Adds a specified number of random values to the array.
     * Each value is a randomly generated integer between 0 and 99.
     *
     * @param n The number of random values to add.
     * @throws IllegalStateException If adding n values exceeds the array's capacity.
     */
    public void addRandom(int n) throws IllegalStateException 
    {
        if (size + n > getCapacity()) 
        {
            throw new IllegalStateException("Array cannot hold that many random values");
        }
        Random rand = new Random();
        for (int i = 0; i < n; i++) 
        {
            addValue(rand.nextInt(100));
        }
    }

    /**
     * Removes the value at the specified index from the array.
     * All elements to the right of the removed element are shifted one position to the left,
     * and the size of the array is decremented by 1.
     *
     * @param index the index of the value to remove
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 or index >= size)
     */
    public void removeValueAt(int index) throws IndexOutOfBoundsException 
    {
        if (index < 0 || index >= size) 
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        for (int i = index; i < size - 1; i++) 
        {
            array[i] = array[i + 1];
        }
        size--;
    }

    /**
     * Checks if the array is empty.
     * The array is considered empty if its size is 0.
     *
     * @return true if the array is empty, false otherwise
     */
    public boolean isEmpty() 
    {
        return size == 0;
    }

    /**
     * Checks if the array is full.
     * The array is considered full if its size is equal to its capacity.
     *
     * @return true if the array is full, false otherwise
     */
    public boolean isFull() 
    {
        return size == getCapacity();
    }

    /**
     * Checks if the array contains any duplicate values.
     * The method compares each element with every other element in the array.
     *
     * @return true if the array contains duplicates, false otherwise
     */
    public boolean hasDuplicates() 
    {
        for (int i = 0; i < size; i++) 
        {
            for (int j = i + 1; j < size; j++) 
            {
                if (array[i] == array[j]) 
                {
                    return true;
                }
            }
        }
        return false;
    }
}
