package luna;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import luna.domain.Airport;
import luna.domain.Country;
import luna.domain.Runway;
import luna.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@UIScope
@SpringView(name = QueryView.VIEW)
public class QueryView extends VerticalLayout implements View {
    static final String VIEW = "query";

    @Autowired
    private CountryService countryService;

    @PostConstruct
    void init() {
        List<Object[]> result = new ArrayList<>();
        Grid<Object[]> grid = new Grid<>();
        VerticalLayout lay = new VerticalLayout();
        HorizontalLayout inputLay = new HorizontalLayout();
        Label l = new Label("Please enter country code or name: ");
        TextField f = new TextField();
        Button go = new Button("Go");
        go.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                String input = f.getValue();
                result.clear();
                List<Country> countries = countryService.findAllByNameOrCode(input);
                for (Country c : countries) {
                    for (Airport a : c.getAirports()) {
                        for (Runway r : a.getRunways()) {
                            String[] row = new String[5];
                            row[0] = c.getCode();
                            row[1] = c.getName();
                            row[2] = a.getName();
                            row[3] = r.getLeIdent();
                            row[4] = r.getSurface();
                            result.add(row);
                        }
                    }
                }
                grid.clearSortOrder();
            }
        });

        grid.setWidth(1120, Unit.PIXELS);
        grid.setItems(result);
        grid.addColumn((ValueProvider<Object[], Object>)
                row -> (row[0])).setCaption("Country code");
        grid.addColumn((ValueProvider<Object[], Object>)
                row -> (row[1])).setCaption("Country name");
        grid.addColumn((ValueProvider<Object[], Object>)
                row -> (row[2])).setCaption("Airport");
        grid.addColumn((ValueProvider<Object[], Object>)
                row -> (row[3])).setCaption("Runway identity");
        grid.addColumn((ValueProvider<Object[], Object>)
                row -> (row[4])).setCaption("Runway Surface");
        lay.addComponent(l);
        inputLay.addComponent(f);
        inputLay.addComponent(go);
        lay.addComponent(inputLay);
        lay.addComponent(grid);
        addComponent(lay);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {}
}