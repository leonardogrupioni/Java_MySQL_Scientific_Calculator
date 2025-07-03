import javax.swing.JOptionPane;
/**
 * Aplicativo para testar as classes.
 * 
 * @author
 * @version 1.0
 */
public class TestaCalcCientifica {
    public static void main(String args[]){
        
        double valor = 870;//Double.parseDouble(JOptionPane.showInputDialog("Forneca valor:"));
        // Todas operacoes com a calculadora cientifica
        CalcCientifica cc1 = new CalcCientifica(3, "+", valor);
        CalcCientifica cc2 = new CalcCientifica(3, "-", valor);
        CalcCientifica cc3 = new CalcCientifica(3, "*", valor);
        CalcCientifica cc4 = new CalcCientifica(3, "/", valor);
        CalcCientifica cc5 = new CalcCientifica(33, "%", valor);
        CalcCientifica cc6 = new CalcCientifica("sqrt", 3);
        CalcCientifica cc7 = new CalcCientifica("seno", 60);
        CalcCientifica cc8 = new CalcCientifica("inverso", 5);
        CalcCientifica cc9 = new CalcCientifica("fatorial", 6);

        System.out.println("Operacoes com a Calculadora Cientifica:");       
        System.out.println(cc1 + " = " + cc1.calcular());
        System.out.println(cc2 + " = " + cc2.calcular());
        System.out.println(cc3 + " = " + cc3.calcular());
        System.out.println(cc4 + " = " + cc4.calcular());
        System.out.println(cc5 + " = " + cc5.calcular());
        System.out.println(cc6 + " = " + cc6.calcular());
        System.out.println(cc7 + " = " + cc7.calcular());
        System.out.println(cc8 + " = " + cc8.calcular());
        System.out.println(cc9.toString() + " = " + cc9.calcular());
    }
}
