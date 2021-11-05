/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */


package com.hotel.web.service;

import com.hotel.web.model.DateDiscount;
import com.hotel.web.model.StudentDiscount;

import java.util.List;

public interface DiscountService {

    List<DateDiscount> getAllDateDiscount();

    DateDiscount saveDateDiscount(DateDiscount dateDiscount);

    DateDiscount getDateDiscountId(Long id);

    DateDiscount updateDateDiscount(DateDiscount dateDiscount);

    StudentDiscount updateStudentDiscount(StudentDiscount studentDiscount);

    StudentDiscount getStudentDiscount();

    void deleteDateDiscountId(Long id);

}
