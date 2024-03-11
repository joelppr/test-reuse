# Ejemplo de código Python con vulnerabilidades OWASP Top 10

# 1. Pérdida de Control de Acceso (A01:2021)
def get_sensitive_data(user_id):
    # Simulación de falta de control de acceso
    if user_id == "admin":
        return "Datos confidenciales"
    else:
        return "Acceso denegado"

# 2. Fallas Criptográficas (A02:2021)
def encrypt_data(data):
    # Simulación de cifrado inseguro
    return data.encode("base64")  # No se debe usar base64 para cifrar datos sensibles

# 3. Inyección (A03:2021)
def execute_query(user_input):
    # Simulación de vulnerabilidad de inyección SQL
    query = f"SELECT * FROM users WHERE username = '{user_input}'"
    # ¡No concatenes directamente el valor del usuario en la consulta SQL!

# 4. Diseño Inseguro (A04:2021)
class InsecureDesign:
    def __init__(self, password):
        # Simulación de diseño inseguro
        self.password = password

    def authenticate(self, user_input):
        # ¡No almacenes contraseñas en texto plano!
        return self.password == user_input

# 5. Configuración de Seguridad Incorrecta (A05:2021)
def disable_security_headers():
    # Simulación de configuración incorrecta
    response.headers["X-Frame-Options"] = "ALLOWALL"
    response.headers["Content-Security-Policy"] = "default-src 'self'"

# 6. Componentes Vulnerables y Desactualizados (A06:2021)
# No se muestra aquí, pero asegúrate de mantener tus bibliotecas actualizadas.

# 7. Identificación y Autenticación Rota (A07:2021)
def login(username, password):
    # Simulación de autenticación insegura
    if username == "admin" and password == "admin123":
        return "Bienvenido, administrador"
    else:
        return "Credenciales inválidas"

# 8. Exposición de Datos Sensibles (A08:2021)
def get_user_profile(user_id):
    # Simulación de exposición de datos sensibles
    if user_id == "123":
        return {"nombre": "Juan Pérez", "email": "juan@example.com"}
    else:
        return "Usuario no encontrado"

# 9. Falta de Control de Acceso a Nivel de Función (A09:2021)
def transfer_funds(from_account, to_account, amount):
    # Simulación de falta de control de acceso
    if from_account == "user123" and to_account == "user456":
        # Realizar transferencia
        return "Transferencia exitosa"
    else:
        return "Acceso denegado"

# 10. Configuración Incorrecta de Seguridad (A10:2021)
def enable_debug_mode():
    # Simulación de configuración incorrecta
    app.debug = True
    # ¡No debes habilitar el modo de depuración en producción!
