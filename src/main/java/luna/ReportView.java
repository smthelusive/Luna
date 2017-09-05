package luna;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import luna.service.CountryService;
import luna.service.RunwayService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@UIScope
@SpringView(name = ReportView.VIEW)
public class ReportView extends VerticalLayout implements View {
    static final String VIEW = "report";

    @Autowired
    private CountryService countryService;
    @Autowired
    private RunwayService runwayService;

    private HorizontalLayout minmaxLay;
    private VerticalLayout lay;
    @PostConstruct
    void init() {
        lay = new VerticalLayout();
        drawMostCommonRunwayIdent();
        minmaxLay = new HorizontalLayout();
        drawMinAirGrid();
        drawMaxAirGrid();
        lay.addComponent(minmaxLay);
        drawRunwaySurfacesPerCountry();
        addComponent(lay);
    }

    @SuppressWarnings("unchecked")
    private void drawRunwaySurfacesPerCountry() {
        Label sur = new Label("Runway surfaces per country: ");
        List<Object[]> result = countryService.findWithSurfaces();
        Grid<Object[]> gridS = new Grid<>();
        gridS.setWidth(1000, Unit.PIXELS);
        gridS.setHeight(800, Unit.PIXELS);
        gridS.setItems(result);
        gridS.addColumn((ValueProvider<Object[], Object>)
                row -> (row[0])).setCaption("Country");
        gridS.addColumn((ValueProvider<Object[], Object>)
                row -> (row[1])).setCaption("Types of runways");
        lay.addComponent(sur);
        lay.addComponent(gridS);
    }

    private void drawMaxAirGrid() {
        VerticalLayout maxLay = new VerticalLayout();
        Label max = new Label("10 countries with maximum airports: ");
        List<Object[]> maxCountReport = countryService.findWithMaxAirports();
        Grid<Object[]> gridMax = new Grid<>();
        gridMax.setItems(maxCountReport);
        gridMax.setHeight(420, Unit.PIXELS);
        gridMax.addColumn((ValueProvider<Object[], Object>)
                row -> (row[0])).setCaption("Country");
        gridMax.addColumn((ValueProvider<Object[], Object>)
                row -> (row[1])).setCaption("Airport count");
        maxLay.addComponent(max);
        maxLay.addComponent(gridMax);
        minmaxLay.addComponent(maxLay);
    }

    private void drawMinAirGrid() {
        VerticalLayout minLay = new VerticalLayout();
        Label min = new Label("10 countries with minimum airports: ");
        List<Object[]> minCountReport = countryService.findWithMinAirports();
        Grid<Object[]> gridMin = new Grid<>();
        gridMin.setHeight(420, Unit.PIXELS);
        gridMin.setItems(minCountReport);
        gridMin.addColumn((ValueProvider<Object[], Object>)
                row -> (row[0])).setCaption("Country");
        gridMin.addColumn((ValueProvider<Object[], Object>)
                row -> (row[1])).setCaption("Airport count");
        minLay.addComponent(min);
        minLay.addComponent(gridMin);
        minmaxLay.addComponent(minLay);
    }

    private void drawMostCommonRunwayIdent() {
        List<String> idents = runwayService.findMostCommonLeIdent();
        String commonIdents = "";
        for (String ident : idents) {
            commonIdents += ident + "; ";
        }
        Label leIdents = new Label("10 most common runway identifications: " + commonIdents);
        lay.addComponent(leIdents);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {}
}