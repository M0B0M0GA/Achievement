package springmvc.service;

import springmvc.entity.Score;

import java.util.List;

public interface ScoreService {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    Integer getScoreTotal();

    List<Score> scoreList(int start, int count);

    List<Score> selectByStudent(Integer studentID);

}
