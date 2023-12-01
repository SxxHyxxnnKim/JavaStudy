package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Menu;
import java.util.ArrayList;
import java.util.List;
import validation.InputValidation;
import validation.OrderValidation;
import view.InputView;

public class InputController {

    InputView inputView = new InputView();
    InputValidation inputValidation = new InputValidation();
    OrderValidation orderValidation = new OrderValidation();

    public int inputVisitDate() {
        String inputDate = "";
        while (true) {
            inputView.whatIsYourVisitDate();
            inputDate = Console.readLine();
            if (inputValidation.isInputInteger(inputDate)) {
                inputValidation.validationDate(inputDate);
            }
            break;
        }
        return Integer.parseInt(inputDate);
    }

    public List<Menu> inputOrderedMenu() {
        List<Menu> orderedMenu = null;
        boolean orderComplete = false;
        while (!orderComplete) {
            orderedMenu = new ArrayList<>();
            inputView.whatMenuWantToOrder();
            String[] inputMenu = Console.readLine().split(",");
            generateOrderedMenuList(orderedMenu, inputMenu);
            try {
                orderValidation.checkValidateOrder(orderedMenu);
                orderValidation.checkOrderedMenuOnlyDrink(orderedMenu);
                orderValidation.checkMinimumOrderPrice(orderedMenu);
                orderComplete = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orderedMenu;
    }

    private void generateOrderedMenuList(List<Menu> orderedMenu, String[] inputMenu) {
        for (String eachMenu : inputMenu) {
            String[] oneMenu = eachMenu.split("-");
            String menuName = oneMenu[0];
            String menuCount = oneMenu[1];
            inputValidation.isInputInteger(menuCount);
            orderedMenu.add(new Menu(menuName, Integer.parseInt(menuCount)));
        }
    }
}
