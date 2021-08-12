/**
*The Paylist class implements a playlist object
*that stores information on a playlist
*
*@author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
*
*@version 1 build 1 July 8, 2020
*
**/

import java.util.Scanner;
public class Playlist
{
	int MAX_SONGS = 50;
	private SongRecord initList[] = new SongRecord[MAX_SONGS+1];
	private int songCount;

	//Invariants
	//MAX_SONGS is the max number of songs as specified in the assignment
	// initList makes the initial empty list of no songs
	// songCount is the number of songs in the playlist

	/**
	* Returns an instance of a playlist
	*
	* Postcondition:
	*	The playlist has been initialized to an empty list of SongRecords
	*
	**/

	public Playlist()
	{
		this.initList= initList;
		this.songCount = 0;
	}



	/**
	* inputs a new SongRecord into the playlist
	*
	* @param location
	* 	the number in the playlist for the song
	*
	* @param inSong
	*	a SongRecord object to be added
	*
	* @throws IllegalArgumentException
	*	If the entered location is out of range
	*
	* @throws FullPlaylistExcpetion
	* 	if there are 50 songs already in list
	**/

	public void addSong(int position, SongRecord inSong)
	{
		try
		{
			int location = position;
			if (location <1 || location > (this.songCount +1))
				throw new IllegalArgumentException();

			try
			{

				if (this.songCount == MAX_SONGS)
					throw new FullPlaylistException();


				for (int q = this.songCount +1; q>location; q--)
				{
					this.initList[q] =(SongRecord)this.initList[q-1].clone();

				}

				this.initList[location] = inSong;
				this.songCount++;
			}
			catch (FullPlaylistException k)
			{
			}

		}
		catch (IllegalArgumentException k)
		{
				System.out.println("Position out of Range!");
		}

	}

	/**
	* adds a song
	*
	*@param location
	* 	the track in the playlist that you want removed
	*
	* @throws IllegalArgumentException
	*	if the entered location is out of range
	**/

	public void removeSong(int position)
	{

		try
		{
			int location = position;

			if (location <1 || location > (this.songCount +1))
				throw new IllegalArgumentException();

			for (int k = location; k<this.songCount; k++)
			{
				this.initList[k] = (SongRecord)this.initList[k+1].clone();
			}

			this.initList[songCount] = null;
			this.songCount--;

		}
		catch (IllegalArgumentException m)
		{
			System.out.println("Position out of range!");
		}
	}



	/**
	*Returns a deepclone of the playlist
	*
	* @returns
	*	A deep copy of the playlist
	**/

	public Object clone()
	{
		Playlist playlistCopy = new Playlist();
		playlistCopy.songCount = this.songCount;

		for (int i = 1; i<= this.songCount; i++) {

			playlistCopy.initList[i] =
				(SongRecord)((SongRecord)this.initList[i]).clone();
		}

		return playlistCopy;
	}


	/**
	*Gets the number of songs in the playlist
	*
	* Precondition: The playlist has been instantiated
	*
	* @returns
	*	number of SongRecords in the playlist
	**/
	public int size()
	{
		return this.songCount;
	}


	/**
	* Compare this playlist to another for equality
	*
	* @param
	*	a playlist object to compare it to
	*
	* @ returns
	* 	a boolean, if they are exact duplicates
	*	then it is true, else false
	**/

	public boolean equals(Playlist inPlaylist)
	{
		boolean checkEq = true;

		String thatTitle;
		String inPlayTitle;

		String thatArtist;
		String inPlayArtist;

		int thatMinutes;
		int inPlayMinutes;

		int thatSeconds;
		int inPlaySeconds;

		int j = 1;

		if (inPlaylist instanceof Playlist)
		{
			if (this.songCount != inPlaylist.songCount)
			{
				checkEq = false;
			} else {
				while (j <= this.songCount && checkEq == true)
				{
					thatTitle = this.initList[j].getTitle();
					inPlayTitle = inPlaylist.initList[j].getTitle();
					//System.out.println("ThatTitle: " + thatTitle);
					//System.out.println("inPlay: " + inPlayTitle);

					if (thatTitle != inPlayTitle)
					{
						checkEq = false;
					}

					thatArtist = this.initList[j].getArtist();
					inPlayArtist = inPlaylist.initList[j].getArtist();

					if (thatArtist != inPlayArtist)
					{
						checkEq = false;
					}


					thatMinutes = this.initList[j].getMinute();
					inPlayMinutes = inPlaylist.initList[j].getMinute();

					if (thatMinutes != inPlayMinutes)
					{
						checkEq = false;
					}


					thatSeconds = this.initList[j].getSeconds();
					inPlaySeconds = inPlaylist.initList[j].getSeconds();

					if (thatSeconds != inPlaySeconds)
					{
						checkEq = false;

					}

					j++;

				} // end for loop
			} // end the else statement

		} else {
			checkEq = false;
		}

		return checkEq;
	}


	/**
	*returns the song at the specified location
	*
	* @param position
	*	the position of the song you want
	*
	* @throws IllegalArgumentException
	*	if the position is out of range
	*
	**/

	public SongRecord getSong(int position)
	{
		try
		{
			if (position <1 || position> this.songCount)
				throw new IllegalArgumentException();

			SongRecord tempSong = (SongRecord)this.initList[position].clone();
			return tempSong;

		}
		catch (IllegalArgumentException m)
		{
			System.out.println("Position out of range!");
			return null;
		}
	}


	/**
	* prints all songs in the playlist in a neat format
	**/

	public void printAllSongs()
	{
		for (int m =1; m<=this.songCount; m++)
		{
			System.out.println(this.initList[m].toString());
		}
	}



	/**
	*generates a new playlist containging all SongRecords in the original playlist
	*by the specified artist
	*
	* @param originalList
	*	original playlist
	*
	* @param artist
	*	String of the name of the desired artist
	*
	*Precondition
	* playlist referred to by originalList has been instantiated
	*
	*Postcondition
	*
	*@returns artistList
	*	playlist of the songs by the specified artist
	*
	**/

	public static Playlist getSongsByArtist(Playlist originalList, String artist)
	{
		Playlist artistList = new Playlist();
		int count = 0;
		String tempArtist;
		artist = artist;

		for (int n = 1; n<=originalList.songCount; n++)
		{
			tempArtist = originalList.initList[n].getArtist();
			if (tempArtist.contains(artist))
			{
				count++;
				artistList.initList[count] = (SongRecord)
					originalList.initList[n].clone();

			}
		}

		artistList.songCount = count;
		if (count == 0)
		{
			return null;
		} else {
			return artistList;
		}
	}


	/**
	*prints the playlist as a nicely formatted string
	*
	* @returns playString
	*	the string that has all the info
	**/

	public String toString()
	{
		String playString = "";
		for (int p = 1; p <= this.songCount; p++)
		{
			playString = playString + this.initList[p].toString() + "\n";
		}
		return playString;
	}


}// end class
