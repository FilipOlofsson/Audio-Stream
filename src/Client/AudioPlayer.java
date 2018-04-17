package Client;

import java.io.IOException;

public class AudioPlayer implements Runnable {

    private Connection connection;
    private String IP = "localhost";
    private int port = 65513;
    private WAVPlayer player;
    private boolean playing = false;


    AudioPlayer() {
        try {
            connection = new Connection(IP, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void startSong(int id) {
        try {
            connection.sendSongChoice(id);
            player = new WAVPlayer(connection.getHeader());
            playing = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if(playing) {
            try {
                player.play(connection.getTwoBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
