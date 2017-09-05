package luna;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;

@SpringView(name = DefaultView.VIEW)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW = "";

    @PostConstruct
    void init() {
        addComponent(new Label("Welcome! Please choose Query or Report"));
    }

    @Override
    public void enter(ViewChangeEvent event) {}
}

