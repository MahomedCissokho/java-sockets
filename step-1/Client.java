import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        // String request = "";
        String input = "";

        System.out.println("Simple echo client ");

        try {
            System.out.println("Waiting for client Connection...");
            InetAddress localAddress = InetAddress.getLocalHost();

            try(
                Socket socket = new Socket(localAddress, 9999);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            )
            {
                System.out.println("Connected to the Server");
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a text : ");

                while(!input.equalsIgnoreCase("quit")){

                    input = scanner.nextLine();
                    out.println(input);
                    System.out.println("Server response : "+in.readLine());
                }
                scanner.close();
            }

        }catch (Exception e) {
            // handle the exception 
        }
    }
}
