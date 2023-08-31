package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RecommendMenus {
    private final ArrayList<String> recommendMenus;
    private final ArrayList<Integer> foodCountList;

    public RecommendMenus(AvoidingMenus avoidingMenus) {
        this.recommendMenus = new ArrayList<>();
        this.foodCountList = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        generateRecommendMenus(avoidingMenus);
    }


    private void countFoodUp(Category category) {
        int index = category.getIndex();
        foodCountList.set(index, foodCountList.get(index)+1);
    }

    private boolean isValidMenu(AvoidingMenus avoidingMenus, Category category, String menu) {
        return validateAvoidMenu(avoidingMenus, menu) && validateMenuDuplicate(menu) && validateDuplicateCategory(category, menu);
    }

    private boolean validateDuplicateCategory(Category category, String menu) {
        int categoryIndex = category.getIndexByDisplayName(menu);
        return foodCountList.get(categoryIndex) != 2;
    }


    private Category getRandomCategory() {
        int index = Randoms.pickNumberInRange(1, 5);
        return Category.getByIndex(index);
    }

    private String getRandomMenuInCategory(Category category) {
        return Category.getRandomMenu(category);
    }

    private boolean validateMenuDuplicate(String menu) {
        for (String recommendMenu : recommendMenus) {
            if (Objects.equals(recommendMenu, menu)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateAvoidMenu(AvoidingMenus avoidingMenus, String menu) {
        Optional<List<String>> avoidingMenusOptional = avoidingMenus.getAvoidingMenu();
        if (avoidingMenusOptional.isPresent()) {
            List<String> menus = avoidingMenusOptional.get();
            return !menus.contains(menu);
        }
        return true;
    }

    private void generateRecommendMenus(AvoidingMenus avoidingMenus) {
        while (recommendMenus.size() < 5) {
            Category randomCategory = getRandomCategory();
            String newMenu = getRandomMenuInCategory(randomCategory);
            if(isValidMenu(avoidingMenus, randomCategory, newMenu)){
                recommendMenus.add(newMenu);
                countFoodUp(randomCategory);
            }
        }
    }

    private void sortRecommendMenus() {

    }

}
