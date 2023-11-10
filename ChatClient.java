import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 8080); // Reemplaza "IP_DEL_SERVIDOR" por la dirección IP del servidor

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            System.out.print("Ingresa tu nombre: ");
            String username = consoleInput.readLine();

            while (true) {
                System.out.print(username + ": ");
                clientMessage = consoleInput.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("bye")) {
                    break;
                }

                serverMessage = in.readLine();
                System.out.println("Servidor: " + serverMessage);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
