package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 报警数据统计的实体类
 *
 * @ author: SongWenjing
 * @ Date 2020/5/3 9:10
 */
public class WarnMessage {
    private Integer id;
    private Integer zoneId;
    private Integer rank;
    private String messageCode;
    private String message;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

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


    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WarnMessage{" +
                "id=" + id +
                ", zoneId=" + zoneId +
                ", rank=" + rank +
                ", messageCode='" + messageCode + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
