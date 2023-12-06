/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author Lenovo
 */
public interface IConstant {
    String REGEX_PRODUCT_ID     = "^[A-Z]{2}[0-9]{6}$";
    String REGEX_PRODUCT_NAME   = "^[A-Za-z0-9]+$";
    String REGEX_PRODUCT_ELECTRICITYCONSUMPTION = "^[0-9]+$";
    String REGEX_PRODUCT_NUMBERCHOICE = "[1-2]";
    String REGEX_PRODUCT_BATTERYCAPACITY = "[0-9]{4}$";
}
