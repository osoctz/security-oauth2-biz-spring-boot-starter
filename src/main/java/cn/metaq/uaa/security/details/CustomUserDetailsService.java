package cn.metaq.uaa.security.details;

import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.dao.UserDao;
import cn.metaq.uaa.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * CustomUserDetailsService
 *
 * @author tz
 * @date 2020/11/20 下午1:11
 * @since 1.0
 */
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Resource
    private BaseTemplate template;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Cacheable(value = "user",key = "#username")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户
        User user=userDao.findOne((Specification<User>)(root,cq,cb)->cb.equal(root.get("username"),username)).orElseThrow();

        CustomUserDetails userDetails=new CustomUserDetails();
        //user->role->authority
        userDetails.setAuthorities(this.loadAuthoritiesByUserId(user.getId()));
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setLastPasswordResetDate(user.getLastPasswordResetDate());
        userDetails.setEnabled(user.isEnabled());

        return userDetails;
    }

    public Set<CustomGrantedAuthority> loadAuthoritiesByUserId(Long userId){

        String jql="select new cn.metaq.uaa.security.details.CustomGrantedAuthority(a.authority) from UserRole ur " +
                "left join RoleAuthority ra on ur.roleId=ra.roleId " +
                "left join Authority a on ra.authorityId=a.id where ur.userId=:userId";

        Map<String,Object> params=new HashMap<>();
        params.put("userId",userId);

        List<CustomGrantedAuthority> authorities=template.list(CustomGrantedAuthority.class,jql,params);

        return authorities.stream().collect(Collectors.toSet());
    }

//    public void changePassword(String oldPassword, String newPassword) {
//
//        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
//        String username = currentUser.getName();
//        if (authenticationManager != null) {
//            log.debug("Re-authenticating user '" + username + "' for password change request.");
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
//        } else {
//            log.debug("No authentication manager set. can't change Password!");
//            return;
//        }
//
//        log.debug("Changing password for user {} ", username);
//        User user=userDao.findOne((Specification<User>)(root,cq,cb)->cb.equal(root.get("username"),username)).orElseThrow();
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userDao.save(user);
//    }
}
