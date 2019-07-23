package com.gilsonalves.helpdesk.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.gilsonalves.helpdesk.entity.AlteracoesStatus;
import com.gilsonalves.helpdesk.entity.Ticket;

@Component
public interface TicketService {

	/**
	 * Método que cria ou altera um ticket
	 * 
	 * @param ticket
	 * @return
	 */
	Ticket createOrUpdate(Ticket ticket);

	/**
	 * Método que busca um ticket pelo ID
	 */
	Ticket findById(String id);

	/**
	 * Método que remove um ticket
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * Método que retorna os registros e a quantidade de paginas
	 * 
	 * @param page
	 * @param count
	 * @return
	 */
	Page<Ticket> listTiket(int page, int count);

	/**
	 * Método que guarda todas as alterações
	 * 
	 * @param alteracoes
	 * @return
	 */
	AlteracoesStatus createChangeStatus(AlteracoesStatus alteracoes);

	/**
	 * Método que lista todas as alterações feitas
	 * 
	 * @param tickectId
	 * @return
	 */
	List<AlteracoesStatus> listAlteracoesStatus(String tickectId);

	/**
	 * Método que pesquisa apenas os tickets de um determinado usuário
	 * 
	 * @param page
	 * @param count
	 * @param userId
	 * @return
	 */
	Page<Ticket> findByCurrentUser(int page, int count, String userId);

	/**
	 * Método que pesquiza por parametros
	 * 
	 * @param page
	 * @param count
	 * @param titulo
	 * @param status
	 * @param prioridade
	 * @return
	 */
	Page<Ticket> findByParameters(int page, int count, String titulo, String status, String prioridade);

	/**
	 * Método que realiza uma pesquiza por parametros de um determinado usuário
	 * 
	 * @param page
	 * @param count
	 * @param titulo
	 * @param status
	 * @param prioridade
	 * @param userID
	 * @return
	 */
	Page<Ticket> findByParametersAndCurrentUser(int page, int count, String titulo, String status, String prioridade, String userID);
	
	/**
	 * Método que pesquiza pelo numero do ticket
	 * @param page
	 * @param count
	 * @param numero
	 * @return
	 */
	Page<Ticket> findByNumero(int page, int count, int numero);
	
	/**
	 * Método que faz um resumo de todos os tickets
	 * @return
	 */
	List<Ticket> findAll();
	
	/**
	 * Método que pesquisa por parametros de um determinado técnico
	 * @param page
	 * @param count
	 * @param titulo
	 * @param status
	 * @param prioridade
	 * @param assignedUser
	 * @return
	 */
	Page<Ticket> findByParmaterAndAssignedUser(int page, int count, String titulo, String status, String prioridade, String assignedUser);
}




















