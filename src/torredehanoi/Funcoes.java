package torredehanoi;

public class Funcoes {
    
    public static void imprimirTorres(int v1[], int v2[], int v3[]){
        for (int i = 4; i >= 0; i--) {
            System.out.println(v1[i] + "\t" + v2[i] + "\t" + v3[i]);
        }
        System.out.println("A\tB\tC");
    }
    
    public static boolean passarBarra (int v1[], int v2[]){
        int aux = 0;
        int posAux = 0;
        boolean possivel = false;
        
        for (byte i = 4; i >= 0; i--) {
            if(v1[i] != 0){
                aux = v1[i];
                posAux = i;
                break;
            }
        }
        
        if(v2[0] == 0){
            possivel = true;
        }
        
        for (byte i = 1; i < v1.length; i++) {
            if (aux < v2[i-1]){
                possivel = true;
            }
        }
        
        for (byte i = 0; i < v1.length; i++) {
            if (possivel && v2[i] == 0){
                v2[i] = aux;
                v1[posAux] = 0;
                break;
            }
        }
        
        return possivel;      
    }
    
    public static boolean vitoria(int v1[]){
        boolean igual = true;
        int vetorBase[] = {5, 4, 3, 2, 1};
        
        for (int i = 0; i < v1.length; i++) {
            if (vetorBase[i] != v1[i]){
                igual = false;
            }
        }
        
        return igual;
    }
    
    public static boolean entradaCorreta (String e){
        return e.equals("AB") || e.equals("AC") || e.equals("BA")
               || e.equals("BC") || e.equals("CA") || e.equals("CB");
    }    
}
