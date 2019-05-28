package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.common.ResultDTO;

@Controller
public class IndexController {
  @RequestMapping({"/", "/index"})
  public String index() {
    return "/index";
  }

  // @RequestMapping("/login")
  // public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
  // System.out.println("HomeController.login()");
  // // 登录失败从request中获取shiro处理的异常信息。
  // // shiroLoginFailure:就是shiro异常类的全类名.
  // String exception = (String) request.getAttribute("shiroLoginFailure");
  // System.out.println("exception=" + exception);
  // String msg = "";
  // if (exception != null) {
  // if (UnknownAccountException.class.getName().equals(exception)) {
  // System.out.println("UnknownAccountException -- > 账号不存在：");
  // msg = "UnknownAccountException -- > 账号不存在：";
  // } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
  // System.out.println("IncorrectCredentialsException -- > 密码不正确：");
  // msg = "IncorrectCredentialsException -- > 密码不正确：";
  // } else if ("kaptchaValidateFailed".equals(exception)) {
  // System.out.println("kaptchaValidateFailed -- > 验证码错误");
  // msg = "kaptchaValidateFailed -- > 验证码错误";
  // } else {
  // msg = "else >> " + exception;
  // System.out.println("else -- >" + exception);
  // }
  // }
  // map.put("msg", msg);
  // // 此方法不处理登录成功,由shiro进行处理
  // return "/login";
  // }

  @RequestMapping("/403")
  public String unauthorizedRole() {
    System.out.println("------没有权限-------");
    return "403";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
    ResultDTO resultDTO = new ResultDTO();
    try {
      String pwd = password;
      UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
      Subject subject = SecurityUtils.getSubject();
      subject.login(token);

    } catch (DisabledAccountException e) {
      resultDTO.setMessage("账户已被禁用");
      resultDTO.setResultCode(500);
      return resultDTO;
    } catch (AuthenticationException e) {
      resultDTO.setMessage("用户名或密码错误");
      resultDTO.setResultCode(500);
      return resultDTO;
    }

    // 执行到这里说明用户已登录成功
    resultDTO.setResultCode(200);
    return resultDTO;
  }


  /**
   * 登录系统
   * 
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }
}
