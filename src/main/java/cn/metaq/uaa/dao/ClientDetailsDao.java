package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.uaa.domain.ClientDetails;
import org.springframework.stereotype.Repository;

/**
 * ClientDetailsDao
 *
 * @author tz
 * @date 2020/11/22 下午4:59
 * @since 1.0
 */
@Repository
public interface ClientDetailsDao extends BaseDao<ClientDetails,Long> {

}
