package jpashop.newshop.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDER")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @Column(name = "order_no")
    private String orderNo;

    // orderlist
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    // user
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_no")
    private User user;

    // shpn
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shpn_id")
    private Shpn shpn;

    @Enumerated(EnumType.STRING)
    private Status orderStatus;

    @CreatedDate
    private LocalDateTime rgstDttm;

    private String rgstNm;

    @LastModifiedDate
    private LocalDateTime modiDttm;

    private String modiNm;

    /**
     * @param user
     * 연관관계 매핑
     */
    public void setUser(User user){
        this.user = user; // user 설정 후
        user.getOrders().add(this); // user에 order 연결
    }

    /**
     * @param shpn
     * 연관관계 매핑
     */
    public void setShpn(Shpn shpn){
        this.shpn = shpn;
        shpn.setOrder(this);
    }

    public void setOrderItems(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}


