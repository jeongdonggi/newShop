package jpashop.newshop.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "SHPN")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Shpn {
    @Id
    @Column(name = "shpn_id")
    private String shpnNo;

    //order
    @OneToOne(mappedBy = "shpn")
    private Order order;

    @Enumerated(EnumType.STRING)
    private Status status; // enum

    @CreatedDate
    private LocalDateTime rgstDttm;

    private String rgstNm;

    @LastModifiedDate
    private LocalDateTime modiDttm;

    private String modiNm;

    public void setOrder(Order order) {
        this.order = order;
    }
}
