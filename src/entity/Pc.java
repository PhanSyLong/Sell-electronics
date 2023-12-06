/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import constant.IConstant;
import static constant.IConstant.REGEX_PRODUCT_ELECTRICITYCONSUMPTION;
import util.Validate;

/**
 *
 * @author Lenovo
 */
public class Pc extends Product {

    private String electricityConsumption;

    public Pc() {
    }

    public Pc(String electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public Pc(String id, String name, Brand brand, OperatingSystem operatingSystem, int price, int quantity, String electricityConsumption) {
        super(id, name, brand, operatingSystem, price, quantity);
        this.electricityConsumption = electricityConsumption;
    }

    public String getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(String electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }
    @Override
    public void print(){
        super.print();    
        System.out.printf("%-8s W/h \n", electricityConsumption);
    }
    
    @Override
    public void input() {
        super.input();
        electricityConsumption = Validate.getString(
                "Enter your electricityConsumption ",
                "iNVALIDE NUMBER",
                IConstant.REGEX_PRODUCT_ELECTRICITYCONSUMPTION);

    }
}
