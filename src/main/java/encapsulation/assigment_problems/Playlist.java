package encapsulation.assigment_problems;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String title) {
        songs[songCount] = title;
        songCount++;
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];
        System.arraycopy(songs, 0, copy, 0, songCount);
        return copy;
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
