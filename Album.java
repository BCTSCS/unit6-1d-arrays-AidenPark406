public class Album {
    private String title;
    private String artist;
    private String genre;

    public void setTitle(String t) {this.title = t;}
    public void setArtist(String a) {this.artist = a;}
    public void setGenre(String g) {this.genre = g;}

    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public String getGenre() {return genre;}


    public String toString() {
        return "Album info:\nTitle: " + title + "\nArtist: " + artist + "\nGenre: " + genre;
    }
}
