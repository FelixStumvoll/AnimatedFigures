package animatedfigures.util;

public class ThreadUtil {
    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {
            //Checked exception suck
        }
    }
}
