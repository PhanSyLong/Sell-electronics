/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import bo.BrandBO;
import bo.OperatingSystemBO;
import constant.IConstant;
import java.util.ArrayList;
import java.util.List;
import util.Helper;
import util.Validate;

/**
 *
 * @author DELL
 */
public class Product {
    private String id;
    private String name;
    private Brand brand;
    private OperatingSystem operatingSystem;
    private int price;
    private int quantity;

    public Product() {
    }

    public Product(String id, String name, Brand brand, OperatingSystem operatingSystem, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    
    public void input() {
        id = Validate.getString("Enter id product: ", "Invalide Id format", IConstant.REGEX_PRODUCT_ID);
        name = Validate.getString("Enter name product: ", "Invalide name format", IConstant.REGEX_PRODUCT_NAME);
        System.out.println("----Select Brand----");
        brand = Helper.selectBrand();
        System.out.println("----Select OperatingSystem----");
        operatingSystem = selectOperatingSystem();
        price = Validate.getInt("Enter price: ", "Invalid price", "Invalid price", 10, 50000);
        quantity = 0;
    }
    
    
        private OperatingSystem selectOperatingSystem() {
        OperatingSystemBO operatingSystemBO = new OperatingSystemBO(new ArrayList<>());
        operatingSystemBO.loadFromFile("OperatingSystem.txt");
        List<OperatingSystem> lstOperatingSystem = operatingSystemBO.getLstOperatingSystem();
        
        for(int i = 0; i < lstOperatingSystem.size(); i++) {
            System.out.printf("%-4s%-5s%-50s\n", i + 1, lstOperatingSystem.get(i).getId(), lstOperatingSystem.get(i).getName());
        }
        
        int choice = Validate.getInt(
                "Enter your choice: ",
                "must be from 1 to " + lstOperatingSystem.size(),
                "Must be integer number",
                1,
                lstOperatingSystem.size()
        );
        
        for(int i = 0; i < lstOperatingSystem.size(); i++) {
            if (choice == (i + 1)) {
                return lstOperatingSystem.get(i);
            }
        }
        return null;
    }

        public void print(){
            System.out.printf("%-10s%-20s%-8s%-20s%-8d%-8d", id , name, brand.getName(), operatingSystem.getName(), price , quantity);
        }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", brand=" + brand + ", operatingSystem=" + operatingSystem + ", price=" + price + ", quantity=" + quantity + '}';
    }


}