package com.jojo.financialcontrol;


import com.jojo.financialcontrol.dao.ExpenseDAO;
import com.jojo.financialcontrol.dao.GenericDAOImpl;
import com.jojo.financialcontrol.entity.Expense;

public class Main {

    public static void main(String[] args) {

        ExpenseDAO expenseDAO = new ExpenseDAO();

        expenseDAO.findById(1L);
    }
}
