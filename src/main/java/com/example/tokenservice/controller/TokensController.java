package com.example.authenticationservice.controller;

import com.example.authenticationservice.db.Token;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/tokens")
public class TokensController {

    @RequestMapping(path="/issue", method=POST)
    public ResponseEntity<String> issueToken(@RequestParam("bucket") String username, @RequestParam("bucket") String password) {
        // lookup in repo
        // if ok issue token
        SecurityProperties.User res = new SecurityProperties.User();
        Token t = new Token("a", new Date().toInstant().getEpochSecond(), new String[]{"a","b"});

        if( res == null ) return ResponseEntity.status(404).build();
        else {
            return ResponseEntity.ok().body( t.token );
        }
    }

    @RequestMapping(path="/expire", method = POST)
    public void expire(@RequestParam("tid") String tid) {
        //find token
        Token t = new Token("a", new Date().toInstant().getEpochSecond(), new String[]{"a","b"});
        t = Token.expire(t);
        //update storage
    }

    @RequestMapping(path="/validate", method=POST)
    public Boolean isValid(@RequestParam("tid") String tid) {
        // lookup token
        Token t = new Token("a", new Date().toInstant().getEpochSecond(), new String[]{"",""});

        if( t == null || t.expires < new Date().toInstant().getEpochSecond() ) return false;
        else return true;
    }



}
