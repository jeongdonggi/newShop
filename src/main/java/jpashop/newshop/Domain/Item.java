package jpashop.newshop.Domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ITEM")
@EntityListeners(AuditingEntityListener.class)
public class Item {
    @Id
    @Column(name = "item_id")
    private String itemId;

    private String itemNm;

    private Long price;

    private Long stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<Item> items;

    // Category
    @Enumerated(EnumType.STRING)
    private Category category;


    @CreatedDate
    private LocalDateTime rgsnDttm;

    private String rgsnNm;

    @LastModifiedDate
    private LocalDateTime modiDttm;

    private String modiNm;

}
