package cn.metaq.uaa.config;

import cn.metaq.common.core.DaoTemplate;
import cn.metaq.data.jpa.BaseTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * SecurityOauth2BizAutoConfiguration
 *
 * @author tz
 * @date 2020/11/23 上午11:34
 * @since 1.0
 */
@Configuration
public class SecurityOauth2BizAutoConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @PersistenceContext
    private EntityManager em;

    @Bean
    public DaoTemplate template(){
        return new BaseTemplate(em);
    }
}
