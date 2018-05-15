package com.mohit.program.topic;

import java.util.UUID;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class ConversionMaster {

    static String a = "ff,ba,c0,00";
    static int index = 0;

    /**
     * convert string to hex
     * @param integer
     */
    public void HexString(int integer){
        try {
            System.out.println(Integer.toHexString(integer));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * character to byte
     * @param str
     */
    public static void charToByte(String str){
        String[] asa = a.split(",");

        // character to byte
        char[] add = new char[4];
        add[0] = (char) Integer.parseInt(asa[0].trim(), 16);
        add[1] = (char) Integer.parseInt(asa[1].trim(), 16);
        add[2] = (char) Integer.parseInt(asa[2].trim(), 16);
        add[3] = (char) Integer.parseInt(asa[3].trim(), 16);

        // byte to hex-decimal ,decimal
        int x = 0;
        String dec = "";
        String hex = "";
        for (int i = 0; i < add.length; i++) {
            x = add[i];
            if (x < 0) {
                x += 256;
            }
            add[i] = (char) x;
            // log(((int) x) + "");
            dec += x + " ";
            hex += Integer.toHexString(x) + " ";
        }
    }

    /**
     * This method is used to generate UUID
     */
    public static void getUUID(){
        UUID uu = UUID.randomUUID();

        System.out.println("Random UUID String = " + uu);
        System.out.println("UUID version       = " + uu.version());
        System.out.println("UUID variant       = " + uu.variant());
    }

    /**
     * use this method to evaluate process time
     */
    public static void checkProcressTime(){
        long t1 = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            char[] arr = new char[10];
            for(int j=0;j<10;j++){
                arr[j] = 'a';
            }
            String getchar = new String(arr);
        }
        long t2 = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<10;j++){
                str.append("z");
            }
            String getchar = str.toString();
        }
        long t3 = System.currentTimeMillis();
        long x = t2 - t1;
        System.out.println(x+"");
        long y = t3 - t2;
        System.out.println(y+"");
    }

    /**
     * convert using redix (Base) throw {@link NumberFormatException} where input do not
     * verified.
     */
    public static void IntegerRedix() throws NumberFormatException{
        // from hex to int / string
        int x = Integer.parseInt("ff", 16);

        // int to hex
        String y = Integer.toHexString(2147483647);
    }
}
