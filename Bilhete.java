import java.util.Arrays;
import java.util.Random;

public class Bilhete {
    private int[] numerosEscolhidos;
    private int[] resultadoSorteio;

    //Construtor
    public Bilhete(int[]numerosEscolhidos){
        this.numerosEscolhidos=numerosEscolhidos;
    }

    //Metodo para sortear numeros
    public void realizarSorteio() {
        Random random = new Random();
        resultadoSorteio = new int[6];

        for (int i = 0; i < resultadoSorteio.length; i++) {
            int numeroGerado;
            boolean repetido;

            do {
                numeroGerado = random.nextInt(60) + 1;
                repetido = false;

                for (int j = 0; j < i; j++) {
                    if (resultadoSorteio[j] == numeroGerado) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);

            resultadoSorteio[i] = numeroGerado;
        }

        Arrays.sort(resultadoSorteio);
    }


    //Metodo para contar acertos
    public int contarAcertos(){
        int acertos=0;
        for (int i = 0; i <numerosEscolhidos.length ; i++) {
            for (int j = 0; j <resultadoSorteio.length; j++) {
                if (numerosEscolhidos==resultadoSorteio){
                    acertos++;
                }
            }
        }
        return acertos;
    }

    //Metodo para exibir infos
    public void exibirInfo(){
        System.out.println("Vamos checar sua pontuação");
        System.out.println("Seus numeros: "+Arrays.toString(this.numerosEscolhidos));
        System.out.println("Numeros sorteados:"+Arrays.toString(this.resultadoSorteio));
        int acertos=contarAcertos();
        if (acertos==6){
            System.out.println("GANHOU PORRA TU TA MT RICO");
            System.out.println("Acertos: "+acertos);
        }else if(acertos==0){
            System.out.println("ERROU TUDO KKKKKKKKKK");
            System.out.println("Acertos: "+acertos);
        }else{
            System.out.println("TENTE NOVAMENTE");
            System.out.println("Acertos: "+acertos);
        }
    }

}
