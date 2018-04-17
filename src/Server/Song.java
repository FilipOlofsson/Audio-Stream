package Server;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Song {

    File song;
    int id;
    List<Byte> songBytes = new LinkedList<>();

    Song(File file, int id) {
        this.song = file;
        this.id = id;
        readSong();
    }

    void readSong() {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream(song));
            int readByte;
            while((readByte = input.readUnsignedByte()) != -1) {
                songBytes.add((byte) readByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // ignore
        }
    }

}
