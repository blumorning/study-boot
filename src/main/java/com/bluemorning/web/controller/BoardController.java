package com.bluemorning.web.controller;

import com.bluemorning.web.Service.BoarsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

	BoarsService boarsService;

	@GetMapping({"", "/"})
	public String board(@RequestParam(value="idx", defaultValue = "0") Long idx, Model model) {
		model.addAttribute("board", boarsService.findBoardByIdx(idx));
		return "/board/form";
	}

	@GetMapping("/list")
	public String list(@PageableDefault Pageable pageable, Model model) {
		model.addAttribute("boardList", boarsService.findBoardList(pageable));
		return "/board/list";
	}

}
