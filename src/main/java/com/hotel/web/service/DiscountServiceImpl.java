/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.service;

import com.hotel.web.model.DateDiscount;
import com.hotel.web.model.StudentDiscount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService{
    List<DateDiscount> dateDiscounts = new ArrayList<>();
    StudentDiscount studentDiscount = new StudentDiscount();
    long id =0;

    public DiscountServiceImpl() {
        studentDiscount.setId(1);
        studentDiscount.setPercent(0);
    }

    @Override
    public List<DateDiscount> getAllDateDiscount() {
        return dateDiscounts;
    }

    @Override
    public DateDiscount saveDateDiscount(DateDiscount dateDiscount) {
        dateDiscount.setId(++id);
        dateDiscounts.add(dateDiscount);
        return dateDiscount;
    }

    @Override
    public DateDiscount getDateDiscountId(Long id) {
        for(int i=0;i< dateDiscounts.size();i++) {
            if(dateDiscounts.get(i).getId()==id) {
                return dateDiscounts.get(i);
            }
        }
        return null;
    }

    @Override
    public DateDiscount updateDateDiscount(DateDiscount dateDiscount) {

        for(int i=0;i< dateDiscounts.size();i++) {
            if(dateDiscounts.get(i).getId()==id) {
                dateDiscounts.remove(i);
                break;
            }
        }
        dateDiscounts.add(dateDiscount);
        return dateDiscount;
    }

    @Override
    public StudentDiscount updateStudentDiscount(StudentDiscount sd) {
        studentDiscount.setPercent(sd.getPercent());
        return studentDiscount;
    }

    @Override
    public StudentDiscount getStudentDiscount() {
        return studentDiscount;
    }

    @Override
    public void deleteDateDiscountId(Long id) {

        for(int i=0;i< dateDiscounts.size();i++) {
            if(dateDiscounts.get(i).getId()==id) {
                dateDiscounts.remove(i);
                break;
            }
        }
    }
}
