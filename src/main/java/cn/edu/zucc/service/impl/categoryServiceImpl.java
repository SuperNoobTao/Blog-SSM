package cn.edu.zucc.service.impl;

import cn.edu.zucc.mapper.CategoryMapper;
import cn.edu.zucc.pojo.Page;
import cn.edu.zucc.pojo.TbCategoryEntity;
import cn.edu.zucc.service.CategoryService;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by shentao on 2016/7/14.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<TbCategoryEntity> getAllCategories() throws Exception {
        return categoryMapper.findAll();
    }

    @Override
    @Transactional
    public boolean addCategory(TbCategoryEntity tbCategoryEntity) throws Exception {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        tbCategoryEntity.setCategoryCdate(now);
        int i = categoryMapper.save(tbCategoryEntity);
        if (i>0) {
            return  true;
        }
            return  false;
    }

    @Override
    @Transactional
    public boolean deleteCategory(int categoryId) {
        int i = categoryMapper.delete(categoryId);
        if (i>0) {
            return true;
        }
        return false;
    }

    @Override
    public TbCategoryEntity queryCategory(Integer id) throws Exception {
        return categoryMapper.findById(id);
    }

    @Override
    public TbCategoryEntity findByName(String name) throws Exception {
        return categoryMapper.findByName(name);
    }

    @Override
    @Transactional
    public boolean updateCategory(TbCategoryEntity tbCategoryEntity) throws Exception {
        int i = categoryMapper.update(tbCategoryEntity);
        if (i> 0) {
            return  true;
        }
        return false;
    }

    //分页查询类别
    public Page<TbCategoryEntity> queryPageCategory(String pagenum,String url) throws Exception {
        System.out.println("页号"+pagenum);
        // 总记录数
        int totalrecord = (int) categoryMapper  .getCount();
        Page<TbCategoryEntity> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<TbCategoryEntity>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<TbCategoryEntity>(totalrecord, Integer.parseInt(pagenum));
        System.out.println("page.getStartindex()"+page.getStartindex());
        List<TbCategoryEntity> list = categoryMapper.getPageData(page.getStartindex(),
                page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return  page;

    }





}
