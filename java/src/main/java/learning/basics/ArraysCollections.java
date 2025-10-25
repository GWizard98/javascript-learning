package learning.basics;

import java.util.*;

public class ArraysCollections {
    
    /**
     * Finds the maximum element in an array
     */
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Calculates the average of array elements
     */
    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) {
            return 0.0;
        }
        long sum = 0; // Use long to prevent overflow
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }
    
    /**
     * Reverses an array in place
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    /**
     * Searches for an element using binary search (assumes sorted array)
     */
    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (sortedArr[mid] == target) {
                return mid;
            }
            if (sortedArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
    
    /**
     * Removes duplicates from an array and returns new array
     */
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> uniqueElements = new LinkedHashSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }
        return uniqueElements.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Rotates array to the right by k positions
     */
    public static void rotateRight(int[] arr, int k) {
        if (arr.length == 0) return;
        
        k = k % arr.length; // Handle k > array length
        if (k == 0) return;
        
        // Reverse entire array
        reverseSection(arr, 0, arr.length - 1);
        // Reverse first k elements
        reverseSection(arr, 0, k - 1);
        // Reverse remaining elements
        reverseSection(arr, k, arr.length - 1);
    }
    
    private static void reverseSection(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Creates and populates an ArrayList with even numbers up to limit
     */
    public static ArrayList<Integer> getEvenNumbers(int limit) {
        ArrayList<Integer> evens = new ArrayList<>();
        for (int i = 2; i <= limit; i += 2) {
            evens.add(i);
        }
        return evens;
    }
    
    /**
     * Filters an ArrayList to keep only elements greater than threshold
     */
    public static ArrayList<Integer> filterGreaterThan(ArrayList<Integer> list, int threshold) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (Integer num : list) {
            if (num > threshold) {
                filtered.add(num);
            }
        }
        return filtered;
    }
    
    /**
     * Creates a frequency map of characters in a string
     */
    public static Map<Character, Integer> getCharacterFrequency(String text) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }
    
    /**
     * Creates a word count map from a sentence
     */
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = sentence.toLowerCase().trim().split("\\s+");
        
        for (String word : words) {
            // Remove punctuation
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
    
    /**
     * Finds intersection of two arrays (common elements)
     */
    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for (int num : arr1) {
            set1.add(num);
        }
        
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        
        return new ArrayList<>(intersection);
    }
    
    /**
     * Sorts a list of strings by length
     */
    public static List<String> sortByLength(List<String> strings) {
        List<String> sorted = new ArrayList<>(strings);
        sorted.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return sorted;
    }
    
    /**
     * Groups students by their grades
     */
    public static Map<Character, List<String>> groupStudentsByGrade(Map<String, Character> studentGrades) {
        Map<Character, List<String>> gradeGroups = new HashMap<>();
        
        for (Map.Entry<String, Character> entry : studentGrades.entrySet()) {
            String student = entry.getKey();
            Character grade = entry.getValue();
            
            gradeGroups.computeIfAbsent(grade, k -> new ArrayList<>()).add(student);
        }
        
        return gradeGroups;
    }
    
    /**
     * Merges two sorted arrays into one sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        
        return merged;
    }
    
    /**
     * Implements a simple stack using ArrayList
     */
    public static class SimpleStack<T> {
        private ArrayList<T> stack = new ArrayList<>();
        
        public void push(T item) {
            stack.add(item);
        }
        
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stack.remove(stack.size() - 1);
        }
        
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stack.get(stack.size() - 1);
        }
        
        public boolean isEmpty() {
            return stack.isEmpty();
        }
        
        public int size() {
            return stack.size();
        }
    }
    
    /**
     * Finds the two numbers in array that sum to target
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{}; // No solution found
    }
}