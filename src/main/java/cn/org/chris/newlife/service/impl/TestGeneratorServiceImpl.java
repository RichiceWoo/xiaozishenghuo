package cn.org.chris.newlife.service.impl;

import cn.org.chris.newlife.dao.TestGeneratorMapper;
import cn.org.chris.newlife.model.TestGenerator;
import cn.org.chris.newlife.service.ITestGeneratorService;
import cn.org.chris.newlife.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author: RichiceWoo
 * @date: 2019/01/25 18:14:45
 * @description: TestGenerator服务实现
 */
@Service
@Transactional
public class TestGeneratorServiceImpl extends AbstractService<TestGenerator> implements ITestGeneratorService {
    @Resource
    private TestGeneratorMapper testGeneratorMapper;

}
