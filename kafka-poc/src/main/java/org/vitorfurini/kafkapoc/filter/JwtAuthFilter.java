package org.vitorfurini.kafkapoc.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.jsonwebtoken.*;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthFilter implements Filter  {

    private static final String SECRET_KEY = "sua-chave-secreta";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token ausente ou inválido");
            return;
        }

        String token = authHeader.substring(7);
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        } catch (JwtException e) {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
            return;
        }

        chain.doFilter(req, res);
    }
}
