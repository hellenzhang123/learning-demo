package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Address;
import com.example.demo.model.User;

@Controller
public class UserController {

	@RequestMapping(value="/user")
	public String indexData(ModelMap map) {
		map.put("test", "testValue");
		List<Address> addressList = new ArrayList<>();
		Address address1 = new Address("湖南1","岳阳1", "华容街道1");
		Address address2 = new Address("湖南2","岳阳2", "华容街道2");
		Address address3 = new Address("湖南","岳阳", "华容街道");
		addressList.add(address1);
		addressList.add(address2);
		addressList.add(address3);
		User user = new User("酸酸", 18, "15733525582", "56456413365@qq.com", addressList);
		map.put("user", user);
		map.put("date", new Date());
		Map testMap = new HashMap<>();
		testMap.put("1", 1);
		testMap.put("2", 2);
		testMap.put("3", 3);
		map.put("testMap", testMap);
		return "index";
	}
}
