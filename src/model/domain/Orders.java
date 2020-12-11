package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@SequenceGenerator(name="orders_id_seq_gen", sequenceName="orders_id_seq", initialValue=1, allocationSize=50)
public class Orders {
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orders_id_seq_gen")
    @Id
    @Column(name="oid", nullable=false, precision=10)
    int orderId;//일련번호
    
    @Column(name="ono", nullable=false, precision=10)
    int orderNumber;//주문번호
    
    @ManyToOne
    @JoinColumn(name="mtno")
    Mart martNumber;//마트번호
    
    @ManyToOne
    @JoinColumn(name="pno")
    Product productNumber;//상품번호
    
    @Column(name="amount",nullable=false, precision=10)
    int amount;//수량
    
    @Column(name="totalprice",nullable=false, precision=10)
    int totalPrice;//가격
    
    @Column(name="pdate",nullable=false, length=40)
    String pickupDate;//pickup날짜
    
    @Column(name="ptime",nullable=false, length=40)
    String pickupTime;//pickup시간
    
    @Column(name="ispickup",nullable=false, length=1)
    char ispickup;//pickup여부
}
