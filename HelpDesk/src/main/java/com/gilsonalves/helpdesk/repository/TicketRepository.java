package com.gilsonalves.helpdesk.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gilsonalves.helpdesk.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	/**
	 * Método que pesquisa os tickets pelo id do Usuário
	 * 
	 * @param pages
	 * @param userId
	 * @return
	 */
	Page<Ticket> findByUserIdOrderByDataDesc(Pageable pages, String userId);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriodadeIgnoreCaseContainingOrderByDataDesc(
			String Titulo, String status, String prioridade, Pageable pages);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriodadeIgnoreCaseContainingAndUserIdOrderByDataDesc(
			String Titulo, String status, String prioridade, Pageable pages);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriodadeIgnoreCaseContainingAndassignedUserIdOrderByDataDesc(
			String Titulo, String status, String prioridade, Pageable pages);
	
	Page<Ticket> findByNumber(Integer numero, Pageable pages);
}





















