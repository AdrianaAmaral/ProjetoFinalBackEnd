package com.projetofinal.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.projeto.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
