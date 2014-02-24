package zcy.media.mp3player.player;

import zcy.media.mp3player.decoder.JavaLayerException;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaMp3Player jlp = new JavaMp3Player("E:\\music\\other\\不让我的眼泪陪我过夜.mp3");
		try {
			jlp.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
