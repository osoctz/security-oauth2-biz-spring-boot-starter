package cn.metaq.uaa.security.details;

import cn.metaq.uaa.dao.ClientDetailsDao;
import cn.metaq.uaa.domain.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * CustomClientDetailsService
 *
 * @author tz
 * @date 2020/11/23 上午10:33
 * @since 1.0
 */
@Service
public class CustomClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientDetailsDao clientDetailsDao;

    @Override
    public org.springframework.security.oauth2.provider.ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        ClientDetails clientDetails=clientDetailsDao.findOne((Specification<ClientDetails>)(root, cq, cb)->cb.equal(root.get("clientId"),clientId)).orElseThrow();

        String resourceIds = clientDetails.getResourceIds();
        String scopes = clientDetails.getScope();
        String grantTypes = clientDetails.getAuthorizedGrantTypes();
        String authorities = clientDetails.getAuthorities();
        String redirectUris = clientDetails.getWebServerRedirectUri();
        Integer refreshTokenValiditySeconds = clientDetails.getRefreshTokenValiditySeconds();
        Integer accessTokenValiditySeconds = clientDetails.getAccessTokenValiditySeconds();
        String clientSecret = clientDetails.getClientSecret();

        BaseClientDetails baseClientDetails = new BaseClientDetails(clientId, resourceIds, scopes, grantTypes, authorities, redirectUris);
        baseClientDetails.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);
        baseClientDetails.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
        baseClientDetails.setClientSecret(clientSecret);

        return baseClientDetails;
    }
}
