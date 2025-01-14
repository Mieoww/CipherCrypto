import java.util.*;

public class caesarCipher {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Encryption----------------------------------------
        System.out.println("Enter a text : ");
        String text = sc.nextLine();

        System.out.println("Eter the key : ");
        int key = sc.nextInt();
        sc.nextLine();

        String encryptedText = encrypt(text, key);

        System.out.println("Encrypted text : "+encryptedText);
        //Decryption-------------------------------------------
        System.out.println("Enter an encrypted Text : ");
        String a = sc.nextLine();

        System.out.println("Eter the key : ");
        int k = sc.nextInt();
        sc.nextLine();

        String plaintext = decrypt(a, k);

        System.out.println("Plain text : "+plaintext);
        //Brute force-----------------------------------------------
        System.out.println("Enter an encrypted Text : ");
        text = sc.nextLine();
        bruteForce(text);

    }
    public static String encrypt(String text, int key)
    {
        char[] arr = text.toCharArray();
        char[] encrypted = new char[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            char ch= arr[i];
            if (Character.isLetter(ch))
            {
                int base = Character.isUpperCase(ch)? 'A' : 'a';
                encrypted[i] = (char)((ch-base+key)%26+base);
            }else{
                encrypted[i] = ch;
            }
        }
        return new String(encrypted);
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
    public static void bruteForce(String text)
    {
        System.out.println("Possible option : ");
        for(int i=1; i<=26; i++)
        {
            String option = decrypt(text, i);
            System.out.println("Key : "+i+" Text : "+option);
        }
    }
}

