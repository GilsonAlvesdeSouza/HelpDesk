package com.gilsonalves.helpdesk.enums;

public enum StatusEnum {

	NOVO,
	ACEITO,
	RESOLVIDO,
	APROVADO,
	REPROVADO,
	FINALIZADO;
	
	public static StatusEnum getStatus(String status) {
		switch (status) {
		case "novo": return NOVO;
		case "aceito": return ACEITO;
		case "resolvido": return RESOLVIDO;
		case "aprovado": return APROVADO;
		case "reprovado": return REPROVADO;
		case "finalizado": return FINALIZADO;
		default: return NOVO;			
		}
	}
	
}
