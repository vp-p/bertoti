package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PainelView implements ComponenteView {
    private String titulo;
    private List<ComponenteView> filhos = new ArrayList<>();
    private JPanel panel;

    public PainelView(String titulo) {
        this.titulo = titulo;
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.panel.setBorder(BorderFactory.createTitledBorder(titulo));
    }

    public void adicionar(ComponenteView c) {
        filhos.add(c);
        panel.add(c.getComponente());
    }

    public void limpar() {
        filhos.clear();
        panel.removeAll();
    }

    @Override
    public JComponent getComponente() {
        return panel;
    }
}
