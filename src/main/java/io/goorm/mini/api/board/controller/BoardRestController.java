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

    private final BoardService service;

    @Autowired
    public BoardRestController(BoardService boardService) {
        this.service = boardService;
    }

    /** get board list */
    @GetMapping("/boards")
    public List<Board> list() {
        List<Board> result = service.getBoards();

//        log.debug("list size : " + result.size());
//        log.debug("test");
        return result;
    }

    /** get board by id */
    @GetMapping("/boards/{seq}")
    public Board board(@PathVariable Long seq) {
        Board result = service.getBoardById(seq);
        return result;
    }

    /** create board */
    @PostMapping("/boards")
    public int post(@RequestBody Board board) {
        return service.createBoard(board);
    }

    /** update board page */
    @PutMapping("/boards")
    public Board put(@RequestBody Board board) {
//        //
//        log.debug("seq: " + seq);
//        return boardService.createBoard(board);
//        return
        return service.updateBoard(board);
    }

    @DeleteMapping("/boards/{seq}")
    public boolean delete(@PathVariable("seq") Long seq) {
        return service.deleteBoard(seq);
    }
}