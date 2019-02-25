package com.suchaos.chapter19;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * 在 Enum 父类中，并没有 values() 方法，那么这个方法从何而来
 * 答案是，values() 是由编译器添加进去的 static 方法，还添加了 valueOf(java.lang.String) 方法
 *
 * 由于 values() 方法是由编译器添加的新方法，所有，如果向上转型为 Enum，将无法使用该方法。
 * 不过，在 Class 对象中，有一个 getEnumConstants() 方法，可以使用。
 * 详情见 UpcastEnum 类
 *
 * Compiled from "Reflection.java"
 * final class com.suchaos.chapter19.Explore extends java.lang.Enum<com.suchaos.chapter19.Explore> {
 *   public static final com.suchaos.chapter19.Explore HERE;
 *   public static final com.suchaos.chapter19.Explore THERE;
 *   public static com.suchaos.chapter19.Explore[] values();
 *   public static com.suchaos.chapter19.Explore valueOf(java.lang.String);
 *   static {};
 * }
 *
 * @author suchao
 * @date 2019/2/25
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("------------- Analyzing " + enumClass + " ----------------");
        System.out.print("Interfaces: ");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.print(type + " ");
        }
        System.out.println();
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.print("Methods: ");
        TreeSet<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.print(methods);
        System.out.println();
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.print("Explore.removeAll(Enum)? ");
        exploreMethods.removeAll(enumMethods);
        System.out.print(exploreMethods);
        System.out.println();
    }
}

enum Explore {
    HERE, THERE
}
