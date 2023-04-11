package com.example.furama.controller;

import com.example.furama.model.customer.Customer;
import com.example.furama.services.customer.impl.CustomerServices;
import com.example.furama.services.customer.impl.CustomerTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private CustomerTypeServices customerTypeServices;
    @GetMapping("list")
    private String getList(Model model,@RequestParam(value = "page", defaultValue = "0")int page){
        model.addAttribute("customerList",customerServices.getAll(PageRequest.of(page,4)));
        return "customer/list";
    }
    @GetMapping("")
    private String getPage(Model model,@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "nameSearch",defaultValue = "") String nameSearch)
    {
        model.addAttribute("customerList",customerServices.findByName(nameSearch, PageRequest.of(page,4)));
        model.addAttribute("nameSearch",nameSearch);
        return "customer/list";
    }
    @GetMapping(value = "save")
    private String getSave(@RequestParam(name = "id",defaultValue = "0") Integer id, Model model){
        if (id==0){
            model.addAttribute("customer",new Customer());
        }else {
            model.addAttribute("customer",customerServices.getCustomerById(id));
        }
        model.addAttribute("customerTypeList",customerTypeServices.findAll());
        model.addAttribute("id",id);
        return "customer/save";
    }
    @PostMapping(value = "/save")
    private String saveCustomer(@ModelAttribute("customer")Customer customer){
        customerServices.save(customer);
        return "redirect:/customer";
    }
    @GetMapping(value = "delete")
    private String deleteCustomer(@RequestParam(name = "id") Integer id) {
        customerServices.delete(customerServices.getCustomerById(id));
        return "redirect:/customer";
    }
}
