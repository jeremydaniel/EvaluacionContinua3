package sistema.daa2.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.daa2.exception.ResourceNotFoundException;

import sistema.daa2.model.Venta;
import sistema.daa2.repository.VentaRepository;



@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api/v3")
public class VentaController {
	
	@Autowired
	private VentaRepository ventaRepository;
	@GetMapping("/ventas")
	public List<Venta> getAllVentas() {
	return ventaRepository.findAll();
	}
	@GetMapping("/ventas/{id}")
	public ResponseEntity<Venta> getVentaById(@PathVariable(value = "id") int idventa)
	throws ResourceNotFoundException {
	Venta venta= ventaRepository.findById(idventa)
	.orElseThrow(() -> new ResourceNotFoundException("Venta not found for this id :: " + idventa));
	return ResponseEntity.ok().body(venta);
	}
	@PostMapping("/ventas")
	public Venta createVenta(@RequestBody Venta venta) {
	return ventaRepository.save(venta);
	}
	
	@PutMapping("/ventas/{id}")
	public ResponseEntity<Venta> updateEmployee(@PathVariable(value = "id") int idventa,
			 @RequestBody Venta ventaDetails) throws ResourceNotFoundException {
		Venta venta = ventaRepository.findById(idventa)
				.orElseThrow(() -> new ResourceNotFoundException("Venta not found for this id :: " + idventa));

		venta.setTotal(ventaDetails.getTotal());
	
		final Venta updatedVenta = ventaRepository.save(venta);
		return ResponseEntity.ok(updatedVenta);
	}
	@DeleteMapping("/ventas/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") int idventa)
			throws ResourceNotFoundException {
		Venta venta = ventaRepository.findById(idventa)
				.orElseThrow(() -> new ResourceNotFoundException("Venta not found for this id :: " + idventa));

		ventaRepository.delete(venta);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
