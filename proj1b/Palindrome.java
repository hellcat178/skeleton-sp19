public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque deque = new LinkedListDeque();

        for (int i = 0; i < word.length(); i++){
            deque.addLast(word.charAt(i));
        }
        return deque;

    }

    public boolean isPalindrome (String word){
        Deque<Character> deque = wordToDeque(word);
        isPalindromeHelper(deque);
        if (deque.size() == 0 || deque.size() == 1){
            return true;
        }
        else
            return false;
    }
    public void isPalindromeHelper(Deque<Character> d){
        if (d.size() == 0 || d.size() == 1){
            return;
        }
        if (d.get(0) != d.get(d.size()-1)){
            return;
        }
        d.removeFirst();
        d.removeLast();

        isPalindromeHelper(d);
    }

    public boolean isPalindrome (String word, CharacterComparator cc) {
        CharacterComparator comparator = new OffByOne();
        Deque<Character> deque = wordToDeque(word);

        isPalindromeOffByOneHelper(deque,comparator);
        if (deque.size() == 0 || deque.size() == 1){
            return true;
        }
        else
            return false;
    }

    public boolean isPalindrome (String word, CharacterComparator cc, int n) {
        CharacterComparator comparator = new OffByN(n);
        Deque<Character> deque = wordToDeque(word);

        isPalindromeOffByNHelper(deque, comparator, n);
        if (deque.size() == 0 || deque.size() == 1){
            return true;
        }
        else
            return false;
    }

    public void isPalindromeOffByOneHelper(Deque<Character> d, CharacterComparator cc){
        if (d.size() == 0 || d.size() == 1){
            return;
        }
        if (!cc.equalChars(d.get(0),d.get(d.size()-1))){
            return;
        }

        d.removeFirst();
        d.removeLast();

        isPalindromeOffByOneHelper(d,cc);
    }

    public void isPalindromeOffByNHelper(Deque<Character> d, CharacterComparator cc, int n){
        if (d.size() == 0 || d.size() == 1){
            return;
        }
        if (!cc.equalChars(d.get(0),d.get(d.size()-1))){
            return;
        }

        d.removeFirst();
        d.removeLast();

        isPalindromeOffByNHelper(d,cc,n);
    }



}
