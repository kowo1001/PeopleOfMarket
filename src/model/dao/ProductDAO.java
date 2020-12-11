package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Mart;
import model.domain.Product;
import model.util.PublicCommon;

public class ProductDAO {
	// create
	public static Product createProduct(int productNo, String productName, int price, EntityManager em)
			throws SQLException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product p = null;
		p = Product.builder().productNo(productNo).productName(productName).price(price).build();
		em.persist(p);
		return p;
	}

	// select
	public static void findAllProduct(EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product", Product.class).getResultList();
		p.forEach(v -> System.out.println(v));
	}

	public static void findProduct(int productNo, EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pno=?", Product.class)
				.setParameter(1, productNo).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		}
	}

	public static void findProduct(String productName, EntityManager em) throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pname=?", Product.class)
				.setParameter(1, productName).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		}
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
}