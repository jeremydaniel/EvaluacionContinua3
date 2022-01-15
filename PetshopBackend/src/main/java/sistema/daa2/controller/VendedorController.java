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

import sistema.daa2.model.Vendedor;
import sistema.daa2.repository.VendedorRepository;

@CrossOrigin(origins = "http://localhost:4200")  
@RestController
@RequestMapping("/api/v2")
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping("/vendedores")
	public List<Vendedor> getAllVendedores() {
		return vendedorRepository.findAll();
	}
	
	@GetMapping("/vendedores/{id}")
	public ResponseEntity<Vendedor> getClienteById(@PathVariable(value = "id") int idvendedor)
			throws ResourceNotFoundException {
		Vendedor vendedor= vendedorRepository.findById(idvendedor)
				.orElseThrow(() -> new ResourceNotFoundException("Vendedor not found for this id :: " + idvendedor));
		return ResponseEntity.ok().body(vendedor);
}
	
	@PostMapping("/vendedores")
	public Vendedor createCliente(@RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	@PutMapping("/vendedores/{id}")
	public ResponseEntity<Vendedor> updateEmployee(@PathVariable(value = "id") int idvendedor,
			 @RequestBody Vendedor vendedorDetails) throws ResourceNotFoundException {
		Vendedor vendedor = vendedorRepository.findById(idvendedor)
				.orElseThrow(() -> new ResourceNotFoundException("Vendedor not found for this id :: " + idvendedor));

		vendedor.setNombres(vendedorDetails.getNombres());
		vendedor.setApellidos(vendedorDetails.getApellidos());
		vendedor.setDni(vendedorDetails.getDni());
		vendedor.setCelular(vendedorDetails.getCelular());
		vendedor.setDireccion(vendedorDetails.getDireccion());
	
		final Vendedor updatedVendedor = vendedorRepository.save(vendedor);
		return ResponseEntity.ok(updatedVendedor);
}
	@DeleteMapping("/vendedores/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") int idvendedor)
			throws ResourceNotFoundException {
		Vendedor vendedor = vendedorRepository.findById(idvendedor)
				.orElseThrow(() -> new ResourceNotFoundException("Vendedor not found for this id :: " + idvendedor));

		vendedorRepository.delete(vendedor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
