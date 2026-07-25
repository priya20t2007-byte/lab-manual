import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {

    // Method 1: Frequency Count
    public static boolean isAnagramFrequency(String s, String t) {

        // Convert to lowercase and remove spaces
        s = s.toLowerCase().replaceAll("\\s+", "");
        t = t.toLowerCase().replaceAll("\\s+", "");

        // Check length
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Increase count for first string
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Decrease count for second string
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Method 2: Sorting
    public static boolean isAnagramSorting(String s, String t) {

        // Convert to lowercase and remove spaces
        s = s.toLowerCase().replaceAll("\\s+", "");
        t = t.toLowerCase().replaceAll("\\s+", "");

        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char c : arr1) {
            sb1.append(c);
        }

        for (char c : arr2) {
            sb2.append(c);
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First String: ");
        String s = sc.nextLine();

        System.out.print("Enter Second String: ");
        String t = sc.nextLine();

        boolean result1 = isAnagramFrequency(s, t);
        boolean result2 = isAnagramSorting(s, t);

        System.out.println("\nUsing Frequency Count Method: " + result1);
        System.out.println("Using Sorting Method: " + result2);

        sc.close();
    }
}
