package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import model.domain.Mart;
=======
import model.domain.Mart;
import model.domain.Orders;
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
import model.domain.Product;
import model.util.PublicCommon;

public class ProductDAO {
	// create
	public static Product createProduct(int productNo, String productName, int price, EntityManager em)
			throws SQLException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product p = null;
<<<<<<< HEAD
		p = Product.builder().productNo(productNo).productName(productName).price(price).build();
=======
		p = Product.builder().productNo(productNo).productName(productName).price(price).orders(new ArrayList<>()).build();
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
		em.persist(p);
		return p;
	}

	// select
	public static void findAllProduct(EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product", Product.class).getResultList();
		p.forEach(v -> System.out.println(v));
	}

<<<<<<< HEAD
	public static void findProduct(int productNo, EntityManager em) throws SQLException {
=======
	public static Product findProduct(int productNo, EntityManager em) throws SQLException {
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
		List<Product> p = em.createNativeQuery("select * from Product where pno=?", Product.class)
				.setParameter(1, productNo).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		}
<<<<<<< HEAD
=======
		return p.get(0);
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
	}

	public static void findProduct(String productName, EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pname=?", Product.class)
				.setParameter(1, productName).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		}
<<<<<<< HEAD
=======
		;
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
	}

	// update
	public static void updateProduct(String productName, int price, int productNo, EntityManager em)
			throws SQLException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int result = em.createNativeQuery("update product set pname = ?, price = ? where pno = ?", Product.class)
				.setParameter(1, productName).setParameter(2, price).setParameter(3, productNo).executeUpdate();
		if (result != 0) {
			System.out.println("---업데이트 완료---");
		} else {
			System.out.println("---업데이트 실패---");
		}
		tx.commit();
	}

	// delete
	public static void deleteProduct(int productNo, EntityManager em) throws SQLException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int result = em.createNativeQuery("delete from Product where pno=?", Product.class).setParameter(1, productNo)
				.executeUpdate();
		if (result != 0) {
			System.out.println("--- 삭제 완료---");
		} else {
			System.out.println("--- 삭제 실패---");
		}
		tx.commit();
	}
	
<<<<<<< HEAD
	  @Test
	  public void test() {
	      EntityManager em = PublicCommon.getEntityManager();
	      try {
	    	  	Product p = createProduct(1, "백산수", 3000, em);
	            System.out.println(p);
	            System.out.println("----------------------------------");
	          
	      }catch(Exception e) {
	          e.printStackTrace();
	      }finally {
	          em.close();
	      }
	  }
=======
	public static List<Orders> getOrders(int productNo, EntityManager em) throws SQLException, NoResultException {
		Product p = (Product)em.createNativeQuery("select * from Product where pno=?", Product.class)
				.setParameter(1, productNo).getSingleResult();
		return p.getOrders();
	}
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
}