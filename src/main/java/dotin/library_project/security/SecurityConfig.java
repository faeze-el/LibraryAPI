//package dotin.library_project.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class DevelopmentSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .anyRequest().permitAll()
//                .and().csrf().disable();
//        return http.build();
//    }
//}
package dotin.library_project.security;

import dotin.library_project.business.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .csrf().disable()
                //.authorizeHttpRequests().anyRequest().authenticated()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/books/**").hasRole("ADMIN")
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/reservations").hasRole("READER")
                .antMatchers(HttpMethod.GET, "/reservations/{id}").hasRole("READER")
                .antMatchers(HttpMethod.PUT, "/reservations/**").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.GET, "/reservations").hasRole("LIBRARIAN")
                .anyRequest().authenticated();
//                .and()
//                .formLogin()
//                .permitAll();
        return http.build();
    }

    @Autowired
    private final UserService appUserService;


    @Bean
    public UserDetailsService userDetailsService(){
        return appUserService;
    }

    @Bean
    public AuthenticationManager configureGlobal(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder provider = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.userDetailsService(appUserService).passwordEncoder(passwordEncoder());

        return provider.build();


    }

//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(appUserService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("READER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }
}