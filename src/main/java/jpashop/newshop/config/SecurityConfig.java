package jpashop.newshop.config;

import jpashop.newshop.Domain.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 클래스가 하나 이상의 Bean을 가지고 있음을 알림
@EnableWebSecurity
public class SecurityConfig {
    
    // 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /**
         * 권한 설정
         */
        http.
                authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/","/login","/join","/joinProc").permitAll()
                        .requestMatchers("/admin").hasAnyAuthority(UserRole.ADMIN.getKey()) // hasRole은 기본적으로 앞에 ROLE_ 을 붙여준다.
                        .requestMatchers("/my/**").hasAnyAuthority(UserRole.ADMIN.getKey(), UserRole.USER.getKey()) // getAuthorities 반환값으로 평가
                        .anyRequest().authenticated()
                );
        /**
         * Login Form 위치 변경
         */
        http
                .formLogin((auth) ->
                        auth
                                .loginPage("/login")
                                .loginProcessingUrl("/loginProc")
                                .permitAll()
                );

        /**
         * CSRF 비활성화: 배포 환경에서는 활성화 해주어야 됨
         */
//        http
//                .csrf(AbstractHttpConfigurer::disable);
        // POST,PUT,DELETE 요청에 대해 토큰 검증을 진행한다. 구문을 없애주면 자동으로 처리해준다.
        /**
         * 다중 로그인 설정
         */
        http
                .sessionManagement((auth) ->
                        auth
                                .maximumSessions(2) // 다중 로그인 허용 갯수
                                .maxSessionsPreventsLogin(false) // 초과하였을 경우 처리 방법. true: 차단, false: 기존 세션 삭제
                );
        /**
         * 세션 공격 보호
         * 1. sessionManagement().sessionFixation().none() : 로그인 시 세션 정보 변경 안함
         * 2. sessionManagement().sessionFixation().newSession() : 로그인 시 세션 새로 생성
         * 3. sessionManagement().sessionFixation().changeSessionId() : 로그인 시 동일한 세션에 대한 id 변경 - 주로 사용
         */
        http
                .sessionManagement((auth) ->
                        auth
                                .sessionFixation().changeSessionId()
                );


        return http.build();
    }
}
