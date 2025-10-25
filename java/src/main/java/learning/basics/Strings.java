package learning.basics;

public class Strings {
    
    /**
     * Reverses a string using StringBuilder
     */
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * Checks if a string is a palindrome (reads same forwards and backwards)
     */
    public static boolean isPalindrome(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return cleaned.equals(reverse(cleaned));
    }
    
    /**
     * Counts vowels in a string
     */
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Converts string to title case (first letter of each word capitalized)
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                result.append(c);
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        
        return result.toString();
    }
    
    /**
     * Removes all whitespace from a string
     */
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }
    
    /**
     * Finds the longest word in a sentence
     */
    public static String findLongestWord(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        String longest = "";
        
        for (String word : words) {
            // Remove punctuation for length comparison
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }
        
        return longest;
    }
    
    /**
     * Compresses a string by removing consecutive duplicate characters
     * Example: "aabbcc" -> "abc"
     */
    public static String compressString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        
        StringBuilder compressed = new StringBuilder();
        char previous = str.charAt(0);
        compressed.append(previous);
        
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current != previous) {
                compressed.append(current);
                previous = current;
            }
        }
        
        return compressed.toString();
    }
    
    /**
     * Formats a name string properly (First Last)
     */
    public static String formatName(String firstName, String lastName) {
        return String.format("%s %s", 
            capitalizeFirstLetter(firstName.toLowerCase()),
            capitalizeFirstLetter(lastName.toLowerCase()));
    }
    
    /**
     * Helper method to capitalize first letter of a string
     */
    private static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    /**
     * Checks if two strings are anagrams (same letters, different order)
     */
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Convert to lowercase and sort characters
        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        java.util.Arrays.sort(chars1);
        java.util.Arrays.sort(chars2);
        
        return java.util.Arrays.equals(chars1, chars2);
    }
}