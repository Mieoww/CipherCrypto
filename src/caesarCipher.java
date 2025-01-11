import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class caesarCipher {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text : ");
        String text = sc.nextLine();

        System.out.println("Eter the key : ");
        int key = sc.nextInt();

        String encryptedText = encrypt(text, key);

        System.out.println("Encrypted text : "+encryptedText);

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
    };

}
