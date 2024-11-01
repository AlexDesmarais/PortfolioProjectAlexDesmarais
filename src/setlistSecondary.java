package components.setlist;

import java.util.Objects;

/**
 * Abstract secondary implementation of {@code Setlist}, layering over
 * {@code SetlistKernel}. Author: Alex Desmarais
 */
public abstract class setlistSecondary implements setlist {

    @Override
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= this.getSongCount() || toIndex < 0
                || toIndex >= this.getSongCount()) {
            throw new IndexOutOfBoundsException("Invalid index for moveSong.");
        }

        // Temporarily retrieve song at `fromIndex`
        String song = this.getSongAt(fromIndex);

        // Remove song from `fromIndex`
        removeSong(song);

        // Reinsert song at `toIndex`
        if (toIndex == this.getSongCount()) {
            addSong(song);
        } else {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < toIndex; i++) {
                temp.add(this.getSongAt(i));
            }
            temp.add(song);
            for (int i = toIndex; i < this.getSongCount(); i++) {
                temp.add(this.getSongAt(i));
            }
            clearSetlist();
            for (String s : temp) {
                addSong(s);
            }
        }
    }

    @Override
    public int findSong(String keyword) {
        for (int i = 0; i < this.getSongCount(); i++) {
            if (this.getSongAt(i).contains(keyword)) {
                return i;
            }
        }
        return -1; // Return -1 if not found
    }

    @Override
    public String getSongAt(int index) {
        if (index < 0 || index >= this.getSongCount()) {
            throw new IndexOutOfBoundsException("Invalid index for getSongAt.");
        }
        List<String> copy = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            copy.add(this.getSongAt(i));
        }
        String song = copy.get(index);
        clearSetlist();
        for (String s : copy) {
            addSong(s);
        }
        return song;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < getSongCount(); i++) {
            sb.append(this.getSongAt(i));
            if (i < getSongCount() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SetlistSecondary)) {
            return false;
        }
        SetlistSecondary other = (SetlistSecondary) obj;
        if (this.getSongCount() != other.getSongCount()) {
            return false;
        }
        for (int i = 0; i < getSongCount(); i++) {
            if (!this.getSongAt(i).equals(other.getSongAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}
