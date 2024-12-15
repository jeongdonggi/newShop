package jpashop.newshop.Domain;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="ORDER_ITEM")
@EntityListeners(AuditingEntityListener.class)
public class OrderItem {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_no")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private Long orderPrice;

    private int cnt;

    public void setOrder(Order order) {
        this.order = order;
    }
}
