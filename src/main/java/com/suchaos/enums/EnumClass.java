package com.suchaos.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * EnumClass
 *
 * @author suchao
 * @date 2019/2/25
 */
@Slf4j
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println("compareTo CRAWLING: " + s.compareTo(Shrubbery.CRAWLING));
            System.out.println("equals CRAWLING: " + s.equals(Shrubbery.CRAWLING));
            System.out.println("== CRAWLING: " + (s == Shrubbery.CRAWLING));
            System.out.println(s.name());
            System.out.println("----------------------");
        }

        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}
