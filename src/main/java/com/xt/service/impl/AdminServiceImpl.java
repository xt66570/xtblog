package com.xt.service.impl;

import com.xt.entity.Admin;
import com.xt.redis.AdminKey;
import com.xt.service.AdminService;
import com.xt.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Description (Admin)表服务实现类
 * @author 莫提
 * @date 2020-08-30 22:34:34
 * @Version 1.0
 **/
@Service("adminService")
public class AdminServiceImpl extends BaseService implements AdminService {

    /**
     * @Description 查询单条数据
     * @author 莫提
     * @date 2020-08-30 22:34:34
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer id) {
        Admin admin = null;
        if (redisService.exists(AdminKey.getById,String.valueOf(id))) {
            admin = redisService.get(AdminKey.getById, String.valueOf(id), Admin.class);
        }else {
            admin = adminMapper.queryById(id);
            redisService.set(AdminKey.getById,String.valueOf(id),admin,60*60*24);
        }
        return admin;
    }

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author 莫提
     * @date 2020-08-30 22:34:34
     * @param admin 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Admin admin) {
        if(adminMapper.update(admin) == 1){
            return true;
        }
        return false;
    }

}