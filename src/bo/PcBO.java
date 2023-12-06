/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Brand;
import entity.OperatingSystem;
import entity.Pc;
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
public class PcBO implements IFuncBO {

    private List<Pc> lstPC;

    public PcBO() {
    }

    public PcBO(List<Pc> lstPC) {
        this.lstPC = lstPC;
    }

    public List<Pc> getLstPC() {
        return lstPC;
    }

    @Override
    public void add() {
        Pc obj = new Pc();
        obj.input();
        lstPC.add(obj);
    }

    @Override
    public void update(String id) {
        Pc pc = null;
        for (int i = 0; i < lstPC.size(); i++) {
            if (lstPC.get(i).getId().equals(id)) {
                pc = lstPC.get(i);
            }
        }
        if(pc == null){
            System.out.println("Not found your PC");
            System.out.println("Update fail");
        }else {
            int newprice = Validate.getInt("Enter new price", "informad newprice", "Invalid price", 2000, 4000);
            pc.setPrice(newprice);
            System.out.println("Update success");
        }        
    }

    @Override
    public void delete(String id) {
        boolean idExist = checkIdExist(id);
        if (idExist) {
            for (int i = 0; i < lstPC.size(); i++) {
                if (id.equals(lstPC.get(i).getId())) {
                    lstPC.remove(i);
                }
            }
            System.out.println("Delete success");
        } else {
            System.err.println("this is not exist, false to delete");
        }
    }

    @Override
    public void sortById() {
        Collections.sort(lstPC, new Comparator<Pc>() {
            @Override
            public int compare(Pc obj1, Pc obj2) {
                return obj1.getId().compareTo(obj2.getId());
            }
        });
        for (int i = 0; i < lstPC.size(); i++) {
            lstPC.get(i).print();
        }
    }
   
    @Override
    public void searchByBrand() {
        Brand brand = Helper.selectBrand();
        for (int i = 0; i < lstPC.size(); i++) {
            if (lstPC.get(i).getBrand().equals(brand.getId())) {
                lstPC.get(i).print();
            }
        }
    }

    @Override
    public void searchByName(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < lstPC.size(); i++) {
            if (lstPC.get(i).getName().toLowerCase().contains(name)) {
                lstPC.get(i).print();
            }
        }
    }

    @Override
    public void sortByPrice() {
        Collections.sort(lstPC, new Comparator<Pc>() {
            @Override
            public int compare(Pc obj1, Pc obj2) {
                return obj1.getPrice() - (obj2.getPrice());
            }
        });
        show();
    }

    @Override
    public void importProduct(String id, int quantity) {
        boolean isIdExist = checkIdExist(id);
        if (isIdExist) {
            for (int i = 0; i < lstPC.size(); i++) {
                if (lstPC.get(i).getId().equals(id)) {
                    int oldQuantity = lstPC.get(i).getQuantity();
                    lstPC.get(i).setQuantity(oldQuantity + quantity);
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
            for (int i = 0; i < lstPC.size(); i++) {
                if (lstPC.get(i).getId().equals(id)) {
                    int oldQuantity = lstPC.get(i).getQuantity();
                    if (oldQuantity < quantity) {
                        System.err.println("Not enough quantity for sell");
                    } else {
                        lstPC.get(i).setQuantity(oldQuantity - quantity);
                    }
                }
            }
        } else {
            System.out.println("Id not found, sell false");
        }
    }

    private void show() {
        for (int i = 0; i < lstPC.size(); i++) {
            lstPC.get(i).print();
        }
    }

    private boolean checkIdExist(String id) {
        for (int i = 0; i < lstPC.size(); i++) {
            if (id.equals(lstPC.get(i).getId())) {
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
                String electricityConsumption = words[8];
                Pc obj = new Pc(id, name, new Brand(brandId, brandName), new OperatingSystem(oSId, oSName), price, quantity, electricityConsumption);
                lstPC.add(obj);
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
            for (int i = 0; i < lstPC.size(); i++) {
                pw.print(lstPC.get(i).getId());
                pw.print("|");
                pw.print(lstPC.get(i).getName());
                pw.print("|");
                pw.print(lstPC.get(i).getBrand().getId());
                pw.print("|");
                pw.print(lstPC.get(i).getBrand().getName());
                pw.print("|");
                pw.print(lstPC.get(i).getOperatingSystem().getId());
                pw.print("|");
                pw.print(lstPC.get(i).getOperatingSystem().getName());
                pw.print("|");
                pw.print(lstPC.get(i).getPrice());
                pw.print("|");
                pw.print(lstPC.get(i).getQuantity());
                pw.print("|");
                pw.println(lstPC.get(i).getElectricityConsumption());
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
