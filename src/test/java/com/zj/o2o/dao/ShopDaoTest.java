package com.zj.o2o.dao;

import com.zj.o2o.BaseTest;
import com.zj.o2o.entity.Area;
import com.zj.o2o.entity.PersonInfo;
import com.zj.o2o.entity.Shop;
import com.zj.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * @author zj
 * @create 2019-01-18 15:46
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void listShop() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(12L);
        shopCondition.setOwner(owner);
        List<Shop> list = shopDao.listShop(shopCondition, 0, 5);
        System.out.println("店铺条数：" + list.size());
        Area area = new Area();
        area.setAreaId(9);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(37L);
        shopCondition.setShopCategory(shopCategory);
        shopCondition.setShopName("1");
        shopCondition.setArea(area);
        List<Shop> shopList = shopDao.listShop(shopCondition, 0, 5);
        System.out.println("新店铺条数：" + shopList.size());
    }

    @Test
    public void getShopCount() {
        Shop shopCondition = new Shop();
        int shopCount = shopDao.getShopCount(shopCondition);
        System.out.println("shopCount = " + shopCount);
    }

    @Test
    public void getShopByID() {
        Shop shop = shopDao.getShopByID(33l);
        System.out.println(shop.getArea().getAreaId() + shop.getArea().getAreaName());
    }

    @Test
    public void insertShop() {
        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        area.setAreaId(2);
        owner.setUserId(1L);
        shopCategory.setShopCategoryId(35L);
        shop.setArea(area);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setCreateTime(new Date());
        shop.setShopImg("test");
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        //影响行数
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);

    }

    @Test
    public void updateShop() {
        Shop shop = new Shop();
        shop.setShopId(29L);
        shop.setShopName("测试更新");
        shop.setShopAddr("测试更新");
        shop.setShopDesc("测试更新");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
}