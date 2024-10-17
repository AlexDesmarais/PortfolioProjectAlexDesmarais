import java.util.ArrayList;
import java.util.List;

public class ConcertSetlist {

    private List<String> setlist;

    public ConcertSetlist() {
        this.setlist = new ArrayList<>();
    }

    public void addSong(String song) {
        this.setlist.add(song);
    }

    public void removeSong(String song) {
        this.setlist.remove(song);
    }

    public List<String> getSetlist() {
        return new ArrayList<>(this.setlist);
    }

    public int getSongCount() {
        return this.setlist.size();
    }

    public void clearSetlist() {
        this.setlist.clear();
    }

    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < this.setlist.size() && toIndex >= 0
                && toIndex < this.setlist.size()) {
            String song = this.setlist.remove(fromIndex);
            this.setlist.add(toIndex, song);
        }
    }

    public int findSong(String keyword) {
        for (int i = 0; i < this.setlist.size(); i++) {
            if (this.setlist.get(i).toLowerCase()
                    .contains(keyword.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public String getSongAt(int index) {
        if (index >= 0 && index < this.setlist.size()) {
            return this.setlist.get(index);
        }
        return null;
    }

    public static void main(String[] args) {
        ConcertSetlist mySetlist = new ConcertSetlist();
        mySetlist.addSong("Song 1");
        mySetlist.addSong("Song 2");
        mySetlist.addSong("Song 3");

        System.out.println("Setlist: " + mySetlist.getSetlist());
        System.out.println("Number of songs: " + mySetlist.getSongCount());

        System.out.println(
                "Setlist after moving a song: " + mySetlist.getSetlist());

        mySetlist.removeSong("Song 2");
        System.out.println(
                "Setlist after removing Song 2: " + mySetlist.getSetlist());

        mySetlist.clearSetlist();
        System.out.println("Setlist after clearing: " + mySetlist.getSetlist());
    }
}
