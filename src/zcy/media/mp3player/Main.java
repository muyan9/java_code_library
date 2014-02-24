package zcy.media.mp3player;

import zcy.media.mp3player.decoder.JavaLayerException;
import zcy.media.mp3player.player.JavaMp3Player;

public class Main {

	public static void main(String[] args) {
		JavaMp3Player mp3 = new JavaMp3Player(args[0]);
		try {
			mp3.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
