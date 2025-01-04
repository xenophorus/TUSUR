package ru.xeno;


abstract class AbsMoney {


    abstract public void conversionTo(Money other);
    abstract double conversionHandler(Money other);
    abstract public String toString();
    abstract public double getQuantity();
    abstract public String getName();
}

class Money extends AbsMoney {
    private double rate = 1;
    private double quantity = 1;
    private String name = "";

    public Money(String name, double rate, double quantity) {
        this.name = name;
        this.rate = rate;
        this.quantity = quantity;
    }

    public Money(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public Money(double rate, double quantity) {
        this.rate = rate;
        this.quantity = quantity;
    }

    public Money(double rate) {
        this.rate = rate;
    }

    @Override
    public void conversionTo(Money other) {
        String str = String.format("%.2f %s стоит %.2f %s",
                this.quantity, this.name, this.conversionHandler(other), other.getName());
        System.out.println(str);
    }

    @Override
    double conversionHandler(Money other) {
        return this.quantity * (1 / this.rate) * other.rate;
    }

    public String toString() {
        return String.format("Валюта %s, курс %.4f, количество %.2f",
                this.name, this.rate, this.quantity);
    }

    public double getQuantity() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public double getRate() {
        return this.rate;
    }
}

class Currency extends Money {

    private double rate;
    private double quantity;
    private String name;

    Currency(String name, double rate) {
        super(name, rate);
        this.quantity = 1;
    }

    Currency(String name, double rate, double quantity) {
        super(name, rate, quantity);
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

class Dollar extends Money {

    private double rate;
    private double quantity;

    Dollar(double rate) {
        super("USD", rate, 1);
    }

    Dollar(double rate, double quantity) {
        super("USD", rate, quantity);
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

class Euro extends Money {

    private double quantity;

    Euro(double quantity) {
        super("EUR", 1, quantity);
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Euro euro = new Euro(1);
        Dollar dollar = new Dollar(1.0308, 100);
        Currency rouble = new Currency("RUB", 110.4, 5100);

        System.out.println(euro);
        System.out.println(dollar);
        System.out.println(rouble);

        rouble.conversionTo(dollar);

    }
}