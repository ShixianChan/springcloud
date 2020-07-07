package cn.how2j.springcloud.web;

import cn.how2j.springcloud.pojo.Product;
import cn.how2j.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired ProductService productService;

    @Value("${version}") String version;  // 增加这个属性，就可以从 config-server 去获取 version 信息了

    @RequestMapping("/products")
    public Object products(Model m){
        List<Product> ps = productService.listProducts();  // 把数据取出来
        m.addAttribute("ps",ps);
        m.addAttribute("version", version);
        return "products";  // 把数据放在 product.html 中
    }
}
