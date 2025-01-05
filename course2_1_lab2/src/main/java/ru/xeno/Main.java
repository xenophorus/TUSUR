package ru.xeno;

import java.util.Map;

abstract class AbsMoney {
    abstract void conversionTo(Money other);
    abstract double conversionHandler(Money other);
    abstract public String toString();
    abstract public double getQuantity();
    abstract public String getName();
}

class CurrencyRate {
    /**
     * Класс, по-хорошему, должен качать json с данными, но, поскольку это не отностися к заданию,
     * воспользуюсь такой заглушкой.
     * */

    public static Map<String, Double> rates = Map.of(
            "AED", 3.788187,
            "AUD", 1.658917,
            "BTC", 1.0393649e-5,
            "CAD", 1.48985,
            "CNY", 7.550096,
            "EUR", 1.0,
            "GBP", 0.830193,
            "JPY", 162.238422,
            "RUB", 113.890921,
            "USD", 1.031349);
}

class Money extends AbsMoney {
    private double quantity = 1;
    private String name = "";
    private double rate;

    public Money(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
        this.setRate();
    }

    public Money(String name) {
        this.name = name;
        this.setRate();
    }

    void setRate() {
        this.rate = CurrencyRate.rates.get(this.name);
    }

    @Override
    void conversionTo(Money other) {
        String str = String.format("%.2f %s стоит %.2f %s",
                this.quantity, this.name, this.conversionHandler(other), other.getName());
        System.out.println(str);
    }

    @Override
    double conversionHandler(Money other) {
        return this.quantity * (1 / this.rate) * other.rate;
    }

    public String toString() {
        return String.format("Валюта %s, курс %.2f / EUR, количество %.2f",
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

    Currency(String name) {
        super(name);
        this.quantity = 1;
        this.setRate();
    }

    Currency(String name, double quantity) {
        super(name, quantity);
        this.setRate();
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

class Dollar extends Money {

    private double quantity;

    Dollar() {
        super("USD", 1);
        this.setRate();
    }

    Dollar(double quantity) {
        super("USD", quantity);
        this.setRate();
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

class Euro extends Money {

    private double quantity;

    Euro(double quantity) {
        super("EUR", quantity);
        this.setRate();
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Euro euros = new Euro(1);
        Dollar dollars = new Dollar(100);
        Currency roubles = new Currency("RUB", 5100);
        Currency yuan = new Currency("CNY");
        Currency australianDollar = new Currency("AUD");
        Currency bitcoin = new Currency("BTC", 5);

        System.out.println(euros);
        System.out.println(dollars);
        System.out.println(roubles);

        roubles.conversionTo(dollars);
        euros.conversionTo(roubles);
        dollars.conversionTo(euros);
        dollars.conversionTo(roubles);
        bitcoin.conversionTo(roubles);
        bitcoin.conversionTo(dollars);
        yuan.conversionTo(roubles);
        australianDollar.conversionTo(roubles);

        //test
        System.out.println("--------------");
        Currency roubToBTC = new Currency("RUB", 54788708.47);
        Currency roubToAUD = new Currency("RUB", 68.65);
        Currency roubToUSD100 = new Currency("RUB", 11042.91);
        Currency roubToEUR = new Currency("RUB", 113.89);
        Currency roubToCNY = new Currency("RUB", 15.08);

        roubToUSD100.conversionTo(dollars);
        roubToAUD.conversionTo(australianDollar);
        roubToBTC.conversionTo(bitcoin);
        roubToEUR.conversionTo(euros);
        roubToCNY.conversionTo(yuan);
    }
}