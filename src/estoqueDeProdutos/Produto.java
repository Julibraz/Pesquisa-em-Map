package estoqueDeProdutos;

public class Produto {
    //atributos
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, Double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Nome= '" + nome +
                ", preco= R$" + preco +
                ", quantidade= " + quantidade +
                "\n";
    }

}
