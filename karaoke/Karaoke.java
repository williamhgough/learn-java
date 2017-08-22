import com.treehouse.model.Song;
import com.treehouse.model.SongBook;
import com.treehouse.KaraokeMachine;

public class Karaoke {
    public static void main(String[] args) {
        SongBook library = new SongBook();
        KaraokeMachine machine = new KaraokeMachine(library);
        machine.run();
    }
}