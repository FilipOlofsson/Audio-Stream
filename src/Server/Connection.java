package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable {

    private Socket socket;
    private DataOutputStream output;
    private BufferedReader input;
    private SongList songList = new SongList();

    private Song song;
    private boolean playing = false;


    Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.output = new DataOutputStream(socket.getOutputStream());
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void getSongID() throws IOException {
        song = songList.findSong(Integer.parseInt(input.readLine()));
        playing = true;
    }

    @Override
    public void run() {
        if(playing) {
            for(int i = 0; i < (song.songBytes.size()-1)/2; i++) {
                    byte[] buffer = new byte[2];
                    buffer[0] = song.songBytes.get(i);
                    buffer[1] = song.songBytes.get(++i);
                    System.out.println("Sent " + buffer[0] + ", " + buffer[1]);
                    try {
                        output.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
