/**
*The PlaylistOperations java application tests the methods of the Playlist
*class and allows the user to manipulate a single Playlist object by
*performing operations on it
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
*
* @version 1 Build 1 July 12 2020
**/
import java.util.Scanner; //using this for keybaord input

public class PlaylistOperations
{
	public static void main(String args[])
	{

		// general variables
		boolean      quit = false; // for while loop to keep program going
		Playlist     p1 = new Playlist(); // playlist we will use

		// menu variables
		String       choice; // selction from the menu choice
		Scanner      menuChoice = new Scanner(System.in); // scanner for the menu


		// add song variables
		Scanner     addInTitle = new Scanner(System.in); // scanner to get title
		Scanner     addInArtist = new Scanner(System.in); // scanner to get artist
		Scanner     addInMin = new Scanner(System.in); // scanner to get minute
		Scanner     addInSec = new Scanner(System.in); // scanner to get seconds
		Scanner     addInPos = new Scanner(System.in);  // scanner to get position
		String      addTempTitle; // for constructor
		String      addTempArtist;  // for constructor
		int         addTempMin;  // for constructor
		int         addTempSec;  // for constructor
		int         addTempPos; // to add to playlist


		// get songs variables
		int         getPos;//position to get song from
		Scanner     inGetPos = new Scanner(System.in); // scanner for input


		// remove song variables
		int         remSong; // position to remove from
		Scanner     inRemSong = new Scanner(System.in); // scanner to get position

		// Get song by artist variables
		String     byArtist; // string ofr artist
		Scanner    inByArtist = new Scanner(System.in); // scanner to get desired artist


		while(!quit) // until we select quit this keeps looping
		{
			printMenu(); // calls this method, wanted to condense it in the main

			choice = menuChoice.nextLine().toUpperCase(); // the input the menu choice
			//System.out.println(choice); 

			if (choice.equals("A")) // add song
			{
				System.out.println("ADD SONG!");
				// init new SongRecord
				// add to playlist

				System.out.printf("Enter Title: ");
				addTempTitle = addInTitle.nextLine();

				System.out.printf("Enter Artist: ");
				addTempArtist = addInArtist.nextLine();

				System.out.printf("Enter number of minutes: ");
				addTempMin = addInMin.nextInt();

				System.out.printf("Enter number of Seconds: ");
				addTempSec = addInSec.nextInt();

				SongRecord tempSong = new SongRecord(addTempTitle,
							addTempArtist, addTempMin,
							addTempSec); // constructs song

				System.out.printf("Enter song position between 1 and " + (p1.size()+1) + ": ");
				addTempPos = addInPos.nextInt();

				p1.addSong(addTempPos, tempSong);

				System.out.println("Song added.");

			} else if (choice.equals("G")) { // Get Song
				System.out.printf("Enter the position of the song you want ");
				System.out.printf("between 1 and "+ p1.size() + ": ");
				getPos = inGetPos.nextInt();
				System.out.println(p1.getSong(getPos).toString());

			} else if (choice.equals("R")) { // Remove Song

				System.out.printf("Enter the position of the song you want ");
				System.out.printf("to remove between 1 and "+ p1.size() + ": ");
				remSong = inRemSong.nextInt();
				p1.removeSong(remSong);

			} else if (choice.equals("P")) { // Print all songs

				System.out.println("Now printing all songs: ");
				p1.printAllSongs();

			} else if (choice.equals("B")) { // songs by artist
				System.out.printf("\nPlease input the desired Artist: ");
				byArtist =  inByArtist.nextLine();

				//Playlist.getSongsByArtist(p1, byArtist);

				for (int x = 1; x<=p1.size(); x++)
				{
					String tempArtist = p1.getSong(x).getArtist();
					if (tempArtist.contains(byArtist))
						System.out.println(p1.getSong(x).toString());
				} 


			} else if (choice.equals("S")) { // size

				System.out.printf("\nThere are currently " + p1.size() );
				System.out.printf(" Songs in the playlist.\n");

			} else if (choice.equals("Q")) { // quit
				quit = true;
			} else {
				System.out.println("That's not an option!");
			}



		}
		System.out.println("Have a great day!\n");
	} // end main


	/**
	*prints out the menu of options
	**/

	public static void printMenu()
	{
		System.out.printf("\n\nMenu:\n");
		System.out.printf("Select the letter of the choice you want:\n");
		System.out.printf("\tAdd Song:                 A\n");
		System.out.printf("\tGet Song:                 G\n");
		System.out.printf("\tRemove Song:              R\n");
		System.out.printf("\tPrint All Songs:          P\n");
		System.out.printf("\tPrint Songs By Artist:    B\n");
		System.out.printf("\tSize                      S\n");
		System.out.printf("\tQuit:                     Q\n");
		System.out.printf("Selection: ");
	} // end print menu

}//end class
