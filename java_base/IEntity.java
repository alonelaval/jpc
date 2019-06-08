package com.okycz.panasonic.base;



import java.time.LocalDateTime;

/**
 * @author
 * @create 2018-07-07
 **/
public interface IEntity {


    String getId();

    IEnum getStatus();
    void setStatus(IEnum state);
    LocalDateTime getCreateTime();
    void setCreateTime(LocalDateTime localDate);

    LocalDateTime getLastUpdateTime();

    void setLastUpdateTime(LocalDateTime localDate);
}
