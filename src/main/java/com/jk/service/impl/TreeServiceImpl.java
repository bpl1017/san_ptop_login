package com.jk.service.impl;

import com.jk.dao.TreeDao;

import com.jk.model.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by new鹏 on 2018/5/15.
 */
@Service("treeService")
public class TreeServiceImpl  implements TreeService {
    @Autowired
    private TreeDao treeDao;

    @Override
    public List<Tree> threelist(Integer userid, Integer a) {

        // 查询一级菜单
        List<Tree> firstMenu = treeDao.menuList(userid,a);
        // 查询一级菜单的子菜单
        recursionMenu(firstMenu,userid);

        return firstMenu;
    }
    /**
     * 递归加载子菜单
     */
    public void recursionMenu(List<Tree> firstMenu,Integer  userid) {
        for (Tree tree : firstMenu) {
            // 查询菜单是否有子菜单
            List<Tree> menuList2 = treeDao.menuList(userid,tree.getId());
            if (menuList2.size() > 0) {
                tree.setNodes(menuList2);
                recursionMenu(menuList2,userid);
            }
        }
    }
}
