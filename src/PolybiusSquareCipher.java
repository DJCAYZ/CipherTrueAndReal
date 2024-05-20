public class PolybiusSquareCipher {
    private static final char[][] ALPHABET_LETTERS = new char[][] {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}
    };
    public String encrypt(String plaintext) {
        String cleanPlaintext = plaintext.trim().toLowerCase();
        String encryptedText = "";

        for (int i = 0; i < cleanPlaintext.length(); i++) {
            char currentLetter = cleanPlaintext.charAt(i);

            if (currentLetter >= 'a' || currentLetter <= 'z') {
                encryptedText += getEncryptedLetter(currentLetter);
            }
        }

        return encryptedText;
    }

    public String decrypt(String encryptedText) {
        String plaintext = "";
        int i = 0;
        while (i < encryptedText.length()) {
            char rowPosChar = encryptedText.charAt(i);
            if (!Character.isDigit(rowPosChar)) {
                i++;
                rowPosChar = encryptedText.charAt(i);
            }

            if (i == encryptedText.length() - 1) {
                break;
            }

            char colPosChar = encryptedText.charAt(i + 1);
            if (!Character.isDigit(colPosChar)) {
                i++;
                colPosChar = encryptedText.charAt(i+1);
            }

            plaintext += ALPHABET_LETTERS[Character.digit(rowPosChar, 10)-1][Character.digit(colPosChar, 10)-1];
            i += 2;
        }

        return plaintext;
    }

    private static String getEncryptedLetter(char letter) {
        for (int row = 0; row < ALPHABET_LETTERS.length; row++) {
            for (int col = 0; col < ALPHABET_LETTERS[row].length; col++) {
                if (ALPHABET_LETTERS[row][col] == letter) {
                    return String.valueOf(row + 1) + String.valueOf(col + 1);
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new PolybiusSquareCipher().encrypt("hello world"));
        System.out.println(new PolybiusSquareCipher().decrypt("23153131345234423114"));
    }
}
