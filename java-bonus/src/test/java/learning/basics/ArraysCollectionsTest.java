package learning.basics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ArraysCollectionsTest {
    
    @Test
    void findMaxWorksCorrectly() {
        assertEquals(9, ArraysCollections.findMax(new int[]{1, 5, 3, 9, 2}));
        assertEquals(1, ArraysCollections.findMax(new int[]{1}));
        assertEquals(-1, ArraysCollections.findMax(new int[]{-5, -2, -1, -10}));
        
        assertThrows(IllegalArgumentException.class, 
                    () -> ArraysCollections.findMax(new int[]{}));
    }
    
    @Test
    void calculateAverageWorksCorrectly() {
        assertEquals(4.0, ArraysCollections.calculateAverage(new int[]{2, 4, 6}), 0.001);
        assertEquals(5.0, ArraysCollections.calculateAverage(new int[]{5}), 0.001);
        assertEquals(0.0, ArraysCollections.calculateAverage(new int[]{}), 0.001);
        assertEquals(2.5, ArraysCollections.calculateAverage(new int[]{1, 2, 3, 4}), 0.001);
    }
    
    @Test
    void reverseArrayWorksCorrectly() {
        int[] arr1 = {1, 2, 3, 4, 5};
        ArraysCollections.reverseArray(arr1);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr1);
        
        int[] arr2 = {1, 2};
        ArraysCollections.reverseArray(arr2);
        assertArrayEquals(new int[]{2, 1}, arr2);
        
        int[] arr3 = {1};
        ArraysCollections.reverseArray(arr3);
        assertArrayEquals(new int[]{1}, arr3);
        
        int[] arr4 = {};
        ArraysCollections.reverseArray(arr4);
        assertArrayEquals(new int[]{}, arr4);
    }
    
    @Test
    void binarySearchWorksCorrectly() {
        int[] sorted = {1, 3, 5, 7, 9, 11};
        
        assertEquals(2, ArraysCollections.binarySearch(sorted, 5));
        assertEquals(0, ArraysCollections.binarySearch(sorted, 1));
        assertEquals(5, ArraysCollections.binarySearch(sorted, 11));
        assertEquals(-1, ArraysCollections.binarySearch(sorted, 6));
        assertEquals(-1, ArraysCollections.binarySearch(sorted, 0));
        assertEquals(-1, ArraysCollections.binarySearch(new int[]{}, 5));
    }
    
    @Test
    void removeDuplicatesWorksCorrectly() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, 
                         ArraysCollections.removeDuplicates(new int[]{1, 2, 2, 3, 4, 4}));
        assertArrayEquals(new int[]{5}, 
                         ArraysCollections.removeDuplicates(new int[]{5, 5, 5}));
        assertArrayEquals(new int[]{1, 2, 3}, 
                         ArraysCollections.removeDuplicates(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{}, 
                         ArraysCollections.removeDuplicates(new int[]{}));
    }
    
    @Test
    void rotateRightWorksCorrectly() {
        int[] arr1 = {1, 2, 3, 4, 5};
        ArraysCollections.rotateRight(arr1, 2);
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, arr1);
        
        int[] arr2 = {1, 2, 3};
        ArraysCollections.rotateRight(arr2, 1);
        assertArrayEquals(new int[]{3, 1, 2}, arr2);
        
        int[] arr3 = {1, 2, 3};
        ArraysCollections.rotateRight(arr3, 0);
        assertArrayEquals(new int[]{1, 2, 3}, arr3);
        
        int[] arr4 = {1, 2, 3};
        ArraysCollections.rotateRight(arr4, 6); // k > length
        assertArrayEquals(new int[]{1, 2, 3}, arr4); // Same as k=0
        
        int[] arr5 = {};
        ArraysCollections.rotateRight(arr5, 2);
        assertArrayEquals(new int[]{}, arr5);
    }
    
    @Test
    void getEvenNumbersWorksCorrectly() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        assertEquals(expected, ArraysCollections.getEvenNumbers(10));
        
        expected = new ArrayList<>(Arrays.asList(2));
        assertEquals(expected, ArraysCollections.getEvenNumbers(3));
        
        expected = new ArrayList<>();
        assertEquals(expected, ArraysCollections.getEvenNumbers(1));
    }
    
    @Test
    void filterGreaterThanWorksCorrectly() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 5, 3, 8, 2, 9));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5, 8, 9));
        assertEquals(expected, ArraysCollections.filterGreaterThan(input, 4));
        
        expected = new ArrayList<>();
        assertEquals(expected, ArraysCollections.filterGreaterThan(input, 10));
    }
    
    @Test
    void getCharacterFrequencyWorksCorrectly() {
        Map<Character, Integer> result = ArraysCollections.getCharacterFrequency("hello");
        assertEquals(1, result.get('h'));
        assertEquals(1, result.get('e'));
        assertEquals(2, result.get('l'));
        assertEquals(1, result.get('o'));
        assertEquals(4, result.size());
        
        result = ArraysCollections.getCharacterFrequency("aaa");
        assertEquals(3, result.get('a'));
        assertEquals(1, result.size());
    }
    
    @Test
    void getWordCountWorksCorrectly() {
        Map<String, Integer> result = ArraysCollections.getWordCount("hello world hello");
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        
        result = ArraysCollections.getWordCount("The quick, quick brown fox!");
        assertEquals(1, result.get("the"));
        assertEquals(2, result.get("quick"));
        assertEquals(1, result.get("brown"));
        assertEquals(1, result.get("fox"));
    }
    
    @Test
    void findIntersectionWorksCorrectly() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        List<Integer> result = ArraysCollections.findIntersection(arr1, arr2);
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertEquals(2, result.size());
        
        arr1 = new int[]{1, 2};
        arr2 = new int[]{3, 4};
        result = ArraysCollections.findIntersection(arr1, arr2);
        assertTrue(result.isEmpty());
    }
    
    @Test
    void sortByLengthWorksCorrectly() {
        List<String> input = Arrays.asList("java", "a", "hello", "hi");
        List<String> result = ArraysCollections.sortByLength(input);
        assertEquals(Arrays.asList("a", "hi", "java", "hello"), result);
        
        // Original list should remain unchanged
        assertEquals(Arrays.asList("java", "a", "hello", "hi"), input);
    }
    
    @Test
    void groupStudentsByGradeWorksCorrectly() {
        Map<String, Character> studentGrades = new HashMap<>();
        studentGrades.put("Alice", 'A');
        studentGrades.put("Bob", 'B');
        studentGrades.put("Carol", 'A');
        studentGrades.put("David", 'B');
        
        Map<Character, List<String>> result = ArraysCollections.groupStudentsByGrade(studentGrades);
        
        List<String> aStudents = result.get('A');
        assertTrue(aStudents.contains("Alice"));
        assertTrue(aStudents.contains("Carol"));
        assertEquals(2, aStudents.size());
        
        List<String> bStudents = result.get('B');
        assertTrue(bStudents.contains("Bob"));
        assertTrue(bStudents.contains("David"));
        assertEquals(2, bStudents.size());
    }
    
    @Test
    void mergeSortedArraysWorksCorrectly() {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, 
                         ArraysCollections.mergeSortedArrays(arr1, arr2));
        
        arr1 = new int[]{1, 2, 3};
        arr2 = new int[]{};
        assertArrayEquals(new int[]{1, 2, 3}, 
                         ArraysCollections.mergeSortedArrays(arr1, arr2));
        
        arr1 = new int[]{};
        arr2 = new int[]{4, 5, 6};
        assertArrayEquals(new int[]{4, 5, 6}, 
                         ArraysCollections.mergeSortedArrays(arr1, arr2));
    }
    
    @Test
    void simpleStackWorksCorrectly() {
        ArraysCollections.SimpleStack<Integer> stack = new ArraysCollections.SimpleStack<>();
        
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size()); // peek shouldn't change size
        
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, stack.pop());
        
        assertTrue(stack.isEmpty());
        
        assertThrows(IllegalStateException.class, stack::pop);
        assertThrows(IllegalStateException.class, stack::peek);
    }
    
    @Test
    void twoSumWorksCorrectly() {
        int[] nums = {2, 7, 11, 15};
        int[] result = ArraysCollections.twoSum(nums, 9);
        assertEquals(2, result.length);
        assertTrue((result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        
        nums = new int[]{3, 2, 4};
        result = ArraysCollections.twoSum(nums, 6);
        assertEquals(2, result.length);
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        
        nums = new int[]{1, 2, 3};
        result = ArraysCollections.twoSum(nums, 10);
        assertEquals(0, result.length); // No solution
    }
}