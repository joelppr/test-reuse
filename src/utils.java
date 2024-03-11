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

public class TotallyVulnerableCode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vulnerabilidad 1: Inyección de comandos
        System.out.print("Introduce un comando para ejecutar: ");
        String command = scanner.nextLine();
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Vulnerabilidad 2: Validación insuficiente de entrada
        System.out.print("Introduce dos números para dividir: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int result = num1 / num2;
        System.out.println("Resultado de la división: " + result);

        // Vulnerabilidad 3: Uso de bibliotecas inseguras
        System.out.print("Introduce una URL para obtener datos: ");
        String url = scanner.next();
        try {
            Scanner urlScanner = new Scanner(new java.net.URL(url).openStream());
            while (urlScanner.hasNextLine()) {
                System.out.println(urlScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Vulnerabilidad 4: Almacenamiento inseguro de contraseñas
        System.out.print("Introduce una contraseña para autenticarte: ");
        String inputPassword = scanner.next();
        String hardcodedPassword = "mi_contraseña_secreta";
        if (inputPassword.equals(hardcodedPassword)) {
            System.out.println("Acceso concedido.");
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }
}

import java.util.Base64;

public class OwaspTop10Examples {

    // 1. Pérdida de Control de Acceso (A01:2021)
    public String getSensitiveData(String userId) {
        // Simulación de falta de control de acceso
        if ("admin".equals(userId)) {
            return "Datos confidenciales";
        } else {
            return "Acceso denegado";
        }
    }

    // 2. Fallas Criptográficas (A02:2021)
    public String encryptData(String data) {
        // Simulación de cifrado inseguro
        return Base64.getEncoder().encodeToString(data.getBytes());
        // No se debe usar base64 para cifrar datos sensibles
    }

    // 3. Inyección (A03:2021)
    public void executeQuery(String userInput) {
        // Simulación de vulnerabilidad de inyección SQL
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        // ¡No concatenes directamente el valor del usuario en la consulta SQL!
    }

    // 4. Diseño Inseguro (A04:2021)
    // No se muestra aquí, pero asegúrate de seguir prácticas seguras de diseño.

    // 5. Configuración de Seguridad Incorrecta (A05:2021)
    public void disableSecurityHeaders() {
        // Simulación de configuración incorrecta
        System.setProperty("X-Frame-Options", "ALLOWALL");
        System.setProperty("Content-Security-Policy", "default-src 'self'");
    }

    // 6. Componentes Vulnerables y Desactualizados (A06:2021)
    // No se muestra aquí, pero mantén tus bibliotecas actualizadas.

        // 7. Identificación y Autenticación Rota (A07:2021)
    public String login(String username, String password) {
        // Simulación de autenticación insegura
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "Bienvenido, administrador";
        } else {
            return "Credenciales inválidas";
        }
    }

    // 8. Exposición de Datos Sensibles (A08:2021)
    public String getUserProfile(String userId) {
        // Simulación de exposición de datos sensibles
        if ("123".equals(userId)) {
            return "Nombre: Juan Pérez, Email: juan@example.com";
        } else {
            return "Usuario no encontrado";
        }
    }

    // 9. Falta de Control de Acceso a Nivel de Función (A09:2021)
    public String transferFunds(String fromAccount, String toAccount, double amount) {
        // Simulación de falta de control de acceso
        if ("user123".equals(fromAccount) && "user456".equals(toAccount)) {
            // Realizar transferencia
            return "Transferencia exitosa";
        } else {
            return "Acceso denegado";
        }
    }

    // 10. Configuración Incorrecta de Seguridad (A10:2021)
    public void enableDebugMode() {
        // Simulación de configuración incorrecta
        System.setProperty("debugMode", "true");
        // ¡No debes habilitar el modo de depuración en producción!
    }
}
