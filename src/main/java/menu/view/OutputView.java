package menu.view;

import menu.model.Coach;
import menu.model.RecommendMenus;

public class OutputView {
    public OutputView() {

    }

    public String recommendStartNotification() {
        return "점심 메뉴 추천을 시작합니다.";
    }

    public String avoidingFoodNotification() {
        return "(이)가 못 먹는 메뉴를 입력해 주세요.";
    }

    public String menuRecommendNotification() {
        return "메뉴 추천 결과입니다.";
    }

    public String recommendEnd() {
        return "추천을 완료했습니다.";
    }

    public String day() {
        return "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    }

    public String category() {
        return "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";
    }

    public String coachRecommend(Coach coach) {
        RecommendMenus menus = coach.getRecommendMenus();
    }

}
