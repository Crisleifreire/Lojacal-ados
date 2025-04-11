// Arquivo: .java
import java.util.*;

class Estoque {
    private Map<String, Calcado> calcados;

    public Estoque() {
        this.calcados = new HashMap<>();
    }

    public void adicionarCalcado(Calcado calcado) {
        calcados.put(calcado.getModelo().toLowerCase(), calcado);
    }

    public Calcado consultarEstoque(String modelo) {
        return calcados.get(modelo.toLowerCase());
    }

    public List<Calcado> sugerirModelos(String modelo) {
        List<Calcado> sugestoes = new ArrayList<>();
        for (Calcado c : calcados.values()) {
            if (c.getModelo().toLowerCase().contains(modelo.toLowerCase()) && !c.getModelo().equalsIgnoreCase(modelo)) {
                sugestoes.add(c);
            }
        }
        return sugestoes;
    }

    public void listarTodos() {
        if (calcados.isEmpty()) {
            System.out.println("Nenhum calçado no estoque.");
        } else {
            for (Calcado c : calcados.values()) {
                System.out.println(c);
            }
        }
    }
}