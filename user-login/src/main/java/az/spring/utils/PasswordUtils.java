package az.spring.utils;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    private static final int BCRYPT_ROUNDS = 12;

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(BCRYPT_ROUNDS));
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
