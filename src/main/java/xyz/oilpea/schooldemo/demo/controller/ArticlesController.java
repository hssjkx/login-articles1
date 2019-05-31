package xyz.oilpea.schooldemo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.oilpea.schooldemo.demo.dao.ArticlesDao;
import xyz.oilpea.schooldemo.demo.entities.ArticlesList;

import java.util.Collection;


@Controller
public class ArticlesController {
    @Autowired
    ArticlesDao articlesDao;

    @GetMapping("/articles")
    public String ArticlesPage(Model model){

//getAll查询所有员工，返回一个集合
        Collection<ArticlesList> articles = articlesDao.getAll();

        //放在请求域中、进行共享
        model.addAttribute("articles", articles);


        return "article/articles";
    }

    //文章添加
    //来到文章添加页面
//    @GetMapping("/editpage")
//    public String toAddPage(Model model) {
//        //来到添加页面,查出所有的菜单，在页面显示
//        Collection<Department> departments = departmentDao.getDepartments();
//        model.addAttribute("depts", departments);
//        return "editpage/add";
//    }

//    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/editpage")//映射POST请求，当前项目下的articles
    public String addEmp(ArticlesList articlesList) {
        //文章添加完后，来到文章列表articles页面

        System.out.println("保存的文章信息：" + articlesList);

        articlesDao.save(articlesList); //保存员工

        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/articles";//来到articles页面
        //'/articles'不是来到当前项目下的articles请求，因为我们说返回值，会由thymeleaf模板引擎进行解析，就会在类路径下给我们拼串
        // 拼到类路径下，classpath:/templates/xxxx.html
    }
//
//
//    //来到修改页面，查出当前文章信息，在页面回显
//
    @GetMapping("/editpage/{id}")//路径变量加上id
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        //PathVariable获取路径变量id，
        ArticlesList articlesList = articlesDao.get(id);//获取查的员工
        model.addAttribute("atc", articlesList);

        //页面要显示所有的菜单列表
//        Collection<Department> departments = departmentDao.getDepartments();
//        model.addAttribute("depts", departments);

        //回到修改add页面(add页面是一个修改添加二合一的页面);
        return "editPage/editpage";
    }
//

//    //文章删除
    @DeleteMapping("/aticles/{id}")//delete形式过来的，
    public String deleteEmployee(@PathVariable("id") Integer id) {
        //PathVariable获取路径变量id

        articlesDao.delete(id);//调用删除
        return "redirect:/articles";//return到员工列表页面
    }

}
