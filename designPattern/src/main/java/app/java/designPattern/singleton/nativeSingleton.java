package app.java.designPattern.singleton;

class SingletonInstance {

    private static SingletonInstance instance;

    private SingletonInstance() {}

    public static SingletonInstance getInstance() {
        if (instance == null) {
            instance = new SingletonInstance();
        }

        return instance;
    }

}

public class nativeSingleton {

    public static void main(String[] args) {
        SingletonInstance ins = SingletonInstance.getInstance();
        SingletonInstance ins1 = SingletonInstance.getInstance();

        System.out.println(ins == ins1);
    }

}
