package springmvc.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.dao.ScoreMapper;
import springmvc.entity.Score;
import springmvc.service.ScoreService;

import java.util.List;

@Repository
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Score record) {
        return scoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Score record) {
        return scoreMapper.insertSelective(record);
    }

    @Override
    public Score selectByPrimaryKey(Integer id) {
        return scoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Score record) {
        return scoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Score record) {
        return scoreMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer getScoreTotal() {
        return scoreMapper.getScoreTotal();
    }

    @Override
    public List<Score> scoreList(int start, int count) {
        return scoreMapper.scoreList(start,count);
    }

    @Override
    public List<Score> selectByStudent(Integer studentID) {
        return scoreMapper.selectByStudent(studentID);
    }

}
