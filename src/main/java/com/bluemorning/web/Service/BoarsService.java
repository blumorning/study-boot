package com.bluemorning.web.Service;

import com.bluemorning.web.domain.Board;
import com.bluemorning.web.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoarsService {
	private final BoardRepository boardRepository;

	public BoarsService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public Page<Board> findBoardList(Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
		return boardRepository.findAll(pageable);
	}

	public Board findBoardByIdx(Long idx) {
		return boardRepository.findById(idx).orElse(new Board());
	}

}
