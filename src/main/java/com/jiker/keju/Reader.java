package com.jiker.keju;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author black2w on 2020/5/3.
 * @version 1.0
 */
public class Reader {
    String filePath = "";

    public Reader(String testDataFile) {
        filePath = "src/main/resources/" + testDataFile;
    }


    public int[][] queryMileAndTime(List<String> datas) {
        int[][] mileAndTime = new int[datas.size()][2];
        for (int i = 0; i < datas.size(); i++) {
            mileAndTime[i][0] = Integer.parseInt(datas.get(i).substring(0, datas.get(i).indexOf("公里")));
            mileAndTime[i][1] = Integer.parseInt(datas.get(i).substring(datas.get(i).indexOf("等待") + 2, datas.get(i).indexOf("分钟")));
        }
        return mileAndTime;
    }

    public List<String> queryParms() throws IOException {
        List lists = new ArrayList();
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().equals("")){
                lists.add(line.trim());
            }
        }
        return lists;
    }
}
