package com;

public class Super {
    public Integer getLenght() {
        return new Integer(4);
    }
}

class Sub extends Super {
    public Integer getLenght() {
        return new Integer(5);
    }

    public static void main(String[] args) {
        Super sooper = new Super();
        Sub sub = new Sub();
        System.out.println(sooper.getLenght().toString() + "," + sub.getLenght().toString());
    }
}
