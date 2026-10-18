package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessExample {

    public static void main(String[] args) {
        // 1. Configurar el comando y sus argumentos usando ProcessBuilder
        // En Windows usa: "ping", "-n", "3", "127.0.0.1"
        // En Linux/macOS usa: "ping", "-c", "3", "127.0.0.1"
        ProcessBuilder processBuilder = new ProcessBuilder("ping", "-c", "3", "127.0.0.1");

        // Opcional: Redirigir el flujo de error estándar al flujo de salida estándar
        processBuilder.redirectErrorStream(true);

        try {
            // 2. Iniciar el proceso (devuelve un objeto Process)
            System.out.println("Iniciando el proceso externo...");
            Process process = processBuilder.start();

            // 3. Leer la salida del proceso
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[Salida del Proceso] " + line);
                }
            }

            // 4. Esperar a que el proceso termine y obtener el código de salida
            int exitCode = process.waitFor();
            System.out.println("\nProceso finalizado con código de salida: " + exitCode);

            if (exitCode == 0) {
                System.out.println("¡Comando ejecutado con éxito!");
            } else {
                System.out.println("El comando falló o devolvió un error.");
            }

        } catch (IOException e) {
            System.err.println("Error de I/O al ejecutar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
        }
    }
}
