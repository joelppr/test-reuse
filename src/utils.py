# Ejemplo de código Python con vulnerabilidades

# Vulnerabilidad 1: Inyección de comandos
def execute_command(user_input):
    # ¡Cuidado! No se debe ejecutar directamente el input del usuario.
    result = os.system(f"ls {user_input}")
    return result

# Vulnerabilidad 2: Falta de validación de entrada
def divide_numbers(a, b):
    # No se verifica si b es igual a cero.
    return a / b

# Vulnerabilidad 3: Uso inseguro de bibliotecas
import requests

def fetch_data(url):
    # No se manejan errores ni se verifica la seguridad del sitio web.
    response = requests.get(url)
    return response.text

# Vulnerabilidad 4: Almacenamiento inseguro de contraseñas
def save_password(username, password):
    # No se cifra ni se protege adecuadamente la contraseña.
    with open("passwords.txt", "a") as file:
        file.write(f"{username}:{password}\n")

# ¡Recuerda que este código es solo un ejemplo educativo! No lo uses en producción sin corregir estas vulnerabilidades.

# Siempre es importante revisar y auditar el código para detectar y solucionar posibles problemas de seguridad.
