package view;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    ERROR_IS_NOT_NUMBER("숫자로만 입력해야 합니다."),
    ERROR_DATE_RANGE_WRONG("날짜는 1~31까지만 입력해야 합니다."),
    ERROR_NOT_EXIST_MENU("존재하지 않는 메뉴입니다."),
    ERROR_ORDERED_MENU_COUNT("주문할 메뉴의 수량은 최소 1개 이상입니다."),
    ERROR_ORDERED_MENU_TOO_MUCH("주문은 최대 20개까지만 가능합니다."),
    ERROR_MENU_DUPLICATED("중복된 메뉴가 있습니다."),
    ERROR_MENU_ONLY_DRINK("음료만은 주문 할 수 없습니다."),
    ERROR_MININUM_ORDER_PRICE("최소 주문 금액은 10000원 이상입니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
