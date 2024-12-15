package jpashop.newshop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        // SecurityContextHolder : 세션 관리
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String id = auth.getName(); // UserDetails.getUsername() 반환

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities(); // 사용자 권한 가져오기
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator(); // 권한 목록 중 하나 가져오기

        GrantedAuthority grantedAuthority = iterator.next(); // 권한 목록 중 맨 처음 값을 가져온다.
        String role = grantedAuthority.getAuthority(); // 권한 문자열 추출

        model.addAttribute("id", id);
        model.addAttribute("role", role);

        return "main";
    }
}
