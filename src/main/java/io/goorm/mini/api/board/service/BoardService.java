package io.goorm.mini.api.board.service;

import io.goorm.mini.board.model.Board;
import io.goorm.mini.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper mapper;

    @Autowired
    public BoardService (BoardMapper boardMapper) {
        this.mapper = boardMapper;
    }

    /** 리스트 */
    public List<Board> getBoards(){
        return mapper.selectAll();
    }

    /** 아이디로 검색 */
    public Board getBoardById(long seq) {
        return mapper.selectById(seq);
    }

    /** 생성 */
    public int createBoard(Board board) {
        // 오류 처리로직 필요
        return mapper.insert(board);
    }

    /** 업데이트 */
    public Board updateBoard(Board board) {
        int result = mapper.update(board);
        return board;
    }

    /** 삭제 */
    public boolean deleteBoard(Long seq) {
        try {
            mapper.delete(seq);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
