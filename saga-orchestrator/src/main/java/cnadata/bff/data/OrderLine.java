package cnadata.bff.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="orderline")
public class OrderLine {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private int quantity;
    private BigDecimal totalPrice;

    /*
     * 기본은 PurchaseOrder와 OrderLine 연결 시 PurchaseOrder에서 @OneToMany만 설정하면 된다.
     * 그러나 여기서 @ManyToOne으로 설정한 이유는 OrderLine 별도로 읽을때 이용할 수 있도록 설정한다.
     * 기본ㄷ은 @ManyToOne을 설정할 필요가 없다.
     * 만약 설정 시 에는 insertable=false, updatable=false로 설정해야 한다.

    @ManyToOne
    @JoinColumn(name = "purchase_order_id", insertable = false, updatable = false)
    private PurchaseOrder purchaseOrder;
*/

    @Enumerated (EnumType.STRING)
    private OrderLineStatus status;

    private String sagaStatus;

    public OrderLine(String item, int quantity, BigDecimal totalPrice) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = OrderLineStatus.ENTERED;
    }
}
