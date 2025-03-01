import java.util.*;

public class Spotbox {
    FileOperator A = new FileOperator("albums.txt");
    FileOperator B = new FileOperator("artists.txt");
    FileOperator C = new FileOperator("genres.txt");

    private ArrayList<String> albums = A.toStringList();
    private ArrayList<String> artists = B.toStringList();
    private ArrayList<String> genres = C.toStringList();

    public ArrayList<String> getGenres(String artist) {
        ArrayList<String> artistGenres = new ArrayList<>();
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).equals(artist) && !artistGenres.contains(genres.get(i))) {
                artistGenres.add(genres.get(i));
            }
        }

        return artistGenres;
    }

    public ArrayList<String> commonGenres(String artist1, String artist2) {
        ArrayList<String> genres1 = getGenres(artist1);
        ArrayList<String> genres2 = getGenres(artist2);

        ArrayList<String> commonGenres = new ArrayList<>();
        for (String genre : genres1) {
            if (genres2.contains(genre)) {
                commonGenres.add(genre);
            }
        }

        return commonGenres;
    }

    public static void main(String[] args) {
        Spotbox spotbox = new Spotbox();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first artist: ");
        String artist1 = scanner.nextLine();
        System.out.print("Enter second artist: ");
        String artist2 = scanner.nextLine();

        ArrayList<String> commonGenres = spotbox.commonGenres(artist1, artist2);

        if (commonGenres.isEmpty()) {
            System.out.println("No common genres found between " + artist1 + " and " + artist2 + ".");
        } else {
            System.out.println("Common genres between " + artist1 + " and " + artist2 + ": " + commonGenres);
        }


    }

}
