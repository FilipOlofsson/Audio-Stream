package Client;

import java.io.ObjectOutputStream;

public class Client {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        Thread playThread = new Thread(player);
        playThread.start();
        player.startSong(0);
    }
}
