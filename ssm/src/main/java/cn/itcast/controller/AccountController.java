package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/findAll")
    public String findAll(Model model) {
        System.out.println("表现层.执行了查询...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(path = "/saveAccount")
    public void saveAccount(HttpServletRequest request, Account account, HttpServletResponse response) throws IOException {
        System.out.println("表现层,执行了保存...");
        accountService.saveAccount(account);
        //发送数据到页面
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
