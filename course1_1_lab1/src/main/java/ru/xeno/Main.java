package ru.xeno;

public class Main {
    public static void main(String[] args) {
        Color c1 = new Color();
        Color c2 = new Color(5, 5);
        Color c3 = new Color(-5.25, 5, new int[] {40, 21, 226});

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        c3.setPointPosition(9, 2);
        c2.setXPosition(11);
        c2.setYPosition(-7);
        c2.setColor(new int[] {25, 25, 25});

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        Color d = c2.add(c3);
        System.out.println(d);

        Color e = d.sub(c2);
        System.out.println(e);
        System.out.println(e.equals(c3));
        System.out.println(e.equals(c2));
        System.out.println(e.sub(c2).sub(c3).sub(c2));

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}