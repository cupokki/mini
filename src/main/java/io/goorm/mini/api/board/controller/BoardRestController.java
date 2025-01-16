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


    /** get board list */
    @GetMapping("/boards")
    public List<Board> list() {
        List<Board> result = boardService.getBoards();

//        log.debug("list size : " + result.size());
//        log.debug("test");
        return result;
    }

    /** get board by id */
    @GetMapping("/boards/{seq}")
    public Board board(@PathVariable Long seq) {
        Board result = boardService.getBoardById(seq);
        return result;
    }

    /** create board */
    @PostMapping("/boards")
    public int post(
            @RequestParam String title,
            @RequestParam String contents,
            @RequestParam String regUser
    ) {
//        Board board = new Board();
//        board.setTitle("test");
        Board board = new Board();
        // board 값 set
        return boardService.createBoard(board);
    }

    /** update board */
//    @PostMapping("/boards")
//    public int post(@RequestBody Long seq) {
//        //
//        log.debug("seq: " + seq);
//        return boardService.createBoard(board);
//        return
//    }

}
