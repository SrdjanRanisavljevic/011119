package api.sign.sendForSignatureScreen;

public class RecursionLimiter {

    public static int maxLevel = 5;

    public static void emerge() {
        if (maxLevel == 0)
            return;
        try {
            throw new IllegalStateException("Too deep, emerging - TO MANY RELOADS OF THE SCREEN");
        } catch (IllegalStateException e) {
            if (e.getStackTrace().length > maxLevel + 1)
                throw e;
        }
    }
}

