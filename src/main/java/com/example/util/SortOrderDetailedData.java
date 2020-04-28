package com.example.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 排序方式的类
 *
 * @ author: SongWenjing
 * @ Date 2020/4/23 9:55
 */
public class SortOrderDetailedData {
    private Integer zoneId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;

    public SortOrderDetailedData() {
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "SortOrderDetailedData{" +
                "zoneId=" + zoneId +
                ", sendTime=" + sendTime +
                '}';
    }
}
