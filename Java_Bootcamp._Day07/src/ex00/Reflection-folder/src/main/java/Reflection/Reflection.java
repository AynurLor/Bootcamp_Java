package Reflection;

import classes.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reflection {
     public void showClass(Object object) {
         Class clazz = object.getClass();
         System.out.println(clazz.getName());
     }
    public void showClassField(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            System.out.println("\t" + type.getName() + " " + field.getName());
        }
    }
    public void showClassMethod(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method: methods) {
            method.setAccessible(true);
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> returnTypes = method.getReturnType();

            if (!returnTypes.getTypeName().equals("void")) {
                System.out.print("\t" + returnTypes + " " + name + "(");
            for (Class<?> param:parameterTypes) {
                System.out.print(param);
            }
            System.out.println(")");
            }
        }
    }
    public static Object updateObject(Object subject, Scanner scanner) throws IllegalAccessException {
        Field field = null;
        System.out.println("Enter name of the field for changing:");
        while (field == null) {
            try {
                field = subject.getClass().getDeclaredField(scanner.nextLine());
            } catch (NoSuchFieldException e) {
                System.err.println("No such field, try again.");
            }
        }
        field.setAccessible(true);
        System.out.print("Enter (" + field.getType().getSimpleName() + ") value: ");
        field.set(subject, scannerGetType(field.getType(), scanner));
        System.out.println("Object updated: " + subject);
        return (subject);
    }
    public static void invokeMethod(Object subject, Scanner scanner) throws InvocationTargetException, IllegalAccessException {
        System.out.print("Enter name of the method for call:");
        for (Method m : subject.getClass().getDeclaredMethods()) {
            System.out.print(" " + m.getName());
        }
        System.out.println("");
        Method method = null;
        Parameter[] parameters;
        List<Object> parsedParams = new ArrayList<>();
        while (method == null) {
            try {
                method = subject.getClass().getDeclaredMethod(scanner.nextLine());
            } catch (NoSuchMethodException e) {
                System.out.println("No such method! Try again!");
            }
        }
        parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.print("Enter " + parameter.getType().getSimpleName() + " value: ");
            parsedParams.add(scannerGetType(parameter.getType(), scanner));
        }
        Object ret = method.invoke(subject, parsedParams.toArray());
        if (ret != null) {
            System.out.println("Method returned: " + ret);
        }
    }

    public static Object scannerGetType(Class<?> param, Scanner scanner) {

        switch (param.getSimpleName().toLowerCase()) {
            case "string":
                return scanner.nextLine();
            case "int":
            case "integer":
                return scanner.nextInt();
            case "long":
                return scanner.nextLong();
            case "double":
                return scanner.nextDouble();
            case "float":
                return scanner.nextFloat();
            case "char":
            case "character":
                return scanner.next();
            default:
                throw new RuntimeException("Unrecognized type");
        }
    }

}
