package components.setlist;

/**
 * {@code SetlistKernel} enhanced with secondary methods.
 */
public interface Setlist extends SetlistKernel {

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
    void moveSong(int fromIndex, int toIndex);

    /**
     * Finds a song in the setlist based on a keyword.
     *
     * @param keyword
     *            the keyword to search for
     * @return the index of the first matching song, or -1 if no match is found
     * @ensures findSong = (the index of the first match or -1)
     */
    int findSong(String keyword);

    /**
     * Gets the song at the specified index in the setlist.
     *
     * @param index
     *            the index of the song to retrieve
     * @return the song at the specified index
     * @requires 0 <= index < |this|
     * @ensures getSongAt = (the song at the specified index)
     */
    String getSongAt(int index);
}
