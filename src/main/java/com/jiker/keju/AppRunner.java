package com.jiker.keju;
import com.jiker.keju.Reader;
import com.jiker.keju.Taximete;
import java.io.IOException;
import java.util.List;
public class AppRunner {

    public static void main(String[] args) throws IOException {
        String testDataFile = args[0];
        String receipt = "";
        Reader reader = new Reader(testDataFile);
        try {
            List<String> parms = reader.queryParms();
            int[][] parm = reader.queryMileAndTime(parms);
            receipt = queryPrice(parm);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(receipt);
    }

    public static  String queryPrice(int[][] parms){
        String price = "";
        Taximete taximete = new Taximete();
        for (int i=0; i<parms.length; i++){
            int priceInt = taximete.queryPriceByMileAndTime(parms[i][0], parms[i][1]);
            price = price + "收费" + priceInt + "元" + "\n";
        }
        return price;
    }
}
