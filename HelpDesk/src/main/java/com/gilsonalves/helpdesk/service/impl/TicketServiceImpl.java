package com.gilsonalves.helpdesk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gilsonalves.helpdesk.entity.AlteracoesStatus;
import com.gilsonalves.helpdesk.entity.Ticket;
import com.gilsonalves.helpdesk.repository.AlteracoesStatusRepository;
import com.gilsonalves.helpdesk.repository.TicketRepository;
import com.gilsonalves.helpdesk.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private AlteracoesStatusRepository alteracoesStatusRepository;

	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		return this.ticketRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		this.ticketRepository.delete(id);
	}

	@Override
	public Page<Ticket> listTiket(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findAll(pages);
	}

	@Override
	public AlteracoesStatus createChangeStatus(AlteracoesStatus alteracoes) {
		return this.alteracoesStatusRepository.save(alteracoes);
	}

	@Override
	public List<AlteracoesStatus> listAlteracoesStatus(String tickectId) {
		return this.alteracoesStatusRepository.findByTicketIdOrderByDataDesc(tickectId);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDataDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String titulo, String status, String prioridade) {
		Pageable pages = new PageRequest(page, count);		
		return this.ticketRepository.findByTituloIgnoreCaseContainingAndStatusAndPrioridadeOrderByDataDesc(titulo, status, prioridade, pages);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String titulo, String status, String prioridade,
			String userID) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByTituloIgnoreCaseContainingAndStatusAndPrioridadeAndUserIdOrderByDataDesc(titulo, status, prioridade, userID, pages);
	}

	@Override
	public Page<Ticket> findByNumero(int page, int count, int numero) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByNumero(numero, pages);
	}

	@Override
	public List<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParmaterAndAssignedUser(int page, int count, String titulo, String status,
			String prioridade, String assignedUser) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByTituloIgnoreCaseContainingAndStatusAndPrioridadeAndAssignedUserIdOrderByDataDesc(titulo, status, prioridade, pages, assignedUser);
	}

}
