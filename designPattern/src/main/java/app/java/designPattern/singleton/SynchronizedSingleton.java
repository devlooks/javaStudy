package app.java.designPattern.singleton;

class SynchroSingletonInstance {

    private static SynchroSingletonInstance instance;

    public SynchroSingletonInstance() {
    }

    public static synchronized SynchroSingletonInstance getInstance() {
        if (instance == null) {
            instance = new SynchroSingletonInstance();
        }

        return instance;
    }
}


public class SynchronizedSingleton {

    public static void main(String[] args) {

    }

}
