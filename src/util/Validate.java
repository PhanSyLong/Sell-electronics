/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import constant.IConstant;
import java.util.Scanner;
import static util.Validate.getString;

/**
 *
 * @author Lenovo
 */
public class Validate {

    private Validate() {
    }
    static Scanner sc = new Scanner(System.in);

    public static int getInt(String promtMessage, String outMessage, String InvalidMessage, int min, int max) {
        int number = 0;
        while (true) {
            try {
                System.out.println(promtMessage);
                number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.err.println(outMessage);
                }
            } catch (Exception e) {
                System.err.println(InvalidMessage);
            }
        }
        return number;
    }

    public static boolean isGender(String promtMessage, String outMessage, String InvalidMessage) {
        String name = "";
        String male = "male";
        String female = "female";
        while (true) {
            try {
                System.out.println(promtMessage);
                name = sc.nextLine();
                if (name.equals(male)) {
                    break;
                } else if (name.equals(female)) {
                    return false;
                } else {
                    System.out.println(outMessage);
                }
            } catch (Exception e) {
                System.out.println(InvalidMessage);
            }
        }
        return true;

    }

    public static String getString(
            String messageInfo,
            String messageError,
            final String REGEX
    ) {
        do {
            System.out.println(messageInfo);
            String str = sc.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.err.println(messageError);
        } while (true);
    }

    public static boolean getBoolean(
            String messageinfor,
            String messageChoice,
            String messageError) {
        System.out.println(messageinfor); // in ra thong bao nhap du lieu 
        System.out.println(messageChoice); // in ra menu de lua chon 
        int choice = Integer.parseInt(getString("Enter your choice", messageError, IConstant.REGEX_PRODUCT_NUMBERCHOICE));
        return choice == 1;
    }

}
