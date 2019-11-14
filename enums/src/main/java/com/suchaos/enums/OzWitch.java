package com.suchaos.enums;

/**
 * The witches in the land of Oz.
 *
 * @author suchao
 * @date 2019/2/25
 */
public enum OzWitch {
    /**
     * WEST
     */
    WEST("Miss Gulch, aka the wicked Witch of the West"),

    /**
     * NORTH
     */
    NORTH("north description"),

    /**
     * EAST
     */
    EAST("east description"),

    /**
     * SOUTH
     */
    SOUTH("south description");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }

}
