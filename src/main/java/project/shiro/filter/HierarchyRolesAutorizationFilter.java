package project.shiro.filter;

import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class HierarchyRolesAutorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request,
                                   ServletResponse response, Object mappedValue) throws IOException {
        System.out.println(CollectionUtils.asSet((String[]) mappedValue));
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
