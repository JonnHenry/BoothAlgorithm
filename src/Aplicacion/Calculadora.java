package Aplicacion;

import java.util.ArrayList;
import Aplicacion.Iteracion;
import javax.swing.JOptionPane;

public class Calculadora {

    private ArrayList<Iteracion> datosTabla;

    public Calculadora() {

    }

    public ArrayList<Iteracion> getDatosTabla() {
        return datosTabla;
    }

    //validacion del numero en un rango correcto y que no cause overFlow
    public boolean validarDecimal(String num, int bits) {
        int x = -1;
        try {
            x = Integer.valueOf(num);
            if (x <= Math.pow(2, bits - 1) - 1 && x >= -Math.pow(2, bits - 1) - 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private String divideCuatroCaracteres(String cadenaBits) {
        String nuevaCadenaBits = "";
        Integer numIteraciones = (int) cadenaBits.length() / 4;
        for (int contador = 0; contador < numIteraciones; contador++) {
            nuevaCadenaBits = nuevaCadenaBits + cadenaBits.substring(contador * 4, contador * 4 + 4) + " ";
        }
        return nuevaCadenaBits;
    }

    //convierte un numero a complemento a2
    public ArrayList<Integer> complemento_a2(String x, int tamanio) {
        int bin = Integer.parseInt(x);
        ArrayList<Integer> binarioCompleto = new ArrayList<>();
        if (bin > 0) {
            String binario = Integer.toBinaryString(bin);
            int aux = tamanio - binario.length();
            String bins = "";
            for (int i = 0; i < aux; i++) {
                bins += "0";
            }
            bins = bins + binario;
            binario = bins;
            boolean band = false;
            int pos = 0;
            for (int i = 0; i < binario.length(); i++) {
                if (binario.charAt(i) == '1') {
                    pos = i;
                }
            }
            for (int i = 0; i < pos; i++) {
                if (binario.charAt(i) == '1') {
                    binarioCompleto.add(0);
                } else {
                    binarioCompleto.add(1);
                }
            }
            for (int i = pos; i < binario.length(); i++) {
                binarioCompleto.add(Integer.valueOf(String.valueOf(binario.charAt(i))));
            }

        }
        return binarioCompleto;
    }

    //convierte un numero a binario
    public ArrayList<Integer> binario(String x, int bits) {
        int bin = Integer.parseInt(x);

        ArrayList<Integer> binarioCompleto = new ArrayList<>();
        if (bin < 0) {
            String binario = Integer.toBinaryString(bin);
            for (int i = binario.length() - bits; i < binario.length(); i++) {
                binarioCompleto.add(Integer.parseInt(String.valueOf(binario.charAt(i))));
            }
        } else {
            String binario = Integer.toBinaryString(bin);
            int rango = bits - binario.length();
            for (int i = 0; i < rango; i++) {
                binarioCompleto.add(0);
            }
            for (int i = 0; i < binario.length(); i++) {
                binarioCompleto.add(Integer.parseInt(String.valueOf(binario.charAt(i))));
            }
        }

        return binarioCompleto;
    }

    //suma los dos arreglos 
    public ArrayList<Integer> sumar(ArrayList<Integer> P, ArrayList<Integer> extra, int bit) {
        String a = convierte_a_string(P);
        String b = convierte_a_string(extra);
        ArrayList<Integer> resultado = new ArrayList<>();
        String result = "";
        int s = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);
            result = (char) (s % 2 + '0') + result;
            s /= 2;
            i--;
            j--;
        }
        String salida = result;
        if (result.length() > (bit * 2 + 1)) {
            int x = result.length() - (bit * 2 + 1);
            salida = result.substring(x, result.length());
        }

        for (int k = 0; k < salida.length(); k++) {
            resultado.add(Integer.parseInt(String.valueOf(salida.charAt(k))));
        }
        return resultado;
    }

    //realiza desplazamiento
    public ArrayList<Integer> desplazamiento(ArrayList<Integer> dato) {
        ArrayList<Integer> salida = new ArrayList<>();
        String datos = convierte_a_string(dato);
        String bitSignificativo = datos.substring(0, 1);
        for (int i = 0; i < dato.size(); i++) {
            if (i == 0) {
                salida.add(Integer.valueOf(bitSignificativo));
            } else {
                salida.add(dato.get(i - 1));
            }
        }
        return salida;
    }

    //convierte el vector a string
    public String convierte_a_string(ArrayList<Integer> datos) {
        String salida = "";
        for (int i = 0; i < datos.size(); i++) {
            salida += datos.get(i);
        }
        return salida;
    }

    //crea el vector s
    public void crear_s(ArrayList<Integer> S, ArrayList<Integer> multiplicandoC2, int bit) {
        for (int i = 0; i < (2 * bit + 1); i++) {
            if (i < bit) {
                S.add(multiplicandoC2.get(i));
            } else {
                S.add(0);
            }
        }
    }

    //crea el vector a
    public void crear_a(ArrayList<Integer> A, ArrayList<Integer> multiplicando, int bit) {
        for (int i = 0; i < (2 * bit + 1); i++) {
            if (i < bit) {
                A.add(multiplicando.get(i));
            } else {
                A.add(0);
            }
        }
    }

    //crea el vector p
    public void crear_p(ArrayList<Integer> P, ArrayList<Integer> multiplicador, int bit) {
        for (int i = 0; i < 2 * bit; i++) {
            if (i < bit) {
                P.add(0);
            } else {
                P.add(multiplicador.get(i - bit));
            }
        }
        P.add(0);
    }

    //realiza todo el procedimiento
    public ArrayList<String> procedimiento(String numero1, String numero2, int bit) {
        //Arrays a utilizar

        ArrayList<String> resultado = new ArrayList<String>();
        ArrayList<Integer> A;
        ArrayList<Integer> S;
        ArrayList<Integer> P;
        ArrayList<Integer> multiplicador, multiplicando;
        ArrayList<Integer> multiplicandoC2;
        //valida el numero
        if (validarDecimal(numero1, bit) && validarDecimal(numero2, bit)) {
            A = new ArrayList<>();
            S = new ArrayList<>();
            P = new ArrayList<>();
            int x = Integer.valueOf(numero1);
            int y = Integer.valueOf(numero2);
            //en ves de imprimir se puede mostrar en la interfaz 
            //muestra los numeros que se va a multiplicar

            if (x > 0) {//cuando el primer numero es positivo
                multiplicando = binario(numero1, bit);
                multiplicandoC2 = complemento_a2(numero1, bit);

            } else {//o negativo
                multiplicandoC2 = binario(numero1, bit);
                multiplicando = binario(String.valueOf(x * -1), bit);
            }
            multiplicador = binario(numero2, bit);
            if (x < 0) {//consideraciones para crear los vectores A,S
                crear_a(A, multiplicandoC2, bit);
                crear_s(S, multiplicando, bit);
            } else {
                crear_a(A, multiplicando, bit);
                crear_s(S, multiplicandoC2, bit);
            }
            crear_p(P, multiplicador, bit);
           
            resultado = Iteraciones(A, S, P, bit);
        } else {
            //se deberia mostrar en la interfaz cuando causa overflow por 
            //ejemplo (140)*(-5) en 8 bits causaria overFlow
            //porque en 8 bits se representa solo numeros hasta -127 y 127
            //System.out.println("OverFlow"); //LLamar a una ventana emergente 
            resultado.add("");
            resultado.add("");
            resultado.add("");

            JOptionPane.showMessageDialog(null, "El valor del multiplicando o el multiplicador no puede representarse con la cantidad de bits elegidos.", "Error de OverFlow", JOptionPane.ERROR_MESSAGE);

        }
        return resultado;
    }

    public ArrayList<String> Iteraciones(ArrayList<Integer> A, ArrayList<Integer> S, ArrayList<Integer> P, int bit) {

        //convirtiendo a string los vectores
        this.datosTabla = new ArrayList<Iteracion>();
        ArrayList<String> resultado = new ArrayList<String>();
        String a = convierte_a_string(A);
        String s = convierte_a_string(S);
        String p = convierte_a_string(P);
        
        datosTabla.add(new Iteracion("Valores Iniciales del Algoritmo",
                divideCuatroCaracteres(a.substring(0, bit)), divideCuatroCaracteres(a.substring(bit, bit * 2)), a.substring(bit * 2, bit * 2 + 1),
                divideCuatroCaracteres(s.substring(0, bit)), divideCuatroCaracteres(s.substring(bit, bit * 2)), s.substring(bit * 2, bit * 2 + 1),
                divideCuatroCaracteres(p.substring(0, bit)), divideCuatroCaracteres(p.substring(bit, bit * 2)), p.substring(bit * 2, bit * 2 + 1)));

        
        for (int i = 0; i < bit; i++) {
            String condicion = "";
            //condicion para ver cual se suma o si son solo desplazamientos
            condicion = p.substring(bit * 2 - 1, bit * 2 + 1);
            switch (condicion) {
                case "01": // se debe sumar P Y A
                    P = sumar(P, A, bit);
                    P = desplazamiento(P);
                    a = convierte_a_string(A);
                    s = convierte_a_string(S);
                    p = convierte_a_string(P);
                    //muestra resultados se podria mostrar en una tabla o en un txt en el Gui

                    datosTabla.add(new Iteracion(String.valueOf(i + 1) + ": Operación P=P+A y Desplazamiento",
                            divideCuatroCaracteres(a.substring(0, bit)), divideCuatroCaracteres(a.substring(bit, bit * 2)), a.substring(bit * 2, bit * 2 + 1),
                            divideCuatroCaracteres(s.substring(0, bit)), divideCuatroCaracteres(s.substring(bit, bit * 2)), s.substring(bit * 2, bit * 2 + 1),
                            divideCuatroCaracteres(p.substring(0, bit)), divideCuatroCaracteres(p.substring(bit, bit * 2)), p.substring(bit * 2, bit * 2 + 1)));

                    break;
                case "10"://se suma P y S
                    P = sumar(P, S, bit);
                    P = desplazamiento(P);
                    a = convierte_a_string(A);
                    s = convierte_a_string(S);
                    p = convierte_a_string(P);
                    //resultados en vez de mostrar en consola se debe mostrar en la GUI

                    datosTabla.add(new Iteracion(String.valueOf(i + 1) + ": Operación P=P+S y Desplazamiento",
                            divideCuatroCaracteres(a.substring(0, bit)), divideCuatroCaracteres(a.substring(bit, bit * 2)), a.substring(bit * 2, bit * 2 + 1),
                            divideCuatroCaracteres(s.substring(0, bit)), divideCuatroCaracteres(s.substring(bit, bit * 2)), s.substring(bit * 2, bit * 2 + 1),
                            divideCuatroCaracteres(p.substring(0, bit)), divideCuatroCaracteres(p.substring(bit, bit * 2)), p.substring(bit * 2, bit * 2 + 1)));
                    break;
                default://cuando es solo desplazamiento
                    P = desplazamiento(P);
                    a = convierte_a_string(A);
                    s = convierte_a_string(S);
                    p = convierte_a_string(P);
                    //los datos que se deben mostrar en la GUI

                    datosTabla.add(new Iteracion(String.valueOf(i + 1) + ": Operación Desplazamiento",
                            divideCuatroCaracteres(a.substring(0, bit)), divideCuatroCaracteres(a.substring(bit, bit * 2)), a.substring(bit * 2, bit * 2 + 1),
                            divideCuatroCaracteres(s.substring(0, bit)), divideCuatroCaracteres(s.substring(bit, bit * 2)), s.substring(bit * 2, bit * 2 + 1),
                            divideCuatroCaracteres(p.substring(0, bit)), divideCuatroCaracteres(p.substring(bit, bit * 2)), p.substring(bit * 2, bit * 2 + 1)));

                    break;
            }
        }
        int signo = Integer.valueOf(P.get(0));//vetificamos el signo
        String signoResultado = "";
        String resultadoDecimal = "";
        String resultadoBinario = "";
        resultadoBinario = convierte_a_string(P).substring(0, bit * 2);

        if (signo == 1)//dependiendo del signo se manda a convertir a decimal y devolver el resultado en decimal
        {
            signoResultado = "1=>'-'";
            resultadoDecimal = String.valueOf(convertirDecimalNegativo(P, bit, signo));
        } else {
            resultadoDecimal = String.valueOf(convertirDecimalPositivo(P, bit, signo));
            signoResultado = "0=>'+'";
        }

        resultado.add(signoResultado);
        resultado.add(divideCuatroCaracteres(resultadoBinario));
        resultado.add(resultadoDecimal);
        return resultado;

    }

    //convierte a decimal cuando el resultado es negativo
    public int convertirDecimalNegativo(ArrayList<Integer> dato, int bit, int signo) {
        String decimal = "";
        for (int i = dato.size() - 2; i > 0; i--) {//transforma los 0 en 1 y viceversa
            if (dato.get(i) == 1) {
                decimal += '0';
            } else {
                decimal += '1';
            }
        }
        //lo que se transformo se manda a calcular el decimal
        return convertiraDecimal(decimal, signo);
    }

    //convierte directamente el resultado en decimal
    public int convertirDecimalPositivo(ArrayList<Integer> dato, int bit, int signo) {
        int suma = 0, contador = 0;
        for (int i = dato.size() - 2; i > 0; i--) {
            if (dato.get(i) == 1) {
                suma += Math.pow(2, contador);
            }
            contador++;
        }
        return suma;
    }

    //calcula el decimal de un numero negativo
    public int convertiraDecimal(String numero, int signo) {
        int contador = 0, suma = 1;
        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) == '1') {
                suma += Math.pow(2, contador);
            }
            contador++;
        }
        if (signo == 1) {
            suma *= -1;
        }
        return suma;
    }

}
