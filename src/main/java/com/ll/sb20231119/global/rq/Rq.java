package com.ll.sb20231119.global.rq;

import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class Rq {

    public String redirect(String path, String msg) {
        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);
        //return "redirect:/article/list?msg=" + msg;
        return "redirect:" + path + "?msg=" + msg;
    }
}
