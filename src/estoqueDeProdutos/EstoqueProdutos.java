package estoqueDeProdutos;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    //aributo
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, Double preco, int quantidade){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
        System.out.println(quantidade + " unidade(s) do produto '" + nome + "' adicionado(s), com o valor de R$" + preco + " cada unidade.");
    }

    //Metodo que removera o estoque inteiro de um produto do estoque
    public void removerProduto(String nome) {
        Long chaveParaRemover = null;
        Produto produtoParaRemover = null;

        if (!estoqueProdutosMap.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
                if (entry.getValue().getNome().equals(nome)) {
                    chaveParaRemover = entry.getKey();
                    produtoParaRemover = entry.getValue();
                    break;
                }
            }
        }

        if (chaveParaRemover != null) {
            estoqueProdutosMap.remove(chaveParaRemover);
            System.out.println("Produto removido: " + produtoParaRemover.getNome());
        } else {
            System.out.println("Produto não encontrado: " + nome);
        }
    }

    public void exibirProdutos(){
        if(estoqueProdutosMap.isEmpty()){
            System.out.println("Estoque vázio.");
        }else{
            System.out.println(estoqueProdutosMap);
        }
    }

    public double valorTotalEstoque(){
        double valorTotal = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            //ira percorrer cada produto, obtendo sua quantidade e seu valor para fazer o calculo
            for(Produto p : estoqueProdutosMap.values()){
                valorTotal += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotal;
    }

    //instanciando um novo objeto 'Produto' para que possa ser armazenado o Produto 'maisCaro' e ser retorna em seguida
    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto p : estoqueProdutosMap.values()){
                if(p.getPreco() < menorPreco){
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        }
        return produtoMaisBarato;

    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
                    maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorNoEstoque;
    }
}
