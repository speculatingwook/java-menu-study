package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;

public enum Category {
    JAPANESE_CUISINE(1, "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_CUISINE(2, "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_CUISINE(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_CUISINE(4, "아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_CUISINE(5, "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));


    private final int index;
    private final String displayName;
    private List<String> foods;

    Category(int index, String displayName, List<String> foods) {
        this.index = index;
        this.displayName= displayName;
        this.foods = foods;
    }

    public static String getRandomMenu(Category category) {
        return Randoms.shuffle(category.foods).get(0);
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getIndexByDisplayName(String displayName) {
        for (Category category : Category.values()) {
            if (Objects.equals(category.getDisplayName(), displayName)) {
                return category.getIndex();
            }
        }
        throw new IllegalArgumentException("[ERROR]: No matching Category for index: " + index);
    }


    public int getIndex() {
        return index;
    }

    public static Category getByIndex(int index) {
        for (Category category : Category.values()) {
            if (category.getIndex() == index) {
                return category;
            }
        }
        throw new IllegalArgumentException("[ERROR]: No matching Category for index: " + index);
    }

}
