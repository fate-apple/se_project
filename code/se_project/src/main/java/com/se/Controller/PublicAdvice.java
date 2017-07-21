<<<<<<< HEAD
//package com.se.Controller;
//
//
//import com.se.Repository.Jpa.UserRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * @author Jonsy
// */
//@ControllerAdvice
//public class PublicAdvice {
//
//    @Autowired
//    protected UserRepository userRepository;
//
//    @ExceptionHandler
//    public void handleControllerException(HttpServletRequest request, HttpServletResponse response, Throwable ex) throws IOException {
//        ex.printStackTrace();
//        String ajax = request.getHeader("X-Requested-With");
//        response.setCharacterEncoding("utf-8");
//        if (StringUtils.isEmpty(ajax)) {
//            response.sendRedirect("/error");
//        } else {
//            response.getWriter().println("出错了:" + ex.getMessage());
//        }
//
//    }
//
//    @ModelAttribute
//    public void addCommonModel(Model model, HttpServletRequest request) {
//        Object o = SecurityContextHolder.getContext().getAuthentication().getName();
//        String sec_username = (String) o;
//        String sec_role = "ROLE_VISTOR";
//        UserDetails userDetails;
////        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Object temps = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (temps instanceof UserDetails) {
//            userDetails = (UserDetails) temps;
//            GrantedAuthority[] authorities = userDetails.getAuthorities().toArray(new GrantedAuthority[0]);
//            if (authorities.length > 0) {
//                GrantedAuthority authoritie = authorities[0];
//                sec_role = authoritie.getAuthority();
//            }
//        }
//        if (sec_username != null) {
//            model.addAttribute("sec_username", sec_username);
//            model.addAttribute("sec_role", sec_role);
//        }
//    }
//
//
//}
=======
package com.se.Controller;


import com.se.Repository.Jpa.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Jonsy
 */
@ControllerAdvice
public class PublicAdvice {

    @Autowired
    protected UserRepository userRepository;

    @ExceptionHandler
    public void handleControllerException(HttpServletRequest request, HttpServletResponse response, Throwable ex) throws IOException {
        ex.printStackTrace();
        String ajax = request.getHeader("X-Requested-With");
        response.setCharacterEncoding("utf-8");
        if (StringUtils.isEmpty(ajax)) {
            response.sendRedirect("/error");
        } else {
            response.getWriter().println("出错了:" + ex.getMessage());
        }

    }

    @ModelAttribute
    public void addCommonModel(Model model, HttpServletRequest request) {
        String sec_role = "ROLE_VISTOR";
        String sec_username="AnnonymousUser";
        if(SecurityContextHolder.getContext().getAuthentication()!=null) {
            Object o = SecurityContextHolder.getContext().getAuthentication().getName();
            sec_username = (String) o;

            UserDetails userDetails;
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Object temps = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (temps instanceof UserDetails) {
                userDetails = (UserDetails) temps;
                GrantedAuthority[] authorities = userDetails.getAuthorities().toArray(new GrantedAuthority[0]);
                if (authorities.length > 0) {
                    GrantedAuthority authoritie = authorities[0];
                    sec_role = authoritie.getAuthority();
                }
            }
        }
        if (sec_username != null) {
            model.addAttribute("sec_username", sec_username);
            model.addAttribute("sec_role", sec_role);
        }
        return;
    }
//
//
}
>>>>>>> origin/csy
