package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RegionData {
    //id
    private Integer id;
    //区域id
    private Integer zoneId;
    //小数类型,温度
    private Float waterTemperature;
    //PH
    private Float ph;
    //化学耗氧量
    private Float cod;
    //氨氮
    private Float nh3;
    private Float dox;
    //电导率
    private Float conductivity;
    //浊度
    private Float turbidity;
    //发送时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;

    public RegionData() {
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

    public Float getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Float waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public Float getPh() {
        return ph;
    }

    public void setPh(Float ph) {
        this.ph = ph;
    }

    public Float getCod() {
        return cod;
    }

    public void setCod(Float cod) {
        this.cod = cod;
    }

    public Float getNh3() {
        return nh3;
    }

    public void setNh3(Float nh3) {
        this.nh3 = nh3;
    }

    public Float getConductivity() {
        return conductivity;
    }

    public void setConductivity(Float conductivity) {
        this.conductivity = conductivity;
    }

    public Float getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(Float turbidity) {
        this.turbidity = turbidity;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Float getDox() {
        return dox;
    }

    public void setDox(Float dox) {
        this.dox = dox;
    }

    @Override
    public String toString() {
        return "RegionData{" +
                "id=" + id +
                ", zoneId=" + zoneId +
                ", waterTemperature=" + waterTemperature +
                ", ph=" + ph +
                ", cod=" + cod +
                ", nh3=" + nh3 +
                ", dox=" + dox +
                ", conductivity=" + conductivity +
                ", turbidity=" + turbidity +
                ", sendTime=" + sendTime +
                '}';
    }
}
