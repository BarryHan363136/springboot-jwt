package com.bmw.azure.jwt.controller;

import com.bmw.azure.jwt.common.utils.Contants;
import com.bmw.azure.jwt.config.JwtUtil;
import com.bmw.azure.jwt.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Object login(HttpServletResponse response, @RequestBody final Account account) {
        if(isValidPassword(account)) {
            String jwt = JwtUtil.generateToken(account.username);
            return new HashMap<String,String>(){{
                put("username", account.username);
                put("token", jwt);
                put("expire_time", Contants.EXPIRATION_TIME);
            }};
        }else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    private boolean isValidPassword(Account ac) {
        return "admin".equals(ac.username)
                && "admin".equals(ac.password);
    }


}
