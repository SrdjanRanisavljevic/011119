package pages.sign.sendForSignatureScreen;

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

    public static void main(String[] args) {

        try{

        }catch (Exception e){
            RecursionLimiter.emerge();
        }

    }
}

