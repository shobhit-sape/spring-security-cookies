package com.example.securingweb.security;

// Importing required classes

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@EnableWebSecurity
public class SpringSecurityConfig
        extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.eraseCredentials(true);
//
////        auth.inMemoryAuthentication()
////                .passwordEncoder(passwordEncoder())
////                .withUser("gfg")
////                .password(passwordEncoder().encode("pass"))
////                .roles("ADMIN")
////                .and()
////                .passwordEncoder(passwordEncoder())
////                .withUser("user")
////                .password(passwordEncoder().encode("pass"))
////                .roles("BASIC");
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {

        http.authorizeRequests()


                .antMatchers(HttpMethod.POST,"/").permitAll()

//                .antMatchers(HttpMethod.GET,"/")
//                .hasAnyRole("BASIC", "ADMIN")
//                .antMatchers("/admin")
//                .hasRole("ADMIN")
//                .antMatchers("/")
//                .permitAll()
                .anyRequest()
                .not().authenticated()
                .and().csrf(AbstractHttpConfigurer::disable)
        ;
//                .and()
//                .formLogin()
//                .permitAll()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .and()
//                .logout()
//                .logoutRequestMatcher(
//                        new AntPathRequestMatcher("/logout"))
//                .permitAll();
    }
}