package com.xxx.mall.service;

import com.github.pagehelper.PageHelper;
import com.xxx.mall.mbg.mapper.PmsBrandMapper;
import com.xxx.mall.mbg.model.PmsBrand;
import com.xxx.mall.mbg.model.PmsBrandExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsBrandService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class PmsBrandService {
    private final PmsBrandMapper brandMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public PmsBrandService(PmsBrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
