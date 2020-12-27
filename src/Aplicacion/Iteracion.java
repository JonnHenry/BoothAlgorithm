/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

/**
 *
 * @author jonat
 */
public class Iteracion {

    private final String valores[] = {"A:", "S:", "P:"};
    private String numIteracion = "";
    private String primerosBitsA = "";
    private String segundosBitsA = "";
    private String bitAdicionalA = "";

    private String primerosBitsS = "";
    private String segundosBitsS = "";
    private String bitAdicionalS = "";

    private String primerosBitsP = "";
    private String segundosBitsP = "";
    private String bitAdicionalP = "";

    Iteracion(String numIteracion, String primerosBitsA, String segundosBitsA, String bitAdicionalA, String primerosBitsS, String segundosBitsS, String bitAdicionalS, String primerosBitsP, String segundosBitsP, String bitAdicionalP) {
        this.numIteracion = numIteracion;
        this.primerosBitsA = primerosBitsA;
        this.segundosBitsA = segundosBitsA;
        this.bitAdicionalA = bitAdicionalA;
        this.primerosBitsS = primerosBitsS;
        this.segundosBitsS = segundosBitsS;
        this.bitAdicionalS = bitAdicionalS;
        this.primerosBitsP = primerosBitsP;
        this.segundosBitsP = segundosBitsP;
        this.bitAdicionalP = bitAdicionalP;
    }

    public String getValor(Integer index) { //Retorna el valor del indice
        return valores[index];
    }

    public String getNumIteracion() {
        return numIteracion;
    }

    public String getPrimerosBitsA() {
        return primerosBitsA;
    }

    public String getSegundosBitsA() {
        return segundosBitsA;
    }

    public String getBitAdicionalA() {
        return bitAdicionalA;
    }

    public String getPrimerosBitsS() {
        return primerosBitsS;
    }

    public String getSegundosBitsS() {
        return segundosBitsS;
    }

    public String getBitAdicionalS() {
        return bitAdicionalS;
    }

    public String getPrimerosBitsP() {
        return primerosBitsP;
    }

    public String getSegundosBitsP() {
        return segundosBitsP;
    }

    public String getBitAdicionalP() {
        return bitAdicionalP;
    }

}
