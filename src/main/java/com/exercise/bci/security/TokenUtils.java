package com.exercise.bci.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	/*
	 * Genera un Token con un el secret y tiempo de validacion
	 */
	public static String createToken(String nombre, String email) {
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("nombre", nombre);
		extra.put("email", email);
		
		return Jwts.builder()
				.setSubject(email)
				.addClaims(extra)
				.setIssuedAt(new Date())
				.signWith(key)
				.compact();
	}
	
	/*
	 * Validacion de una autenticacion para un usuario con token
	 */
	public static String getAuthentication(String token) {

        String email = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.replace("Bearer", ""))
                .getBody()
                .getSubject();
            return email;
	}
}
