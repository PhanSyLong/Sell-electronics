/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import constant.IConstant;
import entity.Brand;
import entity.OperatingSystem;
import entity.Pc;
import entity.Smartphone;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import util.Helper;
import util.Validate;

/**
 *
 * @author Lenovo
 */
public class SmartphoneBO implements IFuncBO {

    private List<Smartphone> lstSmartphone;

    public SmartphoneBO() {
    }

    public SmartphoneBO(List<Smartphone> lstSmartphone) {
        this.lstSmartphone = lstSmartphone;
    }

    public List<Smartphone> getLstSmartphone() {
        return lstSmartphone;
    }

    @Override
    public void add() {
        Smartphone obj = new Smartphone();
        obj.input();
        lstSmartphone.add(obj);
    }

    @Override
    public void update(String id) {
        Smartphone Sp = null;
        for (int i = 0; i < lstSmartphone.size(); i++) {
            if (lstSmartphone.get(i).getId().equals(id)) {
                Sp = lstSmartphone.get(i);
            }
        }
        if (Sp == null) {
            System.out.println("Not found your Smartphone");
            System.out.println("Update fail");
        } else {
            String newbatteryCapacity = Validate.getString("Enter new batteryCapacity", "invalid batteryCapacity", IConstant.REGEX_PRODUCT_BATTERYCAPACITY);
            Sp.setBatteryCapacity(newbatteryCapacity);
            System.out.println("Update success");
        }
    }

    @Override
    public void delete(String id) {
        boolean idExist = checkIdExist(id);
        if (idExist) {
            for (int i = 0; i < lstSmartphone.size(); i++) {
                if (id.equals(lstSmartphone.get(i).getId())) {
                    lstSmartphone.remove(i);
                }
            }
            System.out.println("Delete success");
        } else {
            System.err.println("this is not exist, false to delete");
        }
    }

    @Override
    public void sortById() {
        Collections.sort(lstSmartphone, new Comparator<Smartphone>() {
            @Override
            public int compare(Smartphone obj1, Smartphone obj2) {
                return obj1.getId().compareTo(obj2.getId());
            }
        });
        for (int i = 0; i < lstSmartphone.size(); i++) {
            lstSmartphone.get(i).print();
        }

    }

    @Override
    public void searchByBrand() {
        Brand brand = Helper.selectBrand();
        for (int i = 0; i < lstSmartphone.size(); i++) {
            if (lstSmartphone.get(i).getBrand().equals(brand.getId())) {
                lstSmartphone.get(i).print();
            }
        }

    }

    @Override
    public void searchByName(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < lstSmartphone.size(); i++) {
            if (lstSmartphone.get(i).getName().toLowerCase().contains(name)) {
                lstSmartphone.get(i).print();
            }
        }
    }

    @Override
    public void sortByPrice() {
        Collections.sort(lstSmartphone, new Comparator<Smartphone>() {
            @Override
            public int compare(Smartphone obj1, Smartphone obj2) {
                return obj1.getPrice() - (obj2.getPrice());
            }
        });
        show();
    }

    @Override
    public void importProduct(String id, int quantity) {
        boolean isIdExist = checkIdExist(id);
        if (isIdExist) {
            for (int i = 0; i < lstSmartphone.size(); i++) {
                if (lstSmartphone.get(i).getId().equals(id)) {
                    int oldQuantity = lstSmartphone.get(i).getQuantity();
                    lstSmartphone.get(i).setQuantity(oldQuantity + quantity);
                    System.err.println("Success to import quantity");
                }
            }
        } else {
            System.out.println("Id not found, import false");
        }
    }

    @Override
    public void sellProduct(String id, int quantity) {
        boolean isIdExist = checkIdExist(id);
        if (isIdExist) {
            for (int i = 0; i < lstSmartphone.size(); i++) {
                if (lstSmartphone.get(i).getId().equals(id)) {
                    int oldQuantity = lstSmartphone.get(i).getQuantity();
                    if (oldQuantity < quantity) {
                        System.err.println("Not enough quantity for sell");
                    } else {
                        lstSmartphone.get(i).setQuantity(oldQuantity - quantity);
                    }
                }
            }
        } else {
            System.out.println("Id not found, sell false");
        }
    }

    private void show() {
        for (int i = 0; i < lstSmartphone.size(); i++) {
            lstSmartphone.get(i).print();
        }
    }

    private boolean checkIdExist(String id) {
        for (int i = 0; i < lstSmartphone.size(); i++) {
            if (id.equals(lstSmartphone.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loadFromFile(String fileName) {
        boolean result = false;
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[|]");
                String id = words[0];
                String name = words[1];
                String brandId = words[2];
                String brandName = words[3];
                String oSId = words[4];
                String oSName = words[5];
                int price = Integer.parseInt(words[6]);
                int quantity = Integer.parseInt(words[7]);
                String batteryCapacity = words[8];
                Smartphone obj = new Smartphone(id, name, new Brand(brandId, brandName), new OperatingSystem(oSId, oSName), price, quantity, batteryCapacity);
                lstSmartphone.add(obj);
            }
            br.close();
            fr.close();
            result = true;
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;

    }

    @Override
    public boolean saveToFile(String fileName) {
        boolean result = false;
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < lstSmartphone.size(); i++) {
                pw.print(lstSmartphone.get(i).getId());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getName());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getBrand().getId());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getBrand().getName());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getOperatingSystem().getId());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getOperatingSystem().getName());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getPrice());
                pw.print("|");
                pw.print(lstSmartphone.get(i).getQuantity());
                pw.print("|");
                pw.println(lstSmartphone.get(i).getBatteryCapacity());
            }
            System.out.println("Save to file " + fileName + " is success. ");
            pw.close();
            fw.close();

        } catch (Exception e) {

            return result;

        }
        return result;
    }
}
