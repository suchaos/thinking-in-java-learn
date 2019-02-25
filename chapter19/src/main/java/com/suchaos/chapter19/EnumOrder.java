package com.suchaos.chapter19;

import java.util.Arrays;

/**
 * values() : 用来按照 enum 常量的声明顺序，产生有这些常量值构成的数组
 * ordinal()：继承自 java.lang.Enum 的方法，用来表明某个常量的声明顺序，从 0 开始
 *
 * @author suchao
 * @date 2019/2/25
 */
public class EnumOrder {

    public static void main(String[] args) {
        Spiciness[] values = Spiciness.values();
        System.out.println(Arrays.toString(values));
        for (Spiciness s : values) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
