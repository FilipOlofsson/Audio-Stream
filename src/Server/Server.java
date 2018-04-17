package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(65513);
            Connection connection = new Connection(socket.accept());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
