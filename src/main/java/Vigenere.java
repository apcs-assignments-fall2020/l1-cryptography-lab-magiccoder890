import java.util.Scanner;

public class Vigenere {
        public static String encryptVigenere(String message, String key) {
        String str = "";
        key = key.toUpperCase();
        String new_message = message.toUpperCase();
        int space = 0;
        int New_num = 0;
        for (int i = 0; i < new_message.length(); i++) {
            char every_word = new_message.charAt(i);
            New_num = (int)every_word + ((int)key.charAt((i-space) % key.length()) - 65);
            if ((New_num > 90)&& (64 < (int)every_word && (int)every_word < 91)) {
                if (Character.isLowerCase(message.charAt(i))){
                    New_num = New_num + 32 - 26;
                }
                else {
                    New_num -= 26;
                }
                str += (char) New_num;
            }
            else if (64 < (int)every_word && (int)every_word < 91){
                if (Character.isLowerCase(message.charAt(i))){
                    New_num += 32;
                    str += (char) New_num;
                }
                else {
                    str += (char) New_num;
                }
            }
            else {
                str += (char)every_word;
                space += 1;
            }
        }
        System.out.print(str);
        return str;
    }

    public static String decryptVigenere(String message, String key) {
        String str = "";
        key = key.toUpperCase();
        String new_message = message.toUpperCase();
        int space = 0;
        int New_num = 0;
        for (int i = 0; i < new_message.length(); i++) {
            char every_word = new_message.charAt(i);
            New_num = (int)every_word - ((int)key.charAt((i-space) % key.length()) - 65);
            if ((New_num < 65)&& (64 < (int)every_word && (int)every_word < 91)) {
                if(Character.isLowerCase(message.charAt(i))) {
                    New_num = New_num + 26 + 32;
                    str += (char) New_num;
                }
                else {
                    New_num += 26;
                    str += (char) New_num;
                }
            }
            else if (64 < (int)every_word && (int)every_word < 91){
                if(Character.isLowerCase(message.charAt(i))) {
                    New_num = New_num + 32;
                    str += (char) New_num;
                }
                else {
                    str += (char) New_num;
                }
            }
            else {
                str += (char)every_word;
                space += 1;
            }
        }
        System.out.print(str);
        return str;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
