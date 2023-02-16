package torredehanoi;

import static torredehanoi.Funcoes.*;
import java.util.Scanner;

public class TorreDeHanoi {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        boolean jogou = false;
        boolean ganhou = false;
        boolean jogadaCorreta = false;
        int jogadas = 0;
        String movimentos = "";
        
        int torreA[] = {5, 4, 3, 2, 1};
        int torreB[] = {0, 0, 0, 0, 0};
        int torreC[] = {0, 0, 0, 0, 0};
        
        while(true){
        
            jogou = false;
            jogadaCorreta = false;
            
            imprimirTorres(torreA, torreB, torreC);
            while(!jogadaCorreta){
                movimentos = "";
                
                System.out.println("Digite de que torre deseja mover a peça: ");
                movimentos += entrada.nextLine();
            
                System.out.println("Digite em qual torre deseja colocar a peça: ");
                movimentos += entrada.nextLine();
                
                movimentos = movimentos.toUpperCase();
                
                jogadaCorreta = entradaCorreta(movimentos);
                
                if (!jogadaCorreta){
                    System.out.println("DIGITE APENAS TORRES VÁLIDAS!");
                }
            }
            
            switch(movimentos){
                case "AB":
                    jogou = passarBarra(torreA, torreB);
                    break;
                case "AC":
                    jogou = passarBarra(torreA, torreC);
                    break;
                case "BA":
                    jogou = passarBarra(torreB, torreA);
                    break;
                case "BC":
                    jogou = passarBarra(torreB, torreC);
                    break;
                case "CA":
                    jogou = passarBarra(torreC, torreA);
                    break;
                case "CB":
                    jogou = passarBarra(torreC, torreB);
                    break;
            }
            
            if(jogou){
                jogadas += 1;
            }
            
            ganhou = vitoria(torreC);
            
            if(ganhou){
                imprimirTorres(torreA, torreB, torreC);
                System.out.println("OBAA! VOCÊ GANHOU O JOGO COM " + jogadas + " JOGADAS");
                break;
            }
            
        }

        entrada.close();
    }
    
}
