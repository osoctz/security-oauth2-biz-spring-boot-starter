package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.domain.User;
import org.springframework.data.jpa.domain.Specification;

/**
 * UserBiz
 *
 * @author tz
 * @date 2020/11/20 下午12:06
 * @since 1.0
 */
public interface UserBiz extends Biz<User,Long>, QueryBiz<User, Specification> {
}
