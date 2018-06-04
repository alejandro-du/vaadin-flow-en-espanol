package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@HtmlImport("styles/shared-styles.html")
@Route("")
public class MainView extends VerticalLayout {

    private Grid<Comentario> grid = new Grid<>();
    private MonacoEditor textArea = new MonacoEditor();
    private Button button = new Button("Enviar");

    public MainView() {
        addClassName("main-view");

        Image image = new Image("frontend/images/logo.png", "Logo");
        image.setHeight("70px");

        grid.setHeightByRows(true);
        grid.addColumn(Comentario::getFecha);
        grid.addColumn(Comentario::getContenido);
        actualizar();

        textArea.setWidth("100%");

        setHorizontalComponentAlignment(Alignment.END, button);
        button.addClickListener(event -> enviar(textArea.getValue()));

        add(image, grid, textArea, button);
    }

    private void enviar(String contenido) {
        ComentarioRepository.save(new Comentario(contenido));
        actualizar();
        textArea.clear();
    }

    private void actualizar() {
        grid.setItems(ComentarioRepository.findAll());
    }
}
