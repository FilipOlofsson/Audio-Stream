package Client;

import java.io.*;
import java.net.Socket;

public class Connection {

    private DataInputStream input;
    private BufferedWriter output;

    Connection(String IP, int port) throws IOException {
        Socket socket = new Socket(IP, port);
        input = new DataInputStream(socket.getInputStream());
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    byte[] getHeader() throws IOException {
        byte[] buffer = new byte[44];
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) input.readUnsignedByte();
        }
        return buffer;
    }

    byte[] getTwoBytes() throws IOException {
        int firstByte;
        int secondByte;
        firstByte = input.readUnsignedByte();
        secondByte = input.readUnsignedByte();
        byte[] buffer = new byte[2];
        buffer[0] = (byte) firstByte;
        buffer[1] = (byte) secondByte;
        return buffer;
    }

    void sendSongChoice(int id) throws IOException {
        output.write(id);
    }

}
