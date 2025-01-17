package io.goorm.mini.api.board.controller;

import io.goorm.mini.api.board.service.BoardService;
import io.goorm.mini.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService service;

    @Autowired
    public BoardController (BoardService boardService) {
        this.service = boardService;
    }

    /** 인덱스 */
    @GetMapping("")
    public String index() {
        return "board/index";
    }

    /** 게시판 */
    @GetMapping("/boards")
    public String list(Model model) {
        List<Board>  boardList = service.getBoards();
        model.addAttribute("posts", boardList);
        return "board/list";
    }

    /** 상세보기 */
    @GetMapping("/boards/{seq}")
    public String view(
            @PathVariable Long seq,
            Model model){
        Board board = service.getBoardById(seq);
        model.addAttribute("post", board);
        return "board/view";
    }

    /** 생성 */
    @PostMapping("/boards")
    public String create(@ModelAttribute Board board, Model model) {
        var result = service.createBoard(board);
//        model.addAttribute("", result);
//        return "board/create";
        return "redirect:/board/create";
    }

    /** 수정 페이지*/
    @GetMapping("/boards/update/{seq}")
    public String update(@PathVariable Long seq, Model model) {
        model.addAttribute("post", service.getBoardById(seq));
        return "board/update";
    }

    @PutMapping("/boards")
    public String put(@RequestBody Board board, Model model) {
        service.updateBoard(board);
        return "redirect:/list";
    }

}
