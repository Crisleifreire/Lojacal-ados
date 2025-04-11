abstract class Calcado {
    protected String modelo;
    protected String marca;
    protected double preco;
    protected int quantidade;

    public Calcado(String modelo, String marca, double preco, int quantidade) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Marca: " + marca + ", Preço: R$" + preco + ", Estoque: " + quantidade;
    }
}