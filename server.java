import java.net.*;
import java.io.*;

public class server {
	public static void main(String args[]) throws IOException {
	
		int portNumber = 8001;

		try (
			ServerSocket serversocket = new ServerSocket(portNumber);
			Socket clientsocket = serversocket.accept();
			PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
		) {
			String inputLine, outputLine;
			outputLine = "Connection established.";
			out.println(outputLine);
			System.out.println(outputLine);

			while ((inputLine = in.readLine()) != null) {
				outputLine = "Received: " + inputLine;
				out.println(outputLine);
			}

		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection.");
			System.out.println(e.getMessage());
		}
	}
}
