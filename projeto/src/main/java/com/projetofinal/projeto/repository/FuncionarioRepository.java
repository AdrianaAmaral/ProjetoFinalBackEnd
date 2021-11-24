package com.projetofinal.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.projeto.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
