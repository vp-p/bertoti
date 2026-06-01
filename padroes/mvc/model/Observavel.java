package model;

public interface Observavel {
    void adicionarObservador(Observador o);
    void removerObservador(Observador o);
    void notificarObservadores();
}
