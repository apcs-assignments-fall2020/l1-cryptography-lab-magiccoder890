import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message){
        String str = "";
        for (int i = 0; i < message.length(); i++) {
            char every_word = message.charAt(i);
            int new_char = 0;
            if (((int) every_word <=87 && (int) every_word >= 65)|| ((int) every_word <= 119 && (int) every_word >= 97)) {
                new_char = (int)every_word + 3;
                str += (char)new_char;
            }
            else if (((int) every_word <=90 && (int) every_word >= 88)|| ((int) every_word <= 122 && (int) every_word >= 120)) {
                new_char = (int)every_word - 23;
                str += (char)new_char;
            }
            else {
                str += every_word;
            }
        }
        System.out.print(str);
        return str;
    }

    public static String decryptCaesar(String message) {
        String str = "";
        for (int i = 0; i < message.length(); i++) {
            char every_word = message.charAt(i);
            int new_char = 0;
            if (((int) every_word <= 90 && (int) every_word > 67) || ((int) every_word <= 122 && (int) every_word > 99)) {
                new_char = (int) every_word - 3;
                str += (char) new_char;
            } else if (((int) every_word <= 67 && (int) every_word >= 65) || ((int) every_word <= 99 && (int) every_word >= 97)) {
                new_char = (int) every_word + 23;
                str += (char) new_char;
            } else {
                str += every_word;
            }
        }
        System.out.print(str);
        return str;
    }

    public static String encryptCaesarKey(String message, int key) {
        String str = "";
        for (int i = 0; i < message.length(); i++) {
            char every_word = message.charAt(i);
            int new_char = 0;
            if (((int) every_word <= (90-key) && (int) every_word >= 65)|| ((int) every_word <= (122-key) && (int) every_word >= 97)) {
                new_char = (int)every_word + key;
                str += (char)new_char;
            }
            else if (((int) every_word < 90 && (int) every_word >= (91-key))|| ((int) every_word < 122 && (int) every_word >= (123-key))) {
                new_char = (int)every_word - (26-key);
                str += (char)new_char;
            }
            else {
                str += every_word;
            }
        }
        System.out.print(str);
        return str;
    }

    public static String decryptCaesarKey(String message, int key) {
        String str = "";
        for (int i = 0; i < message.length(); i++) {
            char every_word = message.charAt(i);
            int new_char = 0;
            if (((int) every_word <= 90 && (int) every_word > (64 + key)) || ((int) every_word <= 122 && (int) every_word > (96 + key))) {
                new_char = (int) every_word - key;
                str += (char) new_char;
            } else if (((int) every_word <= (64 + key) && (int) every_word >= 65) || ((int) every_word <= (96 + key) && (int) every_word >= 97)) {
                new_char = (int) every_word + (26 - key);
                str += (char) new_char;
            } else {
                str += every_word;
            }
        }
        System.out.print(str);
        return str;
    }

    public static void main (String[]arg){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to \"encrypt\" or \"decrypt\" a message");
            String choice = scanner.nextLine();
            if (choice.equals("encrypt")) {
                System.out.print("Please enter your message to be encrypted:");
                String message = scanner.nextLine();
                System.out.print("Please tell out how many key you want to space");
                int key = scanner.nextInt() % 26;
                key %= 26;
                encryptCaesarKey(message, key);
            }
            else {
                System.out.print("Please inpnt a sentence that you want to be decrypted");
                String message = scanner.nextLine();
                System.out.print("Please tell out how many key you want to space");
                int key = scanner.nextInt();
                key %= 26;
                decryptCaesarKey(message, key);
            }
        }
}
