package xyz.oilpea.schooldemo.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.oilpea.schooldemo.demo.entities.ArticlesList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticlesDao {
    private static Map<Integer, ArticlesList> articlesList = null;

    static {
        articlesList = new HashMap<Integer, ArticlesList>();

        articlesList.put(1001, new ArticlesList(1001, "数据科学学院揭牌仪式圆满举行", "编辑部"));
        articlesList.put(1002, new ArticlesList(1002, "公益暖心丨科技燃青春，信工伴我行", "编辑部"));
        articlesList.put(1003, new ArticlesList(1003, "我系与金蝶软件（中国）有限公司签订共建软件工程专业框架协议", "编辑部" ));
        articlesList.put(1004, new ArticlesList(1004, "信息工程系2019届全体毕业生思想教育大会暨毕业论文动员大会", "编辑部"));
        articlesList.put(1005, new ArticlesList(1005, "挂牌仪式|共同努力，再创辉煌", "编辑部" ));
    }

    private static Integer initId = 1006;

    public void save(ArticlesList articles) {
        if (articles.getId() == null) {
            articles.setId(initId++);
        }

        articlesList.put(articles.getId(), articles);
    }

    //查询所有员工
    public Collection<ArticlesList> getAll() {
        return articlesList.values();
    }

    public ArticlesList get(Integer id) {
        return articlesList.get(id);
    }

    public void delete(Integer id) {
        articlesList.remove(id);
    }
}
