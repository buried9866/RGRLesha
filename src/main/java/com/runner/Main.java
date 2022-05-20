package com.runner;

import com.Utis.Customer;
import com.Utis.NewHibernateUtil;
import com.Utis.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        List<Customer> customers = s.createQuery("from Customer c").list();
        for (Customer customer : customers) {
            System.out.println(customer.getSurname() + " " + customer.getName() + " " + customer.getPatronymic() +
                    "; " + customer.getPhoneNumber() + "; " + customer.getAddress());
        }
        t.commit();


        Transaction t1 = s.beginTransaction();
        Query query = s.createQuery("from Order o where o.status = :status");
        query.setParameter("status", "Выполняется");
        List<Order> orders = query.list();
        for (Order order : orders) {
            System.out.println("Статус: " +order.getStatus() + "; " + "Способ оплаты: " +order.getPaymentMethod() + "; Клиент: "
                    + order.getIdCustomer().getFullName() + "; Диспетчер: " + order.getIdDispatcher().getFullName()
                    + "; Электрик: " + order.getIdElectrician().getFullName());
        }
        t1.commit();


        s.close();
        sf.close();
    }

}
