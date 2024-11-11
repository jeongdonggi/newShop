package jpashop.newshop.Domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class BpAddress {

    private String addr_1;
    private String addr_2;
    private String zipcode;

    protected BpAddress(){}

    public BpAddress(String addr_1, String addr_2, String zipcode) {
        this.addr_1 = addr_1;
        this.addr_2 = addr_2;
        this.zipcode = zipcode;
    }
}
