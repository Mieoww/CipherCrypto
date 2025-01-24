import java.util.*;

public class cryptAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text: ");
        String text = scanner.nextLine();

        // Get the sorted character frequencies
        List<Map.Entry<Character, Integer>> sortedFrequencies = getSortedCharacterFrequencies(text);

        // Print the sorted character frequencies
        System.out.println("Character frequencies sorted from most to least frequent (alphabetic only):");
        for (Map.Entry<Character, Integer> entry : sortedFrequencies) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Calculate the difference between the most used character and 'E'
        int key=0;
        if (!sortedFrequencies.isEmpty()) {
            char mostUsedChar = sortedFrequencies.get(0).getKey();
            key = findKey(mostUsedChar, 'e');
        } else {
            System.out.println("No alphabetic characters found in the input.");
        }

        System.out.println("Possible key = " + key);

        String plainText = decrypt(text, key);
        System.out.println("Text : ");
        System.out.println(plainText);
        // Close the scanner
        scanner.close();
    }

    public static String decrypt(String encrypt, int key)
    {
        char[] arr = encrypt.toCharArray();
        char[] plaintext = new char[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            char ch = arr[i];
            if(Character.isLetter(ch)){
                int base = Character.isUpperCase(ch) ? 'A':'a';
                plaintext[i] = (char) (((ch - base - key + 26) % 26) + base);
            }else{
                plaintext[i] = ch;
            }

        }
        return new String(plaintext);
    }

    public static int findKey (char cipher, char plain)
    {
        int difference = calculateAsciiDifference(cipher, plain);
        return difference;
    }

    // Function to count and sort character frequencies
    public static List<Map.Entry<Character, Integer>> getSortedCharacterFrequencies(String text) {
        // Create a map to store the frequency of each alphabetic character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Loop through each character in the string
        for (char ch : text.toCharArray()) {
            // Check if the character is alphabetic (ignore others)
            if (Character.isLetter(ch)) {
                // Convert character to lowercase to count case-insensitively
                ch = Character.toLowerCase(ch);

                // If the character is already in the map, increment its count
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Convert the frequency map to a list of entries
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list by frequency (highest to lowest)
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        return sortedList;
    }

    // Function to calculate the difference in ASCII values of two characters
    public static int calculateAsciiDifference(char char1, char char2) {
        return Math.abs((int) char1 - (int) char2);
    }
}