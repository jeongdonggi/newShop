package jpashop.newshop.Domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class BpAddress {

    private String bp_addr_1;
    private String bp_addr_2;
    private String bp_zipcode;

    protected BpAddress(){}

    public BpAddress(String bp_addr_1, String bp_addr_2, String bp_zipcode) {
        this.bp_addr_1 = bp_addr_1;
        this.bp_addr_2 = bp_addr_2;
        this.bp_zipcode = bp_zipcode;
    }
}
