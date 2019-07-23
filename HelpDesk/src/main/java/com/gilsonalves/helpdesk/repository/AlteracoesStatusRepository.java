package com.gilsonalves.helpdesk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gilsonalves.helpdesk.entity.AlteracoesStatus;

public interface AlteracoesStatusRepository extends MongoRepository<AlteracoesStatus, String>{
	
	List<AlteracoesStatus> findByTicketIdOrderByDataDesc(String ticketId);

}
