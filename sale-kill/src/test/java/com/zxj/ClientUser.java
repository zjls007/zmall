package com.zxj;

import com.zxj.service.KillService;

import java.util.Random;

/**
 * @author zxj
 * @create 2018/7/19 17:06
 */
public class ClientUser implements Runnable {

    private Long userId;

    KillService killService;

    public ClientUser(Long userId, KillService killService) {
        this.userId = userId;
        this.killService = killService;
    }

    @Override
    public void run() {
        Random rand = new Random();
        long i = rand.nextInt(100);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        killService.rob(userId);
    }

}
