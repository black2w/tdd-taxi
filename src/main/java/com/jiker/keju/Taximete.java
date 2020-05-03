package com.jiker.keju;

/**
 * @author black2w on 2020/5/3.
 * @version 1.0
 */
public class Taximete {
    public int queryPriceByMileAndTime(int mile, int time) {
        if (mile <= 2) {
            return (int) Math.round(6 + time * 0.25);
        } else if (mile > 2 && mile <= 8) {
            return (int) Math.round((6 + (mile - 2) * 0.8) + time * 0.25);
        } else {
            return (int) Math.round((6 + 6 * 0.8 + (mile - 8) * 1.2) + time * 0.25);
        }

    }
}
