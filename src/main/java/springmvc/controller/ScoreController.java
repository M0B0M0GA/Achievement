package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.Score;
import springmvc.service.ScoreService;
import springmvc.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    // 获取分页参数
    int start = 0;
    int count = 10;
    Page page = new Page(start, count);

    @RequestMapping("BaseScorePage")
    public String returnScoreIndexPage(){
        return "listScore";
    }

    @RequestMapping(value = "/addScorePage")
    public String addScorePage(){
        return "addScore";
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public String addScore(HttpServletRequest request){
        Score score = new Score();
        score.setSid(Integer.parseInt(request.getParameter("score_stuID")));
        score.setCid(Integer.parseInt(request.getParameter("score_CourseID")));
        score.setScore(Float.parseFloat(request.getParameter("score")));
        scoreService.insert(score);
        return "addScore";
    }

    @RequestMapping(value = "/listScore")
    public ModelAndView listScore(@RequestParam("pageStart")int pageStart, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listScore");

        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception exception) {
        }
        page.setStart(start);
        List<Score> scores = scoreService.scoreList(page.getStart(), page.getCount());
        int total = scoreService.getScoreTotal();
        page.setTotal(total);
        modelAndView.addObject("page", page);
        modelAndView.addObject("score", scores);
        return modelAndView;
    }

    @RequestMapping("/deleteScore")
    public String deleteScore(@RequestParam("deleteId")int id) {
        scoreService.deleteByPrimaryKey(id);
        return "listScore";
    }

    @RequestMapping("/editScore")
    public ModelAndView editScore() {
        ModelAndView modelAndView = new ModelAndView("editScore");
        return modelAndView;
    }

    @RequestMapping(value = "/updateScore", method = RequestMethod.POST)
    public String updateScore(HttpServletRequest request) {
        Score score = new Score();
        score.setSid(Integer.parseInt(request.getParameter("score_stuID")));
        score.setId(Integer.parseInt(request.getParameter("score_id")));
        score.setCid(Integer.parseInt(request.getParameter("score_CourseID")));
        score.setScore(Float.parseFloat(request.getParameter("score")));
        scoreService.updateByPrimaryKeySelective(score);
        return "editScore";
    }

    @RequestMapping(value = "/searchScore", method = RequestMethod.POST)
    public ModelAndView searchStudent(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listScore");

        int sId=Integer.parseInt(request.getParameter("searchStudent"));
        List<Score> scores = new LinkedList<Score>();
        scores = scoreService.selectByStudent(sId);
        modelAndView.addObject("students", scores);
        return modelAndView;
    }
}
