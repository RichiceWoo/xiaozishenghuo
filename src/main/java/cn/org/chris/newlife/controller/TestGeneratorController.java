package cn.org.chris.newlife.controller;

import cn.org.chris.newlife.core.api.ApiResult;
import cn.org.chris.newlife.core.api.ResponseObject;
import cn.org.chris.newlife.model.TestGenerator;
import cn.org.chris.newlife.service.ITestGeneratorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import cn.org.chris.newlife.utils.CriteriaQuery;

/**
 * @author: RichiceWoo
 * @date: 2019/01/25 18:14:45
 * @description: TestGenerator控制器
 */
@RestController
@RequestMapping("/test/generator")
@Slf4j
public class TestGeneratorController {
    @Autowired
    private ITestGeneratorService testGeneratorService;


    /**
     * 新增TestGenerator
     */
    @PostMapping("/add")
    public ResponseObject add(HttpServletRequest request, HttpServletResponse response,
                              @RequestBody TestGenerator testGenerator) {
        boolean flag = testGeneratorService.save(testGenerator);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除TestGenerator
     */
    @DeleteMapping("/delete")
    public ResponseObject delete(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam Integer id) {
        boolean flag = testGeneratorService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新TestGenerator
     */
    @PutMapping("/update")
    public ResponseObject update(HttpServletRequest request, HttpServletResponse response,
                                 @RequestBody TestGenerator testGenerator) {
        boolean flag = testGeneratorService.update(testGenerator);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * TestGenerator详情
     */
    @GetMapping("/detail")
    public ResponseObject detail(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam Integer id) {
        TestGenerator testGenerator = testGeneratorService.findById(id);
        Assert.notNull(testGenerator, "查找对象不存在！");
        return ApiResult.success(testGenerator);
    }

    /**
     * TestGenerator分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ResponseObject pageList(HttpServletRequest request,
                                   HttpServletResponse response,
                                   TestGenerator testGenerator,
                                   @RequestParam(defaultValue = "0")
                                           Integer pageNum,
                                   @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(TestGenerator.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(testGenerator);
        } else {
            CriteriaQuery.likeTo(testGenerator, criteria);
        }
        List<TestGenerator> list = testGeneratorService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }
}
