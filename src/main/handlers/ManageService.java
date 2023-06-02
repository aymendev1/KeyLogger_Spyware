package main.handlers;

import main.keys.NativeKeyboard;

public class ManageService {
    private NativeKeyboard keyboard;
    public ManageService(){
        keyboard = new NativeKeyboard();
    }

    public NativeKeyboard getKeyboard() {
        return keyboard;
    }
}
