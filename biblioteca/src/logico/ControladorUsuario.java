package logico;

import java.util.ArrayList;
import java.util.Date;

public class ControladorUsuario {
    
    public static ArrayList<Persona> listausuarios = new ArrayList<>();    

    public ControladorUsuario() {
        Persona me = new Persona(1, "0105449649", "Mike", "toreno", "ADMINISTRADOR", "mike@gmail.com", "A+", new Date(),
        "Las Venturas" ,"Masculino", "0987654321", "123");
        Persona nuevo = new Persona(2, "0105449641", "Mike", "toreno", "INVITADO", "mike@gmail.com", "A+", new Date(),
        "Las Vegas", "Masculino", "0987654321", "123");
        ControladorUsuario.listausuarios.add(me);
        ControladorUsuario.listausuarios.add(nuevo);
    }
    
    
    
}
