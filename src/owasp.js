// 1. Pérdida de Control de Acceso (A01:2021)
function getSensitiveData(userId) {
    // Simulación de falta de control de acceso
    if (userId === "admin") {
        return "Datos confidenciales";
    } else {
        return "Acceso denegado";
    }
}

// 2. Fallas Criptográficas (A02:2021)
function encryptData(data) {
    // Simulación de cifrado inseguro
    return btoa(data); // No se debe usar base64 para cifrar datos sensibles
}

// 3. Inyección (A03:2021)
function executeQuery(userInput) {
    // Simulación de vulnerabilidad de inyección SQL
    const query = `SELECT * FROM users WHERE username = '${userInput}'`;
    // ¡No concatenes directamente el valor del usuario en la consulta SQL!
}

// 4. Diseño Inseguro (A04:2021)
// No se muestra aquí, pero asegúrate de seguir prácticas seguras de diseño.

// 5. Configuración de Seguridad Incorrecta (A05:2021)
function disableSecurityHeaders() {
    // Simulación de configuración incorrecta
    response.headers["X-Frame-Options"] = "ALLOWALL";
    response.headers["Content-Security-Policy"] = "default-src 'self'";
}

// 6. Componentes Vulnerables y Desactualizados (A06:2021)
// No se muestra aquí, pero mantén tus bibliotecas actualizadas.

// 7. Identificación y Autenticación Rota (A07:2021)
function login(username, password) {
    // Simulación de autenticación insegura
    if (username === "admin" && password === "admin123") {
        return "Bienvenido, administrador";
    } else {
        return "Credenciales inválidas";
    }
}

// 8. Exposición de Datos Sensibles (A08:2021)
function getUserProfile(userId) {
    // Simulación de exposición de datos sensibles
    if (userId === "123") {
        return "Nombre: Juan Pérez, Email: juan@example.com";
    } else {
        return "Usuario no encontrado";
    }
}

// 9. Falta de Control de Acceso a Nivel de Función (A09:2021)
function transferFunds(fromAccount, toAccount, amount) {
    // Simulación de falta de control de acceso
    if (fromAccount === "user123" && toAccount === "user456") {
        // Realizar transferencia
        return "Transferencia exitosa";
    } else {
        return "Acceso denegado";
    }
}

// 10. Configuración Incorrecta de Seguridad (A10:2021)
function enableDebugMode() {
    // Simulación de configuración incorrecta
    app.debug = true;
    // ¡No debes habilitar el modo de depuración en producción!
}
