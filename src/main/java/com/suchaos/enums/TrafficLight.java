package com.suchaos.enums;

/**
 * switch 中的 enum
 * case RED 而不必写成  case SIGNAL.RED
 *
 * @author suchao
 * @date 2019/2/25
 */
public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(light);
            light.change();
        }
    }
}

enum Signal {
    GREEN, YELLOW, RED
}
