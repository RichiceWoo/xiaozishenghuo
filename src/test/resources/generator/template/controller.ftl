package ${basePackage}.controller;

import cn.org.chris.newlife.core.api.ApiResult;
import cn.org.chris.newlife.core.api.ResponseObject;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
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
* @author: ${author}
* @date: ${date}
* @description: ${modelNameUpperCamel}控制器
*/
@RestController
@RequestMapping("${baseRequestMapping}")
@Slf4j
public class ${modelNameUpperCamel}Controller {
@Autowired
private I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;


/**
* 新增${modelNameUpperCamel}
*/
@PostMapping("/add")
public ResponseObject add(HttpServletRequest request, HttpServletResponse response,
  @RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
boolean flag = ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
    Assert.isTrue(flag, "新增失败！");
    return ApiResult.success();
}

/**
* 删除${modelNameUpperCamel}
*/
@DeleteMapping("/delete")
public ResponseObject delete(HttpServletRequest request, HttpServletResponse response,
  @RequestParam Integer id) {
boolean flag = ${modelNameLowerCamel}Service.deleteById(id);
    Assert.isTrue(flag, "被删除对象不存在！");
    return ApiResult.success();
}

/**
* 更新${modelNameUpperCamel}
*/
@PutMapping("/update")
public ResponseObject update(HttpServletRequest request, HttpServletResponse response,
  @RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
boolean flag = ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    Assert.isTrue(flag, "更新失败！");
    return ApiResult.success();
}

/**
* ${modelNameUpperCamel}详情
*/
@GetMapping("/detail")
public ResponseObject detail(HttpServletRequest request, HttpServletResponse response,
  @RequestParam Integer id) {
${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
    Assert.notNull(${modelNameLowerCamel}, "查找对象不存在！");
    return ApiResult.success(${modelNameLowerCamel});
}

/**
* ${modelNameUpperCamel}分页列表
*
* @param pageNum  页码
* @param pageSize 每页记录数
*/
@GetMapping("/pageList")
public ResponseObject pageList(HttpServletRequest request,
                          HttpServletResponse response,
${modelNameUpperCamel} ${modelNameLowerCamel},
                          @RequestParam(defaultValue = "0")
                          Integer pageNum,
                          @RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(${modelNameUpperCamel}.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if(search==0){
            criteria.andEqualTo(${modelNameLowerCamel});
        }else {
            CriteriaQuery.likeTo(${modelNameLowerCamel},criteria);
        }
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
}
}
