package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import model.domain.Mart;
import model.domain.Orders;
import model.domain.Product;

public class OrdersDAO {

	private static OrdersDAO instance = new OrdersDAO();
	private OrdersDAO() {};
	public static OrdersDAO getInstance( ) {
		return instance;
	}
	
	//create
	public static Orders createOrder(int orderNumber, Mart m, Product p, int amount, int totalPrice, String pickupDate,
			String pickupTime, char ispickup, EntityManager em) throws SQLException {
		EntityTransaction tx = em.getTransaction();
		Orders o = null;

		tx.begin();
		o = Orders.builder().orderNumber(orderNumber).martNumber(m).productNumber(p).amount(amount)
				.totalPrice(totalPrice).pickupDate(pickupDate).pickupTime(pickupTime).ispickup(ispickup).build();
		em.persist(o);
		tx.commit();
		return o;
	}
	
	//read
	public static List<Orders> findAll(EntityManager em) throws SQLException, NoResultException {
		List<Orders> o = em.createNativeQuery("select * from orders", Orders.class).getResultList();
		if (o.size() != 0) {
			return o;
		}
		throw new NoResultException("주문정보가 존재하지 않습니다");
	}

	public static List<Orders> findOrdersByOrderNumber(int orderNumber, EntityManager em)
			throws SQLException, NoResultException {
		List<Orders> o = em.createNativeQuery("select * from orders where ono=?", Orders.class)
				.setParameter(1, orderNumber).getResultList();
		if(o.size() != 0) {
			return o;
		}
		throw new NoResultException("주문정보가 존재하지 않습니다");
	}
	

	//오더 넘버들의 가격들을 다 더한 total price
	public static int getTotalPriceForOrderNumber(int orderNumber, EntityManager em)
			throws SQLException, NoResultException {
		List<Orders> o = findOrdersByOrderNumber(orderNumber, em);
		int totPrice = 0;
		for (int i = 0; i < o.size(); i++) {
			totPrice += o.get(i).getTotalPrice();
		}
		return totPrice;
	}

	public static boolean updateOrders(int orderId, String pickupDate, String pickupTime, EntityManager em)
			throws SQLException, NoResultException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int updatedCount = em.createNativeQuery("update orders set pdate = ?, ptime = ? where oid = ?", Orders.class)
				.setParameter(1, pickupDate).setParameter(2, pickupTime).setParameter(3, orderId).executeUpdate();
		tx.commit();
		if(updatedCount!=0) {
			return true;
		}
		throw new NoResultException("주문정보가 존재하지 않습니다");
	}
	
	public static boolean deleteOrder(int orderId, EntityManager em) throws SQLException, NoResultException{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int deletedCount = em.createNativeQuery("delete from orders where oid = ?", Orders.class)
				.setParameter(1, orderId).executeUpdate();
		tx.commit();
		if(deletedCount != 0) {
			return true;
		}
		throw new NoResultException("주문정보가 존재하지 않습니다");
	}
	
	public static boolean deleteOrderByOno(int orderNumber, EntityManager em) throws SQLException, NoResultException{

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int deletedCount = em.createNativeQuery("delete from orders where ono = ?", Orders.class)
				.setParameter(1, orderNumber).executeUpdate();
		tx.commit();
		if(deletedCount != 0) {
			return true;
		}
		throw new NoResultException("주문정보가 존재하지 않습니다");
	}

	public static boolean endOrder(int orderNumber, EntityManager em) throws SQLException, NoResultException{

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int deletedCount = em.createNativeQuery("update orders set ispickup=0 where ono = ?", Orders.class)
				.setParameter(1, orderNumber).executeUpdate();
		tx.commit();
		if(deletedCount != 0) {
			return true;
		}
		throw new NoResultException("주문정보가 존재하지 않습니다");
	}
}
