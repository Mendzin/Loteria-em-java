import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Bem vindo a Loteria digital, por favor escolha 6 numeros entre 1 e 60 :)");
        int[] escolherNumeros=new int[6];

        for (int i = 0; i <escolherNumeros.length ; i++) {
            int numeroDigitado;
            //Regra para aceitar numeros apenas entre 1 e 60
            while(true){
                System.out.println("Digite um numero: ");
                numeroDigitado=sc.nextInt();

                if (numeroDigitado>=1&&numeroDigitado<=60){
                    break;
                }else {
                    System.out.println(numeroDigitado < 1 ? "O numero não pode ser 0 ou abaixo" : "O numero não pode ser acima de 60");
                }
            }
            escolherNumeros[i]=numeroDigitado;
        }Arrays.sort(escolherNumeros);


        Bilhete bilhete1=new Bilhete(escolherNumeros);

        bilhete1.realizarSorteio();
        bilhete1.contarAcertos();
        bilhete1.exibirInfo();
        sc.close();
    }
}