package framework;

import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class abcde {

    public static void main(String[] args) throws NumberFormatException {


        ArrayList<String> strTest = new ArrayList<>();
        strTest.add("42°");
        strTest.add("41°");
        strTest.add("39°");
        strTest.add("500°");


        String temp = "48˚ Clear˚dasdasd";
        String [] tempArray = temp.split("˚");
        String temp2 = tempArray[2];
        System.out.println(temp2);


        }


    }

