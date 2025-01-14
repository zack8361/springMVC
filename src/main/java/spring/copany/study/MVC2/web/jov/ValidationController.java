package spring.copany.study.MVC2.web.jov;


import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping("/add/v1")
    public String add(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
        // 검증 오류 결과를 보관
        Map<String, String> errors = new HashMap<>();

        if(!StringUtils.hasText(item.getName())) {
            errors.put("itemName", "상품 이름을 입력하세요");

        }

        return "null";
    }

    @PostMapping("/add/v2")
    public String addItem(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(!StringUtils.hasText(item.getName())) {
            bindingResult.addError(new FieldError("item", "itemName", "상품 이름은 필수입니다."));
        }

        return  "null";
    }

}
