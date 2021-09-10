package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "sys_client_details")
public class ClientDetails implements IEntity<Long> {
    private static final long serialVersionUID = -1518957664206201366L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String clientId;
    private String clientSecret;
    private String resourceIds;
    private String scope;
    private String authorities;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String autoApproveScopes;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private String additionalInformation;
}