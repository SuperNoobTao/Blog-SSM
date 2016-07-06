package cn.edu.zucc.service.impl;

import cn.edu.zucc.dto.Message;
import cn.edu.zucc.enums.StateEnum;
import cn.edu.zucc.mapper.UserMapper;
import cn.edu.zucc.pojo.TbUserEntity;
import cn.edu.zucc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by shentao on 2016/7/5.
 */

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private UserMapper userMapper;

    @Override
    public TbUserEntity getById(long userId) {
        return userMapper.queryById(userId);
    }

    @Override
    public TbUserEntity getByName(String userAcount) {
        return userMapper.queryByAcount(userAcount);
    }

    @Override
    public Message login(String userAcount, String userPwd) {
        return null;
    }

//    @Override
//    @Transactional
//    /**
//     * 使用注解控制事务方法的优点：
//     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
//     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
//     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
//     */
//    public Message login(String userAcount, String userPwd) {
////        try {
////        TbUserEntity tbUserEntity = userMapper.selectUser(userAcount,userPwd);
////            if(tbUserEntity == null ){
////                return  new Message(userAcount,userPwd, StateEnum.NO_USER);
////            }else{
////                return new Message(userAcount,userPwd, StateEnum.SUCCESS_LOGIN,tbUserEntity);
////            }
////        } catch (Exception e) {
////            logger.error(e.getMessage(), e);
////            // 所有编译期异常转换为运行期异常
////            return new Message(userAcount,userPwd, StateEnum.INNER_ERROR);
////        }
//
//
// //   }






}
