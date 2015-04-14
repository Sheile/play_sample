package controllers;

import java.util.List;
import java.util.ArrayList;

import play.*;
import play.mvc.*;
import play.data.*;

import com.avaje.ebean.ExpressionList;

import models.Estimate;

public class Estimates extends Controller {

  public static Result list() {
    DynamicForm searchForm = Form.form().bindFromRequest();

    String estimateNumber = searchForm.get("estimateNumber");
    String customerName = searchForm.get("customerName");
    String subject = searchForm.get("subject");

    ExpressionList query = Estimate.find.where();
    if(estimateNumber != null && !estimateNumber.equals("")) {
      query = query.eq("estimateNumber", estimateNumber);
    }
    if(customerName != null && !customerName.equals("")) {
      query = query.like("customerName", "%" + customerName + "%");
    }
    if(subject != null && !subject.equals("")) {
      query = query.like("subject", "%" + subject + "%");
    }

    List<Estimate> estimates = query.findList();
    return ok(views.html.Estimates.list.render(searchForm, estimates));
  }
}

