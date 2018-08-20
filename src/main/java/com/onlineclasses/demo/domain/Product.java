package com.onlineclasses.demo.domain;

import sun.awt.SunHints;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@NotNull (message = "Product name should not be null")
    @Column(name = "product_NAME")
    private String name;

    @Column(name = "catgegory")
    private String category;

    //@Min(value=0, message = "The product unit should not be less than zero")
    @Column(name = "instoc")
    private int inStock;

    @Column(name = "cond")
    private String cond;

    @Column(name = "stat")
    private String stat;

    @Column(name = "description")
    private String description;

    @Column(name = "manu")
    private String manu;

   // @Min(value=0, message = "The product price should not be less than zero")
    @Column(name = "price")
    private double price;

    @Lob
    @Column(name = "image")
    private Byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}


