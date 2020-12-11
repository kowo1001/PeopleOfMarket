package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.domain.Product;

public class ProductDAO {
	//create
	public static Product createProduct(int productNo, String productName, int price, EntityManager em )throws SQLException {
		EntityTransaction tx = em.getTransaction();	
		Product p = null;

		tx.begin();
		p = Product.builder().productNo(productNo).productName(productName).price(price).build();
		em.persist(p);
		tx.commit();
		return p;
	}
	//select
	public static void  findAllProduct (EntityManager em){
		List<Product> p = em.createNativeQuery("select * from Product", Product.class).getResultList();
		p.forEach(v -> System.out.println(v));
	}
	
	public static void findProduct(int productNo, EntityManager em)throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where productNo=?", Product.class).setParameter(1, productNo).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		} ;
	}
	
	public static void findProduct(String productName, EntityManager em)throws SQLException {
		List<Product> p = em.createNativeQuery("select * from Product where productName=?", Product.class).setParameter(1, productName).getResultList();
		p.forEach(v -> System.out.println(v));
		if (p.size() == 0) {
			System.out.println("검색 요청한 제품은 미존재합니다");
		} ;
	}
	
	//update
	public static void updateProduct(String productName, int price, EntityManager em) {
		int result = em.createNativeQuery("update product set productName = ? where productNo = ?", Product.class).setParameter(1, productName).executeUpdate();
		if(result !=0) {
			System.out.println("---업데이트 완료---");
		}else {
			System.out.println("---업데이트 실패---");
		}
	}	
	
	//delete
	public static void deleteProduct(int productNo, EntityManager em) {
			int result = em.createNativeQuery("delete from Product where productNo=?", Product.class).setParameter(1,productNo).executeUpdate(); 
			if(result !=0) {
				System.out.println("--- 삭제 완료---");
			}else {
				System.out.println("--- 삭제 실패---");
			}
	}
	
}