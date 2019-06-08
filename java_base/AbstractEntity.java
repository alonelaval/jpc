package com.okycz.panasonic.base;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-07
 **/
//@Data

@MappedSuperclass
@Data
public abstract class AbstractEntity implements IEntity, Serializable {


    private static Logger logger = LoggerFactory.getLogger(AbstractEntity.class);
    @Column(name="status")
    protected Status status;
    @Column(name="create_time")
    protected LocalDateTime createTime;
    @Column(name="last_update_time")
    protected LocalDateTime lastUpdateTime;
    @Override
    public IEnum getStatus() {
        return status;
    }
    @Override
    public void setStatus(IEnum state) {
        this.status = (Status) state;
    }



}