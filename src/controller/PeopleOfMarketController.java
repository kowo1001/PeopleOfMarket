package controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.dao.MartDAO;
import model.dao.OrdersDAO;

import model.dao.ProductDAO;
import model.domain.Mart;
import model.domain.Orders;
import model.domain.Product;
import model.util.PublicCommon;
import view.RunningEndView;

public class PeopleOfMarketController {
	
	public static void addMart(String martName, String location) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			Mart m = MartDAO.addMart(martName, location, em);
			RunningEndView.allView(m);
		} catch (Exception e) {
			RunningEndView.showError("오류"); 
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void findAllMart() {

		EntityManager em = PublicCommon.getEntityManager();
		try {
			MartDAO.findAll(em).forEach(m -> RunningEndView.allView(m));
		} catch (NoResultException ne) {
			RunningEndView.showError("마트 정보가 없습니다.");
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void findMart(String martName) {

		EntityManager em = PublicCommon.getEntityManager();
		try {
			MartDAO.findMart(martName, em).forEach(m -> RunningEndView.allView(m));
		} catch (NoResultException e) {
			RunningEndView.showError("없는 마트입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void updateMart(int martNumber, String martName, String location) {
		EntityManager em = PublicCommon.getEntityManager();

		try {
			if (MartDAO.updateMart(martNumber, martName, location, em)) {
				RunningEndView.showMessage("수정 성공");
			} else {
				RunningEndView.showError("수정 실패");
			}
		} catch (NoResultException e) {
			RunningEndView.showError("없는 마트입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void deleteMart(int martNumber) {
		EntityManager em = PublicCommon.getEntityManager();

		try {
			if (MartDAO.deleteMart(martNumber, em)) {
				RunningEndView.showMessage("삭제성공");
			} else {
				RunningEndView.showError("삭제실패");
			}
		} catch (NoResultException e) {
			RunningEndView.showError("없는 마트입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void getMartOrders(int martNumber) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			MartDAO.getOrders(martNumber, em).forEach(m -> RunningEndView.allView(m));
		} catch (NoResultException e) {
			RunningEndView.showError("없는 마트입니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}
	
	public static void addProduct(int productNo, String productName, int price) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			ProductDAO.createProduct(productNo, productName, price, em);
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void findAllProduct() {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			ProductDAO.findAllProduct(em);
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void findProduct(String productName) {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			ProductDAO.findProduct(productName, em);
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void updateProduct(int productNo, String productName, int price) {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			ProductDAO.updateProduct(productName, price, productNo, em);
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void deleteProduct(int productNo) {
		EntityManager em = PublicCommon.getEntityManager();

		try {
			ProductDAO.deleteProduct(productNo, em);
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
		
	public static void getProductOrders(int productNumber) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			ProductDAO.getOrders(productNumber, em).forEach(m -> RunningEndView.allView(m));
		} catch (NoResultException e) {
			RunningEndView.showError("없는 마트입니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}
	
	public static void addOrders(int martNumber, int productNumber, int amount, String pickupDate, String pickupTime, char ispickup) {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			Product p = ProductDAO.findProduct(productNumber, em);
			Orders o = OrdersDAO.createOrder(MartDAO.findMart(martNumber, em), p, amount, p.getPrice()*amount, pickupDate, pickupTime, ispickup, em);
			RunningEndView.allView(o);
		} catch (NoResultException e) {
			RunningEndView.showError("없는 주문입니다..");
			e.printStackTrace();
		} catch (SQLException e) {
			RunningEndView.showError("오류");
 			e.printStackTrace();
		}
	}
}