package Chapter0_其他.Q535_TinyURL加密与解密;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 20:38
 **/

public class Solution {
    String alpha = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Encodes a URL to a shortened URL.
    HashMap <String,String> map = new HashMap<>();
    Random rand = new Random();
    //生成随机的6位key
    public String getKey(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 6; i++){
            builder.append(alpha.charAt(rand.nextInt(62)));
        }
        return builder.toString();
    }
    public String encode(String longUrl) {
        //检查是否有重复的key,并且将结果保存到哈希表中
        String key = getKey();
        while(map.containsKey(key)){
            key = getKey();
        }
        map.put(key,longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //根据哈希表来返回原始链接
        shortUrl = shortUrl.replace("http://tinyurl.com/","");
        return map.get(shortUrl);
    }
}
