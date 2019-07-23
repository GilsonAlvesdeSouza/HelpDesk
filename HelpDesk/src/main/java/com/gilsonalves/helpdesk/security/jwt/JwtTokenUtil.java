package com.gilsonalves.helpdesk.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	
	private static final long serialVersionUID = 1L;

	static final String CALIM_KEY_USERNAME = "sub";
	static final String CALIM_KEY_CREATED = "created";
	static final String CALIM_KEY_EXPIRED = "exp";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	/**
	 * Método que obtem o email que está dentro do token
	 * 
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {
		String userName;
		try {
			final Claims claims = getClaimsFromToken(token);
			userName = claims.getSubject();
		} catch (Exception e) {
			userName = null;
		}
		return userName;
	}

	/**
	 * Método que retorna a data de expiração de um token
	 * 
	 * @param token
	 * @return
	 */

	private Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	/**
	 * Método que realiza o passe indutor para extrair as informações obtidas no token
	 * @param token
	 * @return
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	/**
	 * Método que verifica se o token está expirado
	 * @param token
	 * @return
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	/**
	 * Método responsável por gerar o token
	 * @param details
	 * @return
	 */
	public String generateToken(UserDetails details) {
		Map<String, Object> claims = new HashMap<>();
		
		claims.put(CALIM_KEY_USERNAME, details.getUsername());
		
		final Date createDate = new Date();
		claims.put(CALIM_KEY_CREATED, createDate);
		
		return doGenerateToken(claims);
	}

	/**
	 * Método auxiliar para geração do token
	 * @param claims
	 * @return
	 */
	private String doGenerateToken(Map<String, Object> claims) {
		final Date createdDate = (Date) claims.get(CALIM_KEY_CREATED);
		final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
		return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	/**
	 * Método que verifica se o token pode ser atualizado
	 * @param token
	 * @return
	 */
	public Boolean canTokenBeRefreshed(String token) {
		return (isTokenExpired(token));
	}
	
	/**
	 * Método que atualiza o token
	 * @param token
	 * @return
	 */
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CALIM_KEY_CREATED, new Date());
			refreshedToken = doGenerateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	/**
	 * Método que valida o token
	 * @param token
	 * @param userDatails
	 * @return
	*/
	public Boolean validateToken(String token, UserDetails userDatails) {
		JwtUser user = (JwtUser) userDatails;
		final String userName = getUsernameFromToken(token);
		return (userName.equals(user.getUsername()) && !isTokenExpired(token));
	} 
}






















