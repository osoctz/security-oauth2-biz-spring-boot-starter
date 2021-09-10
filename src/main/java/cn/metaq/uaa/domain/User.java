package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * User
 *
 * @author tz
 * @date 2020/11/20 上午10:07
 * @since 1.0
 */
@Table(name = "sys_user")
@Entity
@Setter
@Getter
public class User implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;

    @Column(name = "last_password_reset_date")
    private Date LastPasswordResetDate;
    private boolean enabled;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
