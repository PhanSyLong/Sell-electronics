/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import bo.BrandBO;
import entity.Brand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Helper {

    private Helper() {
    }

    ;
    
    public static void showProductMenu() {
        System.out.println("Techological Product Management");
        System.out.println("\n1. Search by name");
        System.out.println("2. PC management");
        System.out.println("3. Laptop management");
        System.out.println("4. SmartPhone management");
        System.out.println("0. Exit");
    }
    public static void showPCMenu(){
        System.out.println("\n------PC Management------");
        System.out.println("1.Add PC");
        System.out.println("2.Update PC");
        System.out.println("3.Delete PC");
        System.out.println("4.Show all PC (sort by ID)");
        System.out.println("5.Search PC by brand");
        System.out.println("6.Search PC by name");
        System.out.println("7.Show all PC by price");
        System.out.println("8.Import PCs");
        System.out.println("9.Sell Pc");
        System.out.println("0.Exit");
    } 
    public static void showLaptopMenu () {
    System.out.println("\n------PC Management------");
        System.out.println("1.Add Laptop");
        System.out.println("2.Update Laptop");
        System.out.println("3.Delete Laptop");
        System.out.println("4.Show all Laptop(sort by ID)");
        System.out.println("5.Search Laptop by brand");
        System.out.println("6.Search Laptop by name");
        System.out.println("7.Show all Laptop by price");
        System.out.println("8.Import Laptop");
        System.out.println("9.Sell Laptop");
        System.out.println("0.Exit");
    }
    public static void showSmartphoneMenu () {
    System.out.println("\n------PC Management------");
        System.out.println("1.Add Smartphone");
        System.out.println("2.Update Smartphone");
        System.out.println("3.Delete Smartphone");
        System.out.println("4.Show all Smartphone (sort by ID)");
        System.out.println("5.Search Smartphone by brand");
        System.out.println("6.Search Smartphone by name");
        System.out.println("7.Show all Smartphone by price");
        System.out.println("8.Import Smartphone");
        System.out.println("9.Sell Smartphone");
        System.out.println("0.Exit");
    }
   public static Brand selectBrand() {
        BrandBO brandBO = new BrandBO(new ArrayList<>());
        brandBO.loadFromFile("brand.txt");
        List<Brand> lstBrand = brandBO.getLstBrand();
        
        for(int i = 0; i < lstBrand.size(); i++) {
            System.out.printf("%-4s%-5s%-50s\n", i + 1, lstBrand.get(i).getId(), lstBrand.get(i).getName());
        }
        
        int choice = Validate.getInt(
                "Enter your choice: ",
                "must be from 1 to " + lstBrand.size(),
                "Must be integer number",
                1,
                lstBrand.size()
        );
        
        for(int i = 0; i < lstBrand.size(); i++) {
            if (choice == (i + 1)) {
                return lstBrand.get(i);
            }
        }
        return null;
    }
    
}
