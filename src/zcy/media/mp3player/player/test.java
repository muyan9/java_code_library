package zcy.media.mp3player.player;

import zcy.media.mp3player.decoder.JavaLayerException;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaMp3Player jlp = new JavaMp3Player("E:\\music\\other\\�����ҵ��������ҹ�ҹ.mp3");
		try {
			jlp.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
