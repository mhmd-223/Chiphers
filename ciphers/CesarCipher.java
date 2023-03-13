package chapter3.exercises.projects.ciphers;

/**
 * The CesarCipher class is a subclass of SubstitutionCipher that implements a Caesar cipher,
 * which is a simple substitution cipher where each letter is shifted a fixed number of positions
 * down the alphabet.
 */
public class CesarCipher extends SubstitutionCipher {

    /**
     * Constructs a new CesarCipher object with the given rotation amount.
     *
     * @param rotationAmount the number of positions to shift each letter in the alphabet
     * @throws IllegalArgumentException if the rotation amount is negative
     */
    public CesarCipher(int rotationAmount) {
        super(getKey(rotationAmount));
    }

    /**
     * Returns the key string for a Caesar cipher with the given rotation amount.
     *
     * @param rotationAmount the number of positions to shift each letter in the alphabet
     * @return the key string for the Caesar cipher
     * @throws IllegalArgumentException if the rotation amount is negative
     */
    private static String getKey(int rotationAmount) {
        if (rotationAmount < 0)
            throw new IllegalArgumentException("Amount of rotation cannot be negative.");
        char[] key = new char[26];
        for (int i = 0; i < key.length; i++) {
            key[i] = (char) ('A' + (i + rotationAmount) % 26);
        }
        return new String(key);
    }

    public static void main(String[] args) {
        chapter3.studying.CesarCipher s = new chapter3.studying.CesarCipher(3);
        String msg = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String encrypt = s.encrypt(msg);
        System.out.println(encrypt);
        System.out.println(s.decrypt(encrypt));
    }
}
