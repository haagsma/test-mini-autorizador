package com.example.demo.core.domain_services.password;

public interface PasswordManagerService {

    String encode(String password);

    boolean verify(String password, String encoded);
}
