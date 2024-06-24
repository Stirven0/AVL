package Oters;

import java.lang.reflect.Array;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private StringProperty primerNombre;
    private StringProperty segundoNombre;
    private StringProperty primerApellido;
    private StringProperty segundoApellido;
    private IntegerProperty  edad;
    private StringProperty sexo;
    private StringProperty stadoCivil;
    private StringProperty direccion;
    private StringProperty ciudad;
    private StringProperty departamento;
    private StringProperty pais;
    private IntegerProperty  salario;


    
    public Persona(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad,
            String sexo, String stadoCivil, String direccion, String ciudad, String departamento, String pais,
            int salario) {
        this.primerNombre = new SimpleStringProperty(primerNombre);
        this.segundoNombre = new SimpleStringProperty(segundoNombre);
        this.primerApellido = new SimpleStringProperty(primerApellido);
        this.segundoApellido = new SimpleStringProperty(segundoApellido);
        this.edad = new SimpleIntegerProperty(edad);
        this.sexo = new SimpleStringProperty(sexo);
        this.stadoCivil = new SimpleStringProperty(stadoCivil);
        this.direccion = new SimpleStringProperty(direccion);
        this.ciudad = new SimpleStringProperty(ciudad);
        this.departamento = new SimpleStringProperty(departamento);
        this.pais = new SimpleStringProperty(pais);
        this.salario = new SimpleIntegerProperty(salario);
    }

    public Persona() {
    }
    public String getPrimerNombre() {
        return primerNombre.get();
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre.set(primerNombre);
    }
    public StringProperty primerNombreStringProperty() {
        return primerNombre;
    }
    public String getSegundoNombre() {
        return segundoNombre.get();
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre.set(segundoNombre);
    }
    public StringProperty segundoNombreStringProperty() {
        return segundoNombre;
    }
    public String getPrimerApellido() {
        return primerApellido.get();
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido.set(primerApellido);
    }
    public StringProperty primerApellidoStringProperty() {
        return primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido.get();
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido.set(segundoApellido);;
    }
    public StringProperty segundoApellidoStringProperty() {
        return segundoApellido;
    }
    public int getEdad() {
        return edad.get();
    }
    public void setEdad(int edad) {
        this.edad.set(edad);
    }
    public IntegerProperty edadStringProperty() {
        return edad;
    }
    public String getSexo() {
        return sexo.get();
    }
    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }
    public StringProperty sexoStringProperty() {
        return sexo;
    }
    public String getStadoCivil() {
        return stadoCivil.get();
    }
    public void setStadoCivil(String stadoCivil) {
        this.stadoCivil.set(stadoCivil);
    }
    public StringProperty stadoCivilStringProperty() {
        return stadoCivil;
    }
    public String getDireccion() {
        return direccion.get();
    }
    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }
    public StringProperty direccionStringProperty() {
        return direccion;
    }
    public String getCiudad() {
        return ciudad.get();
    }
    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }
    public StringProperty ciudadStringProperty() {
        return ciudad;
    }
    public String getDepartamento() {
        return departamento.get();
    }
    public void setDepartamento(String departamento) {
        this.departamento.set(departamento);
    }
    public StringProperty departamentoStringProperty() {
        return departamento;
    }
    public String getPais() {
        return pais.get();
    }
    public void setPais(String pais) {
        this.pais.set(pais);
    }
    public StringProperty paisStringProperty() {
        return pais;
    }
    public int getSalario() {
        return salario.get();
    }
    public void setSalario(int salario) {
        this.salario.set(salario);
    }
    public IntegerProperty salarioStringProperty() {
        return salario;
    }


    public String[] toArray(){
        
        return  new String[] {primerNombre.get(),segundoNombre.get(),primerApellido.get(),segundoApellido.get(),Integer.toString(edad.get()),sexo.get(),stadoCivil.get(),direccion.get(),ciudad.get(),departamento.get(),pais.get(),Integer.toString(salario.get())};
    }

    @Override
    public String toString() {
        return "Persona [primerNombre=" + primerNombre.get() + ", segundoNombre=" + segundoNombre.get() + ", primerApellido="
                + primerApellido.get() + ", segundoApellido=" + segundoApellido.get() + ", edad=" + edad.get() + ", sexo=" + sexo.get()
                + ", stadoCivil=" + stadoCivil.get() + ", direccion=" + direccion.get() + ", ciudad=" + ciudad.get() + ", departamento="
                + departamento.get() + ", pais=" + pais.get() + ", salario=" + salario.get() + "]";
    }
    
}
