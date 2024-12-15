package jpashop.newshop.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
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

//    @Column(unique = true, nullable = false)
    private String userNm;

    @Column(unique = true, nullable = false)
    private String password;

//    @Column(unique = true, nullable = false)
    private String Email;

    private String Role;

    @Embedded
    private Address address;

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

    private LocalDateTime lastLoginDttm;

    public void addIdPw(String id, String password) {
        this.id = id;
        this.password = password;
        this.Role = UserRole.USER.getKey();
    }

}
