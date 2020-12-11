package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Product;
import model.util.PublicCommon;


public class ProductDAO {
	//create
	public static Product createProduct(int productNo, String productName, int price, EntityManager em ){
		Product p = null;
		p = Product.builder().productNo(productNo).productName(productName).price(price).build();
		em.persist(p);
		return p;
	}
	//select
	public static void  findAllProduct (EntityManager em){
		List<Product> p = em.createNativeQuery("select * from Product", Product.class).getResultList();
		p.forEach(v -> System.out.println(v));
	}
	
	public static void findProduct(int productNo, EntityManager em)throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pno=?", Product.class).setParameter(1, productNo).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		} ;
	}
	
	public static void findProduct(String productName, EntityManager em)throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where pname=?", Product.class).setParameter(1, productName).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		} ;
	}
	
	//update
	public static void updateProduct(String productName, int price, int productNo, EntityManager em) throws SQLException{
		int result = em.createNativeQuery("update product set pname = ?, price = ? where pno = ?", Product.class).setParameter(1, productName).setParameter(2, price).setParameter(3, productNo).executeUpdate();
		if(result !=0) {
			System.out.println("---업데이트 완료---");
		}else {
			System.out.println("---업데이트 실패---");
		}
	}	
	
	//delete
	public static void deleteProduct(int productNo, EntityManager em)throws SQLException {
			int result = em.createNativeQuery("delete from Product where pno=?", Product.class).setParameter(1,productNo).executeUpdate(); 
			if(result !=0) {
				System.out.println("--- 삭제 완료---");
			}else {
				System.out.println("--- 삭제 실패---");
			}
	}
	
	
	@Test
	public void runningTest() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			int newNo = 123;
			System.out.println("---------------select all------------");
			findAllProduct(em);
			System.out.println("---------------create---------------");
			createProduct(newNo, "하하", 1500, em);
			em.flush();
			em.clear();
			System.out.println("---------------select one---------------");
			findProduct(newNo, em);
			System.out.println("---------------update pname, price---------------");
			updateProduct("호호", 5000, newNo, em);
			findProduct("호호", em);
			System.out.println("---------------delete---------------");
			deleteProduct(newNo,em);
			findProduct(newNo, em);
			System.out.println("---------------end---------------");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
}