package com.template.server.global.auth.handler;

import com.template.server.global.error.util.ErrorResponder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

// 로그인 인증 실패 시, 추가 작업을 할 수 있는 클래스
@Slf4j
public class MemberAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        ErrorResponder.sendErrorResponse(response, HttpStatus.UNAUTHORIZED);
        log.error("Authentication failed: {}", exception.getMessage());
    }
}
