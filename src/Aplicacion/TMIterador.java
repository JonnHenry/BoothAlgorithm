/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class TMIterador implements TableModel {

    private ArrayList<Iteracion> tabla;
    private Integer nbits = 8;

    public TMIterador(ArrayList<Iteracion> tabla, Integer nbits) {
        this.tabla = tabla;
        this.nbits = nbits;
    }

    @Override
    public int getRowCount() {
        return tabla.size() * 3;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombre = "";
        switch (columnIndex) {
            case 0: {
                nombre = "Iteración";
                break;
            }

            case 1: {
                nombre = "Valores";
                break;
            }

            case 2: {
                nombre = String.valueOf(nbits) + " bits primarios";
                break;
            }

            case 3: {
                nombre = String.valueOf(nbits) + " bits secundarios";
                break;
            }

            case 4: {
                nombre = "Bit Adicional";
                break;
            }
        }
        return nombre;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        Integer iteracion = (int) Math.ceil(rowIndex / 3);
        Integer subFila = (int) rowIndex % 3;
        ArrayList<String> valoresColumna = new ArrayList<String>();
        Iteracion valoresIteracion = tabla.get(iteracion);

        switch (subFila) {
            case 0: {
                valoresColumna.add(valoresIteracion.getNumIteracion());
                valoresColumna.add(valoresIteracion.getValor(0));
                valoresColumna.add((valoresIteracion.getPrimerosBitsA()));
                valoresColumna.add((valoresIteracion.getSegundosBitsA()));
                valoresColumna.add(valoresIteracion.getBitAdicionalA());
                break;
            }

            case 1: {
                valoresColumna.add("");
                valoresColumna.add(valoresIteracion.getValor(1));
                valoresColumna.add((valoresIteracion.getPrimerosBitsS()));
                valoresColumna.add((valoresIteracion.getSegundosBitsS()));
                valoresColumna.add(valoresIteracion.getBitAdicionalS());
                break;
            }

            case 2: {
                valoresColumna.add("");
                valoresColumna.add(valoresIteracion.getValor(2));
                valoresColumna.add((valoresIteracion.getPrimerosBitsP()));
                valoresColumna.add((valoresIteracion.getSegundosBitsP()));
                valoresColumna.add(valoresIteracion.getBitAdicionalP());
                break;
            }
        }
        return valoresColumna.get(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //No usado
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //No usado

    }

}
