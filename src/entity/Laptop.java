/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import util.Validate;

/**
 *
 * @author Lenovo
 */
public class Laptop extends Product {

    private boolean touchscreen;

    public Laptop() {
    }

    public Laptop(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }

    public Laptop(String name, String id, Brand brand,OperatingSystem operatingSystem, int price, int quantity, boolean touchscreen) {
        super(name, id, brand,operatingSystem, price, quantity);
        this.touchscreen = touchscreen;
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }
    @Override
    public void print(){
        super.print();    
        System.out.printf("%-8s \n", touchscreen ? "Abletotouchscreen" : "Unabletotouchscreen");
    }
    @Override
    public void input() {
        super.input();
        touchscreen = Validate.getBoolean("----Select option ----", "1.YES\n2.NO", "Must be 1.YES or 2.NO");
        
    }
}
