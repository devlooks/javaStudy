package app.java.designPattern.singleton;

class EagerInitSingletonInstance{

    private static final EagerInitSingleton instance = new EagerInitSingleton();

    public EagerInitSingletonInstance() {
    }

    public static EagerInitSingleton getInstance() {
        return instance;
    }
}

public class EagerInitSingleton {

    public static void main(String[] args) {
        EagerInitSingleton ins = EagerInitSingletonInstance.getInstance();
        EagerInitSingleton ins1 = EagerInitSingletonInstance.getInstance();

        System.out.println(ins == ins1);
    }
}
