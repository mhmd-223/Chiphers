package chapter3.exercises.projects.ciphers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a cipher that uses a randomly generated substitution key.
 */
public class RandomCipher extends SubstitutionCipher {

    /**
     * Constructs a new instance of the RandomCipher class with a randomly generated substitution key.
     */
    public RandomCipher() {
        super(getRandKey());
    }

    /**
     * Generates a random substitution key by shuffling the letters of the alphabet.
     *
     * @return A string representing the randomly generated substitution key.
     */
    private static String getRandKey() {
        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        Collections.shuffle(list);
        StringBuilder key = new StringBuilder();
        for (char c : list) {
            key.append(c);
        }
        return key.toString();
    }


    public static void main(String[] args) {
        RandomCipher randomCipher = new RandomCipher();
        String msg = "HELLO HOW ARE YOU";
        String encoded = randomCipher.encode(msg);
        System.out.println("Encoded: " + encoded);
        String decoded = randomCipher.decode(encoded);
        System.out.println("Original: " + decoded);
    }
}
