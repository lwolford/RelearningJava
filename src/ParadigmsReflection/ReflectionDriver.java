package ParadigmsReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDriver {

    public static void main(String[] args) throws Exception {

        ReflectionVariables rv = new ReflectionVariables();

        Class c = rv.getClass();
        Constructor cn = c.getConstructor();
        Method[] m = c.getMethods();

        Method stringMethodCall = c.getDeclaredMethod("stringMethod");
        Method charMethodCall = c.getDeclaredMethod("characterMethod", char.class);
        Method privateMethodCall = c.getDeclaredMethod("privateMethod");

        System.out.println("The name of the class is: " + c.getSimpleName());
        System.out.println("The name of the constructor is: " + cn.getName());
        methodsPrint(m);

        stringMethodCall.invoke(rv);
        Field f = c.getDeclaredField("strVariable");
        f.setAccessible(true);
        f.set(rv, "This is a new string now that the field has become accessible");
        stringMethodCall.invoke(rv);

        charMethodCall.invoke(rv, 'a');

        privateMethodCall.setAccessible(true);
        privateMethodCall.invoke(rv);

    }

    public static void methodsPrint(Method[] m) {
        System.out.print("All of the public methods are: ");
        for (Method method : m)
            System.out.print(method.getName() + ", ");
        System.out.println("\b\b");
    }

}
