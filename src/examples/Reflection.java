package examples;

import model.Resume;

import javax.management.relation.RelationSupport;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("uuid");
        Field field = r.getClass().getDeclaredField("uuid");
        //без открытия доступа будет IllegalAccessException
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        Class c = Class.forName("model.Resume");
        Method m=c.getDeclaredMethod("toString");
        Object t = c.newInstance();
        Object o= m.invoke(t);
        System.out.println(m.invoke(t));
    }
}
