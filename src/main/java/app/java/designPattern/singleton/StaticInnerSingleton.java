package app.java.designPattern.singleton;

class StaticInnerSingletonInstance {

    private static StaticInnerSingletonInstance instance;

    public StaticInnerSingletonInstance() {
    }

    private static class StaticInnerHolder {
        private static final StaticInnerSingletonInstance INSTANCE = new StaticInnerSingletonInstance();
    }

    public static StaticInnerSingletonInstance getInstance() {
        return StaticInnerHolder.INSTANCE;
    }
}

public class StaticInnerSingleton {

    public static void main(String[] args) {
        StaticInnerSingletonInstance ins = StaticInnerSingletonInstance.getInstance();
        StaticInnerSingletonInstance ins1 = StaticInnerSingletonInstance.getInstance();

        System.out.println(ins == ins1);
    }
}
