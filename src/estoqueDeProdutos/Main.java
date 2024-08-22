package estoqueDeProdutos;

public class Main {
    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        //Exibe o estoque vazio
        estoque.exibirProdutos();

        //Adicionando produtos ao estoque
        estoque.adicionarProduto(134L, "Notebook", 1500.0, 1);
        estoque.adicionarProduto(256L, "Mouse", 25.0, 5);
        estoque.adicionarProduto(398L, "Monitor", 400.0, 10);
        estoque.adicionarProduto(464L, "Teclado", 40.0, 12);
        System.out.println();

        //exibe o estoque com os produtos adicionados
        estoque.exibirProdutos();
        System.out.println();

        //Calcula e exibe o valor total do estoque
        System.out.println("\nValor total do estoque: R$" + estoque.valorTotalEstoque());

        //Obtém e exibe o produto mais caro
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("\nProduto mais caro: " + produtoMaisCaro);

        //Obtém e exibe o produto mais barato
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("\nProduto mais barato: " + produtoMaisBarato);

        //Obtém e exibe o produto com a maior quantidade em valor no estoque
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("\nProduto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);

        //Remover Produto
        estoque.removerProduto("Mouse");

        estoque.exibirProdutos();
        estoque.valorTotalEstoque();
    }
}