package com.gh.service;

import com.gh.constant.RedisKeyConstant;
import com.gh.util.AssertUtil;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author finally
 */
@Service
public class HotSearchKeyWordsService {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations listOperations;

    /**
     * 从redis中读取热门搜索关键字
     * @return
     */
    public List<String> find(){
//        BoundListOperations keyword = redisTemplate.boundListOps("hot_search_keyword");
//        List list = keyword.range(0, keyword.size());

        List list = listOperations.range(RedisKeyConstant.HOT_KEYWORDS, 0, -1);

        return list;
    }

    /**
     * 把热门搜索的关键字存入redis
     * @param keywords 可以传入多个关键字，以逗号分隔 华为,苹果
     */
    public Long set(String keywords){
        AssertUtil.isNotEmpty(keywords, "请输入关键字");
//        BoundListOperations operations = redisTemplate.boundListOps("hot_search_keyword");

        String[] newKeyWords = keywords.split(",");

//        Long result = operations.rightPushAll(newKeyWords);

        Long result = listOperations.rightPushAll(RedisKeyConstant.HOT_KEYWORDS, newKeyWords);
        return result;
    }
}
