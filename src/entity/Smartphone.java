/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import constant.IConstant;
import util.Validate;

/**
 *
 * @author Lenovo
 */
public class Smartphone extends Product {

    private String batteryCapacity;

    public Smartphone() {
    }

    public Smartphone(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Smartphone(String id, String name, Brand brand, OperatingSystem operatingSystem,int price, int quantity, String batteryCapacity) {
        super(id, name, brand, operatingSystem, price, quantity ); // id nen de truoc ten
        this.batteryCapacity = batteryCapacity;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
    @Override
    public void print(){
        super.print();    
        System.out.printf("%-8s mAh \n", batteryCapacity);
    }
    @Override
    public void input() {
        super.input();
        batteryCapacity = Validate.getString(
                "Enter BatterryCapacity",
                "Invalid batterryCapacity",
                IConstant.REGEX_PRODUCT_BATTERYCAPACITY
        );
    }
}
