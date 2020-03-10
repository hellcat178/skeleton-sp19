import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean r1 = palindrome.isPalindrome("racecar");
        boolean r2 = palindrome.isPalindrome("a");
        boolean r3 = palindrome.isPalindrome("noon");
        boolean r4 = palindrome.isPalindrome("horse");
        boolean r5 = palindrome.isPalindrome("rancor");
        boolean r6 = palindrome.isPalindrome("aaaaab");
        assertTrue(r1);
        assertTrue(r2);
        assertTrue(r3);
        assertFalse(r4);
        assertFalse(r5);
        assertFalse(r6);
    }

    CharacterComparator comparator = new OffByOne();
    @Test
    public void testIsPalindrome2(){
        assertTrue(palindrome.isPalindrome("flake",comparator));
        assertTrue(palindrome.isPalindrome("abab",comparator));
        assertTrue(palindrome.isPalindrome("121212",comparator));
        assertFalse(palindrome.isPalindrome("111111",comparator));
        assertFalse(palindrome.isPalindrome("racecar",comparator));
        assertFalse(palindrome.isPalindrome("apple",comparator));
    }

    CharacterComparator comparator2 = new OffByN(5);
    @Test
    public void testIsPalindrome3(){
        assertTrue(palindrome.isPalindrome("afbgaf",comparator2,5));
        assertTrue(palindrome.isPalindrome("bg2bg",comparator2,5));

        assertFalse(palindrome.isPalindrome("111111",comparator2,5));
        assertFalse(palindrome.isPalindrome("racecar",comparator2,5));
        assertFalse(palindrome.isPalindrome("apple",comparator2,5));
    }

}