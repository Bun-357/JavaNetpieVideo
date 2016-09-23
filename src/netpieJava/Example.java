package netpieJava;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bunhan
 */
import microgear.Microgear;
import microgear.MicrogearEventListener;

public class Example {
    final static String appID = "MkII";
    final static String Key = "8MHml8LeBZqAuHU";
    final static String Secret = "HyL2A155aMvA5qvYsOOmz4veN";
    static Microgear microgear;
    static callback callback;


    public static void main(String[] args) throws InterruptedException {
        microgear = new Microgear();
        callback = new callback();
        microgear.setCallback(callback);
        microgear.connect(appID,Key,Secret);
        microgear.Subscribe("/Topic");
        int count = 1;
        for(;;){
            microgear.Publish("/Topic", String.valueOf(count)+".  Test message");
            count++;
            Thread.sleep(2000);
        }
    }

     static class callback implements MicrogearEventListener{

        @Override
        public void onConnet() {
            //throw new UnsupportedOperationE
             System.out.println("Microgear is Connected.");
        }

        
   

        @Override
        public void onMessage(String topic, String message) {
            // TODO Auto-generated method stub
            System.out.println(topic+" "+message);
        }

        @Override
        public void onPresent(String token) {
            // TODO Auto-generated method stub
            System.out.println("Present "+token);
        }

        @Override
        public void onAbsent(String token) {
            // TODO Auto-generated method stub
            System.out.println("Absent "+token);
        }

        @Override
        public void onDisconnect() {
            // TODO Auto-generated method stub
            System.out.println("Microgear is Disconnect.");
        }

        @Override
        public void onError(String error) {
            // TODO Auto-generated method stub
            System.out.println("Error "+error);
        }
    }
}