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
			RunningEndView.showError("마트 정보가 존재하지 않습니다.");
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
			RunningEndView.showError("존재하지 않는 마트입니다.");
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
			RunningEndView.showError("존재하지 않는 마트입니다.");
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
			RunningEndView.showError("존재하지 않는 마트입니다.");
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
			RunningEndView.showError("존재하지 않는 마트입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}
	
	public static void getMartOrdersByProNum(int martNumber) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			MartDAO.getOrders(martNumber, em).forEach(m -> RunningEndView.allView(m));
		} catch (NoResultException e) {
			RunningEndView.showError("존재하지 않는 마트입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}
	
	public static void addProduct(String productName, int price) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			Product p = ProductDAO.createProduct(productName, price, em);
			RunningEndView.allView(p);
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void findAllProduct() {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			ProductDAO.findAllProduct(em).forEach(v->RunningEndView.allView(v));
		}catch(NoResultException e) {
			RunningEndView.showError("상품 정보가 존재하지 않습니다.");
		}catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void findProduct(String productName) {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			ProductDAO.findProduct(productName, em).forEach(v->RunningEndView.allView(v));
		}catch(NoResultException e) {
			RunningEndView.showError("존재하지 않는 상품입니다.");
			e.printStackTrace();
		}catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void updateProduct(int productNo, String productName, int price) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			if(ProductDAO.updateProduct(productName, price, productNo, em)) {
				RunningEndView.showMessage("수정 성공");
			}else {
				RunningEndView.showError("수정 실패");
			}
		}catch(NoResultException e) {
			RunningEndView.showError("존재하지 않는 상품입니다.");
			e.printStackTrace();
		}catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void deleteProduct(int productNo) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			if(ProductDAO.deleteProduct(productNo, em)) {
				RunningEndView.showMessage("삭제 성공");
			}else {
				RunningEndView.showError("삭제 실패");
			}
		}catch(NoResultException e) {
			RunningEndView.showError("존재하지 않는 상품입니다.");
			e.printStackTrace();
		}catch (Exception e) {
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
			RunningEndView.showError("존재하지 않는 마트입니다.");
			e.printStackTrace();
		} catch (Exception e) {
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
			RunningEndView.showError("존재하지 않는 주문입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			RunningEndView.showError("오류");
 			e.printStackTrace();
		}
	}
	
	public static void findAllOrders() {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			OrdersDAO.findAll(em).forEach(v->RunningEndView.allView(v));
		}catch(NoResultException e) {
			RunningEndView.showError("주문 정보가 존재하지 않습니다.");
		}catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void updateOrders(int orderId, String pickupDate, String pickupTime) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			if(OrdersDAO.updateOrders(orderId, pickupDate, pickupTime, em)) {
				RunningEndView.showMessage("수정 성공");
			}else {
				RunningEndView.showError("수정 실패");
			}
		}catch(NoResultException e) {
			RunningEndView.showError("존재하지 않는 주문입니다.");
			e.printStackTrace();
		}catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void deleteOrder(int orderId) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			if(OrdersDAO.deleteOrder(orderId, em)) {
				RunningEndView.showMessage("삭제 성공");
			}else {
				RunningEndView.showError("삭제 실패");
			}
		}catch(NoResultException e) {
			RunningEndView.showError("존재하지 않는 상품입니다.");
			e.printStackTrace();
		}catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}	
}