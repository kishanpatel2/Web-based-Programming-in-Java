/*
Author: Kishan Patel
E-mail: kpp5282@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 3/14/2019
File: MusicSelection.java
Purpose: Java application that enables a user to create a playlist from
an online music library
Compiler/IDE: IntelliJ IDEA
System: Macbook Pro
Reference(s): Java 8 API - Oracle Documentation
(http://docs.oracle.com/javase/8/docs/api/);
*/
package musicLibrary;

public class MusicSelection {
    String differentGenres, differentArtist, differentTitles, differentAlbums, releaseDate;


public MusicSelection(){
    differentGenres = "";
    differentArtist = "";
    differentTitles = "";
    differentAlbums = "";
    releaseDate = "";
}

public MusicSelection(String differentGenres, String differentArtist, String differentTitles, String differentAlbums, String releaseDate){
    this.differentGenres = differentGenres;
    this.differentArtist = differentArtist;
    this.differentTitles = differentTitles;
    this.differentAlbums = differentAlbums;
    this.releaseDate = releaseDate;
}
    /** This returns the differentGenres of the song
     *
     */
    public String getdifferentGenres() {
        return differentGenres;
    }
    /** This method shows the differentGenres of the song
     *
     * @param differentGenres The differentGenres of the differentAlbums
     */
    public void setdifferentGenres(String differentGenres) {
        this.differentGenres = differentGenres;
    }
    /** This method returns the differentArtist
     *
     */
    public String getdifferentArtist() {
        return differentArtist;
    }
    /** This method shows the differentArtist.
     *
     * @param differentArtist The differentArtist of the song
     */
    public void setdifferentArtist(String differentArtist) {
        this.differentArtist = differentArtist;
    }
    /** This method returns the differentTitles name
     *
     */
    public String getdifferentTitles() {
        return differentTitles;
    }
    /** This method shows the differentTitles of the song
     *
     * @param differentTitles The differentTitles of the song
     */
    public void setdifferentTitles(String differentTitles) {
        this.differentTitles = differentTitles;
    }
    /** This method returns the differentdifferentAlbumss choice
     *
     */
    public String getdifferentAlbums() {
        return differentAlbums;
    }
    /** This method shows the differentAlbums of the song.
     *
     * @param differentAlbums THe differentAlbums of song
     */
    public void setdifferentAlbums(String differentAlbums) {
        this.differentAlbums = differentAlbums;
    }
    /** This method returns the release date
     *
     */
    public String getReleaseDate() {
        return releaseDate;
    }
    /** This method shows the release date of differentAlbums
     *
     * @param releaseDate The release date of differentAlbums
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /*public String toString(){
     return differentGenres + " " + differentArtist + " " + differentTitles + " " + differentAlbums + " " + releaseDate;
    }
*/
    /** This method will show the differentGenres differentArtist differentTitles differentAlbums and release date at end of program
     *
     */
    @Override public String toString()
    {
        String outdifferentGenres="Genre:          "+differentGenres;
        String outdifferentArtist="Artist:         "+differentArtist;
        String outdifferentTitles="Title:          "+differentTitles;
        String outdifferentAlbums="Album:          "+differentAlbums;
        String outDate="Released Date   "+releaseDate;
        return outdifferentGenres+"\n"+outdifferentArtist+"\n"+outdifferentTitles+"\n"+outdifferentAlbums+"\n"+outDate+"\n";
    }
}

