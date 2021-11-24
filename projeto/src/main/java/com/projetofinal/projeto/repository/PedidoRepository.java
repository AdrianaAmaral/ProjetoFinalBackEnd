package com.projetofinal.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.projeto.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	
}
