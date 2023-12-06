/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo;

/**
 *
 * @author Lenovo
 */
public interface IFuncBO {

    void add();

    void update(String id);

    void delete(String id);

    void sortById();

    void searchByBrand();

    void searchByName(String name);

    void sortByPrice();

    void importProduct(String id, int quantity);

    void sellProduct(String id, int quantity);
    
    boolean loadFromFile(String fileName);
    
    boolean saveToFile(String fileName);
}
