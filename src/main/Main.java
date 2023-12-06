/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import bo.LaptopBO;
import bo.PcBO;
import bo.PcBO;
import bo.ProductBO;
import bo.SmartphoneBO;
import constant.IConstant;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import util.Helper;
import util.Validate;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean flag = true;
        boolean flagPC = true;
        PcBO pcBO = new PcBO(new ArrayList<>());
        pcBO.loadFromFile("PC.txt");
        boolean flagLaptop = true;
        LaptopBO laptopBO = new LaptopBO(new ArrayList<>());
        laptopBO.loadFromFile("Laptop.txt");
        boolean flagSmartphone = true;
        SmartphoneBO smartphoneBO = new SmartphoneBO(new ArrayList<>());
        smartphoneBO.loadFromFile("Smartphone.txt");

        while (flag) {
            Helper.showProductMenu();
            int choice = Validate.getInt("Enter your choice: ", "Must be from 0 to 6", "Must be number", 0, 6);
            switch (choice) {
                case 1:
                    System.out.println("\n---------Search By Name---------");
                    List<Product> lstProduct = new ArrayList<>();
                    lstProduct.addAll(pcBO.getLstPC());
                    lstProduct.addAll(laptopBO.getLstLaptop());
                    lstProduct.addAll(smartphoneBO.getLstSmartphone());
                    ProductBO productBO = new ProductBO(lstProduct);
                    String nameProduct = Validate.getString(
                            "Enter your name for searching: ",
                            "Invalid Name",
                            IConstant.REGEX_PRODUCT_NAME
                    );
                    productBO.searchByName(nameProduct);
                    break;
                case 2:
                    flagPC = true;
                    while (flagPC) {
                        Helper.showPCMenu();
                        int choicePC = Validate.getInt("Enter your choice: ", "Must be from 0 to 9", "Must be number", 0, 9);
                        switch (choicePC) {
                            case 1:
                                System.out.println("\n---------ADD PC---------");
                                pcBO.add();
                                break;
                            case 2:
                                System.out.println("\n---------UPDATE PC---------");
                                String idToUpdate = Validate.getString("Enter id need to update", "invalid id", IConstant.REGEX_PRODUCT_ID);
                                pcBO.update(idToUpdate);
                                break;
                            case 3:
                                System.out.println("\n---------DELETE PC---------");
                                String idToDelete = Validate.getString("Enter id need delete", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                pcBO.delete(idToDelete);
                                break;
                            case 4:
                                System.out.println("\n---------SHOW ALL PC (sort by ID)---------");
                                pcBO.sortById();
                                break;
                            case 5:
                                System.out.println("\n---------SEARCH PC BY BRAND---------");
                                pcBO.searchByBrand();
                                break;
                            case 6:
                                System.out.println("\n---------SEARCH PC BY NAME---------");
                                String name = Validate.getString(
                                        "Enter your name for searching: ",
                                        "Invalid Name",
                                        IConstant.REGEX_PRODUCT_NAME
                                );
                                pcBO.searchByName(name);
                                break;
                            case 7:
                                System.out.println("\n---------SHOW ALL PC (sort by price)---------");
                                pcBO.sortByPrice();
                                break;
                            case 8:
                                System.out.println("\n---------IMPORT PC---------");
                                String idPCImport = Validate.getString("Enter id of PC for importing: ", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                int quantityImport = Validate.getInt(
                                        "Enter quantity of PC for importing: ",
                                        "Must be positive number",
                                        "Must be integer number",
                                        1,
                                        Integer.MAX_VALUE
                                );
                                pcBO.importProduct(idPCImport, quantityImport);
                                break;
                            case 9:
                                System.out.println("\n---------SELL PC---------");
                                String idPCSell = Validate.getString("Enter id of PC for selling: ", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                int quantitySell = Validate.getInt(
                                        "Enter quantity of PC for selling: ",
                                        "Must be positive number",
                                        "Must be integer number",
                                        1,
                                        Integer.MAX_VALUE
                                );
                                pcBO.sellProduct(idPCSell, quantitySell);
                                break;
                            default:
                                flagPC = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n---------Laptop Management---------");
                    flagLaptop = true;
                    while (flagLaptop) {
                        Helper.showLaptopMenu();
                        int choiceLaptop = Validate.getInt("Enter your choice: ", "Must be from 0 to 9", "Must be number", 0, 9);
                        switch (choiceLaptop) {
                            case 1:
                                System.out.println("\n---------ADD Laptop---------");
                                laptopBO.add();
                                break;
                            case 2:
                                System.out.println("\n---------UPDATE Laptop---------");
                                break;
                            case 3:
                                System.out.println("\n---------DELETE Laptop---------");
                                String id = Validate.getString("Enter id need delete", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                laptopBO.delete(id);
                                break;
                            case 4:
                                System.out.println("\n---------SHOW ALL Laptop (sort by ID)---------");
                                laptopBO.sortById();
                                break;
                            case 5:
                                System.out.println("\n---------SEARCH Laptop BY BRAND---------");
                                laptopBO.searchByBrand();
                                break;
                            case 6:
                                System.out.println("\n---------SEARCH Laptop BY NAME---------");
                                String name = Validate.getString(
                                        "Enter your name for searching: ",
                                        "Invalid Name",
                                        IConstant.REGEX_PRODUCT_NAME
                                );
                                laptopBO.searchByName(name);
                                break;
                            case 7:
                                System.out.println("\n---------SHOW ALL Laptop (sort by price)---------");
                                laptopBO.sortByPrice();
                                break;
                            case 8:
                                System.out.println("\n---------IMPORT Laptop---------");
                                String idLaptopImport = Validate.getString("Enter id of Laptop for importing: ", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                int quantityImport = Validate.getInt(
                                        "Enter quantity of Laptop for importing: ",
                                        "Must be positive number",
                                        "Must be integer number",
                                        1,
                                        Integer.MAX_VALUE
                                );
                                laptopBO.importProduct(idLaptopImport, quantityImport);
                                break;
                            case 9:
                                System.out.println("\n---------SELL Laptop---------");
                                String idLaptopSell = Validate.getString("Enter id of Laptop for selling: ", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                int quantitySell = Validate.getInt(
                                        "Enter quantity of Laptop for selling: ",
                                        "Must be positive number",
                                        "Must be integer number",
                                        1,
                                        Integer.MAX_VALUE
                                );
                                laptopBO.sellProduct(idLaptopSell, quantitySell);
                                break;
                            default:
                                flagLaptop = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n---------SmartPhone Management---------");
                    flagSmartphone = true;
                    while (flagSmartphone) {
                        Helper.showSmartphoneMenu();
                        int choiceSmartphone = Validate.getInt("Enter your choice: ", "Must be from 0 to 9", "Must be number", 0, 9);
                        switch (choiceSmartphone) {
                            case 1:
                                System.out.println("\n---------ADD Smartphone---------");
                                smartphoneBO.add();
                                break;
                            case 2:
                                System.out.println("\n---------UPDATE Smartphone---------");
                                break;
                            case 3:
                                System.out.println("\n---------DELETE Smartphone---------");
                                String id = Validate.getString("Enter id need delete", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                smartphoneBO.delete(id);
                                break;
                            case 4:
                                System.out.println("\n---------SHOW ALL Smartphone (sort by ID)---------");
                                smartphoneBO.sortById();
                                break;
                            case 5:
                                System.out.println("\n---------SEARCH Smartphone BY BRAND---------");
                                smartphoneBO.searchByBrand();
                                break;
                            case 6:
                                System.out.println("\n---------SEARCH Smartphone BY NAME---------");
                                String name = Validate.getString(
                                        "Enter your name for searching: ",
                                        "Invalid Name",
                                        IConstant.REGEX_PRODUCT_NAME
                                );
                                smartphoneBO.searchByName(name);
                                break;
                            case 7:
                                System.out.println("\n---------SHOW ALL Smartphone (sort by price)---------");
                                smartphoneBO.sortByPrice();
                                break;
                            case 8:
                                System.out.println("\n---------IMPORT Smartphone---------");
                                String idSmartphoneImport = Validate.getString("Enter id of Smartphone for importing: ", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                int quantityImport = Validate.getInt(
                                        "Enter quantity of Smartphone for importing: ",
                                        "Must be positive number",
                                        "Must be integer number",
                                        1,
                                        Integer.MAX_VALUE
                                );
                                smartphoneBO.importProduct(idSmartphoneImport, quantityImport);
                                break;
                            case 9:
                                System.out.println("\n---------SELL Smartphone---------");
                                String idSmartphoneSell = Validate.getString("Enter id of Smartphone for selling: ", "Invalid Id", IConstant.REGEX_PRODUCT_ID);
                                int quantitySell = Validate.getInt(
                                        "Enter quantity of Smartphone for selling: ",
                                        "Must be positive number",
                                        "Must be integer number",
                                        1,
                                        Integer.MAX_VALUE
                                );
                                smartphoneBO.sellProduct(idSmartphoneSell, quantitySell);
                                break;
                            default:
                                flagSmartphone = false;
                                break;
                        }
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        pcBO.saveToFile("PC.txt");
        laptopBO.saveToFile("Laptop.txt");
        smartphoneBO.saveToFile("Smartphone.txt");

    }

}
