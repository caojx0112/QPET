package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.Eva;
import com.qf.bean.Evaluates;
import com.qf.bean.Shoppes;
import com.qf.bean.Shoptypes;
import com.qf.dto.Pet;
import com.qf.dao.ShoppesMapper;
import com.qf.dao.ShoptypesMapper;
import com.qf.service.ShoppesService;
import com.qf.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private ShoptypesServiceImpl shoptypesService;

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
            Shoptypes shoptypes = shoptypesService.selectByPrimaryKey(shoppes.getTypeid());
            shoppes.setDogtype(shoptypes.getTypename());
            shoppes.setFeedback(format);
            shoppes.setEvaluatescount(count);
        }
        List all = specificationService.findAll(shopid);
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
        return shoppesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Shoppes record) {
        return 0;
    }

    //首页全查
    @Override
    public Map findAll() {
        Map map = new HashMap();
        List<Shoppes> all = shoppesMapper.findAll();
        List<Pet> pets  =new ArrayList<>();
        List<Pet> foods =new ArrayList<>();
        List<Pet> goods =new ArrayList<>();
        for (Shoppes shoppes : all) {
            if (shoppes.getType() == 1) {
                Pet pet = new Pet();
                pet.setShopid(shoppes.getShopid());
                pet.setShopimage(shoppes.getShopimage());
                pet.setShopname(shoppes.getShopname());
                pet.setContent(shoppes.getContent());
                pet.setOldprice(shoppes.getOldprice());
                pet.setNewprice(shoppes.getNewprice());
                pets.add(pet);
                map.put("pet",pets);
            } else if (shoppes.getType()==2){
                Pet food =new Pet();
                food.setShopid(shoppes.getShopid());
                food.setShopimage(shoppes.getShopimage());
                food.setShopname(shoppes.getShopname());
                food.setContent(shoppes.getContent());
                food.setOldprice(shoppes.getOldprice());
                food.setNewprice(shoppes.getNewprice());
                foods.add(food);
                map.put("food",foods);
            }else {
                Pet good =new Pet();
                good.setShopid(shoppes.getShopid());
                good.setShopimage(shoppes.getShopimage());
                good.setShopname(shoppes.getShopname());
                good.setContent(shoppes.getContent());
                good.setOldprice(shoppes.getOldprice());
                good.setNewprice(shoppes.getNewprice());
                goods.add(good);
                map.put("good",goods);
            }

        }
        return map;
    }
    //搜索填充
    @Override
    public List<String> fill(String k,Integer type) {
        return shoppesMapper.fill(k, type);
    }
    //热门搜索
    @Override
    public List<String> findHot() {
        return shoppesMapper.findHot();
    }



    @Override
    public List<Shoppes> find(String shopname, Integer type, Integer sort1, Integer sort2, Integer sort3, Integer sort4, Integer sort5) {
        return shoppesMapper.find(shopname,type, sort1, sort2, sort3, sort4, sort5);
    }


    @Override
    public List<Shoptypes> pettype(Integer typeid) {
        return shoppesMapper.pettype(typeid);
    }


}
