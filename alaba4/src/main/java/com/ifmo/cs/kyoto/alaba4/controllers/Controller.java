package com.ifmo.cs.kyoto.alaba4.controllers;

import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.service.ResultService;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {


//    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
//    public void method(HttpServletResponse httpServletResponse) {
//        httpServletResponse.setHeader("Location", "http://localhost:3000/");
//        httpServletResponse.setStatus(302);
//    }
//
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "http://localhost:3000/mainpage");
    }


}
