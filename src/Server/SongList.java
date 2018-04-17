package Server;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SongList {

    List<Song> songList = new LinkedList<>();
    String basePath = "songs/";


    SongList() {
        int id = 0;
        File folder = new File(basePath);
        for(File file : Objects.requireNonNull(folder.listFiles())) {
            songList.add(new Song(file, id));
            System.out.println("Added song with name " + file.getName() + ", id is " + id);
            id++;
        }
    }

    Song findSong(int id) {
        for(Song song : songList) {
            if(song.id == id) {
                return song;
            }
        }
        return null;
    }

}
