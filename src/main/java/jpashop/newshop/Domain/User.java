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
@Table(name="USER")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String userNm;

    @Embedded
    private Address adress;

    @Embedded
    private BpAddress bpAddress;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @CreatedDate
    private LocalDateTime rgstDttm;

    private String rgstNm;

    private LocalDateTime modiDttm;

    private String modiNm;

    @LastModifiedDate
    private LocalDateTime lastLoginDttm;

}
