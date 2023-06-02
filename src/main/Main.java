package main;

import main.handlers.ManageService;
import main.keys.NativeKeyboard;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Main {

 public static void main(String[] args) throws NativeHookException {
     ManageService service = new ManageService();
     GlobalScreen.registerNativeHook();
     GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());

 }
}
