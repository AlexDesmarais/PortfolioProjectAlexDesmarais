package components.setlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Kernel implementation of ConcertSetlist.
 *
 * Convention: The internal list `setlist` contains only unique song titles.
 * Correspondence: This `SetlistKernel` is modeled by the sequence of strings in
 * `setlist`.
 */
public class ConcertSetlist1L extends SetlistSecondary {

    // Internal representation of the setlist as a List of Strings
    private final List<String> setlist;

    /**
     * Default constructor. Initializes an empty setlist.
     */
    public ConcertSetlist1L() {
        this.setlist = new ArrayList<>();
    }

    /**
     * Adds a song to the setlist.
     *
     * @param song
     *            the song to be added
     * @updates this
     * @ensures this = #this * <song>
     */
    @Override
    public void addSong(String song) {
        if (!this.setlist.contains(song)) { // Ensure uniqueness
            this.setlist.add(song);
        }
    }

    /**
     * Removes a song from the setlist.
     *
     * @param song
     *            the song to be removed
     * @updates this
     * @requires song is in the setlist
     * @ensures this = #this - <song>
     */
    @Override
    public void removeSong(String song) {
        this.setlist.remove(song);
    }

    /**
     * Returns the number of songs in the setlist.
     *
     * @return the song count
     * @ensures getSongCount = |this|
     */
    @Override
    public int getSongCount() {
        return this.setlist.size();
    }

    /**
     * Clears the setlist of all songs.
     *
     * @updates this
     * @ensures this = <empty>
     */
    @Override
    public void clearSetlist() {
        this.setlist.clear();
    }

    /**
     * Moves a song from one index to another within the setlist.
     *
     * @param fromIndex
     *            the index of the song to be moved
     * @param toIndex
     *            the index where the song should be moved
     * @updates this
     * @requires 0 <= fromIndex < |this| and 0 <= toIndex < |this|
     * @ensures the song is moved to the new position
     */
    @Override
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= this.setlist.size() || toIndex < 0
                || toIndex >= this.setlist.size()) {
            throw new IndexOutOfBoundsException("Invalid index for moveSong.");
        }
        String song = this.setlist.remove(fromIndex);
        this.setlist.add(toIndex, song);
    }

    /**
     * Finds a song in the setlist based on a keyword.
     *
     * @param keyword
     *            the keyword to search for
     * @return the index of the first matching song, or -1 if no match is found
     * @ensures findSong = (the index of the first match or -1)
     */
    @Override
    public int findSong(String keyword) {
        for (int i = 0; i < this.setlist.size(); i++) {
            if (this.setlist.get(i).contains(keyword)) {
                return i;
            }
        }
        return -1; // Return -1 if no match is found
    }

    /**
     * Gets the song at the specified index in the setlist.
     *
     * @param index
     *            the index of the song to retrieve
     * @return the song at the specified index
     * @requires 0 <= index < |this|
     * @ensures getSongAt = (the song at the specified index)
     */
    @Override
    public String getSongAt(int index) {
        if (index < 0 || index >= this.setlist.size()) {
            throw new IndexOutOfBoundsException("Invalid index for getSongAt.");
        }
        return this.setlist.get(index);
    }

    /**
     * Returns a string representation of the setlist.
     *
     * @return a string representation of the setlist
     */
    @Override
    public String toString() {
        return this.setlist.toString();
    }

    /**
     * Checks if this setlist is equal to another object.
     *
     * @param obj
     *            the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ConcertSetlist1L))
            return false;
        ConcertSetlist1L other = (ConcertSetlist1L) obj;
        return this.setlist.equals(other.setlist);
    }

    /**
     * Returns the hash code of the setlist.
     *
     * @return the hash code of the setlist
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.setlist);
    }

    /**
     * Provides an iterator over the setlist.
     *
     * @return an iterator over the setlist
     */
    @Override
    public Iterator<String> iterator() {
        return this.setlist.iterator();
    }
}
