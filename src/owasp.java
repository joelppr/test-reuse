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
