package com.example.demo.core.domain_services.password.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.demo.core.domain_services.password.PasswordManagerService;
import org.springframework.stereotype.Service;

@Service
public class BCryptPasswordManagerServiceImpl implements PasswordManagerService {
    @Override
    public String encode(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    @Override
    public boolean verify(String password, String encoded) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), encoded);
        return result.verified;
    }
}
