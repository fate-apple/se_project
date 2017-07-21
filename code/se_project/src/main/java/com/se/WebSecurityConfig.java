package com.se;

import com.se.Filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.se.Service.Auth.JwtUserDetailsServiceImpl;
import org.springframework.util.Assert;

/**
 * Created by clevo on 2017/7/10.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        Assert.notNull(this.userDetailsService, "sjw!!!");
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(this.userDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }
    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }


        @Override
        protected   void configure(HttpSecurity httpSecurity) throws Exception{
            httpSecurity
                    // 由于使用的是JWT，我们这里不需要csrf
                    .csrf().disable();

                    // 基于token，所以不需要session
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

            httpSecurity.authorizeRequests()
                    //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                    // 允许对于网站静态资源的无授权访问
                    .antMatchers(
                            HttpMethod.GET,
                            "/",
                            "/*.html",
                            "/favicon.ico",
                            "/**/*.html",
                            "/**/*.css",
                            "/**/*.js",
                            "/img/**",
                            "/font-awesome/**"
                    ).permitAll()
                    // 对于获取token的rest api要允许匿名访问
<<<<<<< HEAD
                    .antMatchers("/auth/**","/register").permitAll()
=======
                    .antMatchers("/auth/**","/register","/manage/teacher/**","/error","/api/**").permitAll()
>>>>>>> origin/csy
                    // 除上面外的所有请求全部需要鉴权认证
                    .anyRequest().authenticated().and()
                    .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/base/news").permitAll().and()
                    .logout().permitAll();
//                        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//                                UsernamePasswordAuthenticationFilter.class)
                    // 添加一个过滤器验证其他请求的Token是否合法
            httpSecurity.addFilterBefore(authenticationTokenFilterBean(),
                            UsernamePasswordAuthenticationFilter.class);
            httpSecurity.headers().cacheControl();
        }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 使用自定义身份验证组件
//        auth.authenticationProvider(new CustomAuthenticationProvider());
//
//    }
}
