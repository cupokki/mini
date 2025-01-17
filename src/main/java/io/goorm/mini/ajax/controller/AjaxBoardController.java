package io.goorm.mini.ajax.controller;

import io.goorm.mini.api.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxBoardController {

    private final BoardService service;

    @Autowired
    public AjaxBoardController(BoardService boardService){
        this.service = boardService;
    }

    /** 리스트 */
    @GetMapping("/boards")
    public String list(Model model) {
        model.addAttribute(service.getBoards());
        return "ajax/list";
    }
}
