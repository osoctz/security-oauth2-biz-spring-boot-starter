package cn.metaq.uaa.web;

import cn.metaq.common.web.dto.Result;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * LoginController
 *
 * @author tz
 * @date 2020/11/23 下午1:45
 * @since 1.0
 */
@Log4j2
@Controller
public class LoginController {

    @Autowired
    private KeyPair keyPair;

    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenService;

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @GetMapping("/oauth/token_key")
    @ResponseBody
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user")
    @ResponseBody
    public Result user(Principal user) {
        return Result.ok(user);
    }

//    @PostMapping("/login")
//    public Result<OAuth2AccessToken> login(@RequestBody Map<String, String> parameters){
//        try {
//            parameters.put(OAuth2Utils.GRANT_TYPE,parameters.get(OAuth2Utils.GRANT_TYPE));//设置授权类型为密码模式
//            parameters.put(OAuth2Utils.CLIENT_ID,parameters.get(OAuth2Utils.CLIENT_ID));
//            parameters.put("client_secret",parameters.get("client_secret"));
//            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            //grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//此处不能为空
//            ResponseEntity<OAuth2AccessToken> responseEntity= tokenEndpoint.postAccessToken(
//                    new UsernamePasswordAuthenticationToken(
//                            parameters.get(OAuth2Utils.CLIENT_ID),
//                            parameters.get("client_secret"),
//                            grantedAuthorities),parameters);
//            return  Result.ok(responseEntity.getBody());
//        }catch (InvalidGrantException e){
//            log.error("login error  用户名密码不正确 ....",e);
//            return Result.error(e.getMessage());
//        }
//        catch (Exception e){
//            log.error("login error ....",e);
//            return  Result.error(e.getMessage());
//        }
//    }


    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }


//    @GetMapping("/admin/logout")
//    @ResponseBody
//    public Result<String> logout(@RequestHeader(name = "Authorization") String accessToken){
//        try {
//            log.info("logout  start ......");
//            accessToken= accessToken.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
//            consumerTokenService.revokeToken(accessToken);
//            log.info("logout  end ......");
//            return Result.ok("退出登入成功");
//        }
//        catch (Exception e){
//            log.error("logout error ....",e);
//            return Result.error(e.getMessage());
//        }
//    }
}
