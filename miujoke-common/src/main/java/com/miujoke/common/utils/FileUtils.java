package com.miujoke.common.utils;

import cn.hutool.core.date.DateUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/9 16:28
 */
public class FileUtils {

    public static void main1(String[] args) throws IOException {
        File file = new File("D:\\IdeaProjects\\springboot\\miujoke-springcloud\\fileDir");
        File toFile = new File("D:\\IdeaProjects\\springboot\\miujoke-springcloud\\kk\\fileDir");
        boolean newFile = file.createNewFile();
        File absoluteFile = file.getAbsoluteFile();
        File parentFile = file.getParentFile();
        System.out.println(parentFile.getParent());
        System.out.println(parentFile.getPath());
        // 获取最近修改文件时间
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());
        System.out.println(format);
        boolean b = file.renameTo(toFile);
        System.out.println(b);


        if (newFile) {
            System.out.println("文件创建成功");
        } else {
            System.out.println("文件创建失败");
        }

    }


    public static void main(String[] args) {
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        String putVal = concurrentHashMap.put("test", "test");
        String getVal = concurrentHashMap.get("test");

        int nums[] ={-10,-3,0,5,9};
        TreeNode helper = helper(nums, 0, nums.length - 1);
        System.out.println(helper);
    }

    public static TreeNode helper(int[] nums, int left, int right){
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static class TreeNode {
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
