package arrays;

public class PalindromePhrase {
    public static void main(String[] args) {
        PalindromePhrase p = new PalindromePhrase();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        StringBuilder p = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                p.append(s.charAt(i));
            } else if ('A' <= s.charAt(i)  && s.charAt(i) <= 'Z') {
                p.append((char)(s.charAt(i)+32));
            }
        }
        System.out.println("p: " + p.toString());
        int l=0, r=p.length()-1;
        while (l<r) {
            if (p.charAt(l) != p.charAt(r)) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
