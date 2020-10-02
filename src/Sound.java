
import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;


public class Sound {
	
	URL cb;
	
	public Sound() {
		try {
			
			//File f = new File("d:\\Alia\\Downloads\\other\\java\\sound");
			//cb = f.toURL();
			//cb = new URL("https://taira-komori.jpn.org/sound_os/daily01/door_bell.mp3");
			//cb = new URL("http://billor.chsh.chc.edu.tw/sound/Wate.wav");
			cb = new URL("http://billor.chsh.chc.edu.tw/sound/Birds.wav");
			AudioClip au = Applet.newAudioClip(cb);
			au.play();
		}catch (MalformedURLException e) {
            e.printStackTrace();
        }	
	}
	
	public Sound(int mode) {
		try {
		    switch(mode) {
		        case 1://fire
	        	    cb = new URL("http://billor.chsh.chc.edu.tw/sound/fire1.wav");
	    	        break;
		        case 2://Fire+Bomb
		    	    cb = new URL("http://billor.chsh.chc.edu.tw/sound/EXPLO%20TIGHT%20SHOCK.WAV");
		    	    break;
		        case 3://water
		        	cb = new URL("http://bbcsfx.acropolis.org.uk/assets/07038320.wav");
		    }
		    AudioClip au = Applet.newAudioClip(cb);
			au.play();
		    
		}catch (MalformedURLException e) {
            e.printStackTrace();
        }
	}
	
//	public static void main(String args[]) {
//
//	    //Sound s = 
//	    		new Sound();
//	    //s.setVisible(true);
//
//	    }

}
