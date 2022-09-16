package logico;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMusuario implements TableModel{
    
    protected ArrayList<Persona> listapersonas;
    
    public TMusuario(ArrayList<Persona> lista) {
        listapersonas = lista; 
    }
    
    @Override
    public int getRowCount() {
        return listapersonas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String titulo = "";
        switch(columnIndex){
            case 0: {
                titulo = "ID";
                break; 
            }
            
            case 1: {
                titulo = "NOMBRE";
                break; 
            }
             
            case 2: {
                titulo = "APELLIDO";
                break; 
            }
            
            case 3: {
                titulo = "GÉNERO";
                break; 
            }
            
            case 4: {
                titulo = "ROL";
                break; 
            }
        
            case 5: {
                titulo = "FECHA DE NACIMIENTO";
                break; 
            }  
        }
        return titulo;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return columnIndex != 0;
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona user = listapersonas.get(rowIndex);
        String valor = "";
        switch(columnIndex){
            case 0: {
                valor = user.getCedula();
                break; 
            }
            
            case 1: {
                valor = user.getNombre();
                break; 
            }
             
            case 2: {
                valor = user.getApellido();
                break; 
            }
            
            case 3: {
                valor = user.getGenero();
                break; 
            }
            
            case 4: {
                valor = user.getTipo_usuario();
                break; 
            }
        
            case 5: {
                //valor = user.getFecha_nac();
                break; 
            }  
        }
        return valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       /* Persona per = listapersonas.get(rowIndex);
        switch(columnIndex){
            case 0: {
                per.setCedula(aValue.toString());
                break; 
            }
            
            case 1: {
                per.setNombre(aValue.toString());
                break; 
            }
             
            case 2: {
                per.setApellido(aValue.toString());
                break; 
            }
            
            case 3: {
                per.setGenero(aValue.toString());
                break; 
            }
            
            case 4: {
                per.setTipo_usuario(aValue.toString());
                break; 
            }
        
            case 5: {
                per.setFecha_nac(aValue.toString());
                break; 
            }  
        }*/
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    
    
    
}
