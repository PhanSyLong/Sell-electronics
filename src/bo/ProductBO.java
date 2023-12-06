/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Product;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ProductBO {

    List<Product> lstProduct;

    public ProductBO() {
    }

    public ProductBO(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }

    public void searchByName(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < lstProduct.size(); i++) {
            if (lstProduct.get(i).getName().toLowerCase().contains(name)) {
                lstProduct.get(i).print();
            }
        }
    }

}
