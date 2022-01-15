package sistema.daa2.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	private Integer cod_vendedor;
	
	private String nombres;

	private String apellidos;
	
	private String dni;
	
	private String celular;

	private String direccion;

	public Vendedor() {
	
	}

	public Vendedor(Integer cod_vendedor, String nombres, String apellidos, String dni, String celular,
			String direccion) {
		super();
		this.cod_vendedor = cod_vendedor;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.celular = celular;
		this.direccion = direccion;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCod_vendedor() {
		return cod_vendedor;
	}

	public void setCod_vendedor(Integer cod_vendedor) {
		this.cod_vendedor = cod_vendedor;
	}
    @Column(name = "nombres",length=50, nullable = false)
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	@Column(name = "apellidos",length=50, nullable = false)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Column(name = "dni",length=8, nullable = false)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Column(name = "dnicliente",length=9, nullable = false)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@Column(name = "direccion",length=50, nullable = false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
