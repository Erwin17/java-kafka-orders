package com.app.stream.producer.model;

public class Product {

    private final Long id;
    private final String name;
    private final int weight;
    private final double price;

    public Product(){
        this.id = 0L;
        this.name = null;
        this.weight = 0;
        this.price = 0;
    }

    public Product(String name, int weight, double price){
        this.id = 0L;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
