import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
public class Music {
	AudioClip clip = null;
	private URL source;
	public Music(String s) {
		    switch(s) {
		        case "Do"://Do
		    	    source = getClass().getResource("music/Do.wav");
		    	    break;
		        case "Re"://Re
		        	source = getClass().getResource("music/Re.wav");
		    	    break;
		        case "Mi"://Mi
		        	source = getClass().getResource("music/Mi.wav");
		        	break;
		        case "Fa"://Fa
		    	    source = getClass().getResource("music/Fa.wav");
		    	    break;
		        case "Sol"://Sol
		        	source = getClass().getResource("music/Sol.wav");
		    	    break;
		        case "La"://La
		    	    source = getClass().getResource("music/La.wav");
		    	    break;
		        case "Si"://Si
		        	source = getClass().getResource("music/Si.wav");
		    	    break;
		        case "Do_1"://Do_8va
		        	source = getClass().getResource("music/Do-1.wav");
		    }
		    clip = Applet.newAudioClip(source);
			//au.play();
		    
	}
	
	public AudioClip getAudioClip() {
		return this.clip;
	}
	public void setAudioClip(AudioClip clip) {
		this.clip = clip;
	}
	
	public void play() {
		if(getAudioClip() != null) {
			getAudioClip().play();
		}
	}
	public void loop() {
		if(getAudioClip() != null) {
			getAudioClip().loop();
		}
	}
	public void stop() {
		if(getAudioClip() != null) {
			getAudioClip().stop();
		}
	}
	//AudioClip Do = new AudioClip(getClass().getResource("music/Do.wav").toString());

}
