package live;

import com.music.Playable;
import com.music.string.Veena;
import com.music.wind.Saxophone;

public class Test {
	public static void main(String[] args) {
		// Creating instance of Veena and calling play()
		Veena veena = new Veena();
		veena.play();

		// Creating instance of Saxophone and calling play()
		Saxophone saxophone = new Saxophone();
		saxophone.play();

		// Using Playable reference
		System.out.println("\nUsing Playable reference:");
		Playable playable1 = new Veena();
		playable1.play();

		Playable playable2 = new Saxophone();
		playable2.play();
	}
}