package org.example.di;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // getObject로를 통해 들어가는 class에 대해서, 각각 값 주입 시켜서 생성 한다.
        AccountService acc = ContainerService.getObject(AccountService.class);

        acc.join();
    }
}
