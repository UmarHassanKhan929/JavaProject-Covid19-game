/*
 * 
 * 
 * 									Audio files class, which is responsible to decode audio file in a format readable by java
 * 
 * 
 */

package Audio;
import java.util.HashMap;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	
	//hashmaps to store audio files with tags
	private static HashMap<String, Clip> audioclip;
	private static int gap;
	private static boolean mute = false;
	
	
	//init method to create hashmap
	public static void init() {
		audioclip = new HashMap<String, Clip>();
		gap = 0;
	}
	
	//loading audio files
	public static void load(String s, String n) {
		
		if(audioclip.get(n) != null) 
			return;
		
		Clip clip;
		
		try {			
			AudioInputStream ais = AudioSystem.getAudioInputStream( MusicPlayer.class.getResourceAsStream(s) );
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,baseFormat.getSampleRate(),16,baseFormat.getChannels(),baseFormat.getChannels() * 2,baseFormat.getSampleRate(),false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			audioclip.put(n, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//playing audio files
	public static void play(String s) {
		
		play(s, gap);
		
	}
	
	public static void play(String s, int i) {
		
		if(mute) 
			return;
		
		Clip c = audioclip.get(s);
		
		if(c == null) 
			return;
		
		if(c.isRunning()) 
			c.stop();
		
		c.setFramePosition(i);
		
		while(!c.isRunning()) 
			c.start();
	}
	
	
	//stopping audio files
	public static void stop(String s) {
		
		if(audioclip.get(s) == null) 
			return;
		
		if(audioclip.get(s).isRunning()) 
			audioclip.get(s).stop();
	}
	
	
	//resuming audio files
	public static void resume(String s) {
		if(mute) 
			return;
		if(audioclip.get(s).isRunning()) 
			return;
		audioclip.get(s).start();
	}
	
	//loops the audio files
	public static void loop(String s) {
		loop(s, gap, gap, audioclip.get(s).getFrameLength() - 1);
	}
	
	public static void loop(String s, int frame) {
		loop(s, frame, gap, audioclip.get(s).getFrameLength() - 1);
	}
	
	public static void loop(String s, int start, int end) {
		loop(s, gap, start, end);
	}
	
	public static void loop(String s, int frame, int start, int end) {
		stop(s);
		if(mute) return;
		audioclip.get(s).setLoopPoints(start, end);
		audioclip.get(s).setFramePosition(frame);
		audioclip.get(s).loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
	//set position of some audio frame
	public static void setPosition(String s, int frame) {
		audioclip.get(s).setFramePosition(frame);
	}
	
	//receives the frame of audio file
	public static int getFrames(String s) { 
		return audioclip.get(s).getFrameLength(); 
	}
	
	//gets the position of audio file frame
	public static int getPosition(String s) { 
		return audioclip.get(s).getFramePosition();
	}
	
	//closes the audio file
	public static void close(String s) {
		stop(s);
		audioclip.get(s).close();
	}

}

