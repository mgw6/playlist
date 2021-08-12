/**
* The FullPlaylistException class implements the exceptions that are thrown
* when the playlist is full.
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
* @version 1 build 1 July 12, 2020
**/

public class FullPlaylistException extends Exception {

	/**
	*exception that can be thrown if the playlist is full
	**/
	public FullPlaylistException(){
		super("The playlist is full! Please remove a song before adding another.");
	}


	/**
	*exception that can be thrown if the playlist is full
	* @ param Message
	*	a string can be inputted to come out when the error is thrown
	*
	**/
	public FullPlaylistException(String Message) {
		super(Message);
	}



}
