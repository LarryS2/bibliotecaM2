package logico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String tipo_usuario;
    private String email;
    private String tipo_sangre;
    private Date fecha_nac;
    private String direccion;
    private String genero;
    private String telefono;
    private String password;
    
    public Persona() {
    }

    public Persona(String cedula) {
        this.cedula = cedula;
    }

    public Persona(int id, String cedula, String nombre, String apellido,
            String tipo_usuario, String email, String tipo_sangre, Date 
                    fecha_nac, String direccion, String genero, String telefono, String password) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_usuario = tipo_usuario;
        this.email = email;
        this.tipo_sangre = tipo_sangre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.genero = genero;
        this.telefono = telefono;
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_usuario=" + tipo_usuario + ", email=" + email + ", tipo_sangre=" + tipo_sangre + ", fecha_nac=" + fecha_nac + ", direccion=" + direccion + ", genero=" + genero + ", telefono=" + telefono + ", password=" + password + '}';
    }
    
    public  boolean ValidarNombreYapellido(String nom) {
        return nom.matches("^[a-zA-Z]{2,}$");
    }
    
    public boolean ValidarCedula(String cedula) {
        int suma = 0;
        if (cedula.length() == 9) {

            return false;

        } else {
            int a[] = new int[cedula.length() / 2];
            int b[] = new int[(cedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < cedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
                c = c + 2;
                if (i < (cedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1)))) {
                return true;
            } else {
                return suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0';
            }
        }
    }
    
    
    public boolean ValidarCorreo(String correo)
    {
        return correo.matches("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}");
    }

    public boolean ValidarDireccion(String dire)
    {
        return dire.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
    
    public boolean ValidarTelefono(String tel)
    {
        return tel.matches("[593]{0,3}[0]{1}[1-9]{9}");
    }
    
    /*8 caracteres, al menos una letra en minúscula, una en mayúscula y números, no contiene símbolos especiales*/
    public boolean ValidarPassword(String pass) {
        return pass.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
    }
    
    public boolean Validar_fecha(String fecha) {
    try{
        
        new Date();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        String fechaCad = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return fecha.equals(fechaCad);
    }catch (ParseException pe){
    } catch (Exception e) {
    }
    return false;    
    }
}
