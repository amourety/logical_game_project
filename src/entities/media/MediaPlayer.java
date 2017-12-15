package entities.media;
/**
 * Created by amour on 24.02.2017.
 */
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MediaPlayer {
    private AudioInputStream ais;
    private Clip clip;
    private int framePosition;
    private static MediaPlayer instance = null;
    private MediaPlayer() {
    }
    public static MediaPlayer getInstance() {
        if (instance == null)
            instance = new MediaPlayer();
        return instance;
    }

    public void play() {
        try {
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        } catch (IOException ex) {
            getErrorInfo(ex, "Ошибка: ");
        } catch (LineUnavailableException ex) {
            getErrorInfo(ex, "Возможно, этот файл используется другим приложением: ");
        }
    }

    public void stop() {
        framePosition = clip.getFramePosition();
        clip.stop();
    }
    public void setTrack(File soundFile) {
        try {
            ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
        } catch (IOException ex) {
            getErrorInfo(ex, "Ошибка: ");
        }  catch (UnsupportedAudioFileException ex) {
            getErrorInfo(ex, "Невозможно воспроизвести файл (поддерживаются лишь форматы WAV, AU, AIF): ");
        }  catch (LineUnavailableException ex) {
            getErrorInfo(ex, "Возможно, этот файл используется другим приложением: ");
        }
    }

    private void getErrorInfo(Exception ex, String msg) {
        System.out.print(msg);
        System.err.println(ex.getMessage());
        System.exit(1);
    }
}
