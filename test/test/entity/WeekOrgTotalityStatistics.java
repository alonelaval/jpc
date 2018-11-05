package com.alonelaval.entity;

import javax.persistence.*;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;  
import java.time.LocalDateTime;  

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_week_org_totality_statistics")
public class WeekOrgTotalityStatistics {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "wots_id")
    private Integer wotsId;  
    @Column(name = "org_id")
    private Integer orgId;  
    @Column(name = "org_name")
    private String orgName;  
    @Column(name = "org_count")
    private Integer orgCount;  
    @Column(name = "sale_amount")
    private Integer saleAmount;  
    @Column(name = "teacher_count")
    private Integer teacherCount;  
    @Column(name = "course_count")
    private Integer courseCount;  
    @Column(name = "total_user_count")
    private Integer totalUserCount;  
    @Column(name = "current_service_user_count")
    private Integer currentServiceUserCount;  
    @Column(name = "buy_user_count")
    private Integer buyUserCount;  
    @Column(name = "like_user_count")
    private Integer likeUserCount;  
    @Column(name = "cancel_order_user_count")
    private Integer cancelOrderUserCount;  
    @Column(name = "order_count")
    private Integer orderCount;  
    @Column(name = "cancel_order_count")
    private Integer cancelOrderCount;  
    @Column(name = "pv_count")
    private Integer pvCount;  
    @Column(name = "uv_count")
    private Integer uvCount;  
    @Column(name = "user_exponent")
    private Integer userExponent;  
    @Column(name = "class_count")
    private Integer classCount;  
    @Column(name = "place_count")
    private Integer placeCount;  
    @Column(name = "week_date")
    private LocalDate weekDate;  
    @Column(name = "state")
    private Byte state;  
    @Column(name = "create_time")
    private LocalDateTime createTime;  
    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;  
	
}