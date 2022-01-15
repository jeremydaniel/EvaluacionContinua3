package sistema.daa2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    private int idcliente;

    private String dni_cli;

    private String nombre_cli;
 
    private String  apellido_cli;

    private String  celular_cli;
   
    private String  direccion_cli;
	
    public Cliente() {
		
	}

	public Cliente(Integer idcliente, String dni_cli, String nombre_cli, String apellido_cli, String celular_cli,
			String direccion_cli) {
		super();
		this.idcliente = idcliente;
		this.dni_cli = dni_cli;
		this.nombre_cli = nombre_cli;
		this.apellido_cli = apellido_cli;
		this.celular_cli = celular_cli;
		this.direccion_cli = direccion_cli;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
   @Column(name = "dnicliente",length=8, nullable = false)
	public String getDni_cli() {
		return dni_cli;
	}

	public void setDni_cli(String dni_cli) {
		this.dni_cli = dni_cli;
	}
	   @Column(name = "nombrecliente",length=50, nullable = false)
	public String getNombre_cli() {
		return nombre_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}
    @Column(name = "apellidocliente",length=50, nullable = false)
	public String getApellido_cli() {
		return apellido_cli;
	}

	public void setApellido_cli(String apellido_cli) {
		this.apellido_cli = apellido_cli;
	}
	@Column(name = "celularcliente",length=9, nullable = false)
	public String getCelular_cli() {
		return celular_cli;
	}

	public void setCelular_cli(String celular_cli) {
		this.celular_cli = celular_cli;
	}
	@Column(name = "direccioncliente",length=50, nullable = true)
	public String getDireccion_cli() {
		return direccion_cli;
	}

	public void setDireccion_cli(String direccion_cli) {
		this.direccion_cli = direccion_cli;
	}

    
}
