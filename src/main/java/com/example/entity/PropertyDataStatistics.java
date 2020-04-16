package com.example.entity;

import java.util.Date;

/**
 * @author: SongWenjing
 * @Date 2020/4/15 22:25
 * 历史数据处理页面用到的类
 * 对应day_region_data
 * week_region_data
 * month_region_data
 * year_region_data
 */
public class PropertyDataStatistics {
    private Integer id;



    private Integer zoneId;
    private String property;
    private Float maxData;
    private Float minData;
    private Float avgData;
    private Float sumData;
    private Date sendTime;

    public PropertyDataStatistics() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

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

    public Float getAvgData() {
        return avgData;
    }

    public void setAvgData(Float avgData) {
        this.avgData = avgData;
    }

    public Float getSumData() {
        return sumData;
    }

    public void setSumData(Float sumData) {
        this.sumData = sumData;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "PropertyDataStatistics{" +
                "id=" + id +
                ", zoneId=" + zoneId +
                ", property='" + property + '\'' +
                ", maxData=" + maxData +
                ", minData=" + minData +
                ", avgData=" + avgData +
                ", sumData=" + sumData +
                ", sendTime=" + sendTime +
                '}';
    }
}
