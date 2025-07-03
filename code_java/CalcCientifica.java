/**
 * Calculadora científica composta por Calculadora básica.
 * Implementa novas operações e as 5 operações básicas 
 * (+, -, *, /, %).
 * 
 * @author 
 * @version 1.0
 */
public class CalcCientifica {
    // Atributos
    CalcBasica cb;

    // Construtores
    /**
     * Construtor para operações avançadas.
     *
     * @param operador String: "sqrt", "inverso", "seno", "fatorial"
     * @param operando double: valor onde o operador será aplicado
     */
    CalcCientifica(String operador, double operando) {
        cb = new CalcBasica(operando, operador, 0);
    }

    /**
     * Construtor para operações básicas.
     *
     * @param operando1 double: operando 1
     * @param operador String: "+", "-", "*", "/", "%"
     * @param operando2 double: operando 2
     */
    CalcCientifica(double operando1, String operador, double operando2) {
        cb = new CalcBasica(operando1, operador, operando2);
    }

    /**
     * Método calcular com persistência no banco de dados.
     *
     * @return O resultado da expressão
     */
    public double calcular() {
        double res = 0;
        String status = "success";
        String mensagem = "";
        String calculadora = "cientifica";

        try {
            switch (cb.getOperador()) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    res = cb.calcular();
                    break;
                case "sqrt":
                    if (cb.getOperando1() < 0) {
                        throw new ArithmeticException("Raiz quadrada de número negativo.");
                    }
                    res = Math.sqrt(cb.getOperando1());
                    break;
                case "inverso":
                    if (cb.getOperando1() == 0) {
                        throw new ArithmeticException("Divisão por zero ao calcular o inverso.");
                    }
                    res = cb.dividir(1.0, cb.getOperando1());
                    break;
                case "seno":
                    res = Math.sin(Math.toRadians(cb.getOperando1()));
                    break;
                case "fatorial":
                    if (cb.getOperando1() < 0) {
                        throw new ArithmeticException("Fatorial de número negativo não é definido.");
                    }
                    res = fatorial((long) cb.getOperando1());
                    break;
                default:
                    throw new IllegalArgumentException("Operador inválido: " + cb.getOperador());
            }
        } catch (Exception e) {
            res = 0;
            status = "failure";
            mensagem = e.getMessage();
        }

        // Persistência
        try {
            Database db = new Database();
            db.gravarDadosDB(calculadora, cb.getOperando1(), cb.getOperador(), cb.getOperando2(), res, status, mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * Método fatorial: calcula o fatorial de um número (parâmetro).
     *
     * @param n long número no qual será calculado o fatorial
     * @return r long fatorial do número (parâmetro)
     */
    private long fatorial(long n){
        long r = 1, i;
        if (n >= 1){
            for(i = n; i > 0; i--){
                r = (long)cb.multiplicar((double)r, (double)i);
            }           
        }
        else{
            r = 0;
        }
        return r;
    }

    /**
     * Método toString
     *
     * @return String representando uma operação básica ou avançada
     */
    public String toString() {
        String expr = cb.getOperador() + "(" + cb.getOperando1() + ")";

        switch (cb.getOperador()) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                expr = cb.toString();
                break;
        }

        return expr;
    }
}
