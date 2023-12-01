package domain;

public enum MenuList {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    SALAD("시저샐러드", 9000),
    STEAK("티본스테이크", 55000),
    BARBECUE("바비큐립", 54000),
    PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),
    CAKE("초코케이크", 15000),
    ICECREAM("아이스크림", 5000),
    CHAMPAGNE("샴페인", 25000),
    RED_WINE("레드와인", 60000),
    ZERO_COKE("제로콜라", 3000);

    private final String menuName;
    private final int menuPrice;
    MenuList(String menuName, int menuPrice){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }
}
