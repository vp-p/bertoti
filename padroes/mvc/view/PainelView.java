package view;

import java.util.ArrayList;
import java.util.List;

public class PainelView implements ComponenteView {
    private String titulo;
    private List<ComponenteView> filhos = new ArrayList<>();

    public PainelView(String titulo) {
        this.titulo = titulo;
    }

    public void adicionar(ComponenteView c) {
        filhos.add(c);
    }

    public void limpar() {
        filhos.clear();
    }

    @Override
    public void renderizar() {
        System.out.println("+----------------------------------+");
        System.out.println("  " + titulo);
        System.out.println("+----------------------------------+");
        for (ComponenteView c : filhos) {
            c.renderizar();
        }
        System.out.println("+----------------------------------+");
    }
}
