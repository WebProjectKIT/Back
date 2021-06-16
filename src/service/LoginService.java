package service;

import domain.Member;
import persistance.MemberRepository;

import java.util.ArrayList;

public class LoginService {
    public Member login(String email, String password) {
            return MemberRepository.getInstance().login(email, password);
    }
}
