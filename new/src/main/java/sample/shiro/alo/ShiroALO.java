package sample.shiro.alo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charwer
 *         if all these method in this controller need return json-formed data,
 *         you can annotate @RestController on this class, instead of annotating @ResponseBody on every method
 */
@RestController
public class ShiroALO {

    @RequestMapping("/role/admin")
    public String roleAdmin() {
        return "role admin :)";
    }

    @RequestMapping("/user/add")
    public String userAdd() {
        return "perm add ^ ^";
    }

    @RequestMapping("/user/edit")
    public String userEdit() {
        return "perm edit ^ ^";
    }
}
