public class CaesarCipher {
    private static final char[] ALPHABET_LETTERS = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private int shift = 0;

    public CaesarCipher(int _shift) {
        setShift(_shift);
    }

    public void setShift(int newShift) {
        shift = newShift;
    }

    public String encrypt(String plaintext) {
        String cleanPlaintext = plaintext.trim().toLowerCase();
        String encryptedText = "";

        for (int i = 0; i < plaintext.length(); i++) {
            char currentLetter = cleanPlaintext.charAt(i);
            int letterPos = getLetterPosition(currentLetter);

            if (letterPos != -1) {
                int encryptedLetterPos = letterPos + shift;
                if (encryptedLetterPos >= 26) {
                    encryptedLetterPos -= 26;
                }

                encryptedText += ALPHABET_LETTERS[encryptedLetterPos];
            } else {
                encryptedText += currentLetter;
            }


        }

        return encryptedText;
    }

    public String decrypt(String encryptedText) {
        String cleanEncryptedText = encryptedText.trim().toLowerCase();
        String plaintext = "";

        for (int i = 0; i < cleanEncryptedText.length(); i++) {
            char currentLetter = cleanEncryptedText.charAt(i);
            int letterPos = getLetterPosition(currentLetter);

            if (letterPos != -1) {
                int decryptedLetterPos = letterPos - shift;
                if (decryptedLetterPos < 0) {
                    decryptedLetterPos += 26;
                }

                plaintext += ALPHABET_LETTERS[decryptedLetterPos];
            } else {
                plaintext += currentLetter;
            }
        }

        return plaintext;
    }

    private static int getLetterPosition(char letter) {
        for (int i = 0; i < ALPHABET_LETTERS.length; i++) {
            if (letter == ALPHABET_LETTERS[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(5);
        System.out.println(cipher.encrypt("hello world"));
        System.out.println(cipher.decrypt("tuuf cnfslqnsl"));
    }
}
