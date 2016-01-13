package sample.test.alo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.test.bso.TestBSO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by charwer on 2014/11/4 004.
 */
@RestController
@RequestMapping("/test")
public class TestALO {

    @Autowired
    protected TestBSO bso;

    @RequestMapping("/conn")
    public String testConn() {
        bso.testConn();
        return "action";
    }

    @RequestMapping("/add")
    public String testAdd() {
        bso.testAdd();
        return "add";
    }

    @RequestMapping("/update")
    public String testUpdate() {
        bso.testUpdate();
        return "update";
    }

    @RequestMapping("/testTx")
    public String testTransactional() {
        bso.testTransactional();
        return "tx";
    }

    @RequestMapping("/page")
    public PageBean testPage(PageBean pageBean, HttpServletRequest request, int page, int pageSize, int pagesize) {
//    	System.out.println("pageNum: "+ pageNum);
        System.out.println("pageBean.pageNum: " + pageBean.getPageNum());

        System.out.println("---------------");
        System.out.println(request.getParameter("pageNum"));
        System.out.println(request.getAttribute("pageNum"));
        System.out.println("page: " + request.getParameter("page"));
        System.out.println("page: " + page);

        System.out.println("pageSize: " + pageSize);
        System.out.println("pagesize: " + pagesize);

        pageBean.setPageNum(3);

        return pageBean;
    }
}
