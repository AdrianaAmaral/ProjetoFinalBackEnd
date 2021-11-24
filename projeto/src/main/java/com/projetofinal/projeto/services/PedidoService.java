package com.projetofinal.projeto.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.projeto.domain.Cliente;
import com.projetofinal.projeto.domain.Funcionario;
import com.projetofinal.projeto.domain.Pedido;
import com.projetofinal.projeto.domain.dto.PedidoDTO;
import com.projetofinal.projeto.domain.enums.Status;
import com.projetofinal.projeto.repository.PedidoRepository;
import com.projetofinal.projeto.services.exceptions.ObjectnotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private ClienteService clienteService;

	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido create(PedidoDTO obj) {
		return repository.save(newPedido(obj));
	}

	public Pedido update(Integer id, @Valid PedidoDTO objDTO) {
		objDTO.setId(id);
		Pedido oldObj = findById(id);
		oldObj = newPedido(objDTO);
		return repository.save(oldObj);
	}

	private Pedido newPedido(PedidoDTO obj) {
		Funcionario funcionario = funcionarioService.findById(obj.getFuncionario());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Pedido Pedido = new Pedido();
		if(obj.getId() != null) {
			Pedido.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			Pedido.setDataFechamento(LocalDate.now());
		}
		
		Pedido.setFuncionario(funcionario);
		Pedido.setCliente(cliente);
		Pedido.setStatus(Status.toEnum(obj.getStatus()));
		Pedido.setTitulo(obj.getTitulo());
		Pedido.setObservacoes(obj.getObservacoes());
		return Pedido;
	}

}