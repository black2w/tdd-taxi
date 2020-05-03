package com.jiker.keju;
import com.jiker.keju.Reader;
import com.jiker.keju.Taximete;

import java.io.IOException;
import java.util.List;

public class AppRunner {

    public static void main(String[] args) throws IOException {
        /*TODO
          1. args[0]为resources下的测试数据文件名，例如传入的args[0]值为"testData.txt"，注意并不包含文件路径。
          2. 你写的程序将把testDataFile作为参数加载此文件并读取文件内的测试数据，并对每条测试数据计算结果。
          3. 将所有计费结果拼接并使用\n分割，然后保存到receipt变量中。
         */
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
