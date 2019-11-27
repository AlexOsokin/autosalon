package com.site.carsite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//включаем авторизацию
                .antMatchers("/","/a1").permitAll()//для главой странички мы разрешаем полный доступ
                .anyRequest().authenticated()//для остальных запросов требуем авторизацию
                .and()
                     .formLogin()
                     .loginPage("/login")
                     .permitAll()
                .and()
                     .logout()
                     .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select name, pass, active from sp_user where name=?")
                .authoritiesByUsernameQuery("select u.name, ur.roles from sp_user u inner join user_role ur on u.id = ur.user_id where u.name=?");
    }
}
