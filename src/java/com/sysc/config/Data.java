
package com.sysc.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
    
    
    public static Calendar calenar = Calendar.getInstance();
    private static String data;

    public Data() {
    }

    public static String Data(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        data = sdf.format(calenar.getTime());
         return data;
    }


    public static String DataBD(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        data = sdf.format(calenar.getTime());
         return data;
    }
    
}
