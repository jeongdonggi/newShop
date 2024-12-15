package jpashop.newshop.controller;

import jpashop.newshop.dto.Join;
import jpashop.newshop.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProc(Join join) {
        joinService.insertJoin(join);

        return "redirect:/login";
    }
}
