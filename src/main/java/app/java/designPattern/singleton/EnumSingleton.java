package app.java.designPattern.singleton;

enum EnumSingletonInstance {

    INSTANCE;
}

public class EnumSingleton {

    public static void main(String[] args) {
        EnumSingletonInstance ins = EnumSingletonInstance.INSTANCE;
        EnumSingletonInstance ins1 = EnumSingletonInstance.INSTANCE;

        System.out.println(ins == ins1);
    }

}
