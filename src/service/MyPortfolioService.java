package service;

import domain.Portfolio;
import persistance.PortfolioRepository;

import java.util.ArrayList;

public class MyPortfolioService {

    private final PortfolioRepository portfolioRepository = PortfolioRepository.getInstance();

    public ArrayList<Portfolio> findByEmail(String email){

        return portfolioRepository.findByEmail(email);

    }


    public void delete(int id) {

        System.out.println(id);
        System.out.print("delete 성공 여부 : ");
        System.out.println(portfolioRepository.delete(id));

    }


    public void write(String email, String title, String link) {

        portfolioRepository.write(email, title, link);

    }
}
