package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){ //Model = 얘에 데이터를 실어서 뷰로 넘김
        model.addAttribute("data", "hello!");
        return "hello"; //뷰 이름
    }
}
