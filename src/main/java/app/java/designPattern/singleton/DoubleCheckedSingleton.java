package app.java.designPattern.singleton;

class DoubleCheckedSingletonInstance {

    private static volatile DoubleCheckedSingletonInstance instance;

    public DoubleCheckedSingletonInstance() {
    }

    public static DoubleCheckedSingletonInstance getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckedSingletonInstance.class) {
                if(instance == null) {
                    instance = new DoubleCheckedSingletonInstance();
                }
            }
        }
        return instance;
    }
}

public class DoubleCheckedSingleton {

    public static void main(String[] args) {
        DoubleCheckedSingletonInstance ins = DoubleCheckedSingletonInstance.getInstance();
        DoubleCheckedSingletonInstance ins1 = DoubleCheckedSingletonInstance.getInstance();

        System.out.println(ins == ins1);
    }

}
