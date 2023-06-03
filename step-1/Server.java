import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Simple Echo Server ");

        
        try(ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server Started...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client...");

            try(
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            ){
                String line;
                while((line = in.readLine()) != null) {
                    System.out.println("Server : "+ line);
                    out.println(line);                    
                }
            }

        } catch (Exception e) {
            // handle the exception
        }
    }
}
