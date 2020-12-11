package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;

import model.domain.Mart;
<<<<<<< HEAD
import model.util.PublicCommon;
=======
import model.domain.Orders;
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4

public class MartDAO {

	public static Mart addMart(String martName, String location, EntityManager em) throws SQLException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Mart m = Mart.builder().martName(martName).location(location).orders(new ArrayList<>()).build();
		em.persist(m);
		tx.commit();
		return m;
	}

	public static List<Mart> findAll(EntityManager em) throws SQLException, NoResultException {
		List<Mart> m = em.createNativeQuery("select * from mart", Mart.class).getResultList();
		if (m.size() == 0) {
			throw new NoResultException();
		}
		return m;
	}

	public static Mart findMart(int martNumber, EntityManager em) throws SQLException, NoResultException {
		Mart m = (Mart) em.createNativeQuery("select * from mart where mtno= ?", Mart.class).setParameter(1, martNumber)
				.getSingleResult();
		if (m == null) {
			throw new NoResultException();
		}
		return m;
	}

	public static List<Mart> findMart(String martName, EntityManager em) throws SQLException, NoResultException {
		List<Mart> m = em.createNativeQuery("select * from Mart where mtname= ?", Mart.class).setParameter(1, martName)
				.getResultList();
		if (m.size() == 0) {
			throw new NoResultException();
		}
		return m;
	}

	public static boolean updateMart(int martNumber, String martName, String location, EntityManager em)
			throws SQLException, NoResultException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Mart m = findMart(martNumber, em);
		if (m != null) {
			m.setMartName(martName);
			m.setLocation(location);
			tx.commit();
			return true;
		}
		return false;
	}

	public static boolean deleteMart(int martNumber, EntityManager em) throws SQLException, NoResultException {
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Mart m = findMart(martNumber, em);
		if (m != null) {
			em.remove(m);
			tx.commit();
			return true;
		}
		return false;
	}
	
<<<<<<< HEAD
  @Test
  public void test() {
      EntityManager em = PublicCommon.getEntityManager();
      try {
            Mart m = addMart("롯데마트", "마포구",em);
            System.out.println(m);
            System.out.println("----------------------------------");
          
      }catch(Exception e) {
          e.printStackTrace();
      }finally {
          em.close();
      }
  }
    
=======
	public static List<Orders> getOrders(int martNumber, EntityManager em) throws SQLException, NoResultException {
		Mart m = findMart(martNumber, em);
		return m.getOrders();
	}
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
}
