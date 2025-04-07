package Utilty;

public class MyFunc {
    public static void Wait(int sec){
        try {
            Thread.sleep(1000L*sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
