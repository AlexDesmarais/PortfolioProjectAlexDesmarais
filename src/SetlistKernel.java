package components.setlist;

import components.standard.Standard;

/**
 * Setlist kernel component with primary methods.
 *
 * @mathmodel type SetlistKernel is modeled by STRING_SEQUENCE
 * @initially ensures this = <empty>
 */
public interface SetlistKernel extends Standard<SetlistKernel> {

    /**
     * Adds a song to the setlist.
     *
     * @param song
     *            the song to be added
     * @updates this
     * @ensures this = #this * <song>
     */
    void addSong(String song);

    /**
     * Removes a song from the setlist.
     *
     * @param song
     *            the song to be removed
     * @updates this
     * @requires song is in the setlist
     * @ensures this = #this - <song>
     */
    void removeSong(String song);

    /**
     * Returns the number of songs in the setlist.
     *
     * @return the song count
     * @ensures getSongCount = |this|
     */
    int getSongCount();

    /**
     * Clears the setlist of all songs.
     *
     * @updates this
     * @ensures this = <empty>
     */
    void clearSetlist();
}
