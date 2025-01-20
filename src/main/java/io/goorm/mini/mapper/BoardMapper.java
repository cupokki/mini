package io.goorm.mini.mapper;

import io.goorm.mini.board.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> selectAll();

    Board selectById(@Param("seq") Long seq);

    int insert(@Param("board") Board board);

    int update(@Param("board") Board board);

    int delete(@Param("seq") Long seq);
}
