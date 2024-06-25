package src;

import java.io.*;
import java.net.Socket;

public class SimpleSMTPClient {

    public static void main(String[] args) {
        String smtpServer = "smtp.example.com"; // Replace with your SMTP server
        int port = 587; // SMTP port, usually 25, 465, or 587
        String from = "sn.yap@itapps.com"; // Replace with your email address
        String to = "sn.yap@itapps.com"; // Replace with recipient's email address
        String subject = "Test Email";
        String body = "This is a test email sent using plain Java sockets.";

        try (Socket socket = new Socket(smtpServer, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            // Read initial server response
            System.out.println("Server: " + reader.readLine());

            // Send HELO command
            writer.write("HELO " + smtpServer + "\r\n");
            writer.flush();
            System.out.println("Client: HELO " + smtpServer);
            System.out.println("Server: " + reader.readLine());

            // Send MAIL FROM command
            writer.write("MAIL FROM:<" + from + ">\r\n");
            writer.flush();
            System.out.println("Client: MAIL FROM:<" + from + ">");
            System.out.println("Server: " + reader.readLine());

            // Send RCPT TO command
            writer.write("RCPT TO:<" + to + ">\r\n");
            writer.flush();
            System.out.println("Client: RCPT TO:<" + to + ">");
            System.out.println("Server: " + reader.readLine());

            // Send DATA command
            writer.write("DATA\r\n");
            writer.flush();
            System.out.println("Client: DATA");
            System.out.println("Server: " + reader.readLine());

            // Send email headers and body
            writer.write("Subject: " + subject + "\r\n");
            writer.write("From: " + from + "\r\n");
            writer.write("To: " + to + "\r\n");
            writer.write("\r\n"); // Blank line between headers and body
            writer.write(body + "\r\n");
            writer.write(".\r\n"); // End of data
            writer.flush();
            System.out.println("Client: [Email content]");
            System.out.println("Server: " + reader.readLine());

            // Send QUIT command
            writer.write("QUIT\r\n");
            writer.flush();
            System.out.println("Client: QUIT");
            System.out.println("Server: " + reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
