package com.zhujh.controller.myDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhujh on 2018/5/31.
 * 用Jdbc 方式连接mysql
 */
@RestController
@RequestMapping("/mydb")
public class myJdbc
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getUserList")
    public List<Map<String,Object>> getUserList()
    {
        String sqlStr="select * from doctorinfo where is_delete=0 ";
        List<Map<String,Object>> userList=jdbcTemplate.queryForList(sqlStr);
        /*删除 添加*/
        //jdbcTemplate.execute(sqlStr);
        /*更新*/
        //jdbcTemplate.batchUpdate(sqlStr);
        return userList;
    }

    @RequestMapping("/getUser/{id}")
    public Map<String,Object> getUserById(@PathVariable String id) {
        Map<String, Object> myMap = null;
        List<Map<String, Object>> userList = getUserList();
        for (Map<String, Object> map : userList) {
            if (id.equals(map.get("PresDoctorCode"))) {
                myMap = map;
                break;
            }
        }
        return myMap;
    }
}
