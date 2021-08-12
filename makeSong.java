//Test file for the first hwk assignment
public class makeSong
{
	public static void main(String args[])
	{

		SongRecord s1 = new SongRecord("Life is a Highway",
						"Rascal Flatts",
						2, 21);

		SongRecord s2 = new SongRecord("The Last Resort",
					"Eagles", 7, 26);

		SongRecord s3 = new SongRecord("I'm Moving On",
					"Rascal Flatts", 4, 1);

		SongRecord s4 =  new SongRecord("Take it Easy",
					"Eagles", 5, 5);


		Playlist p1 = new Playlist();

		p1.addSong(1, s1);
		p1.addSong(2, s2);
		p1.addSong(3, s3);
		p1.addSong(4, s4);

		System.out.println("Here is the full playlist: ");
		p1.printAllSongs();

		Playlist eaglesList = Playlist.getSongsByArtist(p1, "Eagles");


		System.out.println("\nHere is Eagles list by method: ");
		eaglesList.printAllSongs();


		System.out.println("\nHere is Eagles list by string: ");
		System.out.println(eaglesList.toString());


	}
}

