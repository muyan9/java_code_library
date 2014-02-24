/*
 * 11/19/04		1.0 moved to LGPL.
 * 
 * 06/04/01		Streaming support added. javalayer@javazoom.net
 * 
 * 29/01/00		Initial version. mdm@techie.com
 *-----------------------------------------------------------------------
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published
 *   by the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *----------------------------------------------------------------------
 */

package zcy.media.mp3player.player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import zcy.media.mp3player.decoder.JavaLayerException;


/**
 * The <code>JavaMp3Player</code> class implements a simple command-line
 * player for MPEG audio files.
 *
 * @author Mat McGowan (mdm@techie.com)
 */
public class JavaMp3Player
{
	private String fFilename = null;
	
	public JavaMp3Player(String filename)
	{
		this.fFilename = filename;
	}

	public void play()
		throws JavaLayerException
	{
		try
		{
			if(this.fFilename.trim().equals(""))
				return;
//			System.out.println("playing "+fFilename+"...");
			InputStream in = null;
			in = getInputStream();
			AudioDevice dev = getAudioDevice();
			Player player = new Player(in, dev);
			//单线程播放
			player.play();
			//多线程播放
//			player.InvokeThread();
		}
		catch (IOException ex)
		{
			throw new JavaLayerException("Problem playing file "+fFilename, ex);
		}
		catch (Exception ex)
		{
			throw new JavaLayerException("Problem playing file "+fFilename, ex);
		}
	}

	/**
	 * Playing file from URL (Streaming).
	 */
	protected InputStream getURLInputStream()
		throws Exception
	{

		URL url = new URL(fFilename);
		InputStream fin = url.openStream();
		BufferedInputStream bin = new BufferedInputStream(fin);
		return bin;
	}

	/**
	 * Playing file from FileInputStream.
	 */
	protected InputStream getInputStream()
		throws IOException
	{
		FileInputStream fin = new FileInputStream(fFilename);
		BufferedInputStream bin = new BufferedInputStream(fin);
		return bin;
	}

	protected AudioDevice getAudioDevice()
		throws JavaLayerException
	{
		return FactoryRegistry.systemRegistry().createAudioDevice();
	}

	public static void main(String[] args)
	{
		try
		{
			String aaa = "";//"G:\\music\\other\\米黄色衬衫.mp3";
			JavaMp3Player player = new JavaMp3Player(aaa);
			if (player!=null)
				player.play();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
