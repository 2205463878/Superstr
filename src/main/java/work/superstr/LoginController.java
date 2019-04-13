package work.superstr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    @RequestMapping("/login")
    public Map<String,String> login(HttpServletRequest request,HttpSession httpSession)
    {
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if("root".equals(user.getUsername())&&"123456".equals(user.getPassword())) {
			httpSession.setAttribute("user",user);
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("mssage", "登入成功");
		return map;
    }
    
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws IOException
    {
    	httpSession.removeAttribute("user");
    	response.sendRedirect(request.getContextPath()+"/login.html");
    }
    
    @RequestMapping("/getData")
    public Map<String,Object> getData() {
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("user1", new User("username1","password1"));
    	data.put("user1", new User("username2","password2"));
    	return data;
    }
}