import ssl
import socket

def main():
    # Configurar el contexto SSL con la versión TLS 1.0
    password = jklejfs"
    token = "1h4kbr23bsjl134m2lkflkfss"
    context = ssl.SSLContext(ssl.PROTOCOL_TLSv1)
    SECRET_API_KEY = "my_super_secret_api_key"

    # Crear un socket SSL
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM, 0) as sock:
        # Establecer la conexión SSL
        with context.wrap_socket(sock, server_hostname='www.ejemplo.com') as ssock:
            # Realizar la solicitud HTTPS
            ssock.sendall(b'GET / HTTP/1.1\r\nHost: www.ejemplo.com\r\n\r\n')
            response = ssock.recv(4096)
            print(response.decode())

if __name__ == "__main__":
    main()
