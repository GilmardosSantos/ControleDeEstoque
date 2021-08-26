//Trabalho realizado pelo aluno Gilmar Antonio Ribeiro dos Santos, R.A:20055006-5

package br.com.mapa;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {

    ArrayList<Estoque> cCusto = new ArrayList<Estoque>();

    void impressao(String nome){
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Impressão ---");
        for (Estoque prod : cCusto){
            if(prod.getNome().equalsIgnoreCase(nome)){
                System.out.println("Nome: " + prod.getNome() + "\n" + "Preço: R$ " + prod.getValor() + "\n"
                + "Quantidade: " + prod.getQtd());
            }
        }
    }

    void impressao(){
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Impressão ---");
        for(Estoque prod : cCusto){
            System.out.println("Nome: " + prod.getNome() + "\n" + "Preço: R$ " + prod.getValor() + "\n"
                    + "Quantidade: " + prod.getQtd());
        }
    }

    private boolean checkNome(String nome){
        Boolean found = false;
        for(Estoque item : cCusto){
            if(item.getNome().equalsIgnoreCase(nome)) found = true;
        }
        return found;
    }

    private boolean checkPreco(double preco){
        Boolean valor = false;
        if(preco > 0) valor = true;
        return valor;
    }

    private boolean checkQtd(int qtd){
        Boolean quantidade = false;
        if(qtd > 0) quantidade = true;
        return quantidade;
    }
    public void Inclusao(){
    double valor;
    int quantidade;
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Inclusão ---");
        System.out.println("Nome produto: ");
        Scanner ent = new Scanner(System.in);
        String nome = ent.nextLine();
        if (checkNome(nome)){
            System.out.println("Produto já cadastrado");
        }else{
            do{
                System.out.println("Valor do produto: ");
                valor = ent.nextDouble();
                if (valor <= 0) System.out.println("Valor menor que 0.");
            }while (!checkPreco(valor));
            do{
                System.out.println("Quantidade: ");
                quantidade = ent.nextInt();
                if(quantidade <= 0) System.out.println("Total de produtos menor que 0");
            }while (!checkQtd(quantidade));
            System.out.println("Medida: ");
            String medida = ent.next();
            Estoque prod = new Estoque();
            Scanner entry = new Scanner(System.in);
            System.out.println("Confirmar adição?: S/N");
            String continua = entry.next();
            if(continua.equalsIgnoreCase("s"))
                this.cCusto.add(prod);
            prod.setNome(nome);
            prod.setValor(valor);
            prod.setQtd(quantidade);
            prod.setUnid(medida);
        }
    }
    public void Alteracao(){
        int qtd = 0;
        double valor = 0;
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Alteração ---");

        System.out.println("Nome do produto");
        Scanner ent = new Scanner(System.in);
        String nome = ent.nextLine();
        if(checkNome(nome)){
            for (Estoque prod : cCusto){
                if (prod.getNome().equalsIgnoreCase(nome)){
                    System.out.println("Produto: " + prod.getNome());
                    System.out.println("Quantidade : " + prod.getQtd() + "\n"+"Unidades: "+ prod.getUnid()+ ".");
                    System.out.println("Valor : " + prod.getValor());
                    do{
                        System.out.println("Nova quantidade: ");
                        qtd = ent.nextInt();
                        if (qtd <= 0) System.out.println("Total de produtos menor que 0");
                    }while (!checkQtd(qtd));
                    do{
                        System.out.println("Novo valor: ");
                        valor = ent.nextDouble();
                        if(valor <= 0) System.out.println("Valor menor que 0");
                    }while(!checkPreco(valor));
                    System.out.println("Nova medida: ");
                    String medida = ent.next();
                    System.out.println("Prosseguir: S/N");
                    String continua = ent.next();
                    if(continua.equalsIgnoreCase("S")){
                        prod.setQtd(qtd);
                        prod.setUnid(medida);
                        prod.setValor(valor);
                    }else{
                        System.out.println("O registro não foi concluido!");
                    }
                }
            }
        } else{
            System.out.println("Não encontrado!");
        }
    }

    public void mudarValor(){
        double valorN = 0;
        double valorA;
        double perc;
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Reajuste ---");
        System.out.println("--- Digite o nome do produto que você deseja reajustar o valor---");
        Scanner ent = new Scanner(System.in);
        String nome = ent.nextLine();
        for (Estoque prod : cCusto)
            if (prod.getNome().equalsIgnoreCase(nome)){
                System.out.println("Nome do produto: "+prod.getNome());
                System.out.println("Quantidade em estoque: "+prod.getQtd());
                System.out.println("Valor do produto atual: "+prod.getValor());
                System.out.println("Qual o percentual de aumento que você deseja: ");
                valorA = prod.getValor();
                valorN = ent.nextDouble();
                double total = valorA*valorN;
                System.out.println("Prosseguir: S/N");
                String continua = ent.next();
                if(continua.equalsIgnoreCase("s")) prod.setValor((valorA)+total/100);
            }else System.out.println("Não encontrado");
    }

    public void Pesquisa(){
        String continua = "N";
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Pesquisa ---");

        do{
            System.out.println("Nome do produto");
            Scanner ent = new Scanner(System.in);
            String nome = ent.nextLine();
            for(Estoque prod : cCusto){
                if(prod.getNome().equalsIgnoreCase(nome)){
                    impressao(nome);
                }else System.out.println("Não encontrado");
            }
        } while (continua.equalsIgnoreCase("S"));
    }

    private void RemoverItem(String prod){
        String nome = prod;
        cCusto.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    public void Exclusao(){
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Excluir produto ---");
        System.out.println("Nome do produto");
        Scanner ent = new Scanner(System.in);
        String nome = ent.nextLine();
        impressao(nome);
        System.out.println("Prosseguir S/N");
        String continua = ent.nextLine();
        if (continua.equalsIgnoreCase("S")) RemoverItem(nome);
    }

    public void Entrada() {
        int add = 0;
        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Entrada de produto ---");

        System.out.println("Informe o nome do produto: ");
        Scanner ent = new Scanner(System.in);
        String nome = ent.nextLine();
        for (Estoque item : cCusto) {
            if (item.getNome().equalsIgnoreCase(nome)){
            do {
                System.out.println(item.getNome());
                System.out.println(item.getQtd());
                System.out.println("Quantidade: ");
                add = ent.nextInt();
                if (add <= 0) System.out.println("Total de produtos menor do que 0");
            } while (!checkQtd(add));
            int total = item.getQtd() + add;
            System.out.println("Prosseguir S/N");
            String continua = ent.next();
            if (continua.equalsIgnoreCase("s")) item.setQtd(total);
        } else System.out.println("Produto não cadastrado.");
        break;
        }
    }

    public void saida(){
        int rem = 0;

        System.out.println("------------------------------------------------");
        System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
        System.out.println("--- Sistema de controle de estoque ---");
        System.out.println("--- Saida ---");

        System.out.println("Informe o nome do item para dar baixa");
        Scanner ent = new Scanner(System.in);
        Scanner ent2 = new Scanner(System.in);
        String nome = ent.nextLine();
        for (Estoque item : cCusto)
        if(item.getNome().equalsIgnoreCase(nome)){
            do{
                System.out.println(item.getNome());
                System.out.println(item.getQtd());
                System.out.println("Quantidade: ");
                rem = ent2.nextInt();
                if (rem <= 0) System.out.println("Quantidade informada deve ser maior do que 0");
            } while(checkQtd(rem));
            int total = item.getQtd() - rem;
            System.out.println("Prosseguir S/N");
            Scanner l = new Scanner(System.in);
            String continua = l.next();
            if (continua.equalsIgnoreCase("s")) item.setQtd(total);
            break;
        }else{
            System.out.println("Produto não cadastrado");
        }
    }
    public void autor(){
        System.out.println("Trabalho realizado pelo aluno Gilmar Antonio Ribeiro dos Santos\nR.A: 20055006-5");
    }
}
