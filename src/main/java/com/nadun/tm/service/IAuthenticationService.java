package com.nadun.tm.service;

import com.nadun.tm.dao.request.SignUpRequest;
import com.nadun.tm.dao.request.SigninRequest;
import com.nadun.tm.dao.response.JwtAuthenticationResponse;
import org.springframework.stereotype.Service;


public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
