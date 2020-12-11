package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import model.domain.Mart;
import model.domain.Orders;
import model.domain.Product;

import model.util.PublicCommon;

public class ProductDAO {
	// create
	public static Product createProduct(String productName, int price, EntityManager em)
			throws SQLException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product p = Product.builder().productName(productName).price(price).orders(new ArrayList<>()).build();
		em.persist(p);
		tx.commit();
		return p;
	}

	// select
	public static List<Product> findAllProduct(EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product", Product.class).getResultList();
		if(p.size() == 0) {
			throw new NoResultException();
		}
		return p;
	}

	public static Product findProduct(int productNo, EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pno=?", Product.class)
				.setParameter(1, productNo).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		}

		return p.get(0);
	}

	public static List<Product> findProduct(String productName, EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pname=?", Product.class)
				.setParameter(1, productName).getResultList();
		if (p.size() == 0) {
			throw new NoResultException();
		}
		return p;
	}

	// update
	public static boolean updateProduct(String productName, int price, int productNo, EntityManager em)
			throws SQLException {
		boolean result = false;
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int updatedCount = em.createNativeQuery("update product set pname = ?, price = ? where pno = ?", Product.class)
				.setParameter(1, productName).setParameter(2, price).setParameter(3, productNo).executeUpdate();
		tx.commit();
		if(updatedCount!=0) {
			result = true;
			return result;
		}else {
			throw new NoResultException();
		}
	}

	// delete
	public static boolean deleteProduct(int productNo, EntityManager em) throws SQLException {
		boolean result = false;
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int deletedCount = em.createNativeQuery("delete from Product where pno=?", Product.class).setParameter(1, productNo)
				.executeUpdate();
		tx.commit();
		if (deletedCount != 0) {
			result = true;
			return result;
		} else {
			throw new NoResultException();
		}
	}
	
	public static List<Orders> getOrders(int productNo, EntityManager em) throws SQLException, NoResultException {
		Product p = (Product)em.createNativeQuery("select * from Product where pno=?", Product.class)
				.setParameter(1, productNo).getSingleResult();
		return p.getOrders();
	}
}