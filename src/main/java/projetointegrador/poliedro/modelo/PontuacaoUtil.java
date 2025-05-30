
package projetointegrador.poliedro.modelo;


public class PontuacaoUtil {
    public static int getPontuacaoPorOrdem(int ordem) {
        switch (ordem) {
            case 1:
                return 25000;
            case 2:
                return 45000;
            case 3:
                return 50000;
            case 4:
                return 60000;
            case 5:
                return 65000;
            case 6:
                return 70000;
            case 7:
                return 80000;
            case 8:
                return 150000;
            case 9:
                return 200000;
            case 10:
                return 255000;
            default:
                return 0;
        }
    }
}
