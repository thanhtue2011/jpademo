package com.asiantech.jpa.controller;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiantech.jpa.repository.AccountRepository;
import com.asiantech.jpa.service.AccountService;
import com.asiantech.jpa.entity.Account;
@Controller
@RequestMapping("/admin")
public class AccountController {
	    @Autowired
	    @Qualifier(AccountService.NAME)
	    private AccountService accounService;
	    @Autowired
	    private AccountRepository accountreposity;
	    private Account account = new Account();
	    private List<Account>  listAccount= new ArrayList<Account>();
	    private List<Account>  listAccount2= new ArrayList<Account>();;
	    private List<Account>  listAccountAcc;
	    public List<Account> getAccounts() {
	        return listAccount;
	    }
	    @RequestMapping("")
		public String getIndex(){
			return "redirect:admin/";
		}
	    @RequestMapping("/")
	    public String listthymleaf( ModelMap model) {
	    	int page=1;
	    	int limit = 5;
	    	int end =0;
	    	int dem=0;
	        long  totalrecord = accounService.getTotalAll();
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accounService.getLimitAccount(limit,(page*limit-limit));
	    	listAccount=listAccountAcc;
	         model.put("page", page);
	         model.put("limit", limit);
		     model.put("totalrecord", totalrecord);
		     model.put("iend", dem);
	        model.put("listAccount", listAccount);
	        Account newAccount = new Account();
	        model.put("account", newAccount);
	        return "listthymleaf";
	    }
	    @RequestMapping(value = "thymeleafpage", method = RequestMethod.GET)
	    public ModelAndView getAccountThymeleaf(@RequestParam(value="page",required=false) Integer page,@RequestParam(value="limit",required=false) Integer limit) {
	    	if(page==null)
	        	page=1;
	    	if(limit==null)
	        	limit=5;
	    	int end =0;
	    	int dem=0;
	        long  totalrecord = accounService.getTotalAll();
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accounService.getLimitAccount(limit,(page*limit-limit));
	    	
	    	listAccount=listAccountAcc;
	    	
	    	ModelAndView model = new ModelAndView("listthymleaf");
	        model.addObject("page", page);
	        model.addObject("limit", limit);
		    model.addObject("totalrecord", totalrecord);
		    model.addObject("iend", dem);
	        model.addObject("listAccount", listAccount);
	        model.addObject("msg", accounService.getMsg());
	        Account newAccount = new Account();
	        model.addObject("account", newAccount);
	        accounService.setMsg("");
	        return model;
	    }

	    public List<Account> copyAccount(List<Account> listAccount,List<Account> listAccount2){
	    	listAccount.addAll(listAccount2);
	    	return listAccount;
	    }
	    //delete method post
	    @RequestMapping(value="/delete",method=RequestMethod.POST)
	    public String detete(@Valid Account account,BindingResult bidding, @RequestParam("id") Integer id,@RequestParam("page") Integer page){
	    	 accounService.delete(id);
	    	 accounService.setMsg("Xoa thanh cong Account "+id+" !");
	    	 return "redirect:/admin/thymeleafpage?page="+page;
	    }
	    
	    //update or insert
	    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	    public String saveAccount(@Valid Account account,BindingResult bidding,
	    		@RequestParam("page") Integer page) {
	       accounService.create(account);
	       accounService.setMsg("Them thanh cong!");
	        return "redirect:/admin/thymeleafpage?page="+page;
	    	
	    }
	    
	    //edit method post
	    @RequestMapping(value = "/edit", method = RequestMethod.POST)
	    public ModelAndView edit(@RequestParam("id") Integer id,@RequestParam("page") Integer page) {
	        Account account = accounService.findById(id);
	       // ModelAndView model = new ModelAndView("AccountForm");
	        ModelAndView model = new ModelAndView("formedit");
	        //List<Account> listAccount = accounService.listAccount();
	        //model.addObject("listAccount", listAccount);
	        model.addObject("account", account);
	        model.addObject("page", page);
	        //model.addObject("id",id);
	        //model.setViewName("list");
	     
	        return model;
	    }
	    //save edit
	    @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
	    public String saveedit(@Valid Account account,BindingResult bidding,
	    		@RequestParam("page") Integer page,@RequestParam("id") Integer id) {
	       accounService.update(account);
	       accounService.setMsg("Sua thanh cong Account "+id+" !");
	        return "redirect:/admin/thymeleafpage?page="+page;
	    	
	    }
	    
}
