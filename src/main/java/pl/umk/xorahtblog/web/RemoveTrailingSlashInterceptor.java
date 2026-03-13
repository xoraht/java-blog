package pl.umk.xorahtblog.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class RemoveTrailingSlashInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {

        String uri = request.getRequestURI();
        String query = request.getQueryString();

        if ("/".equals(uri) || uri.contains(".")) {
            return true;
        }

        if (uri.endsWith("/") && uri.length() > 1) {
            String target = uri.substring(0, uri.length() - 1);

            if (query != null && !query.isBlank()) {
                target += "?" + query;
            }

            response.setStatus(308);
            response.setHeader("Location", target);
            return false;
        }

        return true;
    }
}