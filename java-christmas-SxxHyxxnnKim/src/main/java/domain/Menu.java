package domain;

import java.util.List;
import validation.InputValidation;
import view.ErrorMessage;

public class Menu {
    private final String menuName;
    private final int orderCount;
    InputValidation inputValidation = new InputValidation();

    public Menu(String menuName, int orderCount) {
        validationExistMenuName(menuName);
        validationOrderCount(orderCount);
        this.menuName = menuName;
        this.orderCount = orderCount;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    private void validationOrderCount(int orderCount) {
        if (orderCount < 1) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_ORDERED_MENU_COUNT.getMessage());
        }
    }

    private void validationExistMenuName(String menuName) {
        boolean menuNameExists = false;
        for (MenuList menu : MenuList.values()) {
            if (menu.getMenuName().equals(menuName)) {
                menuNameExists = true;
                break;
            }
        }

        if (!menuNameExists) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_NOT_EXIST_MENU.getMessage());
        }
    }

}
