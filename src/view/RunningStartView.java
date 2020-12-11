package view;

import controller.PeopleOfMarketController;

public class RunningStartView {
	public static void main(String[] args) {
		System.out.println("---------------------------");
		System.out.println("마트 추가");
		PeopleOfMarketController.addMart("GS마트", "마포구");
		PeopleOfMarketController.addMart("eMart", "용산구");
		PeopleOfMarketController.addMart("롯데마트", "서초구");
		PeopleOfMarketController.addMart("하나로마트", "성동구");
		PeopleOfMarketController.addMart("홈플러스", "강서구");

		System.out.println("---------------------------");
		System.out.println("마트 검색");
		System.out.println("마트 전체 검색");
		PeopleOfMarketController.findAllMart();
		System.out.println();
		System.out.println("GS마트 검색");
		PeopleOfMarketController.findMart("GS마트");

		System.out.println("---------------------------");
		System.out.println("마트 수정");
		PeopleOfMarketController.updateMart(1, "레몬마트", "마포구");
		PeopleOfMarketController.findAllMart();

		System.out.println("---------------------------");
		System.out.println("마트 삭제");
		PeopleOfMarketController.deleteMart(1);
		PeopleOfMarketController.findMart("레몬마트");

		System.out.println("---------------------------");
		System.out.println("물건 추가");
		PeopleOfMarketController.addProduct(1, "백산수1L", 1200);
		PeopleOfMarketController.addProduct(2, "에비앙1L", 10000);
		PeopleOfMarketController.addProduct(3, "삼다수1L", 1400);
		PeopleOfMarketController.addProduct(4, "몽쉘통통12개입", 3000);
		PeopleOfMarketController.addProduct(5, "초코파이12개입", 3000);
		PeopleOfMarketController.addProduct(6, "콘푸라이트", 4000);
		PeopleOfMarketController.addProduct(7, "오곡코코볼", 4000);
		PeopleOfMarketController.addProduct(8, "바나나", 3000);
		PeopleOfMarketController.addProduct(9, "벗겨먹는고오스", 800);

		System.out.println("---------------------------");
		System.out.println("물건 검색");
		System.out.println("물건 전체 검색");
		PeopleOfMarketController.findAllProduct();
		System.out.println();
		System.out.println("벗겨먹는고오스 검색");
		PeopleOfMarketController.findProduct("벗겨먹는고오스");

		System.out.println("---------------------------");
		System.out.println("물건 수정");
		PeopleOfMarketController.updateProduct(8, "사과", 1500);
		PeopleOfMarketController.findAllProduct();

		System.out.println("---------------------------");
		System.out.println("물건 삭제");
		PeopleOfMarketController.deleteProduct(8);
		PeopleOfMarketController.findAllProduct();
		
		System.out.println("---------------------------");
<<<<<<< HEAD
		System.out.println("물건 추가");
		PeopleOfMarketController.addProduct(1, "백산수1L", 1200);
		PeopleOfMarketController.addProduct(2, "에비앙1L", 10000);
		PeopleOfMarketController.addProduct(3, "삼다수1L", 1400);
		PeopleOfMarketController.addProduct(4, "몽쉘통통12개입", 3000);
		PeopleOfMarketController.addProduct(5, "초코파이12개입", 3000);
		PeopleOfMarketController.addProduct(6, "콘푸라이트", 4000);
		PeopleOfMarketController.addProduct(7, "오곡코코볼", 4000);
		PeopleOfMarketController.addProduct(8, "바나나", 3000);
		PeopleOfMarketController.addProduct(9, "벗겨먹는고오스", 800);
		
		System.out.println("---------------------------");
		System.out.println("물건 검색");
		System.out.println("물건 전체 검색");
		PeopleOfMarketController.findAllProduct();
		System.out.println();
		System.out.println("벗겨먹는고오스 검색");
		PeopleOfMarketController.findProduct("벗겨먹는고오스");
		
		System.out.println("---------------------------");
		System.out.println("물건 수정");
		PeopleOfMarketController.updateProduct(8, "사과", 1500);
		PeopleOfMarketController.findAllProduct();
		
		System.out.println("---------------------------");
		System.out.println("물건 삭제");
		PeopleOfMarketController.deleteProduct(8);
		PeopleOfMarketController.findAllProduct();
=======
		System.out.println("주문 추가");
		PeopleOfMarketController.addOrders(2, 9, 10, "20/12/05", "20/12/05", '1');
		
		PeopleOfMarketController.getMartOrders(2);
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
	}
}
