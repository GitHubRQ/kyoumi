package com.aikon.wht.entity;

import java.util.Date;

public class MidIndividualIndividual {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer creatorId;

    private String memo;

    private Integer status;

    private Integer watcherId;

    private Integer watchedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWatcherId() {
        return watcherId;
    }

    public void setWatcherId(Integer watcherId) {
        this.watcherId = watcherId;
    }

    public Integer getWatchedId() {
        return watchedId;
    }

    public void setWatchedId(Integer watchedId) {
        this.watchedId = watchedId;
    }
}