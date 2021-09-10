package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.uaa.domain.User;
import org.springframework.stereotype.Repository;

/**
 * UserDao
 *
 * @author tz
 * @date 2020/11/20 下午12:05
 * @since 1.0
 */
@Repository
public interface UserDao extends BaseDao<User, Long> {
}
