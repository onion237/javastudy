package chapter03;

public class SongTest {
	public static void main(String[] args) {
//		Song song = new Song();
//		song.setArtist("아이유");
//		song.setTitle("좋은날");
//		song.setAlbum("REAL");
//		song.setYear(2010);
//		song.setTrack(3);
//		song.setComposer("이민수");
		
		Song song = new Song("좋은날", "아이유", "REAL", "이민수", 2010, 3);
		song.show();
		Song song1 = new Song("신호등", "이무진");
		song1.show();
	}
}
