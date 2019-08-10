package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.Eva;
import com.qf.bean.Evaluates;
import com.qf.bean.Shoppes;
import com.qf.dao.ShoppesMapper;
import com.qf.service.ShoppesService;
import com.qf.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 别闹！学习呢！
 */
@Service
public class ShoppesServiceImpl implements ShoppesService {

    @Resource
    private ShoppesMapper shoppesMapper;

    @Resource
    private EvaluatesServiceImpl  evaluatesService;
    @Resource
    private SpecificationService specificationService;

    @Override
    public Shoppes findById(int shopid) {
        Shoppes shoppes = shoppesMapper.findById(shopid);
        int star = evaluatesService.findStar(shopid);
        int count = evaluatesService.Count(shopid);
        if (count==0){
            shoppes.setFeedback(null);
            shoppes.setEvaluatescount(0);
        }else {


            double b = star / count;
            DecimalFormat df = new DecimalFormat("##.##");
            String format = df.format(b * 100);

            shoppes.setFeedback(format);
            shoppes.setEvaluatescount(count);
        }
        List all = specificationService.findAll();
        shoppes.setSpecification(all);
        List<Evaluates> evaluates = evaluatesService.findById(shopid);

        List list=new ArrayList();
        Eva e=null;
        for (Evaluates evaluate : evaluates) {
            e= new Eva();
            e.setUserid(evaluate.getUserid());
            e.setNickname(evaluate.getUsers().getNickname());

            if (evaluate.getEvaluateimage()!=null){
                String[] split = evaluate.getEvaluateimage().split(",");
                e.setEvaluateimage(split);
            }

            e.setContent(evaluate.getContent());
            e.setCreatetime(evaluate.getCreatetime());
            e.setStarlevel(evaluate.getStarlevel());
            list.add(e);

        }
        shoppes.setEvaluates(list);
        return shoppes ;
    }

    @Override
    public int deleteByPrimaryKey(Integer shopid) {
        return 0;
    }

    @Override
    public int insert(Shoppes record) {
        return 0;
    }

    @Override
    public int insertSelective(Shoppes record) {
        return 0;
    }

    @Override
    public Shoppes selectByPrimaryKey(Integer shopid) {
        return shoppesMapper.selectByPrimaryKey(shopid);
    }

    @Override
    public int updateByPrimaryKeySelective(Shoppes record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Shoppes record) {
        return 0;
    }


}
