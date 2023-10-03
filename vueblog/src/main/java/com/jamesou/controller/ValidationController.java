package com.jamesou.controller;

import com.jamesou.common.util.CodeUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Code")
public class ValidationController {

    private static final Logger logger =  LoggerFactory.getLogger(ValidationController.class);

    /**
     * generate validation code
     */
    @GetMapping("getVerify")
    @CrossOrigin(origins = "*")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            CodeUtil randomValidateCode = new CodeUtil();
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Failed to get validation code>>>>{}", e);
        }
    }

    /**
     * check the validation code
     */
    @RequestMapping(value = "/checkVerify",headers = "Accept=application/json")
    @CrossOrigin(origins = "*",allowCredentials="true")
    public boolean checkVerify(@RequestParam String verifyInput, HttpSession session) {
        try{
            String inputStr = verifyInput;
            String random = (String) session.getAttribute(CodeUtil.RANDOMCODEKEY);
            if (random == null) {
                return false;
            }
            if (random.equals(inputStr)) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("验证码校验失败>>{}", e);
            return false;
        }
    }
}

