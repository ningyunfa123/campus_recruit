package com.ecust.test;

import com.ecust.dao.ProductInterfaceDao;
import com.ecust.dao.ProductLineDao;
import com.ecust.pojo.ProductLine;
import com.ecust.service.ProductLineService;
import com.ecust.service.impl.ProductLineServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
public class AddProductLineTest {
    ProductInterfaceDao productInterfaceDao = Mockito.mock(ProductInterfaceDao.class);
    @Test
    public void addProductTest() {
        System.out.println(productInterfaceDao.queryAllInterface().toString());

    }
}
