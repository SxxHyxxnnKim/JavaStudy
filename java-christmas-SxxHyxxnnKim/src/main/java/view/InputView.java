package view;

public class InputView {
    public void greetingMessage(){
        System.out.println(InputMessage.GREETING.getMessage());
    }
    public void whatIsYourVisitDate(){
        System.out.println(InputMessage.VISIT_DATE.getMessage());
    }
    public void whatMenuWantToOrder(){
        System.out.println(InputMessage.ORDER_MENU.getMessage());
    }
}
