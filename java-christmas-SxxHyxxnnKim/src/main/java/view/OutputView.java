package view;

import domain.Menu;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void showWhatEventsOnVisitedDay(int visitDate) {
        System.out.println("12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void showWhatOrderedMenu(List<Menu> orderedMenu) {
        System.out.println("<주문 메뉴>");
        for (Menu menu : orderedMenu) {
            System.out.println(menu.getMenuName() + " " + menu.getOrderCount() + "개");
        }
        System.out.println();
    }

    public void showHowMuchTotalPriceBeforeSale(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        if (totalPrice > 0) {
            System.out.println(totalPrice + "원");
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void showCanGetFreeChampagne(boolean getFreeChampagne) {
        System.out.println("<증정메뉴>");
        if (getFreeChampagne) {
            System.out.println("샴페인 1개");
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void showSaleEventUserGot(Map<String, Integer> saleEvent) {
        System.out.println("<혜택 내역>");
        if (!saleEvent.isEmpty()) {
            for (Map.Entry<String, Integer> event : saleEvent.entrySet()) {
                System.out.println(event.getKey() + ": -" + event.getValue() + "원");
            }
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void showHowMuchTotalSalePrice(int totalSalePrice) {
        System.out.println("<총혜택 금액>");
        if (totalSalePrice > 0) {
            System.out.println("-" + totalSalePrice + "원");
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void showHowMuchTotalPriceAfterSale(int totalPriceToPay) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println("-" + totalPriceToPay + "원");
        System.out.println();
    }

    public void showUserGetWhatBadge(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }
}
