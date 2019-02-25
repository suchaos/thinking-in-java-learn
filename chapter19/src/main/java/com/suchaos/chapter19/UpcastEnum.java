package com.suchaos.chapter19;

/**
 * 由于 values() 方法是由编译器添加的新方法，所有，如果向上转型为 Enum，将无法使用该方法。
 * 不过，在 Class 对象中，有一个 getEnumConstants() 方法，可以使用。
 *
 * @author suchao
 * @date 2019/2/25
 */
public class UpcastEnum {

    public static void main(String[] args) {
        Search[] values = Search.values();

        Enum e = Search.HIHTER;
        //e.values();

        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}

enum Search {
    HIHTER, YOU
}
