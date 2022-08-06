package com.example.Hello.Entities;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer RAM;
    private String CPU;
    private String GPU;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Laptop() {
    }

    public Laptop(Integer RAM, String CPU, String GPU, Integer price) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.GPU = GPU;
        this.price = price;
    }

    public Integer getRAM() {
        return RAM;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "RAM=" + RAM +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", price=" + price +
                '}';
    }
}
