package chestiiCuFisiere.util;

import java.util.Random;

public class PasswordGenerator {

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private final Random random = new Random();
    private final int UPPER_BOUND = 32;

    public String generateRandomPassword(int minLength) {
        int passLength = random.nextInt(UPPER_BOUND - minLength) + minLength;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < passLength; i++) {
            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return builder.toString();
    }
}
