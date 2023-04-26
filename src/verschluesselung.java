import java.util.Scanner;

public class verschluesselung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**************************" + '\n' + "  Caesar-Verschlüsselung" + '\n' + "**************************" + '\n');

        System.out.print("Gaben Sie ein Wort ein, den Sie verschluesseln moechten: ");

        String alphabet = "abcdefghijklmnopqrstuvwxyz", // ein Alphabet in den String eintragen
                word = sc.nextLine();

        System.out.print("Geben Sie den Schluesselfaktor an: ");
        int encodeKey = sc.nextInt(), //Faktor um den das Alphabet verschoben wird
            decodeKey;

        char[] alphabetToChar = alphabet.toCharArray(); // Das Alphabet in array eintragen
        char[] wordToChar = word.toCharArray(); // Das wort was verschluesselt werden soll von word in array eintragen
        char[] encode = new char[wordToChar.length], // in den array die laenge von wordToChar uebergeben
               decode = new char[wordToChar.length];

        // encode
        for (int i = 0; i < alphabetToChar.length; i++) {
            for (int j = 0; j < wordToChar.length; j++) {
                if (wordToChar[j] == alphabetToChar[i]) {
                    encode[j] = alphabetToChar[(i + encodeKey) % alphabetToChar.length];
                }
            }
        }
        System.out.print("Deine verschluessseltes Wort: ");
        System.out.println(encode);
        System.out.println();


        System.out.print("Gib ein Schluesselfaktor an, damit dein Wort entschluesselt wird: ");
        decodeKey = sc.nextInt();
        // decode
        for (int i = 0; i < alphabetToChar.length; i++) {
            for (int j = 0; j < encode.length; j++) {
                if (encode[j] == alphabetToChar[(i + decodeKey) % alphabetToChar.length]) {
                    decode[j] = alphabetToChar[((i + decodeKey) - decodeKey) % alphabetToChar.length];
                }
            }
        }
        System.out.print("Dein entschluesseltes Wort: ");
        System.out.println(decode);
        sc.close();
    }
}
