package jpashop.newshop.service;

import jpashop.newshop.Domain.User;
import jpashop.newshop.dto.Join;
import jpashop.newshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void insertJoin(Join join) {

        String UserId = join.getId();
        String UserPw = bCryptPasswordEncoder.encode(join.getPassword());

        boolean isId = userRepository.existsById(UserId); // 기본 구현

        if (isId ) {
            return;
        }

        User user = new User();

        user.addIdPw(UserId, UserPw);

        userRepository.save(user);
    }
}
