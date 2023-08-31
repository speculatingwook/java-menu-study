package menu.model;

import java.util.List;
import java.util.Optional;

public class AvoidingMenus {
    private final Optional<List<String>> avoidingMenus;

    public AvoidingMenus(Optional<List<String>> avoidingMenus) {
        this.avoidingMenus = avoidingMenus;
    }

    public Optional<List<String>> getAvoidingMenu() {
        return avoidingMenus;
    }
}
