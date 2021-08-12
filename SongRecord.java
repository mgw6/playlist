/**
* The SongRecord class implements a SongRecord item
* that stores information on a song file
*
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
* @version 1 Build 1 July 7, 2020
*
**/


import java.util.Scanner;
public class SongRecord
{
	private String       title;
	private String       artist;
	private int          minutes;
	private int          seconds;


	//Invariants:
	//title represents the name of the song
	//artist is the name of the song's artist
	//minutes is the number of minutes of the song
	//seconds is the number of seconds of the song
	//after the last full minute

	/**
	* Returns an instance of a SongRecord
	*
	* @param t
	*	title of the song
	*
	* @param a
	*	name of artist
	*
	* @param m
	*	length of the song in minutes
	*
	* Precondition:
	*	number of minutes cannot be < 0
	*
	*
	* @param s
	*	length of the songs in seconds
	*
	* Precondition:
	*	number of seconds must be less
	*	than 60 and greater than or
	*	equal to 0
	*
	* @throws IllegalArgumentException
	*	if the seconds is < 0 or > 59
	*
	* @throws IllegalArgumentException
	*	if the minutes is less than 0
	**/

	public SongRecord(String t, String a, int m, int s)
	{
		this.title = t;
		this.artist = a;

		try {
			if (m<0) {
				throw new IllegalArgumentException();
			} else {

			this.minutes = m;
			}
		}
		catch(IllegalArgumentException k) {
			while (m<0) {
				System.out.println("Please input a postive number of minutes: ");
				Scanner scan2 = new Scanner(System.in);
				m = scan2.nextInt();
			}
		}



		try {
			if (s <0 || s>59) {
				throw new IllegalArgumentException();
			} else {
				this.seconds = s;
			}
		}
		catch(IllegalArgumentException l)
		 {
			while (s<0 || s>59)
			 {
				System.out.println("Please input a valid number of seconds; ");
				Scanner scan3 = new Scanner(System.in);
				s = scan3.nextInt();
			}
			this.seconds = s;
		}
	}// end object init



	/**
	* Returns the title of the SongRecord
	*
	* @return
	*	returns the title of the SongRecord
	**/
	public String getTitle()
	{
		return this.title;
	}

	/**
	* Sets the title of the SongRecord
	*
	* @param
	*	the new song title
	*
	* Postcondition:
	*	The title of the song has been changed to the inputed title
	**/
	public void SetTitle(String inName)
	{
		this.title = inName;
	}


	/**
	* Returns the artist of the SongRecord
	*
	* @return
	*	returns the artist of the SongRecord
	**/
	public String getArtist()
	{
		return this.artist;
	}

	/**
	* Sets the Artist of the SongRecord
	*
	* @param inArtist
	*	the new song artist
	*
	* Postcondition:
	*	The artist of the song has been changed to the inputed title
	**/
	public void setArtist(String inArtist)
	{
		this.artist = inArtist;
	}


	/**
	* returns the minute of the SongRecord
	*
	* @return
	*	returns the minute of the song
	**/

	public int getMinute()
	{
		return this.minutes;
	}


	/**
	* Sets the seconds of the SongRecord
	*
	*@param inMinute
	*	the desired minute of the song
	* @throws IllegalArgumentException
	*	if the minutes is less than 0
	**/
	public void setMinute(int inMinute)
	{
		try {
			if (inMinute<0){
				throw new IllegalArgumentException();
			} else {
				this.minutes = inMinute;
			}
		} //end try
		catch(IllegalArgumentException i) {
			while (inMinute < 0) {
				System.out.println("Please input a positive number of minutes: ");
				Scanner scan = new Scanner(System.in);
				inMinute = scan.nextInt();
			}
			this.minutes = inMinute;
		}
	}

	/**
	* returns the seconds of the SongRecord
	*
	* @return
	*	returns the seconds of the SongRecord
	**/

	public int getSeconds()
	{
		return this.seconds;
	}


	/**
	* Sets the seconds of the SongRecord
	*
	*@param inSeconds
	*	the desired seconds of the song
	* @throws IllegalArgumentException
	*	if the seonds is < 0 or >59
	**/
	public void setSeconds(int inSecond)
	{
		try {
			if(0 > inSecond || inSecond > 59){
				throw new IllegalArgumentException();
			} else {
				this.seconds = inSecond;
			}
		}
		catch (IllegalArgumentException j) {
			while (inSecond < 0 || inSecond > 59)
			{
				System.out.println("Make sure seconds is less than 60 and greater than or equal to 0");
				Scanner scan1 = new Scanner(System.in);
				inSecond = scan1.nextInt();
			}
			this.seconds = inSecond;
		}
	}

	/**
	* Prints out the information of the song in the specified format
	*
	**/


	public String toString()
	{
		if (this.seconds <10) {
			return String.format("%-27s%-27s%2d:%02d", this.title, this.artist,
					this.minutes, this.seconds);
		} else {
			return String.format("%-27s%-27s%2d:%d", this.title, this.artist,
					this.minutes, this.seconds);
		}
	}



	/**
	* Returns a deep clone of the Song Record
	*
	* @return
	*	a deep clone of the SongRecord
	*
	*
	**/

	public Object clone()
	{
		String tTemp = this.title;
		String aTemp = this.artist;
		int mTemp = this.minutes;
		int sTemp = this.seconds;

		SongRecord tempCopy = new SongRecord(tTemp, aTemp, mTemp, sTemp);
		return tempCopy;
	}

}//end main

