package cn.metaq.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * ResourceServerConfiguration
 *
 * @author tz
 * @date 2020/11/23 上午11:17
 * @since 1.0
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisTokenStore tokenStore;

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .requestMatchers().antMatchers("/user")
                .and()
                .authorizeRequests().antMatchers("/login","/oauth/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();

//        http.authorizeRequests().antMatchers("/login","/oauth/**",
//                "/api/**",
//                "/swagger-resources/**",
//                "/configuration/**",
//                "/webjars/**",
//                "/actuator/**",
//                "/**/*.html",
//                "/favicon.ico",
//                "/**/*.css",
//                "/v2/**",
//                "/**/*.js").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("**").authenticated()
//                .and()
//                .csrf().disable();

    }
}
