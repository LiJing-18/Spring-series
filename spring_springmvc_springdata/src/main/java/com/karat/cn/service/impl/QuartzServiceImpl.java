package com.karat.cn.service.impl;

import com.karat.cn.service.QuartzService;
import org.springframework.stereotype.Service;


@Service
public class QuartzServiceImpl implements QuartzService {

	@Override
	public void add() {
		System.out.println("QuartzServiceImpl  ---- >>  add");
	}

	@Override
	public void update() {
		System.out.println("QuartzServiceImpl  ---- >>  update");
	}

}
