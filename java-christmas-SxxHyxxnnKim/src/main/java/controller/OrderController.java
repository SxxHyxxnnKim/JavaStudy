package controller;

import domain.Date;
import domain.EventBadge;
import domain.Menu;
import domain.MenuList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {

    private final int D_DAY_SALE_DEFAULT_PRICE = 1000;
    private final int SALE_DEFAULT_PRICE = 2023;
    private final int FREE_CHAMPAGNE_STANDARD = 120000;
    private final int STAR_STANDARD = 5000;
    private final int TREE_STANDARD = 10000;
    private final int SANTA_STANDARD = 20000;
    private Map<String, Integer> salePrices = new HashMap<>();

    public int calculateTotalOrderPrice(List<Menu> orderedMenu) {
        int totalOrderPrice = 0;

        for (Menu menu : orderedMenu) {
            totalOrderPrice += getMenuPrice(menu.getMenuName()) * menu.getOrderCount();
        }

        return totalOrderPrice;
    }

    private int getMenuPrice(String menuName) {
        int menuPrice = 0;
        for (MenuList menu : MenuList.values()) {
            if (menu.getMenuName().equals(menuName)) {
                menuPrice = menu.getMenuPrice();
            }
        }
        return menuPrice;
    }

    public Map<String, Integer> calculateSalePrice(Date fixedDate, List<Menu> orderedMenu) {
        if (fixedDate.getDay() < 26) {
            calculateDdaySalePrice(fixedDate.getDay());
        }
        if (fixedDate.getIsWeekend()) {
            calculateWeekendSalePrice(orderedMenu);
        }
        if (fixedDate.getIsStarDay()) {
            salePrices.put("특별 할인", 1000);
        }
        if (fixedDate.getIsChristmas()) {
            isThereChristmasPastaInOrderedMenu(orderedMenu);
        }
        calculateWeekdaySalePrice(orderedMenu);
        return salePrices;
    }

    private void isThereChristmasPastaInOrderedMenu(List<Menu> orderedMenu) {
        int christmasSpecialMenuSale = 0;

        for (Menu menu : orderedMenu) {
            String menuName = menu.getMenuName();
            if (menuName.equals(MenuList.CHRISTMAS_PASTA.getMenuName())) {
                christmasSpecialMenuSale += SALE_DEFAULT_PRICE * menu.getOrderCount();
            }
        }
        if (christmasSpecialMenuSale > 0) {
            salePrices.put("크리스마스 특별 메뉴 할인", christmasSpecialMenuSale);
        }
    }

    private void calculateWeekdaySalePrice(List<Menu> orderedMenu) {
        int salePriceWeekday = 0;
        for (Menu menu : orderedMenu) {
            String menuName = menu.getMenuName();
            if (menuName.equals(MenuList.CAKE.getMenuName()) ||
                    menuName.equals(MenuList.ICECREAM.getMenuName())) {
                salePriceWeekday += SALE_DEFAULT_PRICE * menu.getOrderCount();
            }
        }
        if (salePriceWeekday != 0) {
            salePrices.put("평일 할인", salePriceWeekday);
        }
    }

    private void calculateWeekendSalePrice(List<Menu> orderedMenu) {
        int salePriceWeekend = 0;
        for (Menu menu : orderedMenu) {
            String menuName = menu.getMenuName();
            if (menuName.equals(MenuList.STEAK.getMenuName()) || menuName.equals(MenuList.BARBECUE.getMenuName())
                    || menuName.equals(MenuList.PASTA.getMenuName()) || menuName.equals(
                    MenuList.CHRISTMAS_PASTA.getMenuName())) {
                salePriceWeekend += SALE_DEFAULT_PRICE * menu.getOrderCount();
            }
        }
        if (salePriceWeekend != 0) {
            salePrices.put("주말 할인", salePriceWeekend);
        }
    }

    private void calculateDdaySalePrice(int day) {
        int dDaySale = D_DAY_SALE_DEFAULT_PRICE + (day * 100);
        salePrices.put("크리스마스 디데이 할인", dDaySale);
    }

    public boolean canUserGetFreeChampagne(int totalPriceToPay) {
        if (totalPriceToPay >= FREE_CHAMPAGNE_STANDARD) {
            salePrices.put("증정이벤트", 25000);
            return true;
        }
        return false;
    }

    public int calculateTotalSalePrice(Map<String, Integer> saleEvent) {
        int totalSalePrice = 0;
        for (Map.Entry<String, Integer> event : saleEvent.entrySet()) {
            totalSalePrice += event.getValue();
        }
        return totalSalePrice;
    }

    public String whatIsUserBadge(int totalSalePrice) {
        if (totalSalePrice < STAR_STANDARD) {
            return EventBadge.DEFAULT.getBadgeGrade();
        } else if (totalSalePrice <= TREE_STANDARD) {
            return EventBadge.STAR.getBadgeGrade();
        } else if (totalSalePrice <= SANTA_STANDARD) {
            return EventBadge.TREE.getBadgeGrade();
        }
        return EventBadge.SANTA.getBadgeGrade();
    }
}
