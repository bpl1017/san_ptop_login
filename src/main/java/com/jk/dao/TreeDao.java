package com.jk.dao;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by new鹏 on 2018/5/15.
 */
@Mapper
public interface TreeDao {
    @Select(" select   *   from   t_tree ,rel_user_role  ,t_user   ,rel_role_tree\n" +
            "   \n" +
            " where   t_tree.id=rel_role_tree.tid \n" +
            "    and   rel_role_tree.roid=rel_user_role.roid \n" +
            "\n" +
            "    and   t_user.userid=rel_user_role.uid\n" +
            "       \n" +
            "     and  t_user.userid=#{userid}  \n" +
            "    and t_tree.pid=#{a}")
    List<Tree> menuList(@Param("userid") Integer userid, @Param("a") Integer a);
}
