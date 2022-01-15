package sistema.daa2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {
	
	private Integer id_venta;
	
    private double total;
 
	private Vendedor vendedor;
    
	private Cliente cliente;

	public Venta() {
	
	}

	public Venta(Integer id_venta, double total, Vendedor vendedor, Cliente cliente) {
		super();
		this.id_venta = id_venta;
		this.total = total;
		this.vendedor = vendedor;
		this.cliente = cliente;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId_venta() {
		return id_venta;
	}

	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	   @ManyToOne
	    @JoinColumn(name="cod_vendedor")
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	 @ManyToOne
	    @JoinColumn(name="idcliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
