package com.yin.controller;

import com.yin.domain.Collection;
import com.yin.domain.Goods;
import com.yin.entity.Result;
import com.yin.service.CollectionService;
import com.yin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName IntelliJ IDEA
 * @Description TODO
 * @Author li
 * @Date 2022/5/4 21:15
 * Version      1.0
 */
@Controller
public class uploadImgController {

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public String uploadImg(Integer goodsId,MultipartFile file, HttpServletRequest request){
        System.out.println(goodsId);
        String originName = file.getOriginalFilename();
        if(!originName.endsWith(".jpg") ){
            return null;
        }
        String format = sdf.format(new Date());
        String realPath = request.getServletContext().getRealPath("/img");
        //String realPath = "D:\\OurProject\\src\\main\\webapp\\img";
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String newName = UUID.randomUUID().toString()+".jpg";
        try {
            file.transferTo(new File(folder,newName));
            //String goodsUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+format+newName;
            String goodsUrl = newName;
            Integer i = goodsService.addImg(goodsUrl,goodsId);
            if(i > 0){
                return "redirect:/showSellGoods";
            }
            return "redirect:/showSellGoods";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/showSellGoods";
        }



        /*String path = request.getSession().getServletContext().getRealPath("/img/");
        FileInputStream fis = new FileInputStream(file.getName());
        FileOutputStream fos = new FileOutputStream(path);
        byte[] bys = new byte[1024];
        int len;
        while((len = fis.read(bys))!= -1){
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
        return new Result(true,"新增成功");*/

    }}
