package com.example.util;

/**
 * @author: SongWenjing
 * @Date 2020/4/21 21:43
 */
public class TransformIntArray {
    public static int[] transformIntArray(String zoneMessage) {
        String[] zoneMessageArray = zoneMessage.split(",");
        int[] zoneMessageIntArray = new int[zoneMessageArray.length];
        for (int i = 0; i < zoneMessageArray.length; i++) {
            zoneMessageIntArray[i] = Integer.parseInt(zoneMessageArray[i]);
        }
        return zoneMessageIntArray;
    }
}
