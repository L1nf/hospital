package com.soft_engin.hospital.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Linf
 * @date 10/16/2022 7:05 PM
 */
public class WebUtils {
    @Nullable
    public static String renderString(@NotNull HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
