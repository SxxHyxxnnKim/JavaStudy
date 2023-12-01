package domain;

public enum EventBadge {
    DEFAULT("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String badgeGrade;
    EventBadge(String badgeGrade){
        this.badgeGrade = badgeGrade;
    }

    public String getBadgeGrade() {
        return badgeGrade;
    }
}
