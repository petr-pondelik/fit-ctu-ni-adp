package cz.cvut.fit.miadp.mvcgame.sounds;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.net.URL;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

public class Sounds {

    public Sounds() {}

    private static class AudioPlayer {
        public AudioPlayer(String path) {
            Clip clip;
            try {
                // Prepare URL path for getAudioInputStream
                URL url = Sounds.class.getResource(path);
                AudioInputStream input = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(input);
                // Close the clip after it finished
                clip.addLineListener(new LineListener() {
                    public void update(LineEvent e) {
                        if (e.getType() == LineEvent.Type.STOP) {
                            e.getLine().close();
                        }
                    }
                });
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    public static void playMissileSound() {
        new AudioPlayer(MvcGameConfig.MISSILE_SOUND);
    }

}
