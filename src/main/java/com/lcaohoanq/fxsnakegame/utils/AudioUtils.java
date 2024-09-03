package com.lcaohoanq.fxsnakegame.utils;

import com.lcaohoanq.fxsnakegame.exceptions.ResourceNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioUtils {

    private static AudioUtils instance;
    private InputStream inputStreamCurrent;
    private AudioInputStream audioInputStream;
    private Clip clip;
    private boolean path = true;

    public boolean isEmptyPath() {
        return !path;
    }

    public static AudioUtils getInstance() {
        if (instance == null){
            instance = new AudioUtils();
        }
        return instance;
    }

    public void playAudio(InputStream inputStream) {
        try {
            if (inputStreamCurrent != null) {
                throw new ResourceNotFoundException("Audio file is missing");
            }
            // Create a byte array to store the audio data
            byte[] audioData = inputStream.readAllBytes();

            // Use ByteArrayInputStream to create an AudioInputStream
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            audioInputStream = AudioSystem.getAudioInputStream(byteArrayInputStream);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
