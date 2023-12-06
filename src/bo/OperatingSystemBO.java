/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Brand;
import entity.OperatingSystem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class OperatingSystemBO {
    private List<OperatingSystem> LstOperatingSystem ;

    public OperatingSystemBO() {
    }

    public OperatingSystemBO(List<OperatingSystem> lstoperatingsystem) {
        this.LstOperatingSystem = lstoperatingsystem;
    }

    public List<OperatingSystem> getLstOperatingSystem() {
        return LstOperatingSystem;
    }

    public void setLstOperatingSystem(List<OperatingSystem> lstOperatingSystem) {
        this.LstOperatingSystem = lstOperatingSystem;
    }
     public boolean loadFromFile(String fileOperatingSystem) {
        boolean result = false;
        try {
            File f = new File(fileOperatingSystem);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[|]");
                OperatingSystem s = new OperatingSystem(words[0], words[1]);
                LstOperatingSystem.add(s);
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

    public void show() {
        System.out.println(LstOperatingSystem);
    }
}
