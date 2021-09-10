package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Authority
 *
 * @author tz
 * @date 2020/11/20 下午2:33
 * @since 1.0
 */
@Table(name = "sys_authority")
@Entity
@Setter
@Getter
public class Authority implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    @Column(name = "resource_id")
    private Long resourceId;
    private String authority;
}
