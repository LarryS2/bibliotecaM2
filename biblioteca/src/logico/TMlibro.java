package logico;

//import java.util.ArrayList;
//import javax.swing.event.TableModelListener;
//import javax.swing.table.TableModel;
//
//public class TMlibro implements TableModel{
//    
//    protected ArrayList<Libro> listalibros = new ArrayList();
//    
//    public TMlibro(ArrayList<Libro> lista) {
//        listalibros = lista;
//    }
//
//    @Override
//    public int getRowCount() {
//        return listalibros.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return 4;
//    }
//
//    @Override
//    public String getColumnName(int columnIndex) {
//        String libro = "";
//        switch(columnIndex){
//            case 0: {
//                libro = "CÓDIGO";
//                break; 
//            }
//            
//            case 1: {
//                libro = "TÍTULO";
//                break; 
//            }
//             
//            case 2: {
//                libro = "CATEGORÍA";
//                break; 
//            }
//            
//            case 3: {
//                libro = "DESCRIPCIÓN";
//                break; 
//            } 
//        }
//        return libro;
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return String.class;
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return false;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Libro lib = listalibros.get(rowIndex);
//        String valor = "";
//        switch(columnIndex){
//            case 0: {
//                //valor = lib.getCodigo();
//                break; 
//            }
//            
//            case 1: {
//                valor = lib.getTitulo();
//                break; 
//            }
//             
//            case 2: {
//                valor = lib.getId_categoria();
//                break; 
//            }
//            
//            case 3: {
//                valor = lib.getDescripcion();
//                break; 
//            }
//        }
//        return valor;
//    
//    }
//    //Ninguno es necesario por el momento
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//    }
//
//    @Override
//    public void addTableModelListener(TableModelListener l) {
//    }
//
//    @Override
//    public void removeTableModelListener(TableModelListener l) {
//    }
//}
