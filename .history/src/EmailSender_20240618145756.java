import java.io.*;
import java.net.*;

public class EmailSender {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("your.smtp.server", 25);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream os = socket.getOutputStream();

            // Simulate conversation with SMTP server
            smtp("HELO yourdomain.com", os, in);
            smtp("MAIL FROM: <from@example.com>", os, in);
            smtp("RCPT TO: <to@example.com>", os, in);
            smtp("DATA", os, in);
            smtp("Subject: Your Subject\r\n\r\nYour email content here.", os, in);
            smtp(".", os, in); // End the email
            smtp("QUIT", os, in);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void smtp(String command, OutputStream os, BufferedReader in) throws IOException {
        os.write((command + "\r\n").getBytes());
        os.flush();
        String response = in.readLine();
        System.out.println(response); // Print the server response
    }
}