package com.september.sunrise.kk.service;

import com.september.sunrise.kk.dto.LoginRequest;
import com.september.sunrise.kk.dto.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest request);
}
