package com.gilsonalves.helpdesk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusAndPrioridadeOrderByDataDesc(
			String Titulo, String status, String prioridade, Pageable pages);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusAndPrioridadeAndUserIdOrderByDataDesc(
			String Titulo, String status, String prioridade, Pageable pages);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusAndPrioridadeAndAssignedUserIdOrderByDataDesc(
			String Titulo, String status, String prioridade, Pageable pages);
	
	Page<Ticket> findByNumero(Integer numero, Pageable pages);
}





















