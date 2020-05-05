package com.example.entity;

import java.util.Date;

/**
 * 增加短信发送的实体类
 *
 * @ author: SongWenjing
 * @ Date 2020/5/4 16:12
 */
public class TextMessaging {
    private Integer id;
    private Integer eventId;
    private Integer zoneId;
    private Integer rank;
    private String sendPhone;
    private String email;
    private Integer status;
    private String remark;
    private Date sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TextMessaging{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", zoneId=" + zoneId +
                ", rank=" + rank +
                ", sendPhone='" + sendPhone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
