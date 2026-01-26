package com.mjc813.CheckQuestion;

import com.mjc813.sec.Singleton;

public class ShopService {
    private static final ShopService shopService = new ShopService();

    private ShopService(){
    }

    public static ShopService getInstance(){
        return shopService;
    }
}
