package com.imarble.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	   private final String SECRET_KEY = "VxaZEfUTvCwF0TWDEMO/CuUp06QvqabuCTDaCsWHRiVvXK9OCeBpxrrFEOaYU+LlueaKUk1ccDOlTxHHRTNl4w==";

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
	        return resolver.apply(extractAllClaims(token));
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts.parser()
	                .setSigningKey(SECRET_KEY)
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        claims.put("roles", userDetails.getAuthorities());
	        return createToken(claims, userDetails.getUsername());
	    }

	    private String createToken(Map<String, Object> claims, String subject) {
	        return Jwts.builder()
	                .setClaims(claims)
	                .setSubject(subject)
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10)) // 1 hour
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
	                .compact();
	    }

	    public boolean validateToken(String token, UserDetails userDetails) {
	        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
	    }

	    private boolean isTokenExpired(String token) {
	        return extractClaim(token, Claims::getExpiration).before(new Date());
	    }
}
