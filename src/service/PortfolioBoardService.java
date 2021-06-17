package service;

import controller.Paging;
import domain.PortfolioBoard;
import persistance.PortfolioBoardRepository;

import java.util.ArrayList;

public class PortfolioBoardService {

    private final PortfolioBoardRepository portfolioBoardRepository = PortfolioBoardRepository.getInstance();
    public PortfolioBoardService() {

    }

    public ArrayList<PortfolioBoard> findBoards() {
        return portfolioBoardRepository.findAll();
    }

    public PortfolioBoard findPostById(long id) {
        return portfolioBoardRepository.findById(id);
    }

    public void write(PortfolioBoard board) {
        portfolioBoardRepository.save(board);
    }

    public void delete(long id) {
        portfolioBoardRepository.deleteById(id);
    }

    public Paging getPagingInfo(int page) {
        Paging paging = new Paging();
        int totalCount = portfolioBoardRepository.getTotalBoardCount();

        paging.setPageNo(page);
        paging.setPageSize(3);
        paging.setTotalCount(totalCount);

        return paging;
    }

    public ArrayList<PortfolioBoard> getBoardList(int page, int pageSize) {
        return portfolioBoardRepository.getChunkList(page, pageSize);
    }
}
