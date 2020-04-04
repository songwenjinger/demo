package com.example.auxiliary;

/**
 * @author: SongWenjing
 * @Date 2020/4/3 17:24
 * 最大值，最小值，累加和，平均数据的辅助类
 */
public class DataStatistics {
    private Float maxData;
    private Float minData;
    private Float sumData;
    private Float avgData;


    public Float getMaxData() {
        return maxData;
    }

    public void setMaxData(Float maxData) {
        this.maxData = maxData;
    }

    public Float getMinData() {
        return minData;
    }

    public void setMinData(Float minData) {
        this.minData = minData;
    }

    public Float getSumData() {
        return sumData;
    }

    public void setSumData(Float sumData) {
        this.sumData = sumData;
    }

    public Float getAvgData() {
        return avgData;
    }

    public void setAvgData(Float avgData) {
        this.avgData = avgData;
    }

    @Override
    public String toString() {
        return "DataStatistics{" +
                "maxData=" + maxData +
                ", minData=" + minData +
                ", sumData=" + sumData +
                ", avgData=" + avgData +
                '}';
    }
}
