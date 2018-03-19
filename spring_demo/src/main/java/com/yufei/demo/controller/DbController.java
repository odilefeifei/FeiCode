package com.yufei.demo.controller;

import com.yufei.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*@Controller*/
@RestController
public class DbController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@ResponseBody*/
    @RequestMapping("/getUsers")

    public List<Map<String, Object>> getDbType(){
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }
   /* @ResponseBody*/
    @RequestMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable String id){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbType();

        for (Map<String, Object> dbmap : list) {

            Set<String> set = dbmap.keySet();

            for (String key : set) {
                if(key.equals("id")){
                    if(dbmap.get(key).equals(id)){
                        map = dbmap;
                    }
                }
            }
        }

        if(map==null)
            map = list.get(0);
        return map;
    }

    /*@ResponseBody*/
    @RequestMapping("/addUser")
    public User addUser(User user){
        String sql = "insert into user(name,password) values(?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
                return ps;

            }
        },holder);
        int newUserId = holder.getKey().intValue();
        user.setId(newUserId);
        return user;

    }


}
