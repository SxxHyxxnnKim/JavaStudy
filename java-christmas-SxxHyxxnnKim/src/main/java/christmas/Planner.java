package christmas;

import controller.InputController;
import controller.OrderController;
import domain.Date;
import domain.Menu;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class Planner {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputController inputController = new InputController();
    OrderController orderController = new OrderController();

    public void plan() {
        inputView.greetingMessage();
        Date fixedDate = new Date(inputController.inputVisitDate());
        List<Menu> orderedMenu = inputController.inputOrderedMenu();

        int totalPriceOrder = orderController.calculateTotalOrderPrice(orderedMenu);
        Map<String, Integer> saleEvent = orderController.calculateSalePrice(fixedDate, orderedMenu);
        boolean getFreeChampagne = orderController.canUserGetFreeChampagne(totalPriceOrder);
        int totalSalePrice = orderController.calculateTotalSalePrice(saleEvent);
        int totalPriceToPay = totalPriceOrder - totalSalePrice;
        String eventBadge = orderController.whatIsUserBadge(totalSalePrice);

        outputView.showWhatEventsOnVisitedDay(fixedDate.getDay());
        outputView.showWhatOrderedMenu(orderedMenu);
        outputView.showHowMuchTotalPriceBeforeSale(totalPriceOrder);
        outputView.showCanGetFreeChampagne(getFreeChampagne);
        outputView.showSaleEventUserGot(saleEvent);
        outputView.showHowMuchTotalSalePrice(totalSalePrice);
        outputView.showHowMuchTotalPriceAfterSale(totalPriceToPay);
        outputView.showUserGetWhatBadge(eventBadge);
    }
}
