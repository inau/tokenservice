package com.example.authenticationservice.db;

public class Token {
    public final String token;
    public final Long expires;
    public final String[] rights;

    public Token(String token, Long expires, String[] rights) {
        this.token = token;
        this.expires = expires;
        this.rights = rights;
    }

    public static Token expire(Token t) {
        return new Token(t.token, 0L, t.rights);
    }
}
