package chapter3.exercises.projects.ciphers;

public class SubstitutionCipher {
    private final char[] encoder;
    private final char[] decoder = new char[26];

    /**
     * Constructs a SubstitutionCipher object with the given encoder string.
     *
     * @param encoder the encoder string containing the 26 uppercase letters to be used as the cipher
     *                key for encryption and decryption
     * @throws IllegalArgumentException if the encoder string length is not 26 or contains characters
     *                                  other than English letters
     */
    public SubstitutionCipher(String encoder) {
        encoder = encoder.toUpperCase();
        validateParameter(encoder);
        this.encoder = encoder.toCharArray();
        for (int i = 0; i < decoder.length - 1; i++) {
            decoder[this.encoder[i] - 'A'] = (char) (i + 'A');
        }
    }

    public static void main(String[] args) {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher("ZPXEILBVHNTAOWMFQJUYGRKDSC");
        String msg = "HELLO HOW ARE YOU";
        String encoded = substitutionCipher.encode(msg);
        System.out.println("Encoded: " + encoded);
        String decoded = substitutionCipher.decode(encoded);
        System.out.println("Original: " + decoded);
    }

    /**
     * Encodes a given text using the encoder cipher key.
     *
     * @param plaintext the text to be encoded
     * @return the encoded message
     */
    public String encode(String plaintext) {
        return transform(plaintext, encoder);
    }

    /**
     * Decodes a given text using the decoder cipher key.
     *
     * @param ciphertext the text to be decoded
     * @return the decoded message
     */
    public String decode(String ciphertext) {
        return transform(ciphertext, decoder);
    }

    /**
     * Transforms a given text using the specified cipher key.
     *
     * @param text the message to be transformed
     * @param code the cipher key to be used for transformation
     * @return the transformed message
     */
    private String transform(String text, char[] code) {
        char[] ciphered = text.toCharArray();
        for (int i = 0; i < ciphered.length; i++) {
            if (Character.isUpperCase(ciphered[i])) {
                ciphered[i] = code[ciphered[i] - 'A'];
            } else if (Character.isLowerCase(ciphered[i])) {
                ciphered[i] = (char) (code[ciphered[i] - ' ' - 'A'] + ' '); // convert it to upper then for lower
            }
        }
        return new String(ciphered);
    }

    /**
     * Validates if the encoder string parameter is a valid cipher key.
     *
     * @param encoder the encoder string to be validated
     * @throws IllegalArgumentException if the encoder string length is not 26 or contains characters
     *                                  other than uppercase letters
     */
    private void validateParameter(String encoder) {
        if (encoder.length() != 26)
            throw new IllegalArgumentException("Cipher string key must be 26 letters.");
        for (int i = 0; i < 26; i++) {
            char ch = encoder.charAt(i);
            if (!Character.isLetter(ch))
                throw new IllegalArgumentException("Cipher string key must contain English letters only.");
        }
    }

}
