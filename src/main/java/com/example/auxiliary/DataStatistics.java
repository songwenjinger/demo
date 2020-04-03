package com.example.auxiliary;

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
