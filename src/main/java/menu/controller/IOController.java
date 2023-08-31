package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Optional;

import static menu.exception.InputValidation.foodInputValid;
import static menu.exception.InputValidation.isValid;

public class IOController {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final InputView inputView;
    private final OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void printError(String error) {
        System.out.println(ERROR_MESSAGE+ error);
    }

    public List<String> coachNameInput() {
        try {
            return isValid(inputView.readInputName());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력값에 문제가 있습니다.");
        }
    }

    public Optional<List<String>> avoidingFoodInput() {
        try {
            return foodInputValid(inputView.readAvoidingMenu());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력값에 문제가 있습니다.");
        }
    }


}
