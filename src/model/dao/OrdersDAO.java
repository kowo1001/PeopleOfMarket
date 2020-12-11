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
  public static Orders createOrder(Mart m, Product p, int amount, int totalPrice, String pickupDate, String pickupTime, char ispickup, EntityManager em) throws SQLException {
      EntityTransaction tx = em.getTransaction();
      Orders o = null;
      
      tx.begin();
      o = Orders.builder().martNumber(m).productNumber(p).amount(amount).totalPrice(totalPrice).pickupDate(pickupDate).pickupTime(pickupTime).ispickup(ispickup).build();
      em.persist(o);
      tx.commit();
      return o;
  }

	public static List<Orders> findAll(EntityManager em) throws SQLException, NoResultException {
		List<Orders> o = em.createNativeQuery("select * from orders", Orders.class).getResultList();
		return o;
	}

	public static Orders findOrdersByOrderId(int orderId, EntityManager em) throws SQLException, NoResultException {
		Orders o = (Orders) em.createNativeQuery("select * from orders where ono=?", Orders.class)
				.setParameter(1, orderId).getSingleResult();
		return o;
	}

	public static Orders findOrdersByOrderNumber(int orderNumber, EntityManager em)
			throws SQLException, NoResultException {
		Orders o = (Orders) em.createNativeQuery("select * from orders where ono=?", Orders.class)
				.setParameter(1, orderNumber).getSingleResult();
		return o;
	}

	public static boolean updateOrders(int orderId, String pickupDate, String pickupTime, EntityManager em)
			throws NoResultException {
		boolean result = false;
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int updatedCount = em.createNativeQuery("update orders set pdate = ?, ptime = ? where oid = ?", Orders.class)
				.setParameter(1, pickupDate).setParameter(2, pickupTime).setParameter(3,orderId).executeUpdate();
		tx.commit();
		if(updatedCount!=0) {
			result = true;
			return result;
		}else {
			throw new NoResultException();
		}
	}
	
	public static boolean deleteOrder(int orderId, EntityManager em) throws NoResultException{
		boolean result = false;
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int deletedCount = em.createNativeQuery("delete from orders where oid = ?", Orders.class)
				.setParameter(1,orderId).executeUpdate();
		tx.commit();
		if(deletedCount != 0) {
			result =true;
			return result;
		}else {
			throw new NoResultException();
		}
	}
}

