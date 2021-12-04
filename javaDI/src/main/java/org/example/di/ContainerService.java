package org.example.di;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    // T 제네릭 타입 선언,
    // 클래스를 리턴하는 것이 아니라 T 클래스 타입을 리턴한다.
    public static <T> T getObject(Class<T> classType) {
        // createInstance에서 return 된 인스턴스
        T instance = createInstance(classType);
        
        // 위의 return 된 인스턴스에 대해서, DI 과정
        // 1. 들어온 클래스의 필드를 돌리면서, Inject있는지 구분
        // 2. @Inject가 붙어있을 경우 해당 붙어있는 필드의 객체생성
        // 3. set을 통해 @Inject붙은 인스턴스 를 주입
        Arrays.stream(classType.getDeclaredFields()).forEach(f->{
            if(f.getAnnotation(Inject.class)!= null){
                Object fieldInstance = createInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType)  {
        try {
            // getConstructor를 통해 받은 객체에 대한 인스턴스 생성 및 return
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException|IllegalAccessException| InvocationTargetException|NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
