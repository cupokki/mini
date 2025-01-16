package io.goorm.mini.api.board.controller;

import io.goorm.mini.api.board.service.BoardService;
import io.goorm.mini.board.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

//    @Autowired
//    public BoardRestController(BoardService boardService) {
//        this.boardService = boardService;
//    }

    @GetMapping("")
    public String index() {
        return "api index";
    }

    /** 리스트 */
    @GetMapping("/boards")
    public List<Board> list() {
        List<Board> result = boardService.getBoards();

//        log.debug("list size : " + result.size());
//        log.debug("test");
        return result;
    }

    /** 상세보기 */
    @GetMapping("/boards/{seq}")
    public Board detail(@PathVariable("seq") Long seq) {
        Board result = boardService.getBoardById(seq);
        return result;
    }
//
//    @PostMapping("/boards")
//    public int post(@RequestBody Long seq) {
//        //
//        log.debug("seq: " + seq);
//        return boardService.createBoard(board);
//        return
//    }

}
