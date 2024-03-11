import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

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

public class VulnerableCodeExample {

    // Vulnerabilidad 1: Inyección de comandos
    public static void executeCommand(String userCommand) {
        try {
            Runtime.getRuntime().exec(userCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Vulnerabilidad 2: Validación insuficiente de entrada
    public static void divideNumbers(int a, int b) {
        if (b != 0) {
            int result = a / b;
            System.out.println("Resultado de la división: " + result);
        } else {
            System.out.println("No se puede dividir por cero.");
        }
    }

    // Vulnerabilidad 3: Uso de bibliotecas inseguras
    public static void fetchFromUntrustedSource(String url) {
        try {
            // No se verifica la seguridad del sitio web antes de hacer la solicitud.
            Scanner scanner = new Scanner(new java.net.URL(url).openStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Vulnerabilidad 4: Almacenamiento inseguro de contraseñas
    private static String hardcodedPassword = "mi_contraseña_secreta";

    public static boolean authenticateUser(String inputPassword) {
        return inputPassword.equals(hardcodedPassword);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un comando para ejecutar (vulnerabilidad 1): ");
        String command = scanner.nextLine();
        executeCommand(command);

        System.out.print("Introduce dos números para dividir (vulnerabilidad 2): ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        divideNumbers(num1, num2);

        System.out.print("Introduce una URL para obtener datos (vulnerabilidad 3): ");
        String url = scanner.next();
        fetchFromUntrustedSource(url);

        System.out.print("Introduce una contraseña para autenticarte (vulnerabilidad 4): ");
        String inputPassword = scanner.next();
        if (authenticateUser(inputPassword)) {
            System.out.println("Acceso concedido.");
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }
}
