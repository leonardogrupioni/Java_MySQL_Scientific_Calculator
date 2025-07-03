/**
 * Calculadora de 4 operações (+, -, x, /) básicas.
 * Com variáveis de instância.
 * 
 * @author
 * @version 18/03/2024
 */
public class CalcBasica {

    // Atributos (variáveis de instância)
    private double operando1;
    private String operador;
    private double operando2;

    /**
     * CalculadoraBasica Construtor
     *
     * @param operando1 double operando1
     * @param operador String operador
     * @param operando2 double operando2
     */
    CalcBasica(double operando1, String operador, double operando2) {
        setOperando1(operando1);
        setOperador(operador);
        setOperando2(operando2);
    }

    // Setters e Getters
    protected void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    protected void setOperador(String operador) {
        this.operador = operador;
    }

    protected void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    protected double getOperando1() {
        return this.operando1;
    }

    protected String getOperador() {
        return this.operador;
    }

    protected double getOperando2() {
        return this.operando2;
    }

    // Métodos de operação
    public static double somar(double a, double b) {
        return (a + b);
    }

    public static double subtrair(double a, double b) {
        return (a - b);
    }

    public static double multiplicar(double a, double b) {
        return (a * b);
    }

    public static double dividir(double a, double b) {
        return (a / b);
    }

    private double resto(double a, double b) {
        return (a % b);
    }

    /**
     * Método calcular com persistência no banco de dados.
     *
     * @return double resultado da operação
     */
    public double calcular() {
        double res = 0;
        String status = "success";
        String mensagem = "";
        String calculadora = "basica";

        try {
            switch (getOperador()) {
                case "+":
                    res = somar(getOperando1(), getOperando2());
                    break;
                case "-":
                    res = subtrair(getOperando1(), getOperando2());
                    break;
                case "*":
                    res = multiplicar(getOperando1(), getOperando2());
                    break;
                case "/":
                    if (getOperando2() == 0) {
                        throw new ArithmeticException("Divisão por zero.");
                    }
                    res = dividir(getOperando1(), getOperando2());
                    break;
                case "%":
                    res = resto(getOperando1(), getOperando2());
                    break;
                default:
                    throw new IllegalArgumentException("Operador inválido: " + getOperador());
            }
        } catch (Exception e) {
            res = 0;
            status = "failure";
            mensagem = e.getMessage();
        }

        // Persistência
        try {
            Database db = new Database();
            db.gravarDadosDB(calculadora, getOperando1(), getOperador(), getOperando2(), res, status, mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * Método toString
     *
     * @return String representando a expressão
     */
    public String toString() {
        return "(" + getOperando1() + " " + getOperador() + " " + getOperando2() + ")";
    }
}
