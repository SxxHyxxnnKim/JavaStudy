package validation;

import controller.OrderController;
import domain.Menu;
import domain.MenuList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mockito.internal.matchers.Or;
import view.ErrorMessage;

public class OrderValidation {
    private static final int MINIMUM_TOTAL_PRICE = 10000;
    OrderController orderController = new OrderController();

    public void checkValidateOrder(List<Menu> orderedMenu) {
        int totalCount = calculateOrderedMenuCount(orderedMenu);
        if (totalCount > 20) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_ORDERED_MENU_TOO_MUCH.getMessage());
        }
        if (!checkDuplicationMenu(orderedMenu)) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_MENU_DUPLICATED.getMessage());
        }
    }

    private boolean checkDuplicationMenu(List<Menu> orderedMenu) {
        Set<String> checkMenuDuplicated = new HashSet<>();
        for (Menu menu : orderedMenu) {
            checkMenuDuplicated.add(menu.getMenuName());
        }
        if (checkMenuDuplicated.size() != orderedMenu.size()) {
            return false;
        }
        return true;
    }

    private int calculateOrderedMenuCount(List<Menu> orderedMenu) {
        int totalCount = 0;
        for (Menu menu : orderedMenu) {
            totalCount += menu.getOrderCount();
        }
        return totalCount;
    }

    public void checkOrderedMenuOnlyDrink(List<Menu> orderedMenu) {
        boolean onlyDrinks = orderedMenu.stream().allMatch(menu -> isDrink(menu.getMenuName()));

        if (onlyDrinks) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_MENU_ONLY_DRINK.getMessage());
        }
    }

    private boolean isDrink(String menuName) {
        for (MenuList menu : MenuList.values()) {
            if (menu.getMenuName().equals(menuName) && isDrinkCategory(menu)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDrinkCategory(MenuList menu) {
        return menu == MenuList.RED_WINE || menu == MenuList.ZERO_COKE || menu == MenuList.CHAMPAGNE;
    }

    public void checkMinimumOrderPrice(List<Menu> orderedMenu) {
        int totalOrderPrice = orderController.calculateTotalOrderPrice(orderedMenu);

        if (totalOrderPrice < MINIMUM_TOTAL_PRICE) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_MININUM_ORDER_PRICE.getMessage());
        }
    }

}
