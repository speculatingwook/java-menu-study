package menu.model;

public class Coach {
    private final String name;
    private final AvoidingMenus avoidingMenus;
    private final RecommendMenus recommendMenus;

    private Coach(String name, AvoidingMenus avoidingMenus) {
        this.name = name;
        this.avoidingMenus = avoidingMenus;
        this.recommendMenus = new RecommendMenus(avoidingMenus);
    }

    public RecommendMenus getRecommendMenus() {
        return recommendMenus;
    }

    private String getName() {
        return name;
    }

}
