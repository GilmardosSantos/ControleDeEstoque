package br.com.mapa;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        Menu menu3 = new Menu();
        Empresa xarife = new Empresa();
        Empresa autor = new Empresa();

        do{
            menu1.menuPrincipal();
            Scanner opcao = new Scanner(System.in);
            int op = opcao.nextInt();
            menu1.setOpcao(op);
            switch (menu1.getOpcao()){
                case 1:
                    do{
                    menu2.menuCadastro();
                    Scanner opcao1 = new Scanner(System.in);
                    int op1 = opcao1.nextInt();
                    menu2.setOpcao(op1);
                    switch (menu2.getOpcao()){
                        case 1:
                            xarife.Inclusao();
                            break;
                        case 2:
                            xarife.Alteracao();
                            break;
                        case 3:
                            xarife.Pesquisa();
                            break;
                        case 4:
                            xarife.Exclusao();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Selecione uma das opções listadas");
                    }
            }while (menu2.getOpcao() != 0);

            break;

            case 2 :
                do{
                    menu3.menuMovimentacao();;
                    Scanner opcao2 = new Scanner(System.in);
                    int op2 = opcao2.nextInt();
                    menu3.setOpcao(op2);
                    switch (menu3.getOpcao()){
                        case 1:
                            xarife.Entrada();
                            break;
                        case 2:
                            xarife.saida();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Selecione uma das opções listadas");
                    }
                } while(menu3.getOpcao()!= 0);
                break;

            case 3:
                xarife.mudarValor();
                break;
            case 4:
                xarife.impressao();
                break;
            case 0:
                autor.autor();
                break;
            default:
                System.out.println("Selecione uma das opções listadas");
            }
         } while (menu1.getOpcao() !=0);
    }
}

