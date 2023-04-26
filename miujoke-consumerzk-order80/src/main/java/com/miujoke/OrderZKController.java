package com.miujoke;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/18 20:56
 */
@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://miujoke-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }

    @GetMapping("/consumer/getZk")
    public String getZkConfig() throws InterruptedException, IOException {
        ZKConfigGet zkOperaDemo = new ZKConfigGet();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZooKeeper();
        System.out.println("====================");
        System.out.println(zooKeeper);
        System.out.println("====================");
        Thread.sleep(Long.MAX_VALUE);
        return JSONUtil.toJsonStr(zooKeeper);
    }


    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
