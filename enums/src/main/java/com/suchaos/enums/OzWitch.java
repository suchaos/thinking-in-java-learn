package com.suchaos.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * The witches in the land of Oz.
 *
 * @author suchao
 * @date 2019/2/25
 */
@Slf4j
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
            log.info(witch + ": " + witch.getDescription());
            log.info(witch + ": " + witch.name());
        }
    }

}
