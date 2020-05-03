package com.jiker.keju;
import org.junit.Assert;
import org.junit.Test;
import com.jiker.keju.Reader;
import com.jiker.keju.Taximete;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author black2w on 2020/5/3.
 * @version 1.0
 */
public class TaxiTest {
    public TaxiTest() throws IOException {
    }

    @Test
    public void query_price_by_mile_and_time() {
        Taximete taximete = new Taximete();
        assertEquals(taximete.queryPriceByMileAndTime(1, 0), 6);
        assertEquals(taximete.queryPriceByMileAndTime(3, 0), 7);
        assertEquals(taximete.queryPriceByMileAndTime(10, 0), 13);
        assertEquals(taximete.queryPriceByMileAndTime(2, 3), 7);
    }

    @Test
    public void query_miles_and_time() {
        Reader reader = new Reader("testData.txt");
        List<String> lists = new ArrayList<>();
        lists.add("1公里，等待0分钟\n");
        lists.add("2公里，等待3分钟\n");
        int[][] arr = {{1, 0}, {2, 3}};
        Assert.assertArrayEquals(reader.queryMileAndTime(lists), arr);
    }


    @Test
    public void query_parms() throws IOException {
        Reader reader = new Reader("testData.txt");
        List<String> lists = new ArrayList<>();
        lists.add("1公里,等待0分钟");
        lists.add("3公里,等待0分钟");
        lists.add("10公里,等待0分钟");
        lists.add("2公里,等待3分钟");

        assertEquals(reader.queryParms(), lists);
    }

    @Test
    public void get_total_receipts() throws IOException {
        Reader reader = new Reader("testData.txt");
        String receipt = "";
        Taximete taximete = new Taximete();
        int[][] parms = reader.queryMileAndTime(reader.queryParms());
        for (int i = 0; i < parms.length; i++) {
            int priceInt = taximete.queryPriceByMileAndTime(parms[i][0], parms[i][1]);
            receipt = receipt + "收费" + priceInt + "元" + "\n";
        }

        assertEquals(receipt,"收费6元\n" +
                "收费7元\n" +
                "收费13元\n" +
                "收费7元\n");
    }



}

