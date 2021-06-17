package service;

import controller.Paging;
import domain.Portfolio;
import domain.PortfolioBoard;
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


    public Paging getPagingInfo(int page, String email) {
        Paging paging = new Paging();
        int totalCount = portfolioRepository.getTotalMyPortfolioCount(email);

        paging.setPageNo(page);
        paging.setPageSize(3);
        paging.setTotalCount(totalCount);

        return paging;
    }

    public ArrayList<Portfolio> getBoardList(int page, int pageSize, String email) {
        return portfolioRepository.getChunkList(page, pageSize, email);
    }

}
