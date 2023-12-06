/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Brand;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class BrandBO {

    private List<Brand> LstBrand;

    public BrandBO() {
    }

    public BrandBO(List<Brand> LstBrand) {
        this.LstBrand = LstBrand;
    }

    public List<Brand> getLstBrand() {
        return LstBrand;
    }

    public void setLstBrand(List<Brand> LstBrand) {
        this.LstBrand = LstBrand;
    }

    public boolean loadFromFile(String fileBrand) {
        boolean result = false;
        try {
            File f = new File(fileBrand);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[|]");
                Brand s = new Brand(words[0], words[1]);
                LstBrand.add(s);
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
        System.out.println(LstBrand);
    }
}
