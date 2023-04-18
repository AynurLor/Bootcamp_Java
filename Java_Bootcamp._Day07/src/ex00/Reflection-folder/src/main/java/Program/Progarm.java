package Program;

import Reflection.Reflection;
import classes.Car;
import classes.User;
import exception.ExceptionIncorrectClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Progarm {
    public static void main(String[] args) throws NoSuchFieldException {
        Reflection rf = new Reflection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Classes:\n  - User\n  - Car");
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        String nameClasses = sc.nextLine();
        if (nameClasses.equals("User")) {
            userAction(rf);
        } else if (nameClasses.equals("Car")) {
            carAction(rf);

        } else {
            throw new ExceptionIncorrectClass();
        }
        sc.close();
    }
    private static void userAction(Reflection rf) throws NoSuchFieldException {
        Scanner sc = new Scanner(System.in);
        User user1 = new User();
        Class clazz = user1.getClass();
        System.out.println("fields: ");
        rf.showClassField(user1);
        System.out.println("methods:");
        rf.showClassMethod(user1);
        System.out.println("---------------------");
        System.out.print("Let’s create an object.\nfirstName:\n-> ");
        try {
            String nameUser = sc.nextLine();
            Field field = user1.getClass().getDeclaredField("firstName");
            field.setAccessible(true);
            field.set(user1, (String) nameUser);

            System.out.print("lastName:\n-> ");
            String lastNameUser = sc.nextLine();
            Field field2 = user1.getClass().getDeclaredField("lastName");
            field2.setAccessible(true);
            field2.set(user1, (String) lastNameUser);

            System.out.print("height:\n-> ");
            Integer height = sc.nextInt();
            Field field3 = user1.getClass().getDeclaredField("height");
            field3.setAccessible(true);
            field3.set(user1, (Integer) height);
            System.out.println("Object created: " + user1.toString());
            rf.updateObject(user1, sc);
            rf.invokeMethod(user1, sc);
//            System.out.println("Object change: " + user1.toString());
            sc.close();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    private static void carAction(Reflection rf) throws NoSuchFieldException {
//        Integer fuelCapacity, Integer expense, String model
        Scanner sc = new Scanner(System.in);
        Car car1 = new Car();
        Class clazz = car1.getClass();
        System.out.println("fields: ");
        rf.showClassField(car1);
        System.out.println("methods:");
        rf.showClassMethod(car1);
        System.out.println("---------------------");
        System.out.print("Let’s create an object.\nfuelCapacity:\n-> ");
        try {
            Integer capacity = sc.nextInt();
            Field field = car1.getClass().getDeclaredField("fuelCapacity");
            field.setAccessible(true);
            field.set(car1, (Integer) capacity);

            System.out.print("expense:\n-> ");
            Integer expense = sc.nextInt();
            Field field2 = car1.getClass().getDeclaredField("expense");
            field2.setAccessible(true);
            field2.set(car1, (Integer) expense);

            sc.nextLine();
            System.out.print("model:\n-> ");
            String model1 = sc.nextLine();
            Field field3 = car1.getClass().getDeclaredField("model");
            field3.setAccessible(true);
            field3.set(car1, (String) model1);
            System.out.println("Object created: " + car1.toString());
            rf.updateObject(car1, sc);
            rf.invokeMethod(car1, sc);
            sc.close();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
