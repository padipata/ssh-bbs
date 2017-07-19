package bbs.dao;

import java.util.List;

import bbs.entity.Board;

public interface IBoardDAO {

	public Board findBoardById(int boardId); // 根据id查找版块

	public List<Board> findBoardList(); // 查询版块列表

}
