package com.se.Domain.Auth;

/**
 * Created by clevo on 2017/7/11.
 */
public class JwtAuthenticationResponse {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
