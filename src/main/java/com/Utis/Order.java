package com.Utis;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "payment_method", nullable = false, length = 20)
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dispatcher", nullable = false)
    private Dispatcher idDispatcher;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_electrician", nullable = false)
    private Electrician idElectrician;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer idCustomer;

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Electrician getIdElectrician() {
        return idElectrician;
    }

    public void setIdElectrician(Electrician idElectrician) {
        this.idElectrician = idElectrician;
    }

    public Dispatcher getIdDispatcher() {
        return idDispatcher;
    }

    public void setIdDispatcher(Dispatcher idDispatcher) {
        this.idDispatcher = idDispatcher;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

