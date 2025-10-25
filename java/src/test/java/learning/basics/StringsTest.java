package learning.basics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    
    @Test
    void reverseWorksCorrectly() {
        assertEquals("cba", Strings.reverse("abc"));
        assertEquals("dlroW olleH", Strings.reverse("Hello World"));
        assertEquals("", Strings.reverse(""));
        assertEquals("a", Strings.reverse("a"));
    }
    
    @Test
    void isPalindromeDetectsCorrectly() {
        assertTrue(Strings.isPalindrome("racecar"));
        assertTrue(Strings.isPalindrome("A man a plan a canal Panama"));
        assertFalse(Strings.isPalindrome("race a car"));
        assertTrue(Strings.isPalindrome("Madam"));
        assertFalse(Strings.isPalindrome("hello"));
    }
    
    @Test
    void countVowelsWorksCorrectly() {
        assertEquals(5, Strings.countVowels("aeiou"));
        assertEquals(3, Strings.countVowels("Hello World"));
        assertEquals(0, Strings.countVowels("xyz"));
        assertEquals(3, Strings.countVowels("Programming"));
        assertEquals(5, Strings.countVowels("EDUCATION"));
    }
    
    @Test
    void toTitleCaseFormatsCorrectly() {
        assertEquals("Hello World", Strings.toTitleCase("hello world"));
        assertEquals("The Quick Brown Fox", Strings.toTitleCase("THE QUICK BROWN FOX"));
        assertEquals("Java Programming", Strings.toTitleCase("jAvA pRoGrAmMiNg"));
        assertEquals("", Strings.toTitleCase(""));
        assertEquals("A", Strings.toTitleCase("a"));
    }
    
    @Test
    void removeWhitespaceWorksCorrectly() {
        assertEquals("HelloWorld", Strings.removeWhitespace("Hello World"));
        assertEquals("NoSpacesHere", Strings.removeWhitespace("No Spaces Here"));
        assertEquals("", Strings.removeWhitespace("   "));
        assertEquals("a", Strings.removeWhitespace(" a "));
    }
    
    @Test
    void findLongestWordWorksCorrectly() {
        assertEquals("programming", Strings.findLongestWord("I love programming"));
        assertEquals("quick", Strings.findLongestWord("The quick brown fox"));
        assertEquals("supercalifragilisticexpialidocious", 
                    Strings.findLongestWord("Mary supercalifragilisticexpialidocious Poppins"));
        assertEquals("Hello", Strings.findLongestWord("Hello!"));
    }
    
    @Test
    void compressStringWorksCorrectly() {
        assertEquals("abc", Strings.compressString("aabbcc"));
        assertEquals("abcd", Strings.compressString("aaabbbcccdddd"));
        assertEquals("abc", Strings.compressString("abc"));
        assertEquals("", Strings.compressString(""));
        assertEquals("a", Strings.compressString("a"));
        assertEquals("ab", Strings.compressString("aab"));
    }
    
    @Test
    void formatNameWorksCorrectly() {
        assertEquals("John Doe", Strings.formatName("john", "doe"));
        assertEquals("Mary Smith", Strings.formatName("MARY", "SMITH"));
        assertEquals("Bob Jones", Strings.formatName("bOb", "jOnEs"));
    }
    
    @Test
    void areAnagramsDetectsCorrectly() {
        assertTrue(Strings.areAnagrams("listen", "silent"));
        assertTrue(Strings.areAnagrams("anagram", "nagaram"));
        assertFalse(Strings.areAnagrams("hello", "world"));
        assertTrue(Strings.areAnagrams("The Eyes", "They See"));
        assertFalse(Strings.areAnagrams("abc", "abcd"));
    }
}