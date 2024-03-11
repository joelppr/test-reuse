import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionExample {

    public static void main(String[] args) {
        // Almacena la contraseña en texto claro (¡esto es inseguro!)
        String plainPassword = "mi_contraseña_secreta";

        // Cifra la contraseña utilizando MD5 (inseguro)
        String hashedPassword = encryptPassword(plainPassword);

        System.out.println("Contraseña en texto claro: " + plainPassword);
        System.out.println("Contraseña cifrada (MD5): " + hashedPassword);
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes());

            // Convierte el hash en una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
