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
import sistema.daa2.model.Cliente;
import sistema.daa2.repository.ClienteRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;


	@GetMapping("/clientes")
	public List<Cliente> getAllEmployees() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") int idcliente)
			throws ResourceNotFoundException {
		Cliente cliente= clienteRepository.findById(idcliente)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id :: " + idcliente));
		return ResponseEntity.ok().body(cliente);
}
	
	@PostMapping("/clientes")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateEmployee(@PathVariable(value = "id") int idcliente,
			 @RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(idcliente)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id :: " + idcliente));

		cliente.setDni_cli(clienteDetails.getDni_cli());
		cliente.setNombre_cli(clienteDetails.getNombre_cli());
		cliente.setApellido_cli(clienteDetails.getApellido_cli());
		cliente.setCelular_cli(clienteDetails.getDireccion_cli());
		cliente.setDireccion_cli(clienteDetails.getDireccion_cli());
	
		final Cliente updatedCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(updatedCliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") int idcliente)
			throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(idcliente)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id :: " + idcliente));

		clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	

}











