package com.mfx.blog.controller;

import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.param.ModifyPassParam;
import com.mfx.blog.service.UserService;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("user/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.insertUser(userDO);
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @PutMapping("user/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.login(userDO);
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/modify.token")
    @ResponseBody
    public ResponseEntity modifyUser(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.update(userDO);
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/password/modify.token")
    @ResponseBody
    public ResponseEntity modifyPassword(@RequestBody ModifyPassParam modifyPassParam, HttpServletRequest request) {
        try {
            userService.modifyPassword(modifyPassParam);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/logout.token")
    @ResponseBody
    public ResponseEntity logout(HttpServletRequest request) {
        try {
            userService.logout();
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
