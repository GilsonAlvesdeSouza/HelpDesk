package com.gilsonalves.helpdesk.repository;

import com.gilsonalves.helpdesk.entity.AlteracoesStatus;

public interface AlteracoesStatusRepository {
	
	Iterable<AlteracoesStatus> findByTicketIdOrderByDataDesc(String ticketId);

}
